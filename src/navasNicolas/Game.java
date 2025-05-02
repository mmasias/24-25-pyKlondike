package navasNicolas;

import java.util.Scanner;

public class Game {
    private Stock stock;
    private Waste waste;
    private Foundation[] foundations;
    private Tableau[] tableaus;
    private Scanner scanner;
    
    public Game() {
        stock = new Stock();
        waste = new Waste();
        foundations = new Foundation[4];
        for (int i = 0; i < 4; i++) {
            foundations[i] = new Foundation(Card.Suit.values()[i]);
        }
        tableaus = new Tableau[7];
        scanner = new Scanner(System.in);
        initializeGame();
    }
    
    private void initializeGame() {
        Deck deck = new Deck();
        
        for (int i = 0; i < 7; i++) {
            Card[] tableauCards = new Card[i+1];
            for (int j = 0; j <= i; j++) {
                tableauCards[j] = deck.deal();
            }
            tableaus[i] = new Tableau(tableauCards);
        }
        
        while (!deck.isEmpty()) {
            stock.addCard(deck.deal());
        }
    }
    
    public void play() {
        boolean exit = false;
        
        while (!exit) {
            display();
            System.out.print("\nElige una opción [1-9]: ");
            int option = scanner.nextInt();
            
            switch (option) {
                case 1-> moveStockToWaste();
                case 2-> moveWasteToFoundation();
                case 3-> moveWasteToTableau();
                case 4-> moveFoundationToTableau();
                case 5-> moveTableauToFoundation();
                case 6-> moveTableauToTableau();
                case 7-> flipTableauCard();
                case 8-> resetWasteToStock();
                case 9->exit = !exit;
            }
            
            if (checkWin()) {
                display();
                System.out.println("\n¡Felicidades! ¡Has ganado el juego!");
                exit = true;
            }
        }
    }
    
    private void moveStockToWaste() {
        if (stock.isEmpty()) {
            System.out.println("No hay cartas en la baraja para mover.");
            return;
        }
        
        Card[] drawnCards = stock.drawToWaste(3);
        waste.addCards(drawnCards);
    }
    
    private void moveWasteToFoundation() {
        Card card = waste.getTopCard();
        if (card == null) {
            System.out.println("No hay cartas en el descarte para mover.");
            return;
        }
        
        Foundation foundation = foundations[card.getSuit().ordinal()];
        if (foundation.placeCard(card)) {
            waste.removeTopCard();
        } else {
            System.out.println("Movimiento no válido. No se puede colocar " + card + " en el palo.");
        }
    }
    
    private void moveWasteToTableau() {
        Card card = waste.getTopCard();
        if (card == null) {
            System.out.println("No hay cartas en el descarte para mover.");
            return;
        }
        
        System.out.print("Selecciona columna de destino (1-7): ");
        int column = scanner.nextInt() - 1;
        
        if (column < 0 || column >= 7) {
            System.out.println("Columna no válida.");
            return;
        }
        
        if (tableaus[column].placeCard(card)) {
            waste.removeTopCard();
        } else {
            System.out.println("Movimiento no válido. No se puede colocar " + card + " en la columna " + (column + 1));
        }
    }
    
    private void moveFoundationToTableau() {
        System.out.print("Selecciona palo de origen (1-4): ");
        int foundationIndex = scanner.nextInt() - 1;
        
        if (foundationIndex < 0 || foundationIndex >= 4) {
            System.out.println("Palo no válido.");
            return;
        }
        
        Card card = foundations[foundationIndex].getTopCard();
        if (card == null) {
            System.out.println("No hay cartas en el palo seleccionado.");
            return;
        }
        
        System.out.print("Selecciona columna de destino (1-7): ");
        int column = scanner.nextInt() - 1;
        
        if (column < 0 || column >= 7) {
            System.out.println("Columna no válida.");
            return;
        }
        
        if (tableaus[column].placeCard(card)) {
            foundations[foundationIndex].removeTopCard();
        } else {
            System.out.println("Movimiento no válido. No se puede colocar " + card + " en la columna " + (column + 1));
        }
    }
    
