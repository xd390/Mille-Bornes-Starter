package nc.unc.gl.borne.services;
import nc.unc.gl.borne.modele.Carte;
import nc.unc.gl.borne.modele.Deck;
import nc.unc.gl.borne.modele.Joueur;

import java.util.Collections;

public class DeckService {

    JoueurService joueurService = new JoueurService();


    public void distribuerMain(Deck pioche, Joueur joueur1, Joueur joueur2){
        for (int i = 0; i < 6; i++) {
            joueurService.piocherCarte(pioche , joueur1);
            joueurService.piocherCarte(pioche , joueur2);
        }
    }

    /**
     * Méthode permettant de créer les 106 cartes du jeu dans la pioche,
     *  et de mélanger la pioche.
     *  @param pioche le deck que l'on souhaite initialiser.
     */
    public void initialiserDeck(Deck pioche) {
        int nb = 0;
        int effet = 0;
        int type = 0;

        // Création des cartes attaques.

        // Création des 5 cartes "feu rouge".
        for (nb = 0; nb < 5; nb++) {
            pioche.add(new Carte(type, 1));
        }
        // Création des 4 cartes "limite de vitesse".
        for (nb = 0; nb < 4; nb++) {
            pioche.add(new Carte(type, 2));
        }

        // Création des 3 cartes par effet "panne d'essence", "crevaison", "accident".
        for (nb = 0; nb < 3; nb++) {
            for (effet = 3; effet < 6; effet++){
                pioche.add(new Carte(type, effet));
            }
        }
        // Changement de type : cartes parades.
        type++;
        // Création des cartes parades.

        // Création des 14 cartes "feu vert".
        for (nb = 0; nb < 14; nb++) {
            pioche.add(new Carte(type, 1));
        }
        // Création des autres cartes parades.
        for (nb = 0; nb < 6; nb++) {
            for (effet = 2; effet < 6; effet++) {
                pioche.add(new Carte(type, effet));
            }
        }

        // Changement de type : cartes bottes.
        type++;
        // Création des cartes bottes.
        for (effet = 2; effet < 6; effet++) {
            pioche.add(new Carte(2, effet));
        }

        // Changement de type : cartes bornes.
        type++;
        // Création des cartes bornes 25, 50 et 75.
        for (nb = 0; nb < 10; nb++) {
            for (effet = 1; effet < 4; effet++) {
                pioche.add(new Carte(type, effet));
            }
        }
        // Création des cartes bornes 100.
        for (nb = 0; nb < 12; nb++) {
            pioche.add(new Carte(type, 4));
        }

        // Création des cartes bornes 200.
        for (nb = 0; nb < 4; nb++) {
            pioche.add(new Carte(type, 5));
        }

        // Mélange de la pioche.
        Collections.shuffle(pioche);

    }
}
