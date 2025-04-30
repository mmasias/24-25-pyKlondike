import java.util.ArrayList;
import java.util.List;

public class OnPlay {
    private final Suit suit;
    private final List<Card> cards;

    public OnPlay(Suit suit) {
        this.suit = suit;
        this.cards = new ArrayList<>();
    }

    public boolean canAddCard(Card card) {
        if (card.getSuit() != suit) return false;
        if (cards.isEmpty()) {
            return card.getRank() == Rank.ACE;
        } else {
            Card topCard = cards.getLast();
            return card.getRank().ordinal() == topCard.getRank().ordinal() + 1;
        }
    }

    public void addCard(Card card) {
        if (canAddCard(card)) {
            cards.add(card);
        }
    }

    public Card getTopCard() {
        return cards.isEmpty() ? null : cards.getLast();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public Suit getSuit() {
        return suit;
    }
}