    private void moveTableauToFoundation() {
        System.out.print("Selecciona columna de origen (1-7): ");
        int column = scanner.nextInt() - 1;
        
        if (column < 0 || column >= 7) {
            System.out.println("Columna no válida.");
            return;
        }
        
        Tableau tableau = tableaus[column];
        if (tableau.getVisibleCount() == 0) {
            System.out.println("No hay cartas visibles en la columna seleccionada.");
            return;
        }
        
        Card card = tableau.getVisibleCard(tableau.getVisibleCount() - 1);
        Foundation foundation = foundations[card.getSuit().ordinal()];
        
        if (foundation.placeCard(card)) {
            // Remove the card from tableau
            int removePosition = tableau.getFirstVisiblePosition() + tableau.getVisibleCount() - 1;
            tableau.removeStack(removePosition);
        } else {
            System.out.println("Movimiento no válido. No se puede colocar " + card + " en el palo.");
        }
    }
    
    private void moveTableauToTableau() {
        System.out.print("Selecciona columna de origen (1-7): ");
        int fromColumn = scanner.nextInt() - 1;
        
        if (fromColumn < 0 || fromColumn >= 7) {
            System.out.println("Columna no válida.");
            return;
        }
        
        Tableau fromTableau = tableaus[fromColumn];
        int visibleCount = fromTableau.getVisibleCount();
        
        if (visibleCount == 0) {
            System.out.println("No hay cartas visibles en la columna de origen.");
            return;
        }
        
        System.out.print("Selecciona cuántas cartas mover (1-" + visibleCount + "): ");
        int count = scanner.nextInt();
        
        if (count < 1 || count > visibleCount) {
            System.out.println("Número de cartas no válido.");
            return;
        }
        
        System.out.print("Selecciona columna de destino (1-7): ");
        int toColumn = scanner.nextInt() - 1;
        
        if (toColumn < 0 || toColumn >= 7) {
            System.out.println("Columna no válida.");
            return;
        }
        
        int firstVisiblePos = fromTableau.getFirstVisiblePosition();
        int fromIndex = firstVisiblePos + visibleCount - count;
        Card[] stackToMove = fromTableau.removeStack(fromIndex);
        
        if (stackToMove != null && tableaus[toColumn].placeStack(stackToMove)) {
            // Success
        } else {
            System.out.println("Movimiento no válido.");
            if (stackToMove != null) {
                fromTableau.placeStack(stackToMove);
            }
        }
    }
    
    private void flipTableauCard() {
        System.out.print("Selecciona columna para voltear carta (1-7): ");
        int column = scanner.nextInt() - 1;
        
        if (column < 0 || column >= 7) {
            System.out.println("Columna no válida.");
            return;
        }
        
        tableaus[column].flipTopCard();
    }
    
    private void resetWasteToStock() {
        if (stock.isEmpty() && waste.isEmpty()) {
            System.out.println("No hay cartas para voltear.");
            return;
        }
        
        if (!stock.isEmpty()) {
            System.out.println("Aún hay cartas en la baraja. Voltea primero todas las cartas.");
            return;
        }
        
        while (!waste.isEmpty()) {
            Card card = waste.removeTopCard();
            card.flip();
            stock.addCard(card);
        }
    }
    
    private boolean checkWin() {
        for (Foundation foundation : foundations) {
            if (!foundation.isComplete()) {
                return false;
            }
        }
        return true;
    }
    
    public void display() {
        System.out.println("\n<OPCIONES>");
        System.out.println("  1. Mover de Baraja a Descarte");
        System.out.println("  2. Mover de Descarte a Palo");
        System.out.println("  3. Mover de Descarte a Columna");
        System.out.println("  4. Mover de Palo a Columna");
        System.out.println("  5. Mover de Columna a Palo");
        System.out.println("  6. Mover de Columna a Columna");
        System.out.println("  7. Voltear carta de Columna");
        System.out.println("  8. Voltear Descarte en Baraja");
        System.out.println("  9. Salir");
        
        System.out.println("\nBARAJA: " + stock);
        System.out.println("Descarte: " + waste);
        
        System.out.println();
        for (int i = 0; i < 4; i++) {
            System.out.println((i + 1) + "º Palo: " + foundations[i]);
        }
        
        System.out.println();
        for (int i = 0; i < 7; i++) {
            System.out.println("Columna [" + (i + 1) + "]: " + tableaus[i]);
        }
    }
    
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}