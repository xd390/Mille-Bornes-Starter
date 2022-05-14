package nc.unc.gl.borne.services;

import nc.unc.gl.borne.modele.Carte;
import nc.unc.gl.borne.modele.Deck;
import nc.unc.gl.borne.modele.Joueur;

import java.util.ArrayList;

public class JoueurService {

    public static void piocherCarte(Deck pioche,Joueur joueur) {
        joueur.main.add((Carte) pioche.pop());

    }

    public void defausserCarte(Carte carte,Joueur joueur) {
        joueur.main.remove(carte);
    }

    public void poserBorne(Carte carteBorne, Joueur joueur) {
        int bornes = carteBorne.getEffet();
        bornes = Integer.parseInt(Carte.getEffets()[3][bornes]);
        joueur.points += bornes;
        joueur.main.remove(carteBorne);

    }

    public void attaquer(Carte carteAttaque, Joueur joueur , Joueur joueurAttaqué) {
        joueurAttaqué.setAttaque(carteAttaque);
        joueur.main.remove(carteAttaque);
    }

    public void poserLimiteVitesse(Carte carteAttaque, Joueur joueur , Joueur joueurAttaqué) {
        joueurAttaqué.setVitesse(carteAttaque);
        joueur.main.remove(carteAttaque);
    }

    public void poserFinLimite(Carte carteParade,Joueur joueur) {
        joueur.vitesse = null;
        joueur.main.remove(carteParade);

    }
    public void poserBotte(Carte botte,Joueur joueur) {
        joueur.immunites.add(botte);
        joueur.main.remove(botte);
    }

    public void poserParade(Carte carteParade,Joueur joueur) {
        if (joueur.isDemarre() == false && carteParade.getEffet() == 1) {
            joueur.setDemarre(true);
        }
        else {
            joueur.setAttaque(null);
            joueur.main.remove(carteParade);
        }

    }



}
