import Systeme.controleur.Controleur;
import Systeme.modele.Damier;
import Systeme.modele.Jeu;
import Systeme.modele.Othello;
import Systeme.vue.Ihm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Ihm i = new Ihm();
        Othello  o = new Othello(i);
        o.jouer();
    }
}