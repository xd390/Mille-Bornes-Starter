package nc.unc.gl.borne;

import lombok.RequiredArgsConstructor;
import nc.unc.gl.borne.modele.Carte;
import nc.unc.gl.borne.modele.Joueur;
import nc.unc.gl.borne.services.CarteService;
import nc.unc.gl.borne.services.JoueurService;
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
                CarteService carteService = new CarteService();
        JoueurService joueurService = new JoueurService();
        //feu vert
        Carte carte = new Carte(1,1,Carte.getEffets()[1][1]);
        //fin de limite
        Carte carte4 = new Carte(1,2,Carte.getEffets()[1][2]);
        //boote citerne
        Carte carte1 = new Carte(2,3,Carte.getEffets()[2][3]);
        //bornes 25
        Carte carte2 = new Carte(3,1,Carte.getEffets()[3][1]);
        //panne essence
        Carte carte5 = new Carte(0,3,Carte.getEffets()[0][3]);
        //crevaison
        Carte carte6 = new Carte(0,4,Carte.getEffets()[0][4]);
        //increvable
        Carte carte7 = new Carte(2,4,Carte.getEffets()[2][4]);
        //accident
        Carte carte8 = new Carte(0,5,Carte.getEffets()[0][5]);
        //Prioritaire
        Carte carte9 = new Carte(2,1,Carte.getEffets()[2][1]);

        Joueur joueur1= new Joueur("Omni");
        Joueur joueur2= new Joueur("tony");


        System.out.println(carte.toString());
        System.out.println(carte1.toString());
        System.out.println(carte2.toString());

        System.out.println(joueur1.toString());
        carteService.jouerCarte(carte,joueur1,joueur2);
        carteService.jouerCarte(carte2,joueur1,joueur2);
        System.out.println(joueur1.toString());
        carteService.jouerCarte(carte1,joueur1,joueur2);
        System.out.println(joueur1.toString());
        carteService.jouerCarte(carte6,joueur2,joueur1);
        System.out.println(joueur1.toString());
        carteService.jouerCarte(carte7,joueur1,joueur2);
        System.out.println(joueur1.toString());
        carteService.jouerCarte(carte8,joueur1,joueur1);
        System.out.println(joueur1.toString());



        System.out.println("------");

    }
}
