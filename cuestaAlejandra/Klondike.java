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
        for (int i = 0; i < 4; i++) {
            System.out.print((i + 1) + "º Palo: ");
            if (palos[i] != null) {
                System.out.println(palos[i]);
            } else {
                System.out.println("No hay cartas en el palo");
            }
        }
        for (int i = 0; i < 7; i++) {
            System.out.print("Columna [" + (i + 1) + "]: ");
            if (columnas[i] != null) {
                System.out.println(columnas[i]);
            } else {
                System.out.println("Vacía");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("OPCIONES>");
        System.out.println("  1. Mover de Baraja a Descarte");
        System.out.println("  2. Mover de Descarte a Palo");
        System.out.println("  3. Mover de Descarte a Columna");
        System.out.println("  4. Mover de Palo a Columna");
        System.out.println("  5. Mover de Columna a Palo");
        System.out.println("  6. Mover de Columna a Columna");
        System.out.println("  7. Voltear carta de Columna");
        System.out.println("  8. Voltear Descarte en Baraja");
        System.out.println("  9. Salir");
    }

    private void inicializarEjemplo() {
        baraja.agregar(new Carta("Q", PaloCarta.DIAMANTES, false));
        baraja.agregar(new Carta("7", PaloCarta.DIAMANTES, false));
        baraja.agregar(new Carta("9", PaloCarta.TREBOLES, false));

        for (int i = 0; i < 4; i++) {
            palos[i] = new Palo();
        }

        for (int i = 0; i < 7; i++) {
            columnas[i] = new Columna();
        }

        // Ejemplo: poner A ♥️ en el primer palo
        palos[0].agregar(new Carta("A", PaloCarta.CORAZONES, true));
        palos[1].agregar(new Carta("A", PaloCarta.DIAMANTES, true));

        columnas[0].agregar(new Carta("3", PaloCarta.PICAS, true));
        columnas[1].agregar(new Carta("K", PaloCarta.CORAZONES, true));
    }

    public static void main(String[] args) {
        new Juego().ejecutar();
    }
}