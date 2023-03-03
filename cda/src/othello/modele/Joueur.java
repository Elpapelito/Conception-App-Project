package othello.modele;

public class Joueur {
    private String nom;
    private int nb_partie_gagnee=0;

    public Joueur(String nom){
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
    public int getNb_partie_gagnee() {
        return nb_partie_gagnee;
    }

    public void incremente_partie_gagnee(){
        nb_partie_gagnee += 1;
    }
}
