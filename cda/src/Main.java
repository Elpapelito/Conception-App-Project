import Systeme.controleur.Controleur;
import Systeme.modele.Othello;
import Systeme.vue.Ihm;

public class Main {

    public static void main(String[] args) {
        Ihm i = new Ihm();
        Othello c = new Othello(i);
        c.jouer();
    }
}