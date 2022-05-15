package nc.unc.gl.borne;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import nc.unc.gl.borne.gui.component.CardComponent;
import nc.unc.gl.borne.gui.component.CardContainerComponent;
import nc.unc.gl.borne.gui.component.PlayerComponent;
import nc.unc.gl.borne.modele.Joueur;
import nc.unc.gl.borne.services.JoueurService;
import nc.unc.gl.borne.services.ObserverService;

import java.awt.*;

@Route("plateau")
@StyleSheet("frontend/login-rich-content.css")
public class Plateau extends VerticalLayout {
        private final HorizontalLayout playerLeft;
        private final HorizontalLayout middleZone;
        private final HorizontalLayout footerZone;
        private Joueur joueur1;
        private Joueur joueur2;
        private final Div divJoueur1=new Div();

    public Plateau() {
        joueur1 = ObserverService.getCurrentJoueur();
        joueur2 = ObserverService.getCurrentAutreJoueur();

        middleZone = new HorizontalLayout();
        CardContainerComponent r1 = new CardContainerComponent(3,1,"25",false, joueur1);
        CardContainerComponent r2 = new CardContainerComponent(3,2,"50",false, joueur1);
        CardContainerComponent r3 = new CardContainerComponent(3,3,"75",false, joueur1);
        CardContainerComponent r4 = new CardContainerComponent(3,4,"100",false, joueur1);
        CardContainerComponent r5 = new CardContainerComponent(3,5,"200",false, joueur1);
        CardContainerComponent r6 = new CardContainerComponent(1,1,"feu vert",false, joueur1);
        CardContainerComponent r7 = new CardContainerComponent(2,0,"botte",true, joueur1);
        middleZone.addClassName("containerDepotCarte");
        middleZone.add(r1,r2,r3,r4,r5,r6,r7);


        playerLeft = new HorizontalLayout();
        playerLeft.addClassName("playerRight");
        PlayerComponent playerComponent = new PlayerComponent(joueur1,joueur2);
        PlayerComponent playerComponent = new PlayerComponent(joueur2);
        playerComponent.addClassName("style_txt");
        playerLeft.add(playerComponent);

        footerZone = new HorizontalLayout();
        footerZone.addClassName("footer");
        H1 infoJ1 = new H1("count : "+String.valueOf(joueur1.getPoints())+" player : "+joueur1.getPseudo());
        infoJ1.addClassName("style_txt");
        infoJ1.addClassName("position_of_info_j1");
        divJoueur1.add(infoJ1);
        footerZone.add(divJoueur1);

        Div piocheCarte=new Div();
        piocheCarte.setId("piocheCarte");
        Button buttonPioche = new Button("Pioche");
        piocheCarte.add(buttonPioche);

        add(playerLeft,middleZone,footerZone);
        add(piocheCarte);
        ajouterCarteDebut();
    }
    public static void showDialog(String caption) {
        VerticalLayout dialogLayout = new VerticalLayout(new Div());
        dialogLayout.setWidth("10%");
        dialogLayout.setMargin(false);
        dialogLayout.setPadding(false);
        Dialog dialog = new Dialog(new H3(caption), dialogLayout);
        dialog.setHeight("40%");
        dialog.setWidth("50%");
        dialog.open();
    }

    private void ajouterCarteDebut(){
        for(int i=0;i< joueur1.getMain().size();i++){
            footerZone.add(new CardComponent(joueur1.getMain().get(i)));
        }
    }

}
