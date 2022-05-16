package nc.unc.gl.borne;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import nc.unc.gl.borne.gui.component.*;
import nc.unc.gl.borne.gui.component.normal.CardComponent;
import nc.unc.gl.borne.gui.component.normal.CardContainerComponent;
import nc.unc.gl.borne.gui.component.parade.CardParadeConpoment;
import nc.unc.gl.borne.gui.component.parade.CardParadeLimitVitesseComponent;
import nc.unc.gl.borne.services.JoueurService;
import nc.unc.gl.borne.services.ObserverService;
import com.vaadin.flow.component.dialog.Dialog;


import static nc.unc.gl.borne.services.ObserverService.getCurrentAutreJoueur;
import static nc.unc.gl.borne.services.ObserverService.getCurrentJoueur;

@Route("plateau")
@StyleSheet("frontend/login-rich-content.css")
public class Plateau extends VerticalLayout {
        private final HorizontalLayout playerLeft;
        private final HorizontalLayout middleZone;
        private final HorizontalLayout upperZone;
        private final HorizontalLayout footerZone;
        private final Div divJoueur1=new Div();
        private final Div divPoubelle=new Div();

        private CardParadeConpoment p1;
        private CardParadeLimitVitesseComponent p2;
        PlayerComponent playerComponent;

        private H1 infoJ1;
        private int cpt =0;

    public Plateau() {
        // Image poubelle = new Image("Images/poubelle.png","poubelle");
        // poubelle.addClassName("size_trash");
        // divPoubelle.addClassName("trash");
        // divPoubelle.add(poubelle);

        upperZone = new HorizontalLayout();
        p1 = new CardParadeConpoment();
        p2 = new CardParadeLimitVitesseComponent();
        upperZone.addClassName("containerDepotCarteUpper");
        upperZone.add(p1, p2);

        middleZone = new HorizontalLayout();
        PoubelleContainerComponent poubelle = new PoubelleContainerComponent("Defausse");
        CardContainerComponent r1 = new CardContainerComponent(3,1,"25",false);
        CardContainerComponent r2 = new CardContainerComponent(3,2,"50",false);
        CardContainerComponent r3 = new CardContainerComponent(3,3,"75",false);
        CardContainerComponent r4 = new CardContainerComponent(3,4,"100",false);
        CardContainerComponent r5 = new CardContainerComponent(3,5,"200",false);
        CardContainerComponent r6 = new CardContainerComponent(1,1,"feu vert",false);
        CardContainerComponent r7 = new CardContainerComponent(2,0,"botte",true);
        middleZone.addClassName("containerDepotCarte");
        middleZone.add(poubelle, r1,r2,r3,r4,r5,r6,r7);

        playerLeft = new HorizontalLayout();
        playerLeft.addClassName("playerRight");

        playerComponent = new PlayerComponent(getCurrentAutreJoueur());
        playerComponent.addClassName("style_txt");
        playerLeft.add(playerComponent);

        footerZone = new HorizontalLayout();
        footerZone.addClassName("footer");
        infoJ1 = new H1("Score : "+String.valueOf(getCurrentJoueur().getPoints())+" player : "+getCurrentJoueur().getPseudo());
        infoJ1.addClassName("style_txt");
        infoJ1.addClassName("position_of_info_j1");
        divJoueur1.add(infoJ1);
        footerZone.add(divJoueur1);
        footerZone.add(divPoubelle);

        Div piocheCarte=new Div();
        piocheCarte.setId("piocheCarte");
        Button buttonPioche = new Button("Pioche");
        buttonPioche.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPioche.addThemeVariants(ButtonVariant.LUMO_LARGE);
        piocheCarte.add(buttonPioche);
        piocheCarte.addClickListener(buttonClickEvent -> piocherCarte());

        add(playerLeft,upperZone, middleZone,footerZone);
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

    public void piocherCarte(){
        infoJ1.setText("Score : "+String.valueOf(getCurrentJoueur().getPoints())+" player : "+getCurrentJoueur().getPseudo() + "Your turn : " + getCurrentJoueur().getPeutJouer());
        playerComponent.setInfoJ2("Score : "+getCurrentAutreJoueur().getPoints()+" player :"+getCurrentAutreJoueur().getPseudo());
        if (getCurrentJoueur().getAttaque() != null)
            p1.setAttaque(getCurrentJoueur().getAttaque());

        if (getCurrentJoueur().getVitesse() != null)
            p2.setAttaque(getCurrentJoueur().getVitesse());

        int nbCartes = getCurrentJoueur().getMain().size();
        if(cpt != getCurrentAutreJoueur().getImmunites().size()){
            Image temp = new Image(getCurrentAutreJoueur().getImmunites().get(cpt).getImageNom(),"Bottes");
            temp.setId("img_bot_"+cpt);
            temp.addClassName("bottesPlayerLeft");
            playerComponent.getBottes().add(temp);
        }
        if (!getCurrentJoueur().getPeutJouer()){
            Notification.show("Ce n'est pas votre tour!");
        }
        else if (nbCartes > 6){
            Notification.show("Vous avez trop de cartes");
        }
        else{
            JoueurService.piocherCarte(ObserverService.getDeck(), getCurrentJoueur());
            footerZone.add(new CardComponent(getCurrentJoueur().getMain().get(getCurrentJoueur().getMain().size()-1)));
        }
    }
    private void ajouterCarteDebut(){
        for(int i=0;i< getCurrentJoueur().getMain().size();i++){
            footerZone.add(new CardComponent(getCurrentJoueur().getMain().get(i)));
        }
    }

}
