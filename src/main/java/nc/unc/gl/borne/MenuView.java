package nc.unc.gl.borne;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("menu")
@PageTitle("Menu")
public class MenuView extends VerticalLayout {


    public MenuView(){
        addClassName("-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);



        Div menu = new Div();
        TextField pseudo = new TextField();
        pseudo.setRequired(true);
        pseudo.setLabel("Entrer votre pseudo");
        Button play = new Button();
        play.setText("Jouer");
        menu.add(pseudo,play);
        Image titre = new Image("cartes/back.PNG","Titre");
        add(titre);
        add(menu);
    }

}
