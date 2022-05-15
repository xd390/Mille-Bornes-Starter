package nc.unc.gl.borne.gui.component;

import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import nc.unc.gl.borne.modele.Joueur;

public class PlayerComponent extends Div implements HasStyle {
    private Div derniereCarteJouer;
    private Joueur joueur1;
    private Joueur joueur2;
    private Div dernièreCarteJouer;
    private CardContainerAttackComponent malus;
    private Div bottes;
    private int cpt_bot=0;

    public PlayerComponent(Joueur joueur1, Joueur joueur2){
        this.setId("infoJoueur");
        this.setText("count : "+joueur.getPoints()+" player :"+joueur.getPseudo());
        derniereCarteJouer = new Div();
        derniereCarteJouer.addClassName("cardPlayerBot");
        derniereCarteJouer.addClassName("superpose_card");
        malus = new CardContainerAttackComponent();
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
        bottes.addClassName("superpose_card");
        bottes.setId("img_bot"+cpt_bot);
        cpt_bot++;

        add(derniereCarteJouer,malus,bottes);
    }

    public Div getBottes() {
        return bottes;
    }

    public Div getDernièreCarteJouer() {
        return derniereCarteJouer;
    }

    public CardContainerAttackComponent getMalus() {
        return malus;
    }

    public Joueur getJoueur() {
        return joueur;
    }
}
