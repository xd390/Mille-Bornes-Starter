package nc.unc.gl.borne.gui.component;

import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.html.Div;
import nc.unc.gl.borne.gui.component.attaques.CardContainerAttackComponent;
import nc.unc.gl.borne.gui.component.attaques.CardContainerLimitSpeedComponent;
import nc.unc.gl.borne.modele.Joueur;

public class PlayerComponent extends Div implements HasStyle {
    private Joueur joueur;
    private Div derniereCarteJouer;
    private CardContainerAttackComponent malus;

    private CardContainerLimitSpeedComponent limiteVitesse;
    private Div bottes;
    private int cpt_bot=0;

    public PlayerComponent(Joueur joueur){
        this.setId("infoJoueur");
        this.setText("Score : "+joueur.getPoints()+" player :"+joueur.getPseudo());
        this.joueur = joueur;

        derniereCarteJouer = new Div();
        derniereCarteJouer.addClassName("cardPlayerBot");
        derniereCarteJouer.addClassName("superpose_card");

        malus = new CardContainerAttackComponent();
        /*
        Image imageTemp = new Image("/cartes/back.png","Posez la carte attaque ici");
        imageTemp.addClassName("cardMalusPlayerLeft");
        malus.add(imageTemp);
        */
        limiteVitesse = new CardContainerLimitSpeedComponent();
        /*
        Image imageTemp2 = new Image("/cartes/back.png","Posez la carte limite vitesse ici");
        imageTemp2.addClassName("cardMalusPlayerLeft");
        limiteVitesse.add(imageTemp2);
        */
        bottes = new Div();
        bottes.addClassName("cardPlayerBot");
        bottes.addClassName("superpose_card");
        bottes.setId("img_bot"+cpt_bot);
        cpt_bot++;

        add(derniereCarteJouer, bottes, malus, limiteVitesse);
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
