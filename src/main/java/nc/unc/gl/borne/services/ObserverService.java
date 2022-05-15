package nc.unc.gl.borne.services;

import com.vaadin.flow.component.UI;
import nc.unc.gl.borne.modele.Carte;
import nc.unc.gl.borne.modele.Deck;
import nc.unc.gl.borne.modele.Joueur;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ObserverService {
    private UI ui = new UI();
    public static Deck deck = new Deck();
    private static final CarteService carteService = new CarteService();
    private static final DeckService deckService = new DeckService();
    private static final JoueurService joueurService = new JoueurService();
    private final static Map<String, Joueur> sessions = new ConcurrentHashMap<>();
    private static List<Joueur> listeJoueur = new ArrayList<>();
    private static boolean check = false;

    private Joueur joueur;

    public ObserverService(Joueur joueur){
        this.joueur = joueur;
        // this.joueur.setNumJoueur(UI.getCurrent().getUIId());
        sessions.put(this.joueur.getPseudo(), this.joueur);
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

    public static Joueur getJoueur(String key) {
        return sessions.get(key);
    }

    public static Joueur getAutreJoueur(String key) {
        String newKey = "";
        Set<String> liste = sessions.keySet();
        Object[] res = liste.toArray();

        if (res[0] == key) {
            newKey = (String) res[1];
        }
        else{
            newKey = (String) res[0];
        }

        return sessions.get(newKey);
    }

    public static void lancerPartie(){
        if (check)
            return;
        deckService.initialiserDeck(deck);
        Collection<Joueur> liste = sessions.values();
        Object[] res = liste.toArray();
        Joueur j1 = (Joueur) res[0];
        Joueur j2 = (Joueur) res[1];
        deckService.distribuerMain(deck, j1, j2);
        listeJoueur.add(j1);
        listeJoueur.add(j2);
        listeJoueur.get(new Random().nextInt(res.length)).setPeutJouer(true);

        check = true;
    }
    public static boolean ActionJoueur(Carte carte,String nomJoueur){
        return carteService.jouerCarte(carte,getJoueur(nomJoueur),getAutreJoueur(nomJoueur));
    }
    public static Map<String, Joueur> getAllSessions(){return sessions;}
}
