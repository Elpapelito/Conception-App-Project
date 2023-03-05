package othello.modele;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DamierOthello {
    private String[][] lesCases;
    private int pions_blancs = 2;
    private int pions_noirs = 2;

    public DamierOthello(){
        lesCases = new String[8][8];
    }
    public void initialise(){
        for(int i=0; i<8; i++)
            for(int j=0;j<8;j++)
                lesCases[i][j]="\uD83D\uDFE9";

        lesCases[3][3] = "\u26AA";
        lesCases[3][4] = "\u26AB";
        lesCases[4][3] = "\u26AB";
        lesCases[4][4] = "\u26AA";
    }

    public void poser_pion(int x, int y, String couleur)  {
        lesCases[x][y]=couleur;
    }

    public void coup_possible(String couleur) throws Exception {
        for(int i=0; i<8; i++)
            for(int j=0;j<8;j++)
                if(est_de_couleur(i,j,couleur))
                    tester_autour(i,j,couleur);
    }
    public void tester_coup(String coup, String couleur) throws Exception {
        Map<Character, Integer> colonne = new HashMap<>();
        colonne.put('A', 0);
        colonne.put('B', 1);
        colonne.put('C', 2);
        colonne.put('D', 3);
        colonne.put('E', 4);
        colonne.put('F', 5);
        colonne.put('G', 6);
        colonne.put('H', 7);


        tester_syntaxe(coup);
        String a = coup.substring(0, 1);
        char b = coup.charAt(2);
        int x = Integer.parseInt(a) - 1;
        int y = colonne.get(b);
        tester_autour(x, y, couleur);
    }


/* sous fonctions pour tester si un coup est valide */
    public void tester_syntaxe(String coup) throws Exception {
        if( coup.length() != 3) throw new Exception("Longueur du syntaxe incorrect");

        char a = coup.charAt(0); char b = coup.charAt(1); char c = coup.charAt(2);

        if( a<'1' || a > '8' || b !=' ' || c <'A' || c > 'H') throw new Exception(" Syntaxe incorrect");
    }
    public void tester_autour(int x, int y,String couleur) throws Exception {
        for(int i=x-1; i<=x+1; i++)
            for(int j=y-1; j<=y+1; j++)
                if (est_une_autre_couleur(x, y, couleur))
                    break;
        throw new Exception("Coup invalide : Vous devez poser dans un case adjacent à un pion adverse");
    }


    public boolean tester_encadrer_gauche(int x,int y,String couleur){
        return est_une_autre_couleur(x,y-1,couleur);
    }
    public boolean tester_encadrer_haut(int x,int y,String couleur){
        return est_une_autre_couleur(x-1,y,couleur);
    }
    public boolean tester_encadrer_bas(int x,int y,String couleur){
        return est_une_autre_couleur(x+1,y,couleur);
    }
    public boolean tester_encadrer_droite(int x,int y,String couleur){
        return est_une_autre_couleur(x,y+1,couleur);
    }
    public boolean tester_encadrer_diag_sup(int x,int y,String couleur){
        return est_une_autre_couleur(x-1,y-1,couleur);
    }
    public boolean tester_encadrer_diag_inf(int x,int y,String couleur){
        return est_une_autre_couleur(x+1,y+1,couleur);
    }





 /* sous-fonctions pour tester le contenu d'une case */
    public boolean est_vide(int x,int y){ return lesCases[x][y].equals("\uD83D\uDFE9");}
    public boolean est_de_couleur(int x,int y,String couleur){ return lesCases[x][y].equals(couleur);}
    public boolean est_une_autre_couleur(int x,int y,String couleur){ return !est_vide(x,y) && !est_de_couleur(x,y,couleur);}

    @Override
    public String toString() {
        String s="";
        for(int i=0; i<8; i++) {
            for (int j = 0; j < 8; j++)
                s += lesCases[i][j];
            s += "\n";
        }
        return s;
    }
}

