package nc.unc.gl.borne.modele;

public class Carte{
    private static String[][] effets = {
        { "attaque", "feu rouge", "limite de vitesse", "panne d'essence", "crevaison", "accident" },
        { "parade", "feu vert", "fin de limite de vitesse", "essence", "roue de secours", "reparations" },
        { "botte", "prioritaire", "prioritaire", "citerne", "increvable", "as du volant" },
        { "etape", "25", "50", "75", "100", "200" } };

    private int type;
    private int effet;

    public Carte(int type, int effet) {
        this.type = type;
        this.effet = effet;
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
}
