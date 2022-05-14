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
        this.setId("infoJoueur");
        this.setText("count : "+joueur.getPoints()+" player :"+joueur.getPseudo());
        this.joueur = joueur;
        dernièreCarteJouer = new Div();
        dernièreCarteJouer.addClassName("cardPlayerBot");
        malus = new CardContainerComponent(0, 0, "Malus",false);
        malus.addClassName("cardPlayerMalus");
        malus.removeClassName("rectangle");
        bottes = new Div();
        bottes.addClassName("cardPlayerBot");

        add(dernièreCarteJouer,malus,bottes);
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
