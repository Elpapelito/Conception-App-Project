import Systeme.controleur.Controleur;
import Systeme.vue.Ihm;

public class Main {

    public static void main(String[] args) {
        Ihm i = new Ihm();
        Controleur c = new Controleur(i);
        c.jouer();
    }
}