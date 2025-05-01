import java.util.Scanner;

public class Partida {
    private final Scanner scanner;
    private boolean ejecutando;

    public Partida() {
        this.scanner = new Scanner(System.in);
        this.ejecutando = true;
    }

    public void iniciar() {
        while (ejecutando) {
            mostrarEstado();
            mostrarMenu();

            System.out.print("Elige una opción [1-9]: ");
            int opcion = scanner.nextInt();

            ejecutarOpcion(opcion);
            System.out.println();
        }
        scanner.close();
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> moverBarajaADescarte();
            case 2 -> moverDescarteAPalo();
            case 3 -> moverDescarteAColumna();
            case 4 -> moverPaloAColumna();
            case 5 -> moverColumnaAPalo();
            case 6 -> moverColumnaAColumna();
            case 7 -> voltearColumna();
            case 8 -> voltearDescarteEnBaraja();
            case 9 -> salirDelJuego();
            default -> System.out.println("Opción inválida. Intenta de nuevo.");
        }
    }

    private void salirDelJuego() {
        System.out.println("Saliendo del juego.");
        ejecutando = false;
    }

    private void moverBarajaADescarte() {
        System.out.println("Mover de Baraja a Descarte");
    }

    private void moverDescarteAPalo() {
        System.out.println("Mover de Descarte a Palo");
    }

    private void moverDescarteAColumna() {
        System.out.println("Mover de Descarte a Columna");
    }

    private void moverPaloAColumna() {
        System.out.println("Mover de Palo a Columna");
    }

    private void moverColumnaAPalo() {
        System.out.println("Mover de Columna a Palo");
    }

    private void moverColumnaAColumna() {
        System.out.println("Mover de Columna a Columna");
    }

    private void voltearColumna() {
        System.out.println("Voltear carta de Columna");
    }

    private void voltearDescarteEnBaraja() {
        System.out.println("Voltear Descarte en Baraja");
    }

    private void mostrarMenu() {
        System.out.println("OPCIONES:");
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

    private void mostrarEstado() {
        System.out.println("BARAJA: [? ?]");
        System.out.println("Descarte: [Q ][7 ][9 ]");
        System.out.println();
        System.out.println("1º Palo: [A ]");
        System.out.println("2º Palo: [A ]");
        System.out.println("3º Palo: No hay cartas ");
        System.out.println("4º Palo: No hay cartas ");
        System.out.println();
        System.out.println("Columna [1]: [3 ]");
        System.out.println("Columna [2]: [K ]");
        System.out.println("Columna [3]: [? ?][? ?][7 ]");
        System.out.println("Columna [4]: [? ?][? ?][? ?]");
        System.out.println("Columna [5]: [? ?][? ?][? ?][? ?][X ]");
        System.out.println("Columna [6]: [? ?][? ?][? ?][? ?][? ?][6 ]");
        System.out.println("Columna [7]: [? ?][? ?][? ?][? ?][? ?][? ?][9 ]");
    }
}
