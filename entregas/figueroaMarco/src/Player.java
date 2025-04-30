import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        Waste waste = new Waste();
        List<OnPlay> foundations = List.of(
            new OnPlay(Suit.HEARTS),
            new OnPlay(Suit.DIAMONDS),
            new OnPlay(Suit.SPADES),
            new OnPlay(Suit.CLUBS)
        );
        List<Column> columns = new ArrayList<>();
        for (int i = 0; i < 7; i++) columns.add(new Column());

        deck.initializeStandardDeck();

        Klondike game = new Klondike(deck, waste, foundations, columns);

        while (!game.isGameOver()) {
            game.displayGameState();
            System.out.println("\nOpciones:");
            System.out.println("1. Mover de Baraja a Descarte");
            System.out.println("2. Mover de Descarte a Palo");
            System.out.println("3. Mover de Descarte a Columna");
            System.out.println("4. Mover de Palo a Columna");
            System.out.println("5. Mover de Columna a Palo");
            System.out.println("6. Mover de Columna a Columna");
            System.out.println("7. Voltear carta de Columna");
            System.out.println("8. Voltear Descarte en Baraja");
            System.out.println("9. Salir");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    game.moveFromDeckToWaste();
                case 2:
                    System.out.print("¿A qué palo? (0-3): ");
                    int foundationIndex = scanner.nextInt();
                    game.moveToFoundationFromWaste(foundationIndex);
                case 3:
                    System.out.print("¿A qué columna? (0-6): ");
                    int colIndex = scanner.nextInt();
                    game.moveToColumnFromWaste(colIndex);
                case 4:
                    System.out.print("Palo (0-3) y Columna (0-6): ");
                    int movingFoundationIndex = scanner.nextInt();
                    int targetFoundationColIndex = scanner.nextInt();
                    game.moveFoundationToColumn(movingFoundationIndexIndex, targetFoundationColIndex);
                case 5:
                    System.out.print("Columna (0-6) y Palo (0-3): ");
                    int SourceColIndex = scanner.nextInt();
                    int foundationTarget = scanner.nextInt();
                    game.moveColumnToFoundation(SourceColIndexIndex, foundationTarget);
                case 6:
                    System.out.print("De Columna (0-6) a Columna (0-6): ");
                    int fromCol = scanner.nextInt();
                    int toCol = scanner.nextInt();
                    game.moveColumnToColumn(fromCol, toCol);
                case 7:
                    System.out.print("¿Qué columna voltear? (0-6): ");
                    int flipCardIndex = scanner.nextInt();
                    game.flipColumnCard(flipCardIndex);
                    break;
                case 8:
                    game.resetDeckFromWaste();
                    break;
                case 9:
                    System.out.println("¡Juego terminado!");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        System.out.println("¡Felicidades! Has ganado el juego.");
    }
}