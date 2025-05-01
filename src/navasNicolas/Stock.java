package navasNicolas;

import java.util.ArrayList;
import java.util.List;

public class Stock extends Deck {
    public Stock() {
        super();
    }
    
    public List<Card> drawToWaste(int count) {
        List<Card> drawnCards = new ArrayList<>();
        for (int i = 0; i < count && !isEmpty(); i++) {
            Card card = deal();
            card.flip(); // Cards are face up in waste
            drawnCards.add(card);
        }
        return drawnCards;
    }
    
    public String toString() {
        if (isEmpty()) {
            return "No hay cartas en la baraja";
        }
        return "[? ?]";
    }
}
