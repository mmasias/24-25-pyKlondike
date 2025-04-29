package doaltoBienvenido;

import java.util.Scanner;


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
        columnas = new Columna[NUM_COLUMNAS];

        for (int i = 0; i < NUM_PALOS; i++) {
            palos[i] = new Palo();
        }
        for (int i = 0; i < NUM_COLUMNAS; i++) {
            columnas[i] = new Columna();
        }

        mensaje = new Mensajes();
        iniciarTablero();
    }

    private void iniciarTablero() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iniciarTablero'");
    }

    public void jugar() {
        mensaje.mostrarMensaje("BIENVENIDO AL SOLITARIO");
        System.out.println();

    }
}