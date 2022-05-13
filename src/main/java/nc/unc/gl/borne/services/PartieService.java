package nc.unc.gl.borne.services;

import nc.unc.gl.borne.modele.Deck;
import nc.unc.gl.borne.modele.Joueur;

import java.util.ArrayList;

public class PartieService {
    JoueurService joueurService = new JoueurService();


    public void distribuerMain(Deck pioche,Joueur joueur1,Joueur joueur2){
        for (int i = 0; i < 6; i++) {
            joueurService.piocherCarte(pioche , joueur1);
            joueurService.piocherCarte(pioche , joueur2);
            }
        }

    }

