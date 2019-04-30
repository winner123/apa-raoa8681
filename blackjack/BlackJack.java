package blackjack;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 
import static java.lang.System.*;
import java.util.Scanner;

public class BlackJack {

    private Dealer deal;
    private Player play;

    public BlackJack() {
        deal = new Dealer();
        play = new Player();
    }

    public void playGame() {
        Scanner keyboard = new Scanner(System.in);
        char choice = 0;
        int playerTotal;
        int dealerTotal;
        
        String answer;
        deal.shuffle();
        play.addCardToHand(deal.deal());
        play.addCardToHand(deal.deal());
        deal.addCardToHand(deal.deal());
        deal.addCardToHand(deal.deal());

        playerTotal = play.getHandValue();
        dealerTotal = deal.getHandValue();

        System.out.println("PLAYER: Total: " + playerTotal + "\n" + play.toString());
        System.out.println("DEALER: Total: " + dealerTotal + "\n" + deal.toString());

        System.out.print("Do you want to hit? [Y/N]: ");
        boolean playerHit = play.hit();

        while (playerTotal <= 21&& playerHit) {
            play.addCardToHand(deal.deal());
            playerTotal = play.getHandValue();
            System.out.println("Total: " + playerTotal);
            System.out.println(play.toString());
            playerHit = play.hit();
        }

        boolean dealerHit = deal.hit();

        while (dealerHit) {
            deal.addCardToHand(deal.deal());
            dealerTotal = deal.getHandValue();
            System.out.println("Total: " + dealerTotal);
            System.out.println(deal.toString());
            dealerHit = deal.hit();
        }

        if (playerTotal > 21 && dealerTotal > 21) {
            System.out.println("Both players bust!");
        }
        if (playerTotal <= 21){
            if(dealerTotal > 21){
                System.out.println("Player wins - Dealer has busted!");
            }
            else {
                System.out.println("Player wins!");
            }
        }
        if(dealerTotal <= 21){
            if(playerTotal > 21){
                System.out.println("Dealer wins - Player has busted!");
            }
            else {
                System.out.println("Dealer wins!");
            }
        }

        System.out.println("Player: "+ playerTotal + " and Dealer:" + dealerTotal + "\n");

        System.out.println("Do you want to play again? [Y/N] ");

        answer = keyboard.next();

        if(answer.toUpperCase().equals("Y")){
            play.resetHand();
            deal.resetHand();
            playGame();
        }
    }
    public String getPlayerHand(Player p) {
        String str = "";
        if (p.toString().contains("ACE")) {
            str += p.getHandValue() + 10;
        } else {
            str += p.getHandValue();
        }
        return str;
    }
    public static void main(String[] args) {
        BlackJack game = new BlackJack();
        game.playGame();
    }
}