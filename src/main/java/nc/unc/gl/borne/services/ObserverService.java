package nc.unc.gl.borne.services;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinSession;
import nc.unc.gl.borne.modele.Joueur;
import nc.unc.gl.borne.session.Broadcaster;
import nc.unc.gl.borne.session.VaadinSessionsHolder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class ObserverService {
    private UI ui = new UI();

    private final static Map<Integer, Joueur> sessions = new ConcurrentHashMap<>();

    private Joueur joueur;

    public ObserverService(Joueur joueur){
        this.joueur = joueur;
        this.joueur.setNumJoueur(ui.getCurrent().getUIId());
        sessions.put(this.joueur.getNumJoueur(), this.joueur);
    }

    public UI getCurrentUI() {
        UI ui = UI.getCurrent();
        if (ui == null) {
            throw new IllegalStateException("UI instance is not available. "
                + "It means that you are calling this method "
                + "out of a normal workflow where it's always implicitly set. "
                + "That may happen if you call the method from the custom thread without "
                + "'UI::access' or from tests without proper initialization.");
        }
        return ui;
    }

    public UI getCurrent() {
        return ui.getCurrent();
    }

    public int getNumJoueur() {
        return this.joueur.getNumJoueur();
    }


    protected Joueur getJoueur(int key) {
        return sessions.get(key);
    }

    public static Map<Integer, Joueur> getAllSessions(){return sessions;}
}
