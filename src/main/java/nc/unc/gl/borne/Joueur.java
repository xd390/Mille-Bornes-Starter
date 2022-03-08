package nc.unc.gl.borne;

import java.util.List;

public class Joueur {

    private String id;
    private String pseudo;
    private int points = 0;
    public List<Carte> cartes;
    private int essence = 0;
    private int feu = 0;
    private int accidente = 0;
    private int limite50 = 0;
    private Integer equipe;
    private boolean attacked = false;

    public Joueur(String id, String pseudo) {
        this.id = id;
        this.pseudo = pseudo;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo){
        this.pseudo = pseudo;
    }
    public String getId() {
        return id;
    }
    public int getPoints() {
        return points;
    }

    public void setPoints(int points){
        this.points = points;
    }

    public int getEssence() {
        return essence;
    }

    public void setEssence(int essence){
        this.essence = essence;
    }
    public int getFeu() {
        return feu;
    }

    public int getAccidente() {
        return accidente;
    }
    public void setAccidente(int accidente){
        this.accidente = accidente;
    }
    public int getLimite50() {
        return limite50;
    }
    public void setLimite50(int limite){
        this.limite50 = limite;
    }
    public Integer getEquipe() {
        return equipe;
    }

    public void setEquipe(Integer equipe) {
        this.equipe = equipe;
    }

    public boolean isAttacked() {
        return attacked;
    }

    public void setAttacked(boolean attacked){
        this.attacked = attacked;
    }
    public void initCarte(List<Carte> cartes){
        this.cartes = cartes;
    }

    public void addCarte(Carte carte){
        this.cartes.add(carte);
    }

    public boolean removeCarte(Carte carte){
        return this.cartes.remove(carte);
    }
    public List<Carte> getCartes() {
        return cartes;
    }
}
