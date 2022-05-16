package nc.unc.gl.borne.gui.component.parade;

import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.dnd.DropEffect;
import com.vaadin.flow.component.dnd.DropTarget;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import nc.unc.gl.borne.gui.component.normal.CardComponent;
import nc.unc.gl.borne.modele.Carte;
import nc.unc.gl.borne.services.ObserverService;

import static nc.unc.gl.borne.services.ObserverService.getCurrentJoueur;


public class CardParadeConpoment extends Div implements DropTarget<CardComponent>, HasStyle {

    private Div div;

    public void setAttaque(Carte carte) {
        div.removeAll();
        Image image = new Image(carte.getImageNom(), "Attaque");
        image.addClassName("size_of_depository_card");
        image.addClassName("superpose_card");
        div.add(image);
    }
    public CardParadeConpoment(){
        div = new Div();
        div.addClassName("rectangle");
        this.add(new Span("Contre attaque"), div);
        this.setActive(true);
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
                    Carte res = (Carte) data;
                    boolean peutJouer = getCurrentJoueur().getPeutJouer();
                    if(1 == res.getType() && res.getEffet() != 2 && res.getEffet() != 1 && ObserverService.ActionJoueur(res, "play") && peutJouer) {
                        CardComponent carte = (CardComponent) e.getDragSourceComponent().get();
                        carte.getImage().removeClassName("size_of_card_player");
                        carte.getImage().removeClassName("space_between_img");
                        carte.getImage().addClassName("size_of_depository_card");
                        carte.getImage().addClassName("superpose_card");
                        div.add(carte.getImage());
                    }
                    else{
                        Notification.show("Cette carte ne correspond au container");
                    }
                });
            }
        });
    }
}
