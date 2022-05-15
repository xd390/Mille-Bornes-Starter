package nc.unc.gl.borne.gui.component;

import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.dnd.DropEffect;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import nc.unc.gl.borne.modele.Carte;
import nc.unc.gl.borne.modele.Joueur;

public class PlayerComponent extends Div implements HasStyle {
    private Joueur joueur;
    private Div dernièreCarteJouer;
    private CardContainerAttackComponent malus;
    private Div bottes;

    public PlayerComponent(Joueur joueur){
        this.setId("infoJoueur");
        this.setText("count : "+joueur.getPoints()+" player :"+joueur.getPseudo());
        this.joueur = joueur;
        dernièreCarteJouer = new Div();
        dernièreCarteJouer.addClassName("cardPlayerBot");
        malus = new CardContainerAttackComponent();
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
        return joueur;
    }
}
