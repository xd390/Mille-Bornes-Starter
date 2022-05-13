package nc.unc.gl.borne.services;

import nc.unc.gl.borne.modele.Deck;
import nc.unc.gl.borne.modele.Joueur;

import java.util.ArrayList;

public class PartieService {
    JoueurService joueurService = new JoueurService();
    public Joueur joueur1;
    public Joueur joueur2;
    public Deck pioche;
    public boolean terminee;
    public Joueur joueurCourant;

    public void distribuerMain(Joueur joueur1,Joueur joueur2){
        for (int i = 0; i < 6; i++) {
            joueurService.piocherCarte(pioche , joueur1);
            joueurService.piocherCarte(pioche , joueur2);
            }
        }

    }

