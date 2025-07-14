import java.util.ArrayList;
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

    public List<Card> getAllCards() {
        return new ArrayList<>(cards);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}