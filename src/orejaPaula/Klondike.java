
public class Klondike {
    private static final int NUMERO_DE_PALOS = 4;
    private static final int NUMERO_DE_COLUMNAS = 7;

    private Baraja baraja;
    private Descarte descarte;
    private Palo[] palos;
    private Columna[] columnas;
    private Menu menu;

    public Klondike() {
        baraja = new Baraja();
        descarte = new Descarte();
        palos = new Palo[NUMERO_DE_PALOS];
        columnas = new Columna[NUMERO_DE_COLUMNAS];
        menu = new Menu();

        for (int indice = 0; indice < NUMERO_DE_PALOS; indice++)
            palos[indice] = new Palo(Carta.Palo.values()[indice]);

        for (int indice = 0; indice < NUMERO_DE_COLUMNAS; indice++)
            columnas[indice] = new Columna();

        repartirCartas();
    }

    private void repartirCartas() {
        for (int columnaActual = 0; columnaActual < NUMERO_DE_COLUMNAS; columnaActual++) {
            for (int cartaActual = 0; cartaActual <= columnaActual; cartaActual++) {
                Carta carta = baraja.sacarCarta();
                if (cartaActual == columnaActual) carta.voltear();
                columnas[columnaActual].agregarCarta(carta);
            }
        }
    }

    private void mostrarEstado() {
        System.out.println("\nBARAJA: " + (baraja.cantidadDeCartas() > 0 ? "[? ?]" : "Vacía"));
        System.out.print("Descarte: ");
        for (Carta carta : descarte.verCartas()) System.out.print(carta + " ");
        System.out.println();
        for (int indice = 0; indice < NUMERO_DE_PALOS; indice++)
            System.out.println((indice + 1) + "º Palo: " + palos[indice]);
        for (int indice = 0; indice < NUMERO_DE_COLUMNAS; indice++)
            System.out.println("Columna [" + (indice + 1) + "]: " + columnas[indice].getCartas());
    }

    public void jugar() {
        int opcion;
        do {
            mostrarEstado();
            menu.mostrarOpciones();
            opcion = menu.pedirOpcion();
            switch (opcion) {
                case 1 -> moverBarajaADescarte();
                case 2 -> moverDescarteAPalo();
                case 3 -> moverDescarteAColumna();
                case 4 -> moverPaloAColumna();
                case 5 -> moverColumnaAPalo();
                case 6 -> moverColumnaAColumna();
                case 7 -> voltearColumna();
                case 8 -> baraja.agregarCartas(descarte.vaciar());
            }
        } while (opcion != 9);
    }

    private void moverBarajaADescarte() {
        Carta carta = baraja.sacarCarta();
        if (carta != null) descarte.agregar(carta);
    }

    private void moverDescarteAColumna() {
        int numeroColumna = menu.pedirNumero("¿A qué columna?", 1, NUMERO_DE_COLUMNAS) - 1;
        if (!descarte.estaVacio() && columnas[numeroColumna].puedeAgregar(descarte.verTope()))
            columnas[numeroColumna].agregarCarta(descarte.sacar());
    }

    private void moverDescarteAPalo() {
        if (descarte.estaVacio()) return;
        Carta carta = descarte.verTope();
        for (Palo palo : palos) {
            if (palo.puedeAgregar(carta)) {
                palo.agregar(descarte.sacar());
                return;
            }
        }
    }

    private void moverPaloAColumna() {
        int numeroPalo = menu.pedirNumero("¿Desde qué palo?", 1, NUMERO_DE_PALOS) - 1;
        int numeroColumna = menu.pedirNumero("¿A qué columna?", 1, NUMERO_DE_COLUMNAS) - 1;
        if (!palos[numeroPalo].estaVacio()) {
            Carta carta = palos[numeroPalo].verTope();
            if (columnas[numeroColumna].puedeAgregar(carta)) {
                columnas[numeroColumna].agregarCarta(palos[numeroPalo].sacar());
            }
        }
    }

    private void moverColumnaAPalo() {
        int numeroColumna = menu.pedirNumero("¿Desde qué columna?", 1, NUMERO_DE_COLUMNAS) - 1;
        Carta carta = columnas[numeroColumna].verTope();
        for (Palo palo : palos) {
            if (palo.puedeAgregar(carta)) {
                palo.agregar(columnas[numeroColumna].sacarCarta());
                columnas[numeroColumna].voltearTope();
                return;
            }
        }
    }

    private void moverColumnaAColumna() {
        int columnaOrigen = menu.pedirNumero("¿Desde qué columna?", 1, NUMERO_DE_COLUMNAS) - 1;
        int columnaDestino = menu.pedirNumero("¿A qué columna?", 1, NUMERO_DE_COLUMNAS) - 1;
        Carta carta = columnas[columnaOrigen].verTope();
        if (columnas[columnaDestino].puedeAgregar(carta)) {
            columnas[columnaDestino].agregarCarta(columnas[columnaOrigen].sacarCarta());
            columnas[columnaOrigen].voltearTope();
        }
    }

    private void voltearColumna() {
        int numeroColumna = menu.pedirNumero("¿Qué columna?", 1, NUMERO_DE_COLUMNAS) - 1;
        columnas[numeroColumna].voltearTope();
    }

    public static void main(String[] args) {
        new Klondike().jugar();
    }
}
