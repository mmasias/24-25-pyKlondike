package navasNicolas;

public class Tableau {
    private Card[] cards;
    private int size;
    
    public Tableau(Card[] initialCards) {
        this.cards = new Card[20];
        this.size = 0;
        if (initialCards != null) {
            for (Card card : initialCards) {
                if (card != null) {
                    cards[size++] = card;
                }
            }
            if (size > 0) {
                cards[size-1].flip();
            }
        }
    }
    
    public boolean canPlace(Card card) {
        if (size == 0) return card.getRank() == Card.Rank.KING;
        Card lastCard = cards[size-1];
        return lastCard.isFaceUp() && 
             card.isBlack() != lastCard.isBlack() && 
             card.getRank().ordinal() == lastCard.getRank().ordinal() - 1;
    }
    
    public boolean placeCard(Card card) {
        if (canPlace(card)) {
            cards[size++] = card;
            return true;
        }
        return false;
    }
    
    public boolean placeStack(Card[] stack) {
        if (stack == null || stack.length == 0) return false;
        if (!canPlace(stack[0])) return false;
        
        for (Card card : stack) {
            if (size < cards.length) {
                cards[size++] = card;
            }
        }
        return true;
    }
    
    public Card[] removeStack(int fromIndex) {
        if (fromIndex < 0 || fromIndex >= size) return null;
        
        int newSize = size - fromIndex;
        Card[] removed = new Card[newSize];
        System.arraycopy(cards, fromIndex, removed, 0, newSize);
        
        size = fromIndex;
        if (size > 0 && !cards[size-1].isFaceUp()) {
            cards[size-1].flip();
        }
        return removed;
    }
    
    public void flipTopCard() {
        if (size > 0) {
            cards[size-1].flip();
        }
    }
    
    public String toString() {
        if (size == 0) return "No hay cartas en la columna";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(cards[i].toString());
        }
        return sb.toString();
    }

    public int getVisibleCount() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (cards[i].isFaceUp()) {
                count++;
            }
        }
        return count;
    }
    
    public Card getVisibleCard(int index) {
        int visibleIndex = 0;
        for (int i = 0; i < size; i++) {
            if (cards[i].isFaceUp()) {
                if (visibleIndex == index) {
                    return cards[i];
                }
                visibleIndex++;
            }
        }
        return null;
    }
    
    public int getFirstVisiblePosition() {
        for (int i = 0; i < size; i++) {
            if (cards[i].isFaceUp()) {
                return i;
            }
        }
        return size; 
    }
}