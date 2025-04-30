package doaltoBienvenido;

import java.util.Scanner;

public class Menu {

    private Mensajes mensaje;
    private Scanner scanner;

    private String[] opciones = {
            "1. Mover de Baraja a Descarte",
            "2. Mover de Descarte a Palo",
            "3. Mover de Descarte a Columna",
            "4. Mover de Palo a Columna",
            "5. Mover de Columna a Palo",
            "6. Mover de Columna a Columna",
            "7. Voltear carta de Columna",
            "8. Voltear Descarte en Baraja",
            "9. Salir"
    };

    private final int MIN_OPCIONES = 1;
    private final int MAX_OPCIONES = 9;

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

    public int elegirOpcion() {
        mensaje.mostrarMensajeLn("Elije una opción (1-9): ");
        int respuestaOpcion = scanner.nextInt();

        while (respuestaOpcion < MIN_OPCIONES || respuestaOpcion > MAX_OPCIONES) {
            mensaje.mostrarMensajeLn("Opción inválida. Intente de nuevo.");
            mensaje.mostrarMensajeLn("Elije una opción (1-9): ");
            respuestaOpcion = scanner.nextInt();
        }
        return respuestaOpcion;
    }
}