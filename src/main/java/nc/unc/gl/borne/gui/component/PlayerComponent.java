package nc.unc.gl.borne.gui.component;

import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.dnd.DropEffect;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import nc.unc.gl.borne.modele.Carte;
import nc.unc.gl.borne.modele.Joueur;

import static nc.unc.gl.borne.services.ObserverService.getCurrentAutreJoueur;

public class PlayerComponent extends Div implements HasStyle {
    private Joueur joueur;
    private Div derniereCarteJouer;
    private CardContainerAttackComponent malus;
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
