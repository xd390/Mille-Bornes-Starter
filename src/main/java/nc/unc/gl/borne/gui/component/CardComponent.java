package nc.unc.gl.borne.gui.component;

import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.dnd.DragSource;
import com.vaadin.flow.component.dnd.EffectAllowed;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import nc.unc.gl.borne.modele.Carte;

public class CardComponent extends Div implements DragSource<CardComponent>, HasStyle {
    private Carte carte;
    private Image image = new Image();
    // (service Carte private) final CarteService carteService = new CarteService();
    public CardComponent(){
        this.setDraggable(true);
    }
    public CardComponent(Carte carte){
        this.carte = carte;
        this.setDraggable(true);
        this.setDragData(carte);
        this.image.setSrc(carte.getImageNom());
        this.image.addClassName("space_between_img");
        this.image.addClassName("size_of_card_player");
        this.add(image);
        this.setEffectAllowed(EffectAllowed.MOVE);
        this.addDragStartListener(e ->
            Notification.show("Vous avez selectionner une carte")
        );
        this.addClassName("Carte-main");

    }

    public Image getImage() {
        return image;
    }

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
        this.image.setSrc(carte.getImageNom());
    }
}
