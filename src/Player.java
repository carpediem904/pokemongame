import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    /**
     * Method for player to play card
     * index is the position of the card that player wants to play
     */
    public Card playCard(int index) {
        if (index >= 0 && index < hand.size()) {
            return hand.remove(index);
        }
        return null;
    }

    // Other methods as needed
    public String getName() {
        return this.name;
    }

    public List<Card> getHand() {
        return hand;
    }

    @Override
    public String toString() {
        StringBuilder handString = new StringBuilder();
        for (Card card : hand) {
            handString.append(card.toString()).append("\n");
        }
        return handString.toString();

    }
}

