package Systeme;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Controleur {
    private ArrayList<Jeu> lesJeux = new Ht<>();
    private Ihm ihm;

    public Controleur(Ihm i){ ihm = i;lesJeux.add(new Othello());}

    public void jouer(){
        int i = 0;
        for(Jeu j : lesJeux) ihm.afficher(++i + " : " + j.getNom());

        ihm.afficher("Saisir le numéro de jeu : ");
        String n = ihm.demander();
        // tester n : tant que n n'est pas un chiffre compris entre 0 et jeu.length, on redemande. Sinon on recupere le chiffre.
        //Dans notre cas, ce sera forcement 1
        //on suppose que n est un chiffre valide. p contient l'entier correspondant à n - 1

        int p =0;
        lesJeux.



    }
}
