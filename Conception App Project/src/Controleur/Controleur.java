package Controleur;
import Vue.Ihm;
import Modele.*;

public class Controleur {

    Ihm ihm;
    Damier damier;
    Joueur[] lesJoueurs;


    public Controleur( Ihm ihm )
    {
        this.ihm = ihm;

    }


    public void jouer(){
        String message = "_______________________________________\n" +
                         "|      Bienvenue dans nos projet      |\n" +
                         "|     de Conception d'application!    |\n" +
                         "|                                     |\n" +
                         "|        Choisissez votre jeu:        |\n" +
                         "|                                     |\n" +
                         "|    @ Othello Joueur Vs Joueur (1)   |\n" +
                         "|_____________________________________|\n" +
                         "Reponse : ";

        String jeu = "0";
        while (!jeu.equals("1")){
            ihm.affiche("coucou");
            jeu = ihm.saisieString(message);
            message = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                    "_______________________________________\n" +
                    "|    Le nombre saisie ne correspond   |\n" +
                    "|             à aucun jeu.            |\n" +
                    "|                                     |\n" +
                    "|        Choisissez votre jeu:        |\n" +
                    "|                                     |\n" +
                    "|    @ Othello Joueur Vs Joueur (1)   |\n" +
                    "|_____________________________________|\n" +
                    "Reponse : ";

        }

        damier = new Damier(8);
        ihm.affiche(damier);



    }




}
