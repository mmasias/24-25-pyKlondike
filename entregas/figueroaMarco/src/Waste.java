import java.util.ArrayList;
import java.util.List;

public class Waste {
    private List<Card> cards;

    public Waste() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        if (card != null) {
            card.flip(); 
            cards.add(card);
        }
    }

    public Card getTopCard() {
        return cards.isEmpty() ? null : cards.getLast();
    }

    public Card removeTopCard() {
        return cards.isEmpty() ? null : cards.removeLast();
    }

    public List<Card> removeAllCards() {
        List<Card> temp = new ArrayList<>(cards);
        cards.clear();
        return temp;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}