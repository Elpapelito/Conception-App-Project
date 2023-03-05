package othello.controleur;

import othello.modele.DamierOthello;
import othello.modele.JoueurOthello;
import othello.vue.IhmOthello;


public class ControleurOthello {
    private IhmOthello ihm;
    private DamierOthello damier;
    private JoueurOthello joueur1;
    private JoueurOthello joueur2;

    public ControleurOthello(IhmOthello ihm){
        this.ihm = ihm;
    }
    public void jouer(){
        /* enregistrement du joueur 1 */
        String nom1 = ihm.demander_nom("Joueur 1");
        joueur1 = new JoueurOthello(nom1);

        /* enregistrement du joueur 2 */
        String nom2 = ihm.demander_nom("Joueur 2");
        joueur2 = new JoueurOthello(nom2);

        /* lance une partie */
        boolean gameover = false;
        while(!gameover){
            damier = new DamierOthello();
            JoueurOthello joueur_courant = joueur1;

            String coup = ihm.demander_coup(joueur_courant.getNom());

        }

    }

}
