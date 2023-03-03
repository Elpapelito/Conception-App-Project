import Systeme.Controleur;
import Systeme.Ihm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Ihm i = new Ihm();
        Controleur c = new Controleur(i);
        c.jouer();
    }
}