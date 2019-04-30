package blackjack;

//� A+ Computer Science  -  www.apluscompsci.com
//Name - 
//Date -
//Class -
//Lab  - 
public class BlackJackCard extends Card {
    
    //constructors
    public BlackJackCard(){
        super();
    }
    public BlackJackCard(String s, String f, int value){
        super(s, f, value);
    }
    
    public BlackJackCard(int value, String s){
        super(value, s);
    }
    public int getValue() {
        int value;
        
        if(super.getPointValue() == 1){
            value = 11;
        }
        else if (super.getPointValue()< 10) {
            value = super.getPointValue();
        }
        else {
            value = 10;
        }
        return value;
    }
}