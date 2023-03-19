package Systeme.modele;

import Systeme.vue.Ihm;

import java.util.List;

public class Othello implements Jeu {
    private Ihm ihm;
    private Damier damier;
    private Joueur joueur1;
    private Joueur joueur2;
    public Othello(Ihm i) {
        ihm = i;
    }

    @Override
    public void jouer() {
        joueur1 = new Joueur(ihm.demanderNomJoueur(1));
        joueur2 = new Joueur(ihm.demanderNomJoueur(2));

        String rejouer;
        do {
            commencerPartie();
            rejouer= ihm.demanderRejouer();
            }
        while(rejouer.equals("O"));
        ihm.afficherScore(joueur1);
        ihm.afficherScore(joueur2);
    }

    public void gameOver() throws Exception {
        String joueur = (damier.getJoueurCourant() == 1) ? joueur2.getNom() : joueur1.getNom();
        if(damier.coupPossible().isEmpty()) {
            ihm.afficherEtatDamier(damier,joueur1,joueur2);
            ihm.demanderPasse(joueur);
            damier.changerJoueurCourant();
            if (damier.coupPossible().isEmpty()) throw new Exception("La partie est finie.");
        }
    }

    public String getJCourant(){
        return (damier.getJoueurCourant() == 1) ? joueur2.getNom() : joueur1.getNom();
    }
    public void mettrePion(){
        String coup;
        do {
            try {
                coup = ihm.demanderCoup(getJCourant());
                damier.testerCoup(coup);
                break;
            } catch (Exception e) {
                ihm.afficherErreur(e);
            }
        }
        while(true);
    }

    public void commencerPartie() {
        damier = new Damier(4);
        damier.initialiserDamierOthello();
        do {
            try{
                damier.changerJoueurCourant();
                gameOver();
                ihm.afficherEtatDamier(damier, joueur1, joueur2);
                System.out.println(damier.coupPossible());
                mettrePion();
            }
            catch(Exception e){
                ihm.afficherErreur(e);break;
            }
        }
        while (true);
        resultat();
    }

    public void resultat(){
        String gagnant;
        if(damier.vainqueur()==0) {gagnant="ex aequo"; joueur1.incremente();joueur2.incremente();}
        else if(damier.vainqueur()>0) {gagnant = joueur1.getNom(); joueur1.incremente();}
        else {gagnant=joueur2.getNom(); joueur2.incremente();}
        ihm.afficherVainqueur(gagnant);
    }

        @Override
        public String getNom () {
            return "othello";
        }
}
