package othello.controleur;

import othello.modele.Damier;
import othello.modele.Joueur;
import othello.vue.Ihm;

import java.util.ArrayList;

public class Controleur {
    private Ihm ihm;
    private Damier damier;
    private Joueur joueur1;
    private Joueur joueur2;

    public Controleur(Ihm ihm){
        this.ihm = ihm;
    }
    public void jouer(){
        /* enregistrement du joueur 1 */
        String nom1 = ihm.demander_nom("Joueur 1");
        joueur1 = new Joueur(nom1);

        /* enregistrement du joueur 2 */
        String nom2 = ihm.demander_nom("Joueur 2");
        joueur2 = new Joueur(nom2);

        /* lance une partie */
        boolean gameover = false;
        while(!gameover){
            damier = new Damier();
            Joueur joueur_courant = joueur1;

            String coup = ihm.demander_coup(joueur_courant.getNom());

        }

    }

}
