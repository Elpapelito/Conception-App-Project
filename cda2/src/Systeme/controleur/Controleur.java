package Systeme.controleur;

import Systeme.vue.Ihm;
import Systeme.modele.Jeu;
import Systeme.modele.Othello;

import java.util.ArrayList;

public class Controleur {
    private static ArrayList<Jeu> lesJeux = new ArrayList<>();
    private Ihm ihm;

    public Controleur(Ihm i){ ihm = i;}

    //ajouter un jeu
    public static void ajouter_jeu(Jeu j){lesJeux.add(j);}

    //supprimer un jeu
    public static void supprimer_jeu(Jeu j){lesJeux.remove(j);}

    //lancer le systeme
    public void jouer(){
        //choisir un jeu : boucle while jusqu'à ce qui tape un nombre valide

        //on suppose qu'il a saisi 1->othello
        Jeu j=new Othello(ihm);
        j.jouer();

    }
}
