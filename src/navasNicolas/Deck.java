package navasNicolas;

public class Deck {
    protected Card[] cards;
    protected int size;
    
    public Deck() {
        cards = new Card[52];
        size = 0;
        initializeDeck();
        shuffle();
    }
    
    private void initializeDeck() {
        int index = 0;
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                cards[index++] = new Card(suit, rank);
            }
        }
        size = 52;
    }
    
    public void shuffle() {
        for (int i = size - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    public Card deal() {
        if (isEmpty()) return null;
        return cards[--size];
    }
    
    public void addCard(Card card) {
        if (size < cards.length) {
            cards[size++] = card;
        }
    }
}