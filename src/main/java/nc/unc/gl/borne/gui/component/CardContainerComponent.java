package nc.unc.gl.borne.gui.component;

import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.dnd.DropEffect;
import com.vaadin.flow.component.dnd.DropTarget;
import com.vaadin.flow.component.html.Div;
import nc.unc.gl.borne.modele.Carte;

import java.util.ArrayList;
import java.util.List;

public class CardContainerComponent extends Div implements DropTarget<CardComponent>, HasStyle {
        public List<CardComponent> cartes = new ArrayList<>();
        public int type;
        private int effet;
        public CardContainerComponent(int type, int effet, String nameContainer){
            this.type = type;
            this.effet = effet;
            this.setTitle(nameContainer);
            this.setDropEffect(DropEffect.MOVE);
            this.addDropListener(e ->{
                if(e.getDropEffect() == DropEffect.MOVE) {
                    e.getDragData().ifPresent(data -> {
                        // the server side drag data is available if it has been set and the
                        // component was dragged from the same UI as the drop target
                        if(data.getClass().equals(CardComponent.class)){
                            cartes.add((CardComponent) data);
                            //e.getDragSourceComponent().ifPresent();
                        }
                    });
                }
            });
        }

}
