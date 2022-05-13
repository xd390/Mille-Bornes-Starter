package nc.unc.gl.borne.services;
import nc.unc.gl.borne.modele.Carte;
import nc.unc.gl.borne.modele.Deck;
import nc.unc.gl.borne.modele.Joueur;
import nc.unc.gl.borne.services.JoueurService;

public class CarteService {

    JoueurService JoueurService = new JoueurService();

    public boolean jouerCarte(Carte carteajouer, Joueur joueur,Joueur joueurCibler) {
        int typecarteajouer = carteajouer.getType();
        boolean possible = false;
        boolean isImmune = false;

        switch (typecarteajouer) {
            //attaque
            case 0:
                if (joueurCibler.getImmunites().size() != 0 && joueurCibler.isDemarre()==true && joueurCibler.getAttaque() == null ) {
                    for (int i = 0; i < joueurCibler.getImmunites().size(); i++) {
                        if (joueurCibler.getImmunites().get(i).getEffet() == carteajouer
                            .getEffet()){
                            isImmune=true;
                        }
                        if (joueurCibler.getImmunites().get(i).getEffet()==2 && carteajouer
                            .getEffet()==1){
                            isImmune=true;
                        }
                        if (joueurCibler.getImmunites().get(i).getEffet()==1 && carteajouer
                            .getEffet()==2){
                            isImmune=true;
                        }
                }

                }
                if (carteajouer.getEffet()==2 && joueurCibler.getVitesse()==null && isImmune==false){
                    possible = true;
                    JoueurService.poserLimiteVitesse(carteajouer, joueur, joueurCibler);
                }
                else if(joueurCibler.getAttaque() == null && joueurCibler.isDemarre()==true && isImmune==false) {
                    possible = true;
                    JoueurService.attaquer(carteajouer, joueur, joueurCibler);
                }
                else{
                    System.out.println("joueurCibler n'est pas attaquable.");


                }
                break;

            //parade
            case 1:
			/* Vérification de l'utilisation d'une carte "feu vert".
			Deux utilisations possibles selon qu'on soit en début de partie
			ou après avoir démarré au moins une fois. */
                if (joueur.isDemarre() == false && carteajouer.getEffet() == 1) {
                    possible = true;
                    JoueurService.poserParade(carteajouer, joueur);
                }

                // Vérification que la joueur a bien été attaqué.
                else if (joueur.getAttaque() != null || joueur.getVitesse() != null) {

				/* Vérification de la correspondance entre la carte attaque et
				la carte parade. */
                    if (joueur.getAttaque() != null
                        && joueur.getAttaque().getEffet() == carteajouer
                        .getEffet()) {
                        possible = true;
                        JoueurService.poserParade(carteajouer, joueur);
                    } else if (joueur.getVitesse() != null
                        && joueur.getVitesse().getEffet() == carteajouer
                        .getEffet()) {
                        possible = true;
                        JoueurService.poserFinLimite(carteajouer, joueur);
                    }
                    else{
                        System.out.println("Votre carte parade ne correspond pas a l'attaque recue ");
                    }
                } else
                    System.out.println("Vous n'avez pas été attaqué !");

                break;



            //Bottes
            case 2:

                possible = true;
                JoueurService.poserBotte(carteajouer, joueur);

                if (joueur.isDemarre() == false && carteajouer.getEffet() == 1 || carteajouer.getEffet() == 2){
                    joueur.setDemarre(true);
                }

                if (joueur.getAttaque() !=null && joueur.getAttaque().getEffet()==carteajouer.getEffet()) {
                    joueur.setAttaque(null);
                }
                break;



            //Bornes
            case 3:
                // Vérification qu'un feu vert a déjà été posé au moins une fois.
                if (joueur.isDemarre()) {
                    // Vérification qu'aucune attaque ne bloque l'avancement.
                    if (joueur.getAttaque() == null) {
                        // Vérification de la limite de vitesse.
                        if (joueur.getVitesse() != null) {
                            if (carteajouer.getEffet() <3) {
                                possible = true;
                                JoueurService.poserBorne(carteajouer,joueur);
                            } else
                                System.out.println("Vous êtes limité à 50.");
                        } else if (joueur.getPoints() + (int) carteajouer.getEffet() > 1000)
                            System.out.println("Vous ne pouvez pas dépasser mille bornes !");
                        else {
                            possible = true;
                            JoueurService.poserBorne(carteajouer, joueur);
                        }
                    } else
                        System.out.println("Vous avez été attaqué !");
                } else
                    System.out.println("Veuillez poser un feu vert pour pouvoir démarrer.");

                break;

        }
        return possible;
    }

}
