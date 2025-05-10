package scr.calderonJimena;

import java.util.Scanner;

public class Menu {
    private final Klondike juego;

    public Menu(Klondike juego) {
        this.juego = juego;
    }

    public void mostrar() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nOPCIONES>");
            System.out.println("  1. Mover de Baraja a Descarte");
            System.out.println("  2. Mover de Descarte a Palo");
            System.out.println("  3. Mover de Descarte a Columna");
            System.out.println("  4. Mover de Palo a Columna");
            System.out.println("  5. Mover de Columna a Palo");
            System.out.println("  6. Mover de Columna a Columna");
            System.out.println("  7. Voltear carta de Columna");
            System.out.println("  8. Voltear Descarte en Baraja");
            System.out.println("  9. Salir\n");

            juego.mostrarEstado();

            System.out.print("\nElige una opción [1-9]: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> juego.robar();
                case 9 -> System.out.println("Saliendo del juego...");
                default -> System.out.println("Opción no implementada todavía.");
            }
        } while (opcion != 9);

        sc.close();
    }
}

