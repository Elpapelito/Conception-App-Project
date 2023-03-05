package Systeme.vue;

import java.util.Scanner;

public class Ihm {
    Scanner sc = new Scanner(System.in);
    public String demander(){
        String reponse = sc.nextLine();
        return reponse;
    }

    public void afficher(String message){
        System.out.print(message);
    }
}
