package othello.vue;

import java.util.Scanner;

public class IhmOthello {
    Scanner sc = new Scanner(System.in);
    public String demander_nom(String joueur){
        System.out.print("Entrez le nom du " + joueur + " : ");
        String nom = sc.next();
        return nom;
    }

    public String saisie(String question){
        System.out.print(question);
        String reponse = sc.next();
        return reponse;
    }

    public String demander_coup(String nom_joueur){
        System.out.print(nom_joueur + ", c'est à vous de jouer. " +
                "Saisir une ligne entre 1 et 8 suivie d'une lettre entre A et H (ex : 3D) : ");
        String coup = sc.next();
        return coup;
    }

    public String demander_rejouer_une_partie(){
        System.out.print("Voulez-vous rejour une autre partie? O/N : ");
        String reponse = sc.next();
        return reponse;
    }

    public void afficher_message(String msg){
        System.out.println(msg);
    }

}
