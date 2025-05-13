package Filothjose;

public class Solitario {
    private final Tablero tablero;
    private final Baraja baraja;
    private final Descarte descarte;
    private final Palo[] palos;
    private final Columna[] columnas;
    private final Menu menu;
    private final Mensajes mensaje;
    private final int NUM_PALOS = 4;
    private final int NUM_COLUMNAS = 7;

    public Solitario() {
        baraja = new Baraja();
        tablero = new Tablero();
        descarte = new Descarte();
        menu = new Menu();
        palos = new Palo[NUM_PALOS];
        columnas = new Columna[NUM_COLUMNAS];

        for (int i = 0; i < NUM_PALOS; i++) {
            palos[i] = new Palo();
        }
        for (int i = 0; i < NUM_COLUMNAS; i++) {
            columnas[i] = new Columna();
        }

        mensaje = new Mensajes();
    }

    public void jugar() {
        boolean sigueJugando = true;
        mensaje.mostrarMensajeLn("BIENVENIDO AL SOLITARIO");
        System.out.println();

        tablero.repartirCartasIniciales();

        while (sigueJugando) {
            menu.mostrarOpciones();
            tablero.mostrar();
            mensaje.mostrarMensajeLn("Elige una opcion :");
            sigueJugando = menu.elegirOpcion(tablero);
        }
        mensaje.mostrarMensajeLn("Gracias por jugar.");
    }

}
