package navasNicolas;

public class Stock extends Deck {
    public Stock() {
        super();
    }
    
    public Card[] drawToWaste(int count) {
        int drawSize = Math.min(count, size);
        Card[] drawnCards = new Card[drawSize];
        
        for (int i = 0; i < drawSize; i++) {
            drawnCards[i] = deal();
            drawnCards[i].flip();
        }
        
        return drawnCards;
    }
    
    public String toString() {
        return isEmpty() ? "No hay cartas en la baraja" : "[? ?]";
    }
}
