package nc.unc.gl.borne;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

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
        cartes.add(img,img2,img3,img4);

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
