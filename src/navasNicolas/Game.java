package navasNicolas;

import java.util.Scanner;

public class Game {
    private Stock stock;
    private Waste waste;
    private Foundation[] foundations;
    private Tableau[] tableaus;
    private Scanner scanner;
    
    public Game() {
        initializeGame();
        scanner = new Scanner(System.in);
    }
    
    private void initializeGame() {
        Deck deck = new Deck();
        
        // Initialize tableaus
        tableaus = new Tableau[7];
        for (int i = 0; i < 7; i++) {
            Card[] tableauCards = new Card[i+1];
            for (int j = 0; j <= i; j++) {
                tableauCards[j] = deck.deal();
            }
            tableaus[i] = new Tableau(tableauCards);
        }
        
        // Add remaining cards to stock
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
                case 1:
                    moveStockToWaste();
                    break;
                case 2:
                    moveWasteToFoundation();
                    break;
                case 3:
                    moveWasteToTableau();
                    break;
                case 4:
                    moveFoundationToTableau();
                    break;
                case 5:
                    moveTableauToFoundation();
                    break;
                case 6:
                    moveTableauToTableau();
                    break;
                case 7:
                    flipTableauCard();
                    break;
                case 8:
                    resetWasteToStock();
                    break;
                case 9:
                    exit = true;
                    System.out.println("¡Gracias por jugar!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
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
        
        List<Card> drawnCards = stock.drawToWaste(3);
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
        
        Card card = tableaus[column].getVisibleCards().isEmpty() ? null : 
                   tableaus[column].getVisibleCards().get(tableaus[column].getVisibleCards().size() - 1);
        
        if (card == null) {
            System.out.println("No hay cartas visibles en la columna seleccionada.");
            return;
        }
        
        Foundation foundation = foundations[card.getSuit().ordinal()];
        if (foundation.placeCard(card)) {
            tableaus[column].removeStack(tableaus[column].getVisibleCards().size() - 1);
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
        
        List<Card> visibleCards = tableaus[fromColumn].getVisibleCards();
        if (visibleCards.isEmpty()) {
            System.out.println("No hay cartas visibles en la columna de origen.");
            return;
        }
        
        System.out.print("Selecciona cuántas cartas mover (1-" + visibleCards.size() + "): ");
        int count = scanner.nextInt();
        
        if (count < 1 || count > visibleCards.size()) {
            System.out.println("Número de cartas no válido.");
            return;
        }
        
        System.out.print("Selecciona columna de destino (1-7): ");
        int toColumn = scanner.nextInt() - 1;
        
        if (toColumn < 0 || toColumn >= 7) {
            System.out.println("Columna no válida.");
            return;
        }
        
        int fromIndex = tableaus[fromColumn].getVisibleCards().size() - count;
        List<Card> stackToMove = tableaus[fromColumn].removeStack(fromIndex);
        
        if (stackToMove != null && tableaus[toColumn].placeStack(stackToMove)) {
            // Success - already handled in the methods
        } else {
            System.out.println("Movimiento no válido.");
            // Return the cards to the original column if the move failed
            if (stackToMove != null) {
                tableaus[fromColumn].placeStack(stackToMove);
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
        
        // Move all cards from waste back to stock (face down)
        while (!waste.isEmpty()) {
            Card card = waste.removeTopCard();
            card.flip(); // Flip back to face down
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