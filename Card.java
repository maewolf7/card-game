//Mae Wolf & Bryce Nyswonger
//CS145
//Lab 4: Card Game

public class Card {
    private final String suit; // Hearts, Clubs, Spades, Diamonds
    private final int rank; // 1-13

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        String rankString;
        switch (rank) {
            case 1:
                rankString = "Ace";
                break;
            case 11:
                rankString = "Jack";
                break;
            case 12:
                rankString = "Queen";
                break;
            case 13:
                rankString = "King";
                break;
            default:
                rankString = String.valueOf(rank);
                break;
        }
        return rankString + " of " + suit;
    }
}