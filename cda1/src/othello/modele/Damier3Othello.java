package othello.modele;

public class Damier3Othello {
    /* pion_blanc = 1 pion_noir = -1 vide = 0 */
    private int[][] lesCases;
    private int nb_pions_blanc = 2;
    private int nb_pions_noir = 2;

    int joueur_courant = -1;
    public Damier3Othello(){
        lesCases = new int[8][8];
    }

    public void initialise(){
        for(int i=0; i<8; i++)
            for(int j=0;j<8;j++)
                lesCases[i][j]=0;

        lesCases[3][3] = 1;
        lesCases[3][4] = -1;
        lesCases[4][3] = -1;
        lesCases[4][4] = 1;
    }

    public void poser_pion(int x, int y){
        lesCases[x][y]=joueur_courant;
    }

    public void changer_joueur_courant(){
        joueur_courant= (joueur_courant == -1) ? 1 : -1;
    }


    //tester le syntaxe du coup
    public void tester_syntaxe(String coup) throws Exception {
        if( coup.length() != 3) throw new Exception("Longueur du syntaxe incorrect");

        char a = coup.charAt(0); char b = coup.charAt(1); char c = coup.charAt(2);

        if( a<'1' || a > '8' || b !=' ' || c <'A' || c > 'H') throw new Exception(" Syntaxe incorrect");
    }


    //tester si la case est vide
    public boolean est_vide(int x,int y){ return lesCases[x][y]==0;}
    public boolean est_pion_joueur(int x,int y){ return lesCases[x][y]==joueur_courant;}
    public boolean est_pion_adverse(int x,int y){ return !est_vide(x,y) && !est_pion_joueur(x,y);}



    //parcours autour de la case
    public void parcours_autour(int x, int y) throws Exception {
        for(int i=-1; i<=1; i++)
            for(int j=-1; j<=1; j++) {
                if(i == 0 && j == 0) continue;
                if(tester_encadrement(x,y,i,j))
                    retourner_pions(x,y,i,j);
            }
    }


//tester si le pion permet d'encadrer un pion adverse
    public boolean tester_encadrement(int x,int y,int a,int b){
        int l = a + x;
        int c = b + y;
        int nb_pions_adverse = 0;
        while (l >= 0 && l < 8 && c >= 0 && c < 8) {
            if (lesCases[l][c] == 0) {
                return false;
            }
            if (lesCases[l][c] == joueur_courant) {
                /* if(nb_pions_adverse>0) return true;
                return false; */
                return nb_pions_adverse > 0;
            }
            nb_pions_adverse++; l += a; c += b;
        }
        return false;
    }


//retourner les pions adverses
    public void retourner_pions(int x, int y,int a,int b){
        int l = a + x;
        int c = b + y;
        while (lesCases[l][c] != joueur_courant) {
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
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (lesCases[i][j] == 0) continue;
                for (int k = -1; k <= 1; k++)
                    for (int l = -1; l <= 1; l++) {
                        if (i == 0 && j == 0) continue;
                        if (tester_encadrement(i, j, k, l))
                            return false;
                    }
            }
        }
        return true;
    }

}
