package nc.unc.gl.borne.gui.component;

import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.dnd.DropEffect;
import com.vaadin.flow.component.dnd.DropTarget;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import nc.unc.gl.borne.modele.Carte;
import nc.unc.gl.borne.services.ObserverService;

import java.util.ArrayList;
import java.util.List;

import static nc.unc.gl.borne.services.ObserverService.getCurrentAutreJoueur;
import static nc.unc.gl.borne.services.ObserverService.getCurrentJoueur;

public class CardContainerAttackComponent extends Div implements DropTarget<CardComponent>, HasStyle {
        // TODO enlever les commentaires devant. private Joueur joueur;

        public CardContainerAttackComponent(){
            this.addClassName("rectangle");
            this.setText("Carte attaque");
            this.setActive(true);
            this.setDropEffect(DropEffect.MOVE);
            this.addDropListener(e ->{
                Notification.show("tentative de pose carte 2");
                if(e.getDropEffect() == DropEffect.MOVE) {
                    e.getDragData().ifPresent(data -> {
                        // the server side drag data is available if it has been set and the
                        // component was dragged from the same UI as the drop target
                        Carte res = (Carte) data;
                        boolean peutJouer = getCurrentJoueur().getPeutJouer();
                        if(0 == res.getType() && res.getEffet() != 2 && ObserverService.ActionJoueur(res, "play") && peutJouer) {
                            CardComponent carte = (CardComponent) e.getDragSourceComponent().get();
                            carte.getImage().removeClassName("size_of_card_player");
                            carte.getImage().removeClassName("space_between_img");
                            carte.getImage().addClassName("cardMalusPlayerLeft");
                            this.add(carte.getImage());
                        }
                        else{
                            Notification.show("Cette carte ne correspond au container");
                        }
                    });
                }
            });
        }
}

