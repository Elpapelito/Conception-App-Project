package Modele;

public class Joueur {

    String nom ;
    String color;
    int partieGagne;


    public Joueur( String name , char color)
    {
        this.nom = name;
        if (color == 'B'){
            this.color = "\\u26AA";
        }
        else
        {
            this.color = "\\u26AB";
        }
        this.partieGagne = 0;


    }

    public String getNom(){
        return this.nom;
    }

    public String getPion(){
        return this.color;

    }

    public int getPartieGagne(){
        return this.partieGagne;
    }

    public void setPartieGagne(int newInt){
        this.partieGagne = newInt;
    }

}
