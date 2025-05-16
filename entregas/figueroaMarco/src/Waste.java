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
        return cards.isEmpty() ? null : cards.get(cards.size() - 1);
    }

    public Card removeTopCard() {
        return cards.isEmpty() ? null : cards.remove(cards.size() - 1);
    }

    public List<Card> removeAllCards() {
        List<Card> temp = new ArrayList<>(cards);
        cards.clear();
        return temp;
    }

    public List<Card> getAllCards() {
        return new ArrayList<>(cards);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}