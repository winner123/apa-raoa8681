package blackjack;
//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 
 
import static java.lang.System.*;
import java.util.Scanner;


//define Player class here 
public class Player extends AbstractPlayer{

	//constructors
    public Player(){
        super();
    }

	//hit method goes here
    public boolean hit(){
        String s = new Scanner(System.in).next();
        switch (s.toUpperCase()) {
            case "Y":
                System.out.println(s);
                return true;
            case "N":
                System.out.println(s);
                return false;
            default:
                System.out.println("Invalid Answer");
                return hit();
        }
    }
} 

