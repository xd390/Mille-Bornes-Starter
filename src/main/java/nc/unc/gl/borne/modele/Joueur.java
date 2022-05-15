package nc.unc.gl.borne.modele;

import nc.unc.gl.borne.services.JoueurService;
import java.util.ArrayList;

public class Joueur {

    public String pseudo;

    public boolean peutJouer = false;

    public int points = 0;

    public ArrayList<Carte> main;
    public ArrayList<Carte> immunites;

    public boolean demarre;
    public Carte attaque;
    public Carte vitesse;


    public Joueur( String pseudo) {

        this.pseudo = pseudo;
        this.points = 0;
        this.main = new ArrayList<Carte>();
        this.immunites = new ArrayList<Carte>();
        this.demarre=false;
        this.attaque = null;
        this.vitesse = null;
    }

    public boolean isPeutJouer() {
        return peutJouer;
    }

    public void setPeutJouer(boolean peutJouer) {
        this.peutJouer = peutJouer;
    }

    public boolean getPeutJouer(){return this.peutJouer;}

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

    public void setDemarre(boolean demarre) {
        this.demarre = demarre;
    }

    public void setAttaque(Carte attaque) {
        this.attaque = attaque;
    }

    public void setVitesse(Carte vitesse) {
        this.vitesse = vitesse;
    }

    public void setImmunites(ArrayList<Carte> immunites) {
        this.immunites = immunites;
    }

    public String toString() {
        return "Joueur [pseudo=" + pseudo + ", points=" + points + ", main=" + main
            + ", demarre=" + demarre + ", attaque=" + attaque
            + ", vitesse=" + vitesse + ", immunites=" + immunites + "]"
            + " , peutJouer= " + peutJouer;
    }


    public void ecrireMain() {
        System.out.print("Contenu de la main: [ ");
        int i = 0;
        for (i = 0; i < this.getMain().size() - 1; i++) {
            System.out.print("Carte n°" + i + " : " + this.getMain().get(i)
                + ", ");
        }
        System.out
            .println("Carte n°" + i + " : " + this.getMain().get(i) + " ]");
    }









}
