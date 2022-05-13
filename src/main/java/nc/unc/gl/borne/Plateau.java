package nc.unc.gl.borne;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.dnd.DragSource;
import com.vaadin.flow.component.dnd.DropEffect;
import com.vaadin.flow.component.dnd.DropTarget;
import com.vaadin.flow.component.dnd.EffectAllowed;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import com.vaadin.flow.component.notification.Notification;
import nc.unc.gl.borne.modele.Deck;

@Route("plateau")
@StyleSheet("frontend/login-rich-content.css")
public class Plateau extends HorizontalLayout {
    public Plateau(){
        Div cartes = new Div();
        Div container=new Div();
        Div  containerPoseCarte=new Div();
        Div joueurDroite=new Div();
        Div carteJoueur=new Div();
        Div carteMalus=new Div();
        Div carteBot=new Div();
        Div informationJoueur=new Div();

        container.addClassName("container");
        containerPoseCarte.addClassName("containerDepotCarte");
        joueurDroite.addClassName("playerRight");
        carteJoueur.addClassName("cardPlayer");
        carteMalus.addClassName("cardPlayerMalus");
        carteBot.addClassName("cardPlayerBot");

        informationJoueur.setId("infoJoueur");


        informationJoueur.setText("count : 200  player : 2");

        container.add( containerPoseCarte,joueurDroite);


        Div r1 = new Div();
        Div r2 = new Div();
        Div r3 = new Div();
        Div r4 = new Div();
        Div r5 = new Div();

        r1.addClassName("rectangle");
        r2.addClassName("rectangle");
        r3.addClassName("rectangle");
        r4.addClassName("rectangle");
        r5.addClassName("rectangle");


        DropTarget<Div> dropTarget1 = DropTarget.create(r1);
        dropTarget1.setDropEffect(DropEffect.MOVE);
        dropTarget1.addDropListener(event -> {
            Notification.show(String.valueOf(event.getDropEffect()));
            // move the dragged component to inside the drop target component
            if (event.getDropEffect() == DropEffect.MOVE) {
                // the drag source is available only if the dragged component is from
                // the same UI as the drop target
                event.getDragSourceComponent().ifPresent(r1::add);

                event.getDragData().ifPresent(data -> {
                    // the server side drag data is available if it has been set and the
                    // component was dragged from the same UI as the drop target
                    var res  = (Image) data;
                    Notification.show(res.getSrc());

                });
            }
        });
        DropTarget<Div> dropTarget2 = DropTarget.create(r2);
        DropTarget<Div> dropTarget3 = DropTarget.create(r3);
        DropTarget<Div> dropTarget4 = DropTarget.create(r4);
        DropTarget<Div> dropTarget5 = DropTarget.create(r5);

        Image img = new Image("/cartes/attaque_vitesse.jpeg","carte");
        Image img2 = new Image("/cartes/attaque_feu.jpeg","carte");
        Image img3 = new Image("/cartes/botte_accident.jpeg","carte");
        Image img4 = new Image("/cartes/parade_crevaison.jpeg","carte");

        Image imgJoueur=new Image("/cartes/attaque_vitesse.jpeg","carte");
        Image imgJoueurMalus=new Image("/cartes/attaque_feu.jpeg","carte");
        Image imgJoueurBot=new Image("/cartes/botte_accident.jpeg","carte");


        img.addClassName("space_between_img");
        img2.addClassName("space_between_img");
        img3.addClassName("space_between_img");
        img4.addClassName("space_between_img");
        cartes.addClassName("footer");

        Div carte1 = new Div();
        carte1.add(img);
        Div carte2 = new Div();
        carte2.add(img2);
        Div carte3 = new Div();
        carte2.add(img3);
        Div carte4 = new Div();
        carte2.add(img4);
        DragSource<Image> carte1Draggable = DragSource.create(img);
        carte1Draggable.addDragStartListener(e -> {
            Notification.show("Vous avez sélectionner une carte");
        });
        carte1Draggable.addDragEndListener(e -> {
           e.clearDragData();
        });
        carte1Draggable.setDragData(carte1);
        carte1Draggable.setEffectAllowed(EffectAllowed.MOVE);
        cartes.add(carte1,carte2,carte3,carte4);

        carteJoueur.add(imgJoueur);
        carteMalus.add(imgJoueurMalus);
        carteBot.add(imgJoueurBot);


        joueurDroite.add(informationJoueur);
        joueurDroite.add(carteJoueur);
        joueurDroite.add(carteMalus);
        joueurDroite.add(carteBot);



        containerPoseCarte.add(r1,r2,r3,r4,r5);

        add(container);
        add(cartes);

    }
    }
