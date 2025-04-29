package doaltoBienvenido;

import java.util.Scanner;

import javafx.scene.control.Menu;

public class Solitario {
    private Tapete tapete;
    private Baraja baraja;
    private Descarte descarte;
    private Palo[] palos;
    private Columna[] columnas;
    private Menu menu;
    private Mensajes mensaje;
    private final int NUM_PALOS = 4;
    private final int NUM_COLUMNAS = 7;
    private Scanner scanner;
    private final int NUM_OPCIONES = 9;

    public Solitario() {
        scanner = new Scanner(System.in);
        baraja = new Baraja();
        tapete = new Tapete();
        descarte = new Descarte();
        menu = new Menu();
        palos = new Palo[NUM_PALOS];
        columnas = new Columnas[NUM_COLUMNAS];

        for (int i = 0; i < NUM_PALOS; i++) {
            palos[i] = new Palo();
        }
        for (int i = 0; i < NUM_COLUMNAS; i++) {
            columnas[i] = new Columna();
        }

        mensaje = new Mensajes();
        iniciarTablero();
    }

    public void jugar() {
        mensaje.mostrarMensaje("BIENVENIDO AL SOLITARIO");
        System.out.println();

        int opcion = 0;

        while (opcion != NUM_OPCIONES) {
            menu.mostrarOpciones();
            menu.mostrarEstado(baraja, descarte, palos, columnas);
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    if (!baraja.estaVacia()) {
                        Carta cartaSacada = baraja.sacar();
                        cartaSacada.setVisible(true);
                        descarte.agregar(cartaSacada);
                    } else {
                        mensaje.mostrarMensaje("La baraja esta vacia.");
                    }

                case 2:
                    if (!descarte.estaVacio()) {
                        mensaje.mostrarMensaje("¿A que palo quieres mover la carta? [1-4]: ");
                        int paloDestino = scanner.nextInt() - 1;
                        if (paloDestino >= 0 && paloDestino < 4) {
                            palos[paloDestino].agregar(descarte.sacarUltima());
                        }
                    }

                case 3:
                    if (!descarte.estaVacio()) {
                        mensaje.mostrarMensaje("¿A que columna quieres mover la carta? [1-7]: ");
                        int columnaDestino = scanner.nextInt() - 1;
                        if (columnaDestino >= 0 && columnaDestino < 7) {
                            columnas[columnaDestino].agregar(descarte.sacarUltima());
                        }
                    }

                case 4:
                    mensaje.mostrarMensaje("¿De que palo quieres mover la carta? [1-4]: ");
                    int paloOrigen = scanner.nextInt() - 1;
                    mensaje.mostrarMensaje("¿A que columna quieres mover la carta? [1-7]: ");
                    int columnaDestinoDePalo = scanner.nextInt() - 1;
                    if (!palos[paloOrigen].estaVacio()) {
                        columnas[columnaDestinoDePalo].agregar(palos[paloOrigen].sacarUltima());
                    }

                case 5:
                    mensaje.mostrarMensaje("¿De que columna quieres mover la carta? [1-7]: ");
                    int columnaOrigen = scanner.nextInt() - 1;
                    mensaje.mostrarMensaje("¿A que palo quieres mover la carta? [1-4]: ");
                    int paloDestinoColumna = scanner.nextInt() - 1;
                    if (!columnas[columnaOrigen].estaVacia()) {
                        palos[paloDestinoColumna].agregar(columnas[columnaOrigen].sacarUltima());
                    }

                case 6:
                    mensaje.mostrarMensaje("¿De que columna quieres mover la carta? [1-7]: ");
                    int columnaOrigen2 = scanner.nextInt() - 1;
                    mensaje.mostrarMensaje("¿A que columna quieres mover la carta? [1-7]: ");
                    int columnaDestino2 = scanner.nextInt() - 1;
                    if (!columnas[columnaOrigen2].estaVacia()) {
                        columnas[columnaDestino2].agregar(columnas[columnaOrigen2].sacarUltima());
                    }

                case 7:
                    mensaje.mostrarMensaje("¿Qué columna quieres voltear? [1-7]: ");
                    int columnaVoltear = scanner.nextInt() - 1;
                    columnas[columnaVoltear].voltearUltima();

                case 8:
                    baraja.volverDesde(descarte);
                    mensaje.mostrarMensaje("Cartas del descarte de vuelta en la baraja.");

                case 9:
                    mensaje.mostrarMensaje("Gracias por jugar.");

                default:
                    mensaje.mostrarMensaje("Opción no valida.");
            }

        }

    }

    private void iniciarTablero() {
        baraja.generarBaraja();

        for (int i = 0; i < NUM_COLUMNAS; i++) {
            for (int j = 0; j <= i; j++) {
                Carta cartaExtraida = baraja.sacarBaraja();
                cartaExtraida.setVisibilidad(j == i);
                columnas[i].agregar(cartaExtraida);
            }
        }
    }

}
