package nc.unc.gl.borne.services;

import nc.unc.gl.borne.modele.Carte;
import nc.unc.gl.borne.modele.Deck;
import nc.unc.gl.borne.modele.Joueur;

import java.util.ArrayList;

public class JoueurService {
    private String pseudo;
    private int points = 0;

    public ArrayList<Carte> main;
    private ArrayList<Carte> immunites;

    private boolean demarre;
    private Carte attaque;
    private Carte vitesse;


    private Integer equipe;
    private boolean attacked = false;

    public JoueurService( String pseudo) {

        this.pseudo = pseudo;
        this.points = 0;
        this.main = new ArrayList<Carte>();
        this.immunites = new ArrayList<Carte>();
        this.demarre=false;
        this.attaque = null;
        this.vitesse = null;
    }


    public void piocherCarte(Deck pioche) {
        this.main.add((Carte) pioche.pop());

    }


    public void defausserCarte(Carte carte) {
        this.main.remove(carte);
    }







    public String getPseudo() {
        return pseudo;
    }
    public int getPoints() {

        return points;
    }
    public ArrayList<Carte> getMain() {
        return main;
    }
    public ArrayList<Carte> getImmunites() {
        return immunites;
    }
    public boolean isDemarre() {
        return demarre;
    }
    public Carte getAttaque() {
        return attaque;
    }
    public Carte getVitesse() {
        return vitesse;
    }

    public void setPseudo(String pseudo){
        this.pseudo = pseudo;
    }
    public void setPoints(int points){
        this.points = points;
    }
    public void setMain(ArrayList<Carte> main) {
        this.main = main;
    }
    public void setImmunites(ArrayList<Carte> immunites) {
        this.immunites = immunites;
    }
    public String toString() {
        return "Joueur [pseudo=" + pseudo + ", points=" + points + ", main=" + main
            + ", demarre=" + demarre + ", attaque=" + attaque
            + ", vitesse=" + vitesse + ", immunites=" + immunites + "]";
    }











}
