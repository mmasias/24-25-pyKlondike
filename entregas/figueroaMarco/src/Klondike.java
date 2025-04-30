public class Klondike {
    private final Deck deck;
    private final Waste waste;
    private final List<OnPlay> foundations;
    private final List<Column> columns;
    private boolean gameOver = false;

    public Klondike(Deck deck, Waste waste, List<OnPlay> foundations, List<Column> columns) {
        this.deck = deck;
        this.waste = waste;
        this.foundations = foundations;
        this.columns = columns;
    }

    public boolean moveFromDeckToWaste() {
        Card card = deck.drawCard();
        if (card != null) {
            waste.addCard(card);
            return true;
        }
        return false;
    }

    public boolean moveToFoundationFromWaste(int foundationIndex) {
        Card card = waste.removeTopCard();
        if (card != null && foundations.get(foundationIndex).canAddCard(card)) {
            foundations.get(foundationIndex).addCard(card);
            return true;
        }
        if (card != null) waste.addCard(card); 
        return false;
    }

    public boolean moveBetweenColumns(int fromIndex, int toIndex) {
        Column fromColumn = columns.get(fromIndex);
        Column toColumn = columns.get(toIndex);
        Card card = fromColumn.removeTopCard();
        if (card != null && toColumn.canReceiveCard(card)) {
            toColumn.addCard(card);
            return true;
        }
        if (card != null) fromColumn.addCard(card);
        return false;
    }

    public boolean moveToColumnFromWaste(int columnIndex) {
        Card card = waste.removeTopCard();
        if (card != null && columns.get(columnIndex).canReceiveCard(card)) {
            columns.get(columnIndex).addCard(card);
            return true;
        }
        if (card != null) waste.addCard(card);
        return false;
    }

    public boolean moveFoundationToColumn(int foundationIndex, int columnIndex) {
        Card card = foundations.get(foundationIndex).getTopCard();
        if (card != null && columns.get(columnIndex).canReceiveCard(card)) {
            foundations.get(foundationIndex).removeTopCard();
            columns.get(columnIndex).addCard(card);
            return true;
        }
        return false;
    }

    public boolean moveColumnToFoundation(int columnIndex, int foundationIndex) {
        Column column = columns.get(columnIndex);
        Card card = column.getFaceUpTopCard();
        if (card != null && foundations.get(foundationIndex).canAddCard(card)) {
            column.removeTopCard();
            foundations.get(foundationIndex).addCard(card);
            return true;
        }
        return false;
    }

    public boolean moveColumnToColumn(int fromIndex, int toIndex) {
        Column from = columns.get(fromIndex);
        Column to = columns.get(toIndex);
        Card card = from.getFaceUpTopCard();
        if (card != null && to.canReceiveCard(card)) {
            from.removeTopCard();
            to.addCard(card);
            return true;
        }
        return false;
    }

    public void flipColumnCard(int columnIndex) {
        columns.get(columnIndex).flipTopHiddenCard();
    }

    public void resetDeckFromWaste() {
        deck.reshuffleFromWaste(waste);
    }

    public boolean isGameOver() {
        return foundations.stream().allMatch(f -> f.getTopCard().getRank() == Rank.KING);
    }

    public void displayGameState() {
        System.out.println("Baraja: " + (deck.isEmpty() ? "[Vacio]" : "[? ?]"));
        System.out.print("Descarte: ");
        waste.getAllCards().forEach(c -> System.out.print(c + " "));
        System.out.println();

        System.out.println("\nFundamentos:");
        for (int i = 0; i < foundations.size(); i++) {
            OnPlay foundation = foundations.get(i);
            System.out.println((i+1) + ". " + foundation.getSuit() + ": " + 
                (foundation.isEmpty() ? "Vacío" : foundation.getTopCard()));
        }

        System.out.println("\nColumnas:");
        for (int i = 0; i < columns.size(); i++) {
            Column col = columns.get(i);
            System.out.print((i+1) + ". ");
            for (Card c : col.getAllCards()) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}