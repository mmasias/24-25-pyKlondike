import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Column {
    private final List<Card> cards;

    public Column() {
        cards = new ArrayList<>();
    }

    public void addInitialCard(Card card) {
        cards.add(card);
    }

    public boolean canReceiveCard(Card card) {
        if (cards.isEmpty()) {
            return card.getRank() == Rank.KING;
        } else {
            Card topCard = getFaceUpTopCard();
            if (topCard == null) return false;
            return card.getColor() != topCard.getColor() &&
                   card.getRank().ordinal() == topCard.getRank().ordinal() - 1;
        }
    }

    public void addCard(Card card) {
        if (canReceiveCard(card)) {
            cards.add(card);
        }
    }

    public Card removeTopCard() {
        if (cards.isEmpty()) return null;
        Card topCard = getFaceUpTopCard();
        if (topCard == null) return null;
        return cards.remove(cards.size() - 1);
    }

    public Card getFaceUpTopCard() {
        for (int i = cards.size() - 1; i >= 0; i--) {
            if (cards.get(i).isFaceUp()) {
                return cards.get(i);
            }
        }
        return null;
    }

    public void flipTopHiddenCard() {
        for (int i = cards.size() - 1; i >= 0; i--) {
            if (!cards.get(i).isFaceUp()) {
                cards.get(i).flip();
                break;
            }
        }
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
    }

    public void initializeStandardDeck() {
        cards.clear();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(suit, rank);
                card.flip(); /
                cards.add(card);
            }
        }
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(cards.size() - 1);
    }

    public void reshuffleFromWaste(Waste waste) {
        List<Card> wasteCards = waste.removeAllCards();
        for (Card card : wasteCards) {
            card.flip(); 
        }
        cards.addAll(wasteCards);
        Collections.shuffle(cards);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}