package nc.unc.gl.borne;

import com.vaadin.flow.component.HtmlContainer;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.Route;
import nc.unc.gl.borne.gui.component.CardComponent;
import nc.unc.gl.borne.gui.component.CardContainerComponent;
import nc.unc.gl.borne.gui.component.PlayerComponent;
import nc.unc.gl.borne.modele.Carte;
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
        private final Joueur joueur1;
        private final Joueur joueur2;
        private final Div divJoueur1=new Div();
        private final Div divPoubelle=new Div();

    public Plateau() {


        joueur1 = ObserverService.getJoueur(JoueurService.getNomJoueur());
        joueur2 = ObserverService.getAutreJoueur(JoueurService.getNomJoueur());

        Image poubelle=new Image("Images/poubelle.jpg","poubelle");
        poubelle.addClassName("size_trash");
        divPoubelle.addClassName("trash");
        divPoubelle.add(poubelle);


        middleZone = new HorizontalLayout();
        CardContainerComponent r1 = new CardContainerComponent(3,1,"25",false);
        CardContainerComponent r2 = new CardContainerComponent(3,2,"50",false);
        CardContainerComponent r3 = new CardContainerComponent(3,3,"75",false);
        CardContainerComponent r4 = new CardContainerComponent(3,4,"100",false);
        CardContainerComponent r5 = new CardContainerComponent(3,5,"200",false);
        CardContainerComponent r6 = new CardContainerComponent(1,1,"feu vert",false);
        CardContainerComponent r7 = new CardContainerComponent(2,0,"botte",true);
        middleZone.addClassName("containerDepotCarte");
        middleZone.addClassName("myresponsive");
        middleZone.add(r1,r2,r3,r4,r5,r6,r7);


        playerLeft = new HorizontalLayout();
        playerLeft.addClassName("playerRight");
        playerLeft.addClassName("myresponsive");
        PlayerComponent playerComponent = new PlayerComponent(joueur2);
        playerComponent.addClassName("style_txt");
        playerLeft.add(playerComponent);

        footerZone = new HorizontalLayout();
        footerZone.addClassName("footer");
        footerZone.addClassName("myresponsive");
        H1 infoJ1 = new H1("count : "+String.valueOf(joueur1.getPoints())+" player : "+joueur1.getPseudo());
        infoJ1.addClassName("style_txt");
        infoJ1.addClassName("position_of_info_j1");
        divJoueur1.add(infoJ1);
        footerZone.add(divJoueur1);
        footerZone.add(divPoubelle);

        Carte c1=new Carte(2,1);
        Carte c2=new Carte(2,1);
        Carte c3=new Carte(1,1);
        Carte c4=new Carte(1,1);
        CardComponent carte1=new CardComponent(c1);
        CardComponent carte2=new CardComponent(c2);
        CardComponent carte3=new CardComponent(c3);
        CardComponent carte4=new CardComponent(c4);
        footerZone.add(carte1,carte2,carte3,carte4);

        Div piocheCarte=new Div();
        piocheCarte.setId("piocheCarte");
        Button buttonPioche = new Button("Pioche");
        piocheCarte.add(buttonPioche);

        add(playerLeft,middleZone,footerZone);
        add(piocheCarte);
        //ajouterCarteDebut();


    }
    private void ajouterCarteDebut(){
        for(int i=0;i< joueur1.getMain().size();i++){
            footerZone.add(new CardComponent(joueur1.getMain().get(i)));
        }
    }

}
