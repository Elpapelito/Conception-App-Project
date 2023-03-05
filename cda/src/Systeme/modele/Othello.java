package Systeme.modele;

import Systeme.vue.Ihm;

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
        //enregistrement des joueurs
        String message =  "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                "_______________________________________\n" +
                "|      Joueur 1 veuillez choisir      |\n" +
                "|             votre nom :             |\n" +
                "|    (Vos pions seront les Noirs )    |\n" +
                "|                                     |\n" +
                "|                                     |\n" +
                "|                                     |\n" +
                "|_____________________________________|\n" +
                "Reponse : ";
        ihm.afficher(message);

        
        String name = ihm.demander();
        joueur1 = new Joueur(name);

        message =  "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                "_______________________________________\n" +
                "|      Joueur 2 veuillez choisir      |\n" +
                "|             votre nom :             |\n" +
                "|    (Vos pions seront les Blancs )   |\n" +
                "|                                     |\n" +
                "|                                     |\n" +
                "|                                     |\n" +
                "|_____________________________________|\n" +
                "Reponse : ";
        ihm.afficher(message);
        name = ihm.demander();
        joueur2 = new Joueur(name);

        //lancer une partie
        String rejouer;
        do {
            commencer_partie();
            do{
                message = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                "_______________________________________\n" +
                "|         Voulez-vous rejouer         |\n" +
                "|        une autre partie? O/N :      |\n" +
                "|_____________________________________|\n" +
                "Reponse : ";
                ihm.afficher(message);
                rejouer=ihm.demander();
            }
            while(!rejouer.equals("O") && !rejouer.equals("N"));
        }
        while(rejouer.equals("O"));


        int score1=joueur1.getNb_partie_gagnee();
        int score2=joueur2.getNb_partie_gagnee();
        ihm.afficher(joueur1.getNom()+" : "+score1+"\n");
        ihm.afficher(joueur2.getNom()+" : "+score2);

    }

    public void commencer_partie(){
        damier = new Damier();
        String joueur;
        do{
            //affichage de l'état du damier à chaque tour
            damier.changer_joueur_courant();
            ihm.afficher(damier.toString());
            ihm.afficher(joueur1.getNom() + " : " + damier.nb_pions_noir() + " pions.\n");
            ihm.afficher(joueur2.getNom() + " : " + damier.nb_pions_blanc() + " pions.\n");
            joueur=(damier.getJoueur_courant()==1)?joueur2.getNom():joueur1.getNom();

            //demander le coup et verifier si c'est valide
            String coup;
            boolean valid;
            do {
                valid=false;
                try{
                    ihm.afficher(joueur + ", c'est à vous de jouer." +
                            " Saisir une ligne entre 1 et 8 suivie d'une lettre entre A et H (ex : 3 D) : ");
                    coup = ihm.demander();
                    if(coup.equals("P")) break;
                    damier.tester_coup(coup);
                }
                catch(Exception e){
                    ihm.afficher(e.getMessage());
                    valid = true;
                }
            }
            while (valid);

        }
        while (!damier.game_over());

        //afficher le dernier état du damier
        ihm.afficher(damier.toString());
        ihm.afficher(joueur1.getNom() + " : " + damier.nb_pions_noir() + " pions.\n");
        ihm.afficher(joueur2.getNom() + " : " + damier.nb_pions_blanc() + " pions.\n");

        //calcul le vainqueur
        String resultat;

        if(damier.vainqueur()==0) {
            resultat = "ex aequo"; joueur1.incremente();joueur2.incremente();
        }
        else if(damier.vainqueur()>0) {
            resultat = joueur1.getNom(); joueur1.incremente();
        }
        else {
            resultat=joueur2.getNom(); joueur2.incremente();
        }
        ihm.afficher("La partie est finie.\n Le vainquer de cette partie est : " + resultat);


    }

    //optionnel
        @Override
        public String getNom () {
            return "othello";
        }
}
