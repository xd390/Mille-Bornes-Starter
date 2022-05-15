package nc.unc.gl.borne.services;

import nc.unc.gl.borne.modele.Carte;
import nc.unc.gl.borne.modele.Deck;
import nc.unc.gl.borne.modele.Joueur;

import java.util.ArrayList;

public class JoueurService {

    public static void piocherCarte(Deck pioche,Joueur joueur) {
        joueur.main.add((Carte) pioche.pop());
    }

    public static void defausserCarte(Carte carte,Joueur joueur) {
        joueur.main.remove(carte);
    }

    public static void poserBorne(Carte carteBorne, Joueur joueur) {
        int bornes = carteBorne.getEffet();
        bornes = Integer.parseInt(Carte.getEffets()[3][bornes]);
        joueur.points += bornes;
        joueur.main.remove(carteBorne);

    }

    public static void attaquer(Carte carteAttaque, Joueur joueur , Joueur receiveAttaque) {
        receiveAttaque.setAttaque(carteAttaque);
        joueur.main.remove(carteAttaque);
    }

    public static void poserLimiteVitesse(Carte carteAttaque, Joueur joueur , Joueur receiveAttaque) {
        receiveAttaque.setVitesse(carteAttaque);
        joueur.main.remove(carteAttaque);
    }

    public static void poserFinLimite(Carte carteParade,Joueur joueur) {
        joueur.vitesse = null;
        joueur.main.remove(carteParade);

    }
    public static void poserBotte(Carte botte,Joueur joueur) {
        joueur.immunites.add(botte);
        joueur.main.remove(botte);
    }

    public static void poserParade(Carte carteParade,Joueur joueur) {
        if (joueur.isDemarre() == false && carteParade.getEffet() == 1) {
            joueur.setDemarre(true);
        }
        else {
            joueur.setAttaque(null);
        }
        joueur.main.remove(carteParade);

    }

}
