package Systeme.modele;

public class Joueur {
    private String nom;
    private int nb_partie_gagnee=0;

    public Joueur(String n){
        nom=n;
    }

    public String getNom() {
        return nom;
    }

    public int getNb_partie_gagnee() {
        return nb_partie_gagnee;
    }

    public void incremente(){nb_partie_gagnee++;}
}
