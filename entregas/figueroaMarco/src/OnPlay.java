import java.util.ArrayList;
import java.util.List;

public class OnPlay {
    private final Suit suit;
    private final List<Card> cards;
    private static final int INDEX_CARD = 1;

    public OnPlay(Suit suit) {
        this.suit = suit;
        this.cards = new ArrayList<>();
    }

    public boolean canAddCard(Card card) {
        if (card.getSuit() != suit) return false;
        if (cards.isEmpty()) {
            return card.getRank() == Rank.ACE;
        } else {
            Card topCard = getTopCard();
            return card.getRank().ordinal() == topCard.getRank().ordinal() + INDEX_CARD;
        }
    }

    public void addCard(Card card) {
        if (canAddCard(card)) {
            cards.add(card);
        }
    }

    public Card getTopCard() {
        return cards.isEmpty() ? null : cards.get(cards.size() - INDEX_CARD);
    }

    public Card removeTopCard() {
        return cards.isEmpty() ? null : cards.remove(cards.size() - INDEX_CARD);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public Suit getSuit() {
        return suit;
    }
}