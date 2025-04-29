package doaltoBienvenido;


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

    public Solitario() {
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
        
    }


    public void jugar() {
        mensaje.mostrarMensajeLn("BIENVENIDO AL SOLITARIO");
        System.out.println();

        menu.mostrarOpciones();
        tapete.mostrar();

        mensaje.mostrarMensajeLn("Elige una Opcion");
        menu.elegirOpcion();
    }
}