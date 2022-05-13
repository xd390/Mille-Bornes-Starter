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
        private boolean carteSpecifique;
        // TODO enlever les commentaires devant. private Joueur joueur;
        public CardContainerComponent(int type, int effet, String nameContainer, Boolean carteSpecifique){
            this.carteSpecifique = carteSpecifique;
            this.type = type;
            this.effet = effet;
            this.addClassName("rectangle");
            this.setTitle(nameContainer);
            this.setDropEffect(DropEffect.MOVE);
            this.addDropListener(e ->{
                if(e.getDropEffect() == DropEffect.MOVE) {
                    e.getDragData().ifPresent(data -> {
                        // the server side drag data is available if it has been set and the
                        // component was dragged from the same UI as the drop target
                        CardComponent res = (CardComponent) data;
                        Carte carte = res.getCarte();
                        if(type == carte.getType() && effet == carte.getEffet() | carteSpecifique && type == carte.getType()){
                            cartes.add(res);
                            e.getComponent().add(res);
                            // TODO appeler le service et faire jouer la carte
                        }
                        else{
                            Notification.show("Cette carte ne correspond au container");
                        }
                    });
                }
            });
        }

}
