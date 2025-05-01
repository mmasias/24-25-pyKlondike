package navasNicolas;

import java.util.Scanner;

public class GameLauncher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
        System.out.println("╔════════════════════════════════╗");
        System.out.println("║    KLONDIKE SOLITAIRE v1.0     ║");
        System.out.println("╚════════════════════════════════╝");
        
        while (!exit) {
            System.out.println("\nMENU PRINCIPAL:");
            System.out.println("1. Nuevo Juego");
            System.out.println("2. Instrucciones");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Entrada no válida. Por favor ingrese un número.");
                scanner.nextLine(); // Clear the buffer
                continue;
            }
            
            switch (choice) {
                case 1:
                    startNewGame(scanner);
                    break;
                case 2:
                    showInstructions();
                    break;
                case 3:
                    exit = true;
                    System.out.println("¡Gracias por jugar! Hasta pronto.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        
        scanner.close();
    }
    
    private static void startNewGame(Scanner scanner) {
        System.out.println("\nIniciando nuevo juego...");
        Game game = new Game();
        game.play();
        
        // After game ends, ask if player wants to play again
        System.out.print("\n¿Desea jugar otra partida? (s/n): ");
        String playAgain = scanner.next().toLowerCase();
        
        if (playAgain.equals("s") || playAgain.equals("si")) {
            startNewGame(scanner);
        }
    }
    
    private static void showInstructions() {
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║               INSTRUCCIONES DEL JUEGO               ║");
        System.out.println("╠════════════════════════════════════════════════════╣");
        System.out.println("║ Objetivo: Mover todas las cartas a los palos       ║");
        System.out.println("║ (fundaciones) en orden ascendente (A-K) por palo.  ║");
        System.out.println("║                                                    ║");
        System.out.println("║ Movimientos permitidos:                            ║");
        System.out.println("║ 1. Mover de Baraja a Descarte                     ║");
        System.out.println("║ 2. Mover de Descarte a Palo                       ║");
        System.out.println("║ 3. Mover de Descarte a Columna                    ║");
        System.out.println("║ 4. Mover de Palo a Columna                        ║");
        System.out.println("║ 5. Mover de Columna a Palo                        ║");
        System.out.println("║ 6. Mover de Columna a Columna                     ║");
        System.out.println("║ 7. Voltear carta de Columna                       ║");
        System.out.println("║ 8. Voltear Descarte en Baraja                     ║");
        System.out.println("║                                                    ║");
        System.out.println("║ Reglas:                                            ║");
        System.out.println("║ - En columnas: cartas en orden descendente y      ║");
        System.out.println("║   alternando colores                              ║");
        System.out.println("║ - En palos: cartas del mismo palo en orden        ║");
        System.out.println("║   ascendente (A,2,3,...,K)                       ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
        
        System.out.println("\nPresione Enter para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
            // Just continue if there's an exception
        }
    }
}
