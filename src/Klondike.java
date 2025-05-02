
public class Klondike {

    private Baraja baraja;
    private Palo[] palos;
    private Descarte descarte;
    private Columna[] columnas;

    private final int NUMERO_PALOS = 4;
    private final int NUMERO_COLUMNAS = 7;

    public Klondike() {
        this.baraja = new Baraja();
        this.descarte = new Descarte();
        this.palos = new Palo[NUMERO_PALOS];
        for (int palo = 0; palo < NUMERO_PALOS; palo++) {
            this.palos[palo] = new Palo();
        }
        this.columnas = new Columna[NUMERO_COLUMNAS];
        for (int columna = 0; columna < NUMERO_COLUMNAS; columna++) {
            this.columnas[columna] = new Columna(columna + 1, baraja);
        }
    }

    public void jugar() {
        Utilidades utilidades = new Utilidades();
        boolean estaJugando = true;
        do {
            Menu menu = new Menu();
            menu.imprimirOpciones();
            imprimirTapete(utilidades);
            int opcion = menu.getOpcion();
            switch (opcion) {
                case 1 -> baraja.moverCarta(descarte);
                case 2 -> descarte.moverCarta(escogerPalo("A"));
                case 3 -> descarte.moverCarta(escogerColumna("A"));
                case 4 -> escogerPalo("De").moverCarta(escogerColumna("A"));
                case 5 -> escogerColumna("De").moverCarta(escogerPalo("A"));
                case 6 -> escogerColumna("De").moverCarta(escogerColumna("A"));
                case 7 -> escogerColumna("Voltear").voltear();
                case 8 -> descarte.voltear(baraja);
                case 9 -> estaJugando = false;
                default -> utilidades.imprimirln("Opción no válida. Intente de nuevo.");
            }
        } while (estaJugando);
    }

    private Columna escogerColumna(String prefijo) {
        return columnas[preguntarOpcion(prefijo, NUMERO_COLUMNAS, "qué columna?")];
    }

    private int preguntarOpcion(String prefijo, int max, String mensaje) {
        Utilidades utilidades = new Utilidades();
        return utilidades.preguntarInt(prefijo + " " + mensaje + " [1-" + max + "]: ", new int[] { 1, max }) - 1;
    }

    private Palo escogerPalo(String prefijo) {
        return palos[preguntarOpcion(prefijo, NUMERO_PALOS, "qué palo?")];
    }

    private void imprimirTapete(Utilidades utilidades) {
        baraja.imprimir();
        descarte.imprimir();
        for (int palo = 0; palo < NUMERO_PALOS; palo++) {
            utilidades.imprimir((palo + 1) + "º Palo: ");
            palos[palo].imprimir();
        }
        for (int columna = 0; columna < NUMERO_COLUMNAS; columna++) {
            utilidades.imprimir("Columna [" + (columna + 1) + "]: ");
            columnas[columna].imprimir();
        }
    }

}
