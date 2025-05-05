package coboIsmael;

import java.util.Scanner;

public class Menu {
    private Scanner lector;

    public Menu(Scanner lector) {
        this.lector = lector;
    }

    public void mostrar() {
        System.out.println("1. Mover de Baraja a Descarte");
        System.out.println("2. Mover de Descarte a Palo");
        System.out.println("3. Mover de Descarte a Columna");
        System.out.println("4. Mover de Columna a Columna");
        System.out.println("5. Mover de Columna a Palo");
        System.out.println("6. Voltear carta en Columna");
        System.out.println("7. Reiniciar Baraja");
        System.out.println("8. Mostrar Tablero");
        System.out.println("9. Salir");
        System.out.print("Opción: ");
    }

    public int leerOpcion() {
        if (lector.hasNextInt()) {
            int opcionSeleccionada = lector.nextInt();
            lector.nextLine();
            return opcionSeleccionada;
        }
        lector.nextLine();
        return -1;
    }
}
