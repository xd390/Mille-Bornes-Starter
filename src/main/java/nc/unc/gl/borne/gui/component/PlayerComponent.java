package nc.unc.gl.borne.gui.component;

import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.html.Div;
import nc.unc.gl.borne.modele.Joueur;

public class PlayerComponent extends Div implements HasStyle {
    private Joueur joueur;
    private Div dernièreCarteJouer;
    private CardContainerComponent malus;
    private Div bottes;

    public PlayerComponent(Joueur joueur){
        this.joueur = joueur;
        dernièreCarteJouer = new Div();
        malus = new CardContainerComponent(0, 0, "Malus",false);
        bottes = new Div();
    }

    public Div getBottes() {
        return bottes;
    }

    public Div getDernièreCarteJouer() {
        return dernièreCarteJouer;
    }

    public CardContainerComponent getMalus() {
        return malus;
    }

    public Joueur getJoueur() {
        return joueur;
    }
}
