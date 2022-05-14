package nc.unc.gl.borne;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import nc.unc.gl.borne.modele.Joueur;
import nc.unc.gl.borne.services.ObserverService;
import nc.unc.gl.borne.session.Broadcaster;
import nc.unc.gl.borne.session.VaadinSessionsHolder;

import java.util.Map;

@Route("menu")
@PageTitle("Menu")
public class MenuView extends VerticalLayout {
    private ObserverService observer;
    private Joueur joueur;

    private Paragraph info;
    private final TextField pseudo;

    public MenuView(){
        addClassName("-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);


        Div menu = new Div();
        pseudo = new TextField();
        pseudo.setRequired(true);
        pseudo.setLabel("Entrer votre pseudo");
        Button play = new Button();
        play.addClickListener(buttonClickEvent -> jouer());
        play.setText("Jouer");
        menu.add(pseudo,play);
        Image titre = new Image("Images/MilleBorne.PNG","Titre");
        menu.add(pseudo, play);
        titre = new Image("cartes/back.PNG","Titre");
        play.addClickListener(clickEvent  -> initPartie());

        info = new Paragraph("");
        this.add(info);
        add(titre);
        add(menu);
    }
    private void jouer(){
        if(pseudo.getOptionalValue().isPresent()){

        }
        else{
            Notification.show("Vous devez entrer un pseudo");
        }
    }

    public void initPartie(){
        String name = pseudo.getValue();
        joueur = new Joueur(name);

        info.setText("En attente de joueurs...");

        System.out.println(name);

        observer = new ObserverService(joueur);

        System.out.println(observer.getCurrent().getUIId());
        System.out.println(observer.getCurrentUI());

        System.out.println(observer.getAllSessions());


        while (observer.getAllSessions().size() < 2){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        info.setText("Redirection...");
        observer.getCurrent().navigate(Plateau.class);
    }

}
