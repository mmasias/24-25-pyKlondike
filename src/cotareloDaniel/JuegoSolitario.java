import java.util.Scanner;

public class JuegoSolitario {
    private Tablero tablero;
    private Scanner entrada;

    public JuegoSolitario() {
        tablero = new Tablero();
        entrada = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;
        opcion = 0;

        while (opcion != 9) {
            System.out.println();
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
            System.out.println();

            tablero.mostrarEstado();
            System.out.println();
            System.out.print("Elige una opción [1-9]: ");
            opcion = entrada.nextInt();

            if (opcion == 1) {
                Carta carta;
                carta = tablero.getBaraja().sacarCarta();
                if (carta != null) {
                    tablero.getDescarte().agregarCarta(carta);
                }
            }
        }
    }
}
