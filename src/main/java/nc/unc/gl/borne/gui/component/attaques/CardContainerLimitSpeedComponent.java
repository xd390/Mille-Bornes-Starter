package nc.unc.gl.borne.gui.component.attaques;

import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.dnd.DropEffect;
import com.vaadin.flow.component.dnd.DropTarget;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import nc.unc.gl.borne.gui.component.normal.CardComponent;
import nc.unc.gl.borne.modele.Carte;
import nc.unc.gl.borne.services.ObserverService;

import static nc.unc.gl.borne.services.ObserverService.getCurrentJoueur;

public class CardContainerLimitSpeedComponent extends Div implements DropTarget<CardComponent>, HasStyle {
    private Div div;
    public CardContainerLimitSpeedComponent(){
        this.addClassName("cardPlayerMalus");
        div = new Div();
        this.add(new Span("Attaque limite de vitesse"), div);
        this.setActive(true);
        this.setDropEffect(DropEffect.MOVE);
        this.addDropListener(e ->{
            if(e.getDropEffect() == DropEffect.MOVE) {
                int nbCartes = getCurrentJoueur().getMain().size();
                if (nbCartes < 7){
                    Notification.show("Vous n'avez pas encore pioché");
                    return;
                }
                e.getDragData().ifPresent(data -> {
                    // the server side drag data is available if it has been set and the
                    // component was dragged from the same UI as the drop target
                    Carte res = (Carte) data;
                    boolean peutJouer = getCurrentJoueur().getPeutJouer();
                    if(0 == res.getType() && res.getEffet() == 2 && ObserverService.ActionJoueur(res, "play") && peutJouer) {
                        CardComponent carte = (CardComponent) e.getDragSourceComponent().get();
                        carte.getImage().removeClassName("size_of_card_player");
                        carte.getImage().removeClassName("space_between_img");
                        carte.getImage().addClassName("cardMalusPlayerLeft");
                        this.add(carte.getImage());
                    }
                    else{
                        Notification.show("Cette carte ne correspond au container ou ce n'est pas votre tour");
                    }
                });
            }
        });
    }
}
