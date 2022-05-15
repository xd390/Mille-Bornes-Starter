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
    private CardContainerComponent malus;
    private Div bottes;

    public PlayerComponent(Joueur joueur){
        this.setId("infoJoueur");
        this.setText("count : "+joueur.getPoints()+" player :"+joueur.getPseudo());
        this.joueur = joueur;
        dernièreCarteJouer = new Div();
        dernièreCarteJouer.addClassName("cardPlayerBot");
        malus = new CardContainerComponent(0, 0, "Malus",true);
        malus.addClassName("cardPlayerMalusAvant");
        Image imageTemp = new Image("/cartes/back.png","Posez la carte attaque ici");
        imageTemp.addClassName("cardMalusPlayerLeft");
        malus.add(imageTemp);
        malus.removeClassName("rectangle");
        malus.addDropListener(e ->{
            Notification.show("tentative de pose carte");
            if(e.getDropEffect() == DropEffect.MOVE) {
                e.getDragData().ifPresent(data -> {
                    // the server side drag data is available if it has been set and the
                    // component was dragged from the same UI as the drop target
                    Carte res = (Carte) data;
                    if(malus.getType() == res.getType() && malus.getEffet() == res.getEffet() | malus.isCarteSpecifique() &&  malus.getType() == res.getType()){
                        CardComponent res2 = (CardComponent) e.getDragSourceComponent().get();
                        res2.getImage().removeClassName("size_of_card_player");
                        res2.getImage().removeClassName("space_between_img");
                        res2.getImage().removeClassName("space_between_img");
                        res2.getImage().addClassName("cardMalusPlayerLeft");
                        res2.getImage().setId("img_");
                        malus.add(res2.getImage());
                        // TODO appeler le service et faire jouer la carte
                    }
                    else{
                        Notification.show("Cette carte ne correspond au container");
                    }
                });
            }
        });
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
