package Systeme.modele;

import othello.controleur.ControleurOthello;
import othello.vue.IhmOthello;

public class Othello implements Jeu{

    @Override
    public String getNom() {
        return "othello";
    }

    @Override
    public void procedure() {
        IhmOthello io = new IhmOthello();
        ControleurOthello co = new ControleurOthello(io);
        co.jouer();
    }
}
