package Systeme.vue;

import java.util.Scanner;

public class Ihm {
    Scanner sc = new Scanner(System.in);


    public String saisie(String question){
        System.out.print(question);
        String reponse = sc.next();
        return reponse;
    }


    public void afficher_message(String msg){
        System.out.println(msg);
    }
}
