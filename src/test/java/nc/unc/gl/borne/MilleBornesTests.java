package nc.unc.gl.borne;

import lombok.RequiredArgsConstructor;
import nc.unc.gl.borne.modele.Carte;
import nc.unc.gl.borne.modele.Deck;
import nc.unc.gl.borne.modele.Joueur;
import nc.unc.gl.borne.services.CarteService;
import nc.unc.gl.borne.services.DeckService;
import nc.unc.gl.borne.services.JoueurService;
import nc.unc.gl.borne.services.PartieService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RequiredArgsConstructor
public class MilleBornesTests {
    private final ApplicationContext springContext;

    @Test
    void spring_context_should_start() {
        DeckService deckService = new DeckService();
        CarteService carteService = new CarteService();
        JoueurService joueurService = new JoueurService();
        PartieService partieService = new PartieService();

        //feu vert
        Carte carte = new Carte(1,1);
        //fin de limite
        Carte carte4 = new Carte(1,2);
        //boote citerne
        Carte carte1 = new Carte(2,3);
        //borne 25
        Carte carte2 = new Carte(3,1);
        //borne 50
        Carte carte3 = new Carte(3,2);
        //panne essence
        Carte carte5 = new Carte(0,3);
        //crevaison
        Carte carte6 = new Carte(0,4);
        //increvable
        Carte carte7 = new Carte(2,4);
        //accident
        Carte carte8 = new Carte(0,5);
        //Prioritaire
        Carte carte9 = new Carte(2,1);
        //feu rouge
        Carte carte10 = new Carte(0,1);
        //limite de vitessee
        Carte carte11 = new Carte(0,2);
        //borne 75
        Carte carte12 = new Carte(3,3);
        //roue de secours
        Carte carte13 = new Carte(1,4);
        //essence
        Carte carte14 = new Carte(1,3);

        Joueur joueur1= new Joueur("Omni");
        Joueur joueur2= new Joueur("tony");
        Joueur joueur3= new Joueur("flo");
        Deck laPioche = new Deck();

        System.out.println(carte.toString());
        System.out.println(carte1.toString());
        System.out.println(carte2.toString());

        System.out.println("---Joueur 1---");
        //On test jouer une carte feu vert afin de demarrer
        System.out.println(joueur1.toString());
        carteService.jouerCarte(carte,joueur1,joueur2);
        //On joue la botte prioritaire qui permet aussi de demarrer
        System.out.println(joueur1.toString());
        carteService.jouerCarte(carte9,joueur1,joueur2);
        System.out.println(joueur1.toString());
        //On joue une carte borne 25 en ayant démarrer /message d'erreur si on a pas encore demarrer
        carteService.jouerCarte(carte2,joueur1,joueur2);
        System.out.println(joueur1.toString());
        //On joue une 2eme carte borne 75 pour un total de 100
        carteService.jouerCarte(carte12,joueur1,joueur2);
        System.out.println(joueur1.toString());


        System.out.println("---Joueur 2---");
        //test joueur2 a etre bien immunisé contre les attaques 1 et 2 lorsque il a la botte prioritaire
        System.out.println(joueur2.toString());
         //on joue la botte prioritaire pour demarrer et etre immuniser
        carteService.jouerCarte(carte9,joueur2,joueur1);
        System.out.println(joueur2.toString());
        //on attaque avec un feu rouge
        carteService.jouerCarte(carte10,joueur1,joueur2);
        System.out.println(joueur2.toString());
        //on attaque avec une limite de vitesse
        carteService.jouerCarte(carte11,joueur1,joueur2);
        System.out.println(joueur2.toString());
        //On attaque le joueur2 puis on pare l'attaque en jouant la botte adéquate
        //crevaison
        carteService.jouerCarte(carte6,joueur1,joueur2);
        System.out.println(joueur2.toString());
        //increvable
        carteService.jouerCarte(carte7,joueur2,joueur1);
        System.out.println(joueur2.toString());

        System.out.println("---Joueur 3---");
        System.out.println(joueur3.toString());
        //On attaque avec une limite de vitesse et modifier la vitesse sur un joueur sans avoir demarrer
        carteService.jouerCarte(carte11,joueur1,joueur3);
        System.out.println(joueur3.toString());
        //On attaque avec une panne d'essence sur un joueur sans avoir demarrer
        carteService.jouerCarte(carte5,joueur1,joueur3);
        System.out.println(joueur3.toString());

        //On attaque avec une panne d'essence sur un joueur ayant demarrer
        carteService.jouerCarte(carte,joueur3,joueur2);
        carteService.jouerCarte(carte5,joueur1,joueur3);
        System.out.println(joueur3.toString());
        //On attaque un joueur deja attaqué
        carteService.jouerCarte(carte8,joueur1,joueur3);
        System.out.println(joueur3.toString());
        //On utilise une parade différente de la panne d'essence
        carteService.jouerCarte(carte13,joueur3,joueur1);
        System.out.println(joueur3.toString());
        //On utilise une parade a la panne d'essence
        carteService.jouerCarte(carte14,joueur3,joueur1);
        System.out.println(joueur3.toString());
        //On joue une carte borne supérieur a la limite de vitesse
        carteService.jouerCarte(carte12,joueur3,joueur1);
        System.out.println(joueur3.toString());
        //On joue une carte borne inférieur a la limite de vitesse
        carteService.jouerCarte(carte3,joueur3,joueur1);
        System.out.println(joueur3.toString());
        //On utilise une fin de limite de vitesse
        carteService.jouerCarte(carte4,joueur3,joueur1);
        System.out.println(joueur3.toString());

        //On initialise un deck qui créer 106 cartes et les mélanges
        deckService.initialiserDeck(laPioche);
        System.out.println(laPioche.size());
        //On distribue 6cartes a 2joueurs
        partieService.distribuerMain(laPioche,joueur1,joueur2);
        //On affiche les mains
        joueur1.ecrireMain();
        joueur2.ecrireMain();
        //On affiche la taille du deck qui doit passé de 106 a 94 cartes
        System.out.println(laPioche.size());

        //On teste de défausser la premiere carte de la main du joueur 1
        joueurService.defausserCarte(joueur1.getMain().get(0),joueur1);
        joueur1.ecrireMain();

        //On teste de défausser la 4eme carte de la main du joueur 2
        joueurService.defausserCarte(joueur2.getMain().get(3),joueur2);
        joueur2.ecrireMain();
    }


}
