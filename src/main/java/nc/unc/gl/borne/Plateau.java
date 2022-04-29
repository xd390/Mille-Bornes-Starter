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
        Div poseCartes=new Div();

        poseCartes.addClassName("container");

        Div r1 = new Div();
        Div r2 = new Div();
        Div r3 = new Div();
        Div r4 = new Div();
        Div r5 = new Div();

        r1.addClassName("rect");
        r2.addClassName("rect");
        r3.addClassName("rect");
        r4.addClassName("rect");
        r5.addClassName("rect");


        Image img = new Image("/cartes/attaque_vitesse.jpeg","carte");
        Image img2 = new Image("/cartes/attaque_feu.jpeg","carte");
        Image img3 = new Image("/cartes/botte_accident.jpeg","carte");
        Image img4 = new Image("/cartes/parade_crevaison.jpeg","carte");

        img.addClassName("padded_img");
        img2.addClassName("padded_img");
        img3.addClassName("padded_img");
        img4.addClassName("padded_img");
        cartes.addClassName("footer");
        cartes.add(img,img2,img3,img4);



        poseCartes.add(r1,r2,r3,r4,r5);

        add(poseCartes);
        add(cartes);

    }
    }
