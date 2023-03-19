package Systeme.modele;

import java.util.ArrayList;
import java.util.List;

public class Damier {
    /* pion_blanc = 1 pion_noir = -1 vide = 0 */
    private int[][] lesCases;
    private int taille;
    private int nbPionsBlanc = 2;
    private int nbPionsNoir = 2;
    private int joueurCourant = 1;

    //-----------------GETTERS-----------------------------
    public int nbPionsBlanc() {
        return nbPionsBlanc;
    }

    public int getJoueurCourant() {
        return joueurCourant;
    }

    public int nbPionsNoir() {
        return nbPionsNoir;
    }

//Contructeur d'un damier vide
    public Damier(int taille) {
        lesCases = new int[taille][taille];
        for (int i = taille; i < taille; i++)
            for (int j = taille; j < taille; j++)
                lesCases[i][j] = 0;

        this.taille = lesCases.length;
    }

//initialisation d'un damier pour Othello
    public void initialiserDamierOthello() {
        if(lesCases.length %2!=0) throw new NotConformDamier("Le damier n'est pas conforme");

        lesCases[(taille/2)-1][(taille/2)-1]=1;
        lesCases[(taille/2)-1][(taille/2)]=-1;
        lesCases[(taille/2)][(taille/2)-1]=-1;
        lesCases[(taille/2)][(taille/2)]=1;
    }

//permuter le joueur courant
    public void changerJoueurCourant() {
        joueurCourant = (joueurCourant == -1) ? 1 : -1;
    }

//tester le coup
    public void testerCoup(String coup) throws CoupInvalid {
        if (!syntaxeValide(coup))
            throw new CoupInvalid("Syntaxe invalide");

        int x = Integer.parseInt(coup.substring(0,1))-1;
        int y = coup.charAt(2)-65;

        coupValide(x,y);
    }

    public boolean syntaxeValide(String coup) {
        if (coup.length() != 3) return false;

        int a = coup.charAt(0);
        int b = coup.charAt(1);
        int c = coup.charAt(2);
        if (a < 49 || a > taille+49-1 || b != 32 || c < 65 || c > taille+65-1)
            return false;
        return true;
    }

    public void coupValide(int x, int y) throws CoupInvalid {
        if(lesCases[x][y]!=0) throw new CoupInvalid("La case contient déjà un pion");
        boolean pionsPose = false;

        for (int i = -1; i <= 1; i++)
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0)
                    continue;

                if (encadrementValide(x, y, i, j)) {
                    lesCases[x][y] = joueurCourant;
                    if (!pionsPose) {
                        if (joueurCourant == -1) {
                            nbPionsNoir++;
                        } else {
                            nbPionsBlanc++;
                        }
                        pionsPose = true;
                    }
                    retournerPions(x, y, i, j);
                }
            }
        if (!pionsPose) throw new CoupInvalid("Il faut que votre pion encadre au moins un pion adverse.");
    }

    public boolean encadrementValide(int x, int y, int a, int b) {
        int l = a + x;
        int c = b + y;
        int nbPionsAdverse = 0;

        while (l >= 0 && l <taille && c >= 0 && c < taille) {
            if (lesCases[l][c] == 0)
                return false;
            if (lesCases[l][c] == joueurCourant)
                return nbPionsAdverse > 0;
            nbPionsAdverse++;
            l += a;
            c += b;
        }
        return false;
    }

    public void retournerPions(int x, int y, int a, int b) {
        int l = a + x;
        int c = b + y;
        while (lesCases[l][c] != joueurCourant) {
            lesCases[l][c] = joueurCourant;

            if (joueurCourant == 1) {
                nbPionsNoir--;
                nbPionsBlanc++;
            } else {
                nbPionsNoir++;
                nbPionsBlanc--;
            }
            l += a;
            c += b;
        }
    }

    public List<String> coupPossible() {
        List<String> coupP=new ArrayList<>();
        for (int i = 0; i <taille; i++)
            for (int j = 0; j <taille; j++) {
                if (lesCases[i][j] != 0)
                    continue;
                for (int k = -1; k <= 1; k++)
                    for (int l = -1; l <= 1; l++) {
                        if (k == 0 && l == 0)
                            continue;
                        if (encadrementValide(i, j, k, l)){
                            String cp = i+1 + " " + String.valueOf(Character.toChars(j+65));
                            coupP.add(cp);
                        }
                    }
            }
        return coupP;
    }

    public String toString() {
        String s = "O";
        for (int i = 65; i<taille+65; i++)
            s+= "|"+ String.valueOf(Character.toChars(i)) +"|";
        s+="\n";
        for (int i = 0; i < taille; i++) {
            s += i + 1;
            for (int j = 0; j < taille; j++)
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

    public int vainqueur() {
        return nbPionsNoir - nbPionsBlanc;
    }
}
