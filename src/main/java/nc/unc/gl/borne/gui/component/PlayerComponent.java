package nc.unc.gl.borne.gui.component;

import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import nc.unc.gl.borne.modele.Joueur;

public class PlayerComponent extends Div implements HasStyle {
    private Joueur joueur1;
    private Joueur joueur2;
    private Div dernièreCarteJouer;
    private CardContainerAttackComponent malus;
    private Div bottes;

    public PlayerComponent(Joueur joueur1, Joueur joueur2){
        this.setId("infoJoueur");
        this.setText("count : "+joueur2.getPoints()+" player :"+joueur2.getPseudo());
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        dernièreCarteJouer = new Div();
        dernièreCarteJouer.addClassName("cardPlayerBot");
        malus = new CardContainerAttackComponent(joueur1, joueur2);
        Image imageTemp = new Image("/cartes/back.png","Posez la carte attaque ici");
        imageTemp.addClassName("cardMalusPlayerLeft");
        malus.add(imageTemp);
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

    public CardContainerAttackComponent getMalus() {
        return malus;
    }

    public Joueur getJoueur() {
        return joueur1;
    }
}
