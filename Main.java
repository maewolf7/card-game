// Mae Wolf & Bryce Nyswonger
//CS145
//Lab 4: Card Game
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // make deck of cards and shuffle it
        Deck deck = new Deck();
        deck.shuffle();
        deck.shuffle();
        deck.shuffle();
        // triple shuffle for good measure

        // Initialize the player's and dealer's hands
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();

        // Deal the initial hands
        playerHand.addCard(deck.getCard());
        dealerHand.addCard(deck.getCard());
        playerHand.addCard(deck.getCard());
        dealerHand.addCard(deck.getCard());

        // Show starting hands
        System.out.println("Dealer's hand: " + dealerHand.getFirstCard() + " + unknown card");
        System.out.println("Your hand: " + playerHand);
        System.out.println( "Your score:" + playerHand.getScore());


        // hit or stand
        while (true) {
            System.out.print("Do you want to hit or stand? ");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("hit")) {
                // Player wants to hit, deal another card and show the updated hand
                playerHand.addCard(deck.getCard());
                System.out.println("Your hand: " + playerHand );
                System.out.println( "Your score:" + playerHand.getScore());



                // Check if the player busts
                if (playerHand.getScore() > 21) {

                    System.out.println("You bust! Dealer wins.");
                    return;
                }
            } else if (input.equals("stand")) {
                // Player stands, dealer reveals their hand and hits if score is less than player
                System.out.println("Dealer's hand: " + dealerHand);
                while (dealerHand.getScore() < playerHand.getScore()) {
                    dealerHand.addCard(deck.getCard());
                    System.out.println("Dealer hits: " + dealerHand.getLastCard());
                }

                // Check if the dealer busts
                if (dealerHand.getScore() > 21) {
                    System.out.println( "Dealer score:" + dealerHand.getScore());
                    System.out.println("Dealer busts! You win.");
                    return;
                }

                // Determine the winner
                int playerScore = playerHand.getScore();
                int dealerScore = dealerHand.getScore();
                if (playerScore > dealerScore) {
                    System.out.println("You win!");
                } else if (dealerScore > playerScore) {
                    System.out.println("Dealer wins.");
                } else {
                    System.out.println("It's a tie!");
                }
                return;
            } else {
                System.out.println("Invalid input, please enter 'hit' or 'stand'.");
            }
        }
    }
}
