package navasNicolas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    protected List<Card> cards;
    
    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
        shuffle();
    }
    
    private void initializeDeck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }
    
    public void shuffle() {
        Collections.shuffle(cards);
    }
    
    public boolean isEmpty() {
        return cards.isEmpty();
    }
    
    public int size() {
        return cards.size();
    }
    
    public Card deal() {
        if (isEmpty()) {
            return null;
        }
        return cards.remove(cards.size() - 1);
    }
    
    public void addCard(Card card) {
        cards.add(card);
    }
    
    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }
}