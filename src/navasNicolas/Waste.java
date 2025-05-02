package navasNicolas;

public class Waste {
    private Card[] cards;
    private int size;
    
    public Waste() {
        cards = new Card[52];
        size = 0;
    }
    
    public void addCards(Card[] newCards) {
        for (Card card : newCards) {
            if (size < cards.length) {
                cards[size++] = card;
            }
        }
    }
    
    public Card getTopCard() {
        return size > 0 ? cards[size - 1] : null;
    }
    
    public Card removeTopCard() {
        return size > 0 ? cards[--size] : null;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void clear() {
        size = 0;
    }
    
    public String toString() {
        if (size == 0) return "No hay cartas en el descarte";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(cards[i].toString());
        }
        return sb.toString();
    }
}
