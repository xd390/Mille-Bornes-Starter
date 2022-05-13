package nc.unc.gl.borne.modele;

public class Carte{
    private static String[][] effets = {
        { "attaque", "feu rouge", "limite de vitesse", "panne d'essence", "crevaison", "accident" },
        { "parade", "feu vert", "fin de limite de vitesse", "essence", "roue de secours", "reparations" },
        { "botte", "prioritaire", "prioritaire", "citerne", "increvable", "as du volant" },
        { "borne", "25", "50", "75", "100", "200" } };

    private static String[][] effetsImageNom = {
        { "attaque", "attaque_feu.jpeg", "attaque_vitesse.jpeg", "attaque_essence.jpeg", "attaque_crevaison.jpeg", "attaque_accident.jpeg" },
        { "parade", "parade_feu.jpeg", "parade_vitesse.jpeg", "parade_essence.jpeg", "parade_crevaison.jpeg", "parade_accident.jpeg" },
        { "botte", "botte_vitesse.jpeg", "botte_vitesse.jpeg", "botte_essence.jpeg", "botte_crevaison.jpeg", "botte_accident.jpeg" },
        { "borne", "borne_25.jpeg", "borne_50.jpeg", "borne_75.jpeg", "borne_100.jpeg", "borne_200.jpeg" } };

    private int type;
    private int effet;
    private String imagePath;
    public Carte(int type, int effet) {
        this.type = type;
        this.effet = effet;
        this.imagePath = "/cartes/"+effetsImageNom[type][effet];
    }

    public Carte() {
        this.type = 0;
        this.effet = 0;
    }

    public int getType() {
        return type;
    }

    public int getEffet() {
        return effet;
    }

    public static String[][] getEffets() {
        return effets;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setEffet(int effet) {
        this.effet = effet;
    }

    public static void setEffets(String[][] effets) {
        Carte.effets = effets;
    }

    @Override
    public String toString() {
        return "[" + Carte.getEffets()[this.type][effet] + "]";
    }

    public String getImageNom() {
        return imagePath;
    }

}
