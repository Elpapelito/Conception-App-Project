package Modele;



public class Damier {

    String[][] plateau;
    String currentJoueur;



    public Damier( int dimensionPlateau)
    {
        this.currentJoueur = "\u26AA";
        this.plateau = new String[dimensionPlateau+1][dimensionPlateau+1];
        this.plateau[(dimensionPlateau/2)][(dimensionPlateau/2)] = "\u26AA";
        this.plateau[(dimensionPlateau/2)+1][(dimensionPlateau/2)+1] = "\u26AA";
        this.plateau[(dimensionPlateau/2)][(dimensionPlateau/2)+1] = "\u26AB";
        this.plateau[(dimensionPlateau/2)+1][(dimensionPlateau/2)] = "\u26AB";
        for( int i = 0; i < plateau.length ;i++){
            if (i ==0){
                for( int a = 0; a < plateau.length ;a++){
                    if (a ==0){
                        plateau[i][a] = "//";
                    }
                    else{
                        char c = (char) (a + 96);
                        plateau[i][a] = String.valueOf(c)+" ";
                    }

                }

            }
            else{
                for( int a = 0; a < this.plateau.length ;a++){
                    if (a ==0){
                        this.plateau[i][0] = String.valueOf(i);
                    }
                    else{
                        if (this.plateau[i][a] == null){
                            this.plateau[i][a] = "\uD83D\uDFE9";
                        }

                    }

                }




            }
        }


    }



    public String toString()
    {
        String result = "";
        String barre = "";
        for (int i =0 ; i < this.plateau.length ; i++)
        {
            barre += "_____";
        }
        for(String[] ligne : this.plateau)
        {
            String chaine = "";

            for(String value : ligne){
                chaine += value+" | ";

            }
            result += chaine + "\n" + barre + "\n";
        }
        return result;
    }

    public void poserPions(String coup){
        int colone = ((int) coup.charAt(0) )-96;
        int ligne = Character.getNumericValue(coup.charAt(1));
        plateau[colone][ligne] = currentJoueur;
        if (this.currentJoueur.equals("\u26AA")){
            this.currentJoueur = "\u26AB";
        }
        else{
            this.currentJoueur = "\u26AA";
        }




    }

    public boolean estRemplie(){
        for(String[] ligne : this.plateau){
            for(String value : ligne){
                if(value.equals("\uD83D\uDFE9")){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean testerCoup(String coup ){
        int colonne = ((int) coup.charAt(0) )-96;
        int ligne = Character.getNumericValue(coup.charAt(1));
        String color = currentJoueur;
        String counterColor;
        if( color.equals("\\u26AA")){
             counterColor = "\\u26AB";
        }
        else{
             counterColor = "\\u26AA";
        }
        if( !plateau[colonne][ligne].equals("\\u26AA") && !plateau[colonne][ligne].equals("\\u26AB")){
            if( colonne+1<= (this.plateau.length-1)  && this.plateau[colonne+1][ligne].equals(counterColor) ){
                return true;
            }
            else if (colonne-1 > 0  && this.plateau[colonne-1][ligne].equals(counterColor)){
                return true;
            }
            else if (ligne-1 > 0  && this.plateau[colonne][ligne-1].equals(counterColor)){
                return true;
            }
            else if (ligne+1<= (this.plateau.length-1)  && this.plateau[colonne][ligne+1].equals(counterColor)){
                return true ;
            }
            else {
                return false;
            }

        }
        else{
            return false;
        }

    }
}
