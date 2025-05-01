package navasNicolas;

import java.util.ArrayList;
import java.util.List;

public class Waste {
    private List<Card> cards;
    
    public Waste() {
        cards = new ArrayList<>();
    }
    
    public void addCards(List<Card> newCards) {
        cards.addAll(newCards);
    }
    
    public Card getTopCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.get(cards.size() - 1);
    }
    
    public Card removeTopCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(cards.size() - 1);
    }
    
    public boolean isEmpty() {
        return cards.isEmpty();
    }
    
    public void clear() {
        cards.clear();
    }
    
    public String toString() {
        if (cards.isEmpty()) {
            return "No hay cartas en el descarte";
        }
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.toString());
        }
        return sb.toString();
    }
}
