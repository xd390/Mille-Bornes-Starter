package nc.unc.gl.borne.services;

import com.vaadin.flow.component.UI;
import nc.unc.gl.borne.Plateau;
import nc.unc.gl.borne.modele.Carte;
import nc.unc.gl.borne.modele.Deck;
import nc.unc.gl.borne.modele.Joueur;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class ObserverService {
    public static Deck deck = new Deck();
    private static CarteService carteService = new CarteService();
    private static DeckService deckService = new DeckService();
    private static Map<String, Joueur> sessions = new ConcurrentHashMap<>();
    private static List<Joueur> listeJoueur = new ArrayList<>();
    private static boolean check = false;

    public ObserverService(Joueur joueur){
        this.sessions.put(getCurrent().getCsrfToken(), joueur);
    }

    public static void finTour(){
        getCurrentJoueur().setPeutJouer(false);
        getCurrentAutreJoueur().setPeutJouer(true);
    }
    public static void finPartie(){
        Plateau.showDialog("Fin de partie!");
    }

    public UI getCurrent() {
        return UI.getCurrent();
    }

    public static Deck getDeck(){
        return deck;
    }

    public static Joueur getCurrentJoueur(){
        return sessions.get(UI.getCurrent().getCsrfToken());
    }

    public static Joueur getCurrentAutreJoueur(){
        return getAutreJoueur(UI.getCurrent().getCsrfToken());
    }

    public static Joueur getJoueur(String key) {
        return sessions.get(key);
    }

    public static Joueur getAutreJoueur(String key) {
        String newKey = "";
        Set<String> liste = sessions.keySet();
        Object[] res = liste.toArray();

        if (res[0] == key) {
            newKey = (String) res[1];
        }
        else{
            newKey = (String) res[0];
        }

        return sessions.get(newKey);
    }

    public static void lancerPartie(){
        if (check)
            return;
        check = true;
        deckService.initialiserDeck(deck);

        Joueur j1 = getCurrentJoueur();
        Joueur j2 = getCurrentAutreJoueur();
        j1.setPeutJouer(true);

        deckService.distribuerMain(deck, j1, j2);

        /*
        listeJoueur.add(j1);
        listeJoueur.add(j2);
        listeJoueur.get(new Random().nextInt(res.length)).setPeutJouer(true);
        */
    }
    public static boolean ActionJoueur(Carte carte){
        boolean isValid = carteService.jouerCarte(carte, getCurrentJoueur(), getCurrentAutreJoueur());
        System.out.println(getCurrentJoueur());
        if (deck.size() == 0){
            finPartie();
            return false;
        }
        if (isValid){
            finTour();
        }
        System.out.println(getCurrentJoueur());
        return isValid;
    }
    public static Map<String, Joueur> getAllSessions(){return sessions;}
}
