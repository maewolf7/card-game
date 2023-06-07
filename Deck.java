//Mae Wolf & Bryce Nyswonger
//CS145
//Lab 4 Card Game
import java.util.Random;

public class Deck {
    private Card[] cards;
    private int cardIndex;

    public Deck() {
        cards = new Card[52];
        String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"};
        int i = 0;
        for (String suit : suits) {
            for (int rank = 1; rank <= 13; rank++) {
                cards[i++] = new Card(suit, rank);
            }
        }
        cardIndex = 0;
    }

    public Card getCard() {
        if (cardIndex >= cards.length) {
            throw new IllegalStateException("No more cards left in the deck");
        }
        return cards[cardIndex++];
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = cards.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
        cardIndex = 0;
    }
}
