package navasNicolas;

import java.util.ArrayList;
import java.util.List;

public class Tableau {
    private final List<Card> cards;
    
    public Tableau(List<Card> initialCards) {
        this.cards = new ArrayList<>();
        if (initialCards != null && !initialCards.isEmpty()) {
            cards.addAll(initialCards);
            // Only the last card is face up initially
            cards.get(cards.size() - 1).flip();
        }
    }
    
    public boolean canPlace(Card card) {
        if (cards.isEmpty()) {
            return card.getRank() == Card.Rank.KING;
        }
        
        Card lastCard = cards.get(cards.size() - 1);
        return lastCard.isFaceUp() && 
               card.isBlack() != lastCard.isBlack() && 
               card.getRank().ordinal() == lastCard.getRank().ordinal() - 1;
    }
    
    public boolean placeCard(Card card) {
        if (canPlace(card)) {
            cards.add(card);
            return true;
        }
        return false;
    }
    
    public boolean placeStack(List<Card> stack) {
        if (stack == null || stack.isEmpty()) {
            return false;
        }
        
        Card bottomCard = stack.get(0);
        if (canPlace(bottomCard)) {
            cards.addAll(stack);
            return true;
        }
        return false;
    }
    
    public List<Card> removeStack(int fromIndex) {
        if (fromIndex < 0 || fromIndex >= cards.size()) {
            return null;
        }
        
        List<Card> removed = new ArrayList<>();
        for (int i = fromIndex; i < cards.size(); i++) {
            if (!cards.get(i).isFaceUp()) {
                return null; // Can't remove face-down cards
            }
        }
        
        while (fromIndex < cards.size()) {
            removed.add(cards.remove(fromIndex));
        }
        
        // Flip the new last card if it exists
        if (!cards.isEmpty()) {
            Card lastCard = cards.get(cards.size() - 1);
            if (!lastCard.isFaceUp()) {
                lastCard.flip();
            }
        }
        
        return removed;
    }
    
    public void flipTopCard() {
        if (!cards.isEmpty()) {
            Card topCard = cards.get(cards.size() - 1);
            if (!topCard.isFaceUp()) {
                topCard.flip();
            }
        }
    }
    
    public List<Card> getVisibleCards() {
        List<Card> visible = new ArrayList<>();
        for (Card card : cards) {
            if (card.isFaceUp()) {
                visible.add(card);
            }
        }
        return visible;
    }
    
    public String toString() {
        if (cards.isEmpty()) {
            return "No hay cartas en la columna";
        }
        
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.toString());
        }
        return sb.toString();
    }
}