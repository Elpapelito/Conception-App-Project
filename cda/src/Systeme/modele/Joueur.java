package Systeme.modele;

public class Joueur {
    private String nom;
    private int nbPartieGagnee=0;

    public Joueur(String n){
        nom=n;
    }

    public String getNom() {
        return nom;
    }

    public int getNbPartiePagnee() {
        return nbPartieGagnee;
    }

    public void incremente(){nbPartieGagnee++;}

    public String toString(){
        return nom + " : " + nbPartieGagnee + " partie(s) gagnée(s).";
    }
}
