package nc.unc.gl.borne.gui.component;

import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.dnd.DropEffect;
import com.vaadin.flow.component.dnd.DropTarget;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import nc.unc.gl.borne.modele.Carte;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CardContainerComponent extends Div implements DropTarget<CardComponent>, HasStyle {
        public List<CardComponent> cartes = new ArrayList<>();
        private int type;
        private int effet;
        private int cpt=0;
        private boolean carteSpecifique;
        // TODO enlever les commentaires devant. private Joueur joueur;
        public CardContainerComponent(int type, int effet, String nameContainer, Boolean carteSpecifique){
            this.carteSpecifique = carteSpecifique;
            this.setActive(true);
            this.type = type;
            this.effet = effet;
            this.addClassName("rectangle");
            //this.setText(nameContainer);
            this.setDropEffect(DropEffect.MOVE);
            this.addDropListener(e ->{
                Notification.show("tentative de pose carte");
                if(e.getDropEffect() == DropEffect.MOVE) {
                    e.getDragData().ifPresent(data -> {
                        // the server side drag data is available if it has been set and the
                        // component was dragged from the same UI as the drop target
                        Carte res = (Carte) data;
                        if(type == res.getType() && effet == res.getEffet() | carteSpecifique && type == res.getType()){
                            CardComponent res2 = (CardComponent) e.getDragSourceComponent().get();
                            res2.getImage().removeClassName("size_of_card_player");
                            res2.getImage().removeClassName("space_between_img");
                            res2.getImage().addClassName("size_of_depository_card");
                            res2.getImage().addClassName("superpose_card");
                            res2.getImage().setId("img_"+cpt);
                            cpt++;
                            this.add(res2.getImage());
                            // TODO appeler le service et faire jouer la carte
                        }
                        else{
                            Notification.show("Cette carte ne correspond au container");
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
