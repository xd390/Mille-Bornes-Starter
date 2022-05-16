package nc.unc.gl.borne;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import nc.unc.gl.borne.modele.Joueur;
import nc.unc.gl.borne.services.ObserverService;


@Route("menu")
@PageTitle("Menu")
public class MenuView extends VerticalLayout {

    Div menu;
    private ObserverService observer;

    private Dialog dialog = new Dialog();
    private final TextField pseudo;

    public MenuView(){
        addClassName("-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);


        menu = new Div();
        pseudo = new TextField();
        pseudo.setRequired(true);
        pseudo.setLabel("Entrer votre pseudo");
        Button play = new Button();
        play.addClickListener(buttonClickEvent -> jouer());
        play.setText("Jouer");
        menu.add(pseudo,play);
        Image titre = new Image("Images/MilleBorne.PNG","Titre");
        menu.add(pseudo, play);

        add(titre);
        add(menu);
        add(dialog);

    }

    public void showDialog(String caption) {
        VerticalLayout dialogLayout = new VerticalLayout(new Div());
        dialogLayout.setWidth("10%");
        dialogLayout.setMargin(false);
        dialogLayout.setPadding(false);
        dialog = new Dialog(new H3(caption), dialogLayout);
        dialog.setHeight("40%");
        dialog.setWidth("50%");
        dialog.open();
    }


    private void jouer(){
        if(pseudo.getOptionalValue().isPresent()){
            // showDialog("En attente de joueurs...");
            initPartie();
        }
        else{
            Notification.show("Vous devez entrer un pseudo");
        }
    }

    public void initPartie(){
        String name = pseudo.getValue();
        Joueur joueur = new Joueur(name);
        observer = new ObserverService(joueur);

        while (ObserverService.getAllSessions().size() < 2){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        observer.lancerPartie();
        observer.getCurrent().navigate(Plateau.class);
    }
}
