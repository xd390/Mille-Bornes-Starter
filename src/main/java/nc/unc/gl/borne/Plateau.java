package nc.unc.gl.borne;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import nc.unc.gl.borne.gui.component.CardComponent;
import nc.unc.gl.borne.gui.component.CardContainerComponent;
import nc.unc.gl.borne.gui.component.PlayerComponent;
import nc.unc.gl.borne.modele.Carte;
import nc.unc.gl.borne.modele.Joueur;

@Route("plateau")
@StyleSheet("frontend/login-rich-content.css")
public class Plateau extends HorizontalLayout {
    public Plateau(){

        Joueur joueur2=new Joueur("toto");
        CardComponent cartes=new CardComponent();
        Div containerPoseCarte=new Div();
        Div joueurDroite=new Div();
        CardComponent carteJoueur=new CardComponent();
        PlayerComponent playerComponent=new PlayerComponent(joueur2);
        Div piocheCarte=new Div();

        Div container=new Div();
        Div informationJoueur=new Div();

        container.addClassName("container");
        containerPoseCarte.addClassName("containerDepotCarte");
        joueurDroite.addClassName("playerRight");
        carteJoueur.addClassName("cardPlayer");

        informationJoueur.setId("infoJoueur");
        piocheCarte.setId("piocheCarte");

        informationJoueur.setText("count : 200  player : 2");

        container.add( containerPoseCarte,joueurDroite);

        CardContainerComponent r1 = new CardContainerComponent(3,1,"25",false);
        CardContainerComponent r2 = new CardContainerComponent(3,2,"50",false);
        CardContainerComponent r3 = new CardContainerComponent(3,3,"75",false);
        CardContainerComponent r4 = new CardContainerComponent(3,4,"100",false);
        CardContainerComponent r5 = new CardContainerComponent(3,5,"200",false);

        Button buttonPioche = new Button("Pioche");

        Image img = new Image("/cartes/attaque_vitesse.jpeg","carte");
        Image img2 = new Image("/cartes/attaque_feu.jpeg","carte");
        Image img3 = new Image("/cartes/botte_accident.jpeg","carte");
        Image img4 = new Image("/cartes/parade_crevaison.jpeg","carte");

        Image imgJoueur=new Image("/cartes/attaque_vitesse.jpeg","carte");
        Image imgJoueurMalus=new Image("/cartes/attaque_feu.jpeg","carte");
        Image imgJoueurBot=new Image("/cartes/botte_accident.jpeg","carte");

        imgJoueur.addClassName("size_of_card_right_player");
        imgJoueurMalus.addClassName("size_of_card_right_player");
        imgJoueurBot.addClassName("size_of_card_right_player");

        Carte carte1 = new Carte(3,1);
        CardComponent carteComponent1 = new CardComponent(carte1);
        cartes.add(carteComponent1);
        cartes.addClassName("footer");

        carteJoueur.add(imgJoueur);
        playerComponent.getMalus().add(imgJoueurMalus);
        playerComponent.getBottes().add(imgJoueurBot);
        piocheCarte.add(buttonPioche);

        joueurDroite.add(informationJoueur);
        joueurDroite.add(carteJoueur);
        joueurDroite.add(playerComponent);

        containerPoseCarte.add(r1,r2,r3,r4,r5);

        add(container);
        add(cartes);
        add(piocheCarte);

    }
    }
