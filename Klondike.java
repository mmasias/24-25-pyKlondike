
public class Klondike {

    private Baraja baraja;
    private Palo[] palos;
    private Descarte descarte;
    private Columna[] columnas;

    private final int NUMERO_PALOS = 4;
    private final int NUMERO_COLUMNAS = 7;

    public Klondike() {
        baraja = new Baraja();
        descarte = new Descarte();
        palos = new Palo[NUMERO_PALOS];
        for (int palo = 0; palo < NUMERO_PALOS; palo++) {
            palos[palo] = new Palo();
        }
        columnas = new Columna[NUMERO_COLUMNAS];
        for (int columna = 0; columna < NUMERO_COLUMNAS; columna++) {
            columnas[columna] = new Columna(columna + 1, baraja);
        }
    }

    public void jugar() {
        boolean estaJugando = true;
        while (estaJugando) {
            Menu menu = new Menu();
            menu.imprimeOpciones();
            mostrarTapete();
            int opcionUsuario = menu.getOpcion();

            switch(opcionUsuario) {
                case 1 -> baraja.moverA(descarte);
                case 2 -> descarte.moverA(escogerPalo("A"));
                case 3 -> descarte.moverA(escogerColumna("A"));
                case 4 -> escogerPalo("De").moverA(escogerColumna("A"));
                case 5 -> escogerColumna("De").moverA(escogerPalo("A"));
                case 6 -> escogerColumna("De").moverA(escogerColumna("A"));
                case 7 -> escogerColumna("De").voltear();
                case 8 -> descarte.voltear(baraja);
                case 9 -> estaJugando = !estaJugando;
            }
        }
    }

    private Palo escogerPalo(String prefijo) {
        int indicePalo = escogerOpcion(prefijo, NUMERO_PALOS, "que palo?");
        return palos[indicePalo - 1];
    }

    private Columna escogerColumna(String prefijo) {
        int indiceColumna = escogerOpcion(prefijo, NUMERO_COLUMNAS, "que columna?");
        return columnas[indiceColumna - 1];
    }

    private int escogerOpcion(String prefijo, int max, String mensaje) {
        Console console = new Console();
        return console.readInt(prefijo + " " + mensaje + "[1-" + max + "]");
    }

    private void mostrarTapete() {
        Console console = new Console();
        baraja.mostrar();
        descarte.mostrar();
        for (int palo = 0; palo < NUMERO_PALOS; palo++) {
            console.write("Palo " + palo);
            palos[palo].mostrar();
        }
        for (int columna = 0; columna < NUMERO_PALOS; columna++) {
            console.write("Columna " + columna);
            columnas[columna].mostrar();
        }
    }
}
