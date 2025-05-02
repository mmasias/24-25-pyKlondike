package navasNicolas;

public class Foundation {
    private final Card.Suit suit;
    private Card[] cards;
    private int size;
    
    public Foundation(Card.Suit suit) {
        this.suit = suit;
        this.cards = new Card[13];
        this.size = 0;
    }
    
    public boolean canPlace(Card card) {
        if (card.getSuit() != suit) return false;
        if (size == 0) return card.getRank() == Card.Rank.ACE;
        return card.getRank().ordinal() == cards[size-1].getRank().ordinal() + 1;
    }
    
    public boolean placeCard(Card card) {
        if (canPlace(card) {
            cards[size++] = card;
            return true;
        }
        return false;
    }
    
    public Card getTopCard() {
        return size > 0 ? cards[size-1] : null;
    }
    
    public Card removeTopCard() {
        return size > 0 ? cards[--size] : null;
    }
    
    public boolean isComplete() {
        return size == 13;
    }
    
    public String toString() {
        return size == 0 ? "No hay cartas en el palo" : getTopCard().toString();
    }
}