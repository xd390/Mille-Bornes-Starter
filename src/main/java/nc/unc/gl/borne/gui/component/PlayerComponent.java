package nc.unc.gl.borne.gui.component;

import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import nc.unc.gl.borne.gui.component.attaques.CardContainerAttackComponent;
import nc.unc.gl.borne.gui.component.attaques.CardContainerLimitSpeedComponent;
import nc.unc.gl.borne.modele.Joueur;

import static nc.unc.gl.borne.services.ObserverService.getCurrentAutreJoueur;

public class PlayerComponent extends Div implements HasStyle {
    private Joueur joueur;
    private Div derniereCarteJouer;
    private CardContainerAttackComponent malus;

    private CardContainerLimitSpeedComponent limiteVitesse;
    private Div bottes;
    private int cpt_bot=0;

    private H4 infoJ2;

    public H4 getInfoJ2() {
        return this.infoJ2;
    }

    public void setInfoJ2(String infoJ2) {
        this.infoJ2.setText(infoJ2);
    }

    public PlayerComponent(Joueur joueur){
        this.setId("infoJoueur");
        infoJ2 = new H4("Score : "+getCurrentAutreJoueur().getPoints()+" player :"+getCurrentAutreJoueur().getPseudo());
        this.joueur = joueur;

        derniereCarteJouer = new Div();
        derniereCarteJouer.addClassName("cardPlayerBot");
        derniereCarteJouer.addClassName("superpose_card");

        malus = new CardContainerAttackComponent();
        Image imageTemp = new Image("/cartes/back.png","Posez la carte attaque ici");
        imageTemp.addClassName("cardMalusPlayerLeft");
        malus.getDiv().add(imageTemp);

        limiteVitesse = new CardContainerLimitSpeedComponent();
        Image imageTemp2 = new Image("/cartes/back.png","Posez la carte limite vitesse ici");
        imageTemp2.addClassName("cardMalusPlayerLeft");
        limiteVitesse.getDiv().add(imageTemp2);

        bottes = new Div();
        bottes.add(new Span("Bottes"));
        bottes.addClassName("cardPlayerBot");
        bottes.addClassName("superpose_card");

        add(infoJ2, derniereCarteJouer, malus, limiteVitesse ,bottes );
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
