package Systeme.vue;

import Systeme.modele.Damier;
import Systeme.modele.Joueur;

import java.util.Scanner;

public class Ihm {
    Scanner sc = new Scanner(System.in);
    
    public String demanderNomJoueur(int numJoueur){
        String name;
        System.out.println(
                "_______________________________________\n" +
                "|      Joueur "+numJoueur+" veuillez choisir      |\n" +
                "|             votre nom :             |\n" +
                "|    (Vos pions seront les Noirs )    |\n" +
                "|                                     |\n" +
                "|                                     |\n" +
                "|                                     |\n" +
                "|_____________________________________|");
        do {
            System.out.print("Réponse : ");
            name=sc.nextLine();
        }
        while(name=="" || !name.matches("^[a-zA-Z]*$"));
        return name;
    }

    public String demanderRejouer(){
        String rejouer;
        System.out.println(
                    "_______________________________________\n" +
                            "|         Voulez-vous rejouer         |\n" +
                            "|        une autre partie? O/N :      |\n" +
                            "|_____________________________________|");
        do{
            System.out.print("Réponse : ");
            rejouer=sc.nextLine();
        }
        while(rejouer=="" || !rejouer.equals("O") && !rejouer.equals("N"));
        return rejouer;
    }

    public String demanderCoup(String nom){
        String coup;
        do {
            System.out.print(nom + ", c'est à vous de jouer." +
                    " Saisir une ligne entre 1 et 8 suivie d'une lettre entre A et H (ex : 3 D) : ");
            coup = sc.nextLine();
        }
        while(coup=="");
        return coup;
    }

    public void demanderPasse(String nom){
        String coup;
        do {
            System.out.print(nom + ", vous ne pouvez plus poser de pion. Passez votre tour en tapant P : ");
            coup = sc.nextLine();
        }
        while(!coup.equals("P"));
    }
    public void afficherEtatDamier(Damier damier, Joueur joueur1, Joueur joueur2){
        System.out.println(damier);
        System.out.println(joueur1.getNom()+ " : " + damier.nbPionsNoir() + " pions noirs.");
        System.out.println(joueur2.getNom() + " : " + damier.nbPionsBlanc() + " pions blancs.");
    }

    public void afficherScore(Joueur joueur){
        System.out.println(joueur);
    }

    public void afficherErreur(Exception e){
        System.out.println(e.getMessage());
    }

    public void afficherVainqueur(String m){
        System.out.println("Le vainqueur est : " +m);
    }
}
