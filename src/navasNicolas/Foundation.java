package navasNicolas;

import java.util.ArrayList;
import java.util.List;

public class Foundation {
    private final Card.Suit suit;
    private final List<Card> cards;
    
    public Foundation(Card.Suit suit) {
        this.suit = suit;
        this.cards = new ArrayList<>();
    }
    
    public boolean canPlace(Card card) {
        if (card.getSuit() != suit) {
            return false;
        }
        
        if (cards.isEmpty()) {
            return card.getRank() == Card.Rank.ACE;
        }
        
        Card topCard = cards.get(cards.size() - 1);
        return card.getRank().ordinal() == topCard.getRank().ordinal() + 1;
    }
    
    public boolean placeCard(Card card) {
        if (canPlace(card)) {
            cards.add(card);
            return true;
        }
        return false;
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
    
    public boolean isComplete() {
        return !cards.isEmpty() && cards.get(cards.size() - 1).getRank() == Card.Rank.KING;
    }
    
    public String toString() {
        if (cards.isEmpty()) {
            return "No hay cartas en el palo";
        }
        return getTopCard().toString();
    }
}