// Mae Wolf & Bryce Nyswonger
//CS145
//lab 4: Card Game
import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getScore() {
        int score = 0;
        boolean hasAce = false;

        for (Card card : cards) {
            int rank = card.getRank();
            if (rank == 1) {
                hasAce = true;
                score += 11;
            } else if (rank >= 10) {
                score += 10;
            } else {
                score += rank;
            }
        }

        // If the hand contains an Ace and the score is over 21, count the Ace as 1 instead of 11
        if (hasAce && score > 21) {
            score -= 10;
        }

        return score;
    }

    public Card getFirstCard() {
        return cards.get(0);
    }

    public Card getLastCard() {
        return cards.get(cards.size() - 1);
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length()); // Remove the last comma and space
        return sb.toString();
    }
}
