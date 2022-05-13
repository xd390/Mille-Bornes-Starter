package nc.unc.gl.borne.modele;

public class Carte{
    private static String[][] effets = {
        { "attaque", "feu rouge", "limite de vitesse", "panne d'essence", "crevaison", "accident" },
        { "parade", "feu vert", "fin de limite de vitesse", "essence", "roue de secours", "reparations" },
        { "botte", "prioritaire", "prioritaire", "citerne", "increvable", "as du volant" },
        { "borne", "25", "50", "75", "100", "200" } };

    private int type;
    private int effet;
    private String imagePath;
    public Carte(int type, int effet, String imageNom) {
        this.type = type;
        this.effet = effet;
        this.imagePath = "/cartes/"+imageNom;
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
