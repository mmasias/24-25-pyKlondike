package Filothjose;

import java.util.Scanner;

public class Menu {

    private final Mensajes mensaje;
    private final Scanner scanner;

    private final String[] opciones = {
            "1. Mover de Baraja a Descarte",
            "2. Mover de Descarte a Palo",
            "3. Mover de Descarte a Columna",
            "4. Mover de Palo a Columna",
            "5. Mover de Columna a Palo",
            "6. Mover de Columna a Columna",
            "7. Dar vuelta a carta de Columna",
            "8. Dar vuelta a Descarte en Baraja",
            "9. Salir"
    };

    public Menu() {
        mensaje = new Mensajes();
        scanner = new Scanner(System.in);
    }

    public void mostrarOpciones() {
        mensaje.mostrarMensajeLn("OPCIONES -->");
        for (int i = 0; i < opciones.length; i++) {
            mensaje.mostrarMensajeLn("  " + opciones[i]);
        }
    }

    public boolean elegirOpcion(Tablero tablero) {
        int opcion = scanner.nextInt();
        if (opcion == 1) {
            tablero.moverBarajaADescarte();
        } else if (opcion == 2) {
            tablero.moverDescarteAPalo();
        } else if (opcion == 3) {
            tablero.moverDescarteAColumna();
        } else if (opcion == 4) {
            tablero.moverPaloAColumna();
        } else if (opcion == 5) {
            tablero.moverColumnaAPalo();
        } else if (opcion == 6) {
            tablero.moverColumnaAColumna();
        } else if (opcion == 7) {
            tablero.darVueltaCartaColumna();
        } else if (opcion == 8) {
            tablero.darVueltaDescarteEnBaraja();
        } else if (opcion == 9) {
            mensaje.mostrarMensajeLn("Gracias por jugar TIO!!!");
            return false;
        } else {
            mensaje.mostrarMensajeLn("Opcion no valida.");
        }
        return true;
    }
}