package nc.unc.gl.borne;

import com.vaadin.flow.component.HtmlContainer;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import nc.unc.gl.borne.gui.component.CardComponent;
import nc.unc.gl.borne.gui.component.CardContainerComponent;
import nc.unc.gl.borne.gui.component.PlayerComponent;
import nc.unc.gl.borne.modele.Carte;
import nc.unc.gl.borne.modele.Joueur;
import nc.unc.gl.borne.services.JoueurService;
import nc.unc.gl.borne.services.ObserverService;

@Route("plateau")
@StyleSheet("frontend/login-rich-content.css")
public class Plateau extends VerticalLayout {
        private final HorizontalLayout playerLeft;
        private final HorizontalLayout middleZone;
        private final HorizontalLayout footerZone;

    public Plateau() {
        Joueur joueur1 = ObserverService.getJoueur(JoueurService.getNomJoueur());
        Joueur joueur2 = ObserverService.getAutreJoueur(JoueurService.getNomJoueur());

        middleZone = new HorizontalLayout();
        CardContainerComponent r1 = new CardContainerComponent(3,1,"25",false);
        CardContainerComponent r2 = new CardContainerComponent(3,2,"50",false);
        CardContainerComponent r3 = new CardContainerComponent(3,3,"75",false);
        CardContainerComponent r4 = new CardContainerComponent(3,4,"100",false);
        CardContainerComponent r5 = new CardContainerComponent(3,5,"200",false);
        middleZone.addClassName("containerDepotCarte");
        middleZone.add(r1,r2,r3,r4,r5);


        playerLeft = new HorizontalLayout();
        playerLeft.addClassName("playerRight");
        Image imgJoueur=new Image("/cartes/attaque_vitesse.jpeg","carte");
        Image imgJoueurMalus=new Image("/cartes/attaque_feu.jpeg","carte");
        Image imgJoueurBot=new Image("/cartes/botte_accident.jpeg","carte");

        imgJoueur.addClassName("size_of_card_right_player");
        imgJoueurMalus.addClassName("size_of_card_right_player");
        imgJoueurBot.addClassName("size_of_card_right_player");

        // joueur2 = new Joueur("toto");
        PlayerComponent playerComponent = new PlayerComponent(joueur2);
        playerComponent.getDernièreCarteJouer().add(imgJoueur);
        playerComponent.getMalus().add(imgJoueurMalus);
        playerComponent.getBottes().add(imgJoueurBot);
        playerLeft.add(playerComponent);

        footerZone = new HorizontalLayout();

        Carte carte1 = new Carte(3,1);
        Carte carte2 = new Carte(3,1);
        CardComponent carteComponent1 = new CardComponent(carte1);
        CardComponent carteComponent2 = new CardComponent(carte2);

        footerZone.add(carteComponent1,carteComponent2);
        footerZone.addClassName("footer");

        Div piocheCarte=new Div();
        piocheCarte.setId("piocheCarte");
        Button buttonPioche = new Button("Pioche");
        piocheCarte.add(buttonPioche);

        add(playerLeft,middleZone,footerZone);
        add(piocheCarte);
    }

}
