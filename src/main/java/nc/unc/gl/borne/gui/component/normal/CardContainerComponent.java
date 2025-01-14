package nc.unc.gl.borne.gui.component.normal;

import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.dnd.DropEffect;
import com.vaadin.flow.component.dnd.DropTarget;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import nc.unc.gl.borne.Plateau;
import nc.unc.gl.borne.gui.component.normal.CardComponent;
import nc.unc.gl.borne.gui.component.parade.CardParadeConpoment;
import nc.unc.gl.borne.modele.Carte;
import nc.unc.gl.borne.services.ObserverService;

import java.util.ArrayList;
import java.util.List;

import static nc.unc.gl.borne.services.ObserverService.getCurrentJoueur;

public class CardContainerComponent extends Div implements DropTarget<CardComponent>, HasStyle {
        public List<CardComponent> cartes = new ArrayList<>();
        private int type;
        private int effet;
        private int cpt=0;
        private boolean carteSpecifique;
        private Div div;
        // TODO enlever les commentaires devant. private Joueur joueur;
        public CardContainerComponent(int type, int effet, String nameContainer, Boolean carteSpecifique){
            this.carteSpecifique = carteSpecifique;
            this.setActive(true);
            this.type = type;
            this.effet = effet;
            div = new Div();
            div.addClassName("rectangle");
            this.add(new Span(nameContainer),div);
            this.setDropEffect(DropEffect.MOVE);
            this.addDropListener(e ->{
                int nbCartes = getCurrentJoueur().getMain().size();
                if (nbCartes < 7){
                    Notification.show("Vous n'avez pas encore pioché");
                    return;
                }
                if(e.getDropEffect() == DropEffect.MOVE) {

                    e.getDragData().ifPresent(data -> {
                        // the server side drag data is available if it has been set and the
                        // component was dragged from the same UI as the drop target
                        Carte carte = (Carte) data;
                        if(type == carte.getType() && effet == carte.getEffet() | carteSpecifique && type == carte.getType()){
                            boolean peutJouer = getCurrentJoueur().getPeutJouer();
                            if(ObserverService.actionJoueur(carte, "play") && peutJouer) {
                                CardComponent card = (CardComponent) e.getDragSourceComponent().get();
                                card.getImage().removeClassName("size_of_card_player");
                                card.getImage().removeClassName("space_between_img");
                                card.getImage().addClassName("size_of_depository_card");
                                card.getImage().addClassName("superpose_card");
                                card.getImage().setId("img_" + cpt);
                                cpt++;
                                div.add(card.getImage());
                            }
                            else{
                                Notification.show("Vous ne pouvez pas jouer cette carte ou ce n'est pas votre tour");
                            }
                        }
                        else{
                            Notification.show("Cette carte ne correspond au container");
                        }
                        if (carte.getType() == 1 && carte.getEffet() == 1){
                            // clear p1/CardParadeCompoment si c'est un feu vert

                        }
                    });
                }
            });
        }

    public int getType() {
        return type;
    }

    public int getEffet() {
        return effet;
    }


    public boolean isCarteSpecifique() {
        return carteSpecifique;
    }
}
