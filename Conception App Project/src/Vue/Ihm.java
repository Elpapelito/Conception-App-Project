package Vue;
import java.util.Scanner;

public class Ihm {

    Scanner sc = new Scanner(System.in);

    public Ihm ()
    {


    }

    public String saisieString(String question){
        System.out.print(question);
        String name = this.sc.next();
        return name;

    }

    public void affiche(Object object){
        System.out.println(object);
    }

}
