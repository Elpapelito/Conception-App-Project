package Systeme.controleur;

import java.util.ArrayList;

import Systeme.modele.Jeu;
import Systeme.modele.Othello;
import Systeme.vue.Ihm;

public class Controleur {
    private ArrayList<Jeu> lesJeux = new ArrayList<Jeu>();
    private Ihm ihm;

    public Controleur(Ihm i){
        ihm = i;
        lesJeux.add(new Othello());
    }

    public void jouer(){
        int i = 0;
        for(Jeu j : lesJeux) ihm.afficher(++i + " : " + j.getNom());

        ihm.afficher("Saisir le numéro de jeu : ");
        String n = ihm.demander();
        while (Integer.valueOf(n)<1 || Integer.valueOf(n)>=lesJeux.size()) {
            ihm.afficher("Numéro non valide, en saisir un valide : ");
            n = ihm.demander();
        }
        // tester n : tant que n n'est pas un chiffre compris entre 0 et jeu.length, on redemande. Sinon on recupere le chiffre.
        //Dans notre cas, ce sera forcement 1
        //on suppose que n est un chiffre valide. p contient l'entier correspondant à n - 1

        int p =Integer.valueOf(n)-1;
        Jeu jeuChoisi=lesJeux.get(p);
        jeuChoisi.procedure();

        //ajouter de quoi changer de jeu ou fermer le selectionneur de jeux

    }
}