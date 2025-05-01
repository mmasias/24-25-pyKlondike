package navasNicolas;

public class Card {
    public enum Suit {
        HEARTS("H"), DIAMONDS("D"), CLUBS("C"), SPADES("S");
        
        private final String symbol;
        
        Suit(String symbol) {
            this.symbol = symbol;
        }
        
        public String getSymbol() {
            return symbol;
        }
    }
    
    public enum Rank {
        ACE("A"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), 
        SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"), JACK("J"), QUEEN("Q"), KING("K");
        
        private final String display;
        
        Rank(String display) {
            this.display = display;
        }
        
        public String getDisplay() {
            return display;
        }
    }
    
    private final Suit suit;
    private final Rank rank;
    private boolean faceUp;
    
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.faceUp = false;
    }
    
    public Suit getSuit() {
        return suit;
    }
    
    public Rank getRank() {
        return rank;
    }
    
    public boolean isFaceUp() {
        return faceUp;
    }
    
    public void flip() {
        faceUp = !faceUp;
    }
    
    public boolean isRed() {
        return suit == Suit.HEARTS || suit == Suit.DIAMONDS;
    }
    
    public boolean isBlack() {
        return !isRed();
    }
    
    @Override
    public String toString() {
        if (!faceUp) {
            return "[? ?]";
        }
        return "[" + rank.getDisplay() + " " + suit.getSymbol() + "]";
    }
}