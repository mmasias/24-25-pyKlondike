import java.util.Scanner;

public class Klondike {
    private Baraja baraja = new Baraja();
    private Descarte descarte = new Descarte();

    public void ejecutar() {
        inicializarEjemplo();
        Scanner scanner = new Scanner(System.in);
        boolean jugando = true;

        while (jugando) {
            mostrarEstado();
            mostrarMenu();

            System.out.print("Elige una opción [1-9]: ");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                baraja.voltear(descarte);
            } else if (opcion == 2) {
                System.out.println("Mover de Descarte a Palo (no implementado aún).");
            } else if (opcion == 3) {
                System.out.println("Mover de Descarte a Columna (no implementado aún).");
            } else if (opcion == 4) {
                System.out.println("Mover de Palo a Columna (no implementado aún).");
            } else if (opcion == 5) {
                System.out.println("Mover de Columna a Palo (no implementado aún).");
            } else if (opcion == 6) {
                System.out.println("Mover de Columna a Columna (no implementado aún).");
            } else if (opcion == 7) {
                System.out.println("Voltear carta de Columna (no implementado aún).");
            } else if (opcion == 8) {
                baraja.reiniciarDesdeDescarte(descarte);
            } else if (opcion == 9) {
                System.out.println("Gracias por jugar.");
                jugando = false;
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }

    private void mostrarEstado() {
        System.out.println("BARAJA: " + baraja);
        System.out.println("Descarte: " + descarte);
    }

    private void mostrarMenu() {
        System.out.println("OPCIONES>");
        System.out.println("  1. Mover de Baraja a Descarte");
        System.out.println("  8. Voltear Descarte en Baraja");
        System.out.println("  9. Salir");
    }

    private void inicializarEjemplo() {
        baraja.agregar(new Carta("Q", PaloCarta.DIAMANTES, false));
        baraja.agregar(new Carta("7", PaloCarta.DIAMANTES, false));
        baraja.agregar(new Carta("9", PaloCarta.TREBOLES, false));
    }

    public static void main(String[] args) {
        new Juego().ejecutar();
    }
}