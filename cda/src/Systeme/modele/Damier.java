package Systeme.modele;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Damier {
    /* pion_blanc = 1 pion_noir = -1 vide = 0 */
    private int[][] lesCases;

    //nb pions sur le damier
    private int nb_pions_blanc = 2;
    private int nb_pions_noir = 2;
    private int joueur_courant = 1;

    public String nb_pions_blanc() {return String.valueOf(nb_pions_blanc);}
    public int getJoueur_courant() {return joueur_courant;}
    public String nb_pions_noir() {return String.valueOf(nb_pions_noir);}
    public Damier(){
        lesCases = new int[8][8];
        for(int i=0; i<8; i++)
            for(int j=0;j<8;j++)
                lesCases[i][j]=0;

        lesCases[3][3] = 1;
        lesCases[3][4] = -1;
        lesCases[4][3] = -1;
        lesCases[4][4] = 1;
    }

    //changer le joueur à chaque tour
    public void changer_joueur_courant(){
        joueur_courant= (joueur_courant == -1) ? 1 : -1;
    }

    //tester si un coup est valide
    public void tester_coup(String coup) throws Exception {
        if (!syntaxe_valide(coup)) throw new Exception("Syntaxe invalide!\n");

        Map<Character, Integer> colonne = new HashMap<>();
        colonne.put('A', 0);colonne.put('B', 1);
        colonne.put('C', 2);colonne.put('D', 3);
        colonne.put('E', 4);colonne.put('F', 5);
        colonne.put('G', 6);colonne.put('H', 7);
        String a = coup.substring(0, 1);
        char b = coup.charAt(2);
        int x = Integer.parseInt(a)-1;
        int y = colonne.get(b);

        if(!coup_valide(x,y)) throw new Exception("Coup invalide!\n");
    }
    public boolean syntaxe_valide(String coup) {
        if( coup.length() != 3) return false;

        char a = coup.charAt(0); char b = coup.charAt(1); char c = coup.charAt(2);
        if( a<'1' || a > '8' || b !=' ' || c <'A' || c > 'H') return false;
        return true;
    }

    public boolean coup_valide(int x, int y) {
        boolean b=false;
        boolean pionsPosé = false;
        for(int i=-1; i<=1; i++)
            for(int j=-1; j<=1; j++) {
                if(i == 0 && j == 0) continue;
                if(encadrement_valide(x,y,i,j)) {
                    lesCases[x][y] = joueur_courant;
                    if (!pionsPosé)
                    {
                        if (joueur_courant == -1 ) {
                            nb_pions_noir++;
                        } else {
                            nb_pions_blanc++;
                        }
                    pionsPosé = true;
                    }
                    retourner_pions(x,y,i,j);
                    b=true;
                }
            }
        return b;
    }
    public boolean encadrement_valide(int x,int y,int a,int b){
        int l = a + x;
        int c = b + y;
        int nb_pions_adverse = 0;

        while (l >= 0 && l < 8 && c >= 0 && c < 8) {
            if (lesCases[l][c] == 0) return false;
            if (lesCases[l][c]==joueur_courant) return nb_pions_adverse > 0;
            nb_pions_adverse++; l += a; c += b;
        }
        return false;
    }

    public void retourner_pions(int x, int y,int a,int b){
        int l = a + x;
        int c = b + y;
        while (lesCases[l][c] != joueur_courant) {
            System.out.println("On retourne un pions et nb pion de "+joueur_courant);
            System.out.println(l +" " + c +" "+"et c un"+ lesCases[l][c] );
            System.out.println("Pions noirs : "+ nb_pions_noir);
            System.out.println("Pions blancs : "+ nb_pions_blanc);
            lesCases[l][c] = joueur_courant;
            
            if (joueur_courant == 1) {
                nb_pions_noir--;
                nb_pions_blanc++;
            } else {
                nb_pions_noir++;
                nb_pions_blanc--;
            }
            l += a;
            c += b;
        }
    }

    //tester si la partie est finie
    public boolean game_over() {
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                if (lesCases[i][j] != 0) continue;

                for (int k = -1; k <= 1; k++)
                    for (int l = -1; l <= 1; l++) {
                        if (k == 0 && l == 0) continue;
                        if (encadrement_valide(i, j, k, l)) return false;
                    }
            }
        return true;
    }

    public String toString(){
        String s="O|A|B|C|D|E|F|G|H|\n";
        for(int i=0; i<8; i++) {
            s+=i+1;
            for (int j = 0; j < 8; j++)
                switch (lesCases[i][j]) {
                    case 0:
                        s += "\uD83D\uDFE9";
                        break;
                    case 1:
                        s += "\u26AA";
                        break;
                    case -1:
                        s += "\u26AB";
                        break;
                }
            s += "\n";
        }
        return s;
    }

    public int vainqueur(){
        return nb_pions_noir - nb_pions_blanc;
    }
}
