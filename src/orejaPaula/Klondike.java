
public class Klondike {
    private Baraja baraja;
    private Descarte descarte;
    private Palo[] palos;
    private Columna[] columnas;
    private Menu menu;

    public Klondike() {
        baraja = new Baraja();
        descarte = new Descarte();
        palos = new Palo[4];
        columnas = new Columna[7];
        menu = new Menu();

        for (int i = 0; i < 4; i++) palos[i] = new Palo(Carta.Palo.values()[i]);
        for (int i = 0; i < 7; i++) columnas[i] = new Columna();

        repartirCartas();
    }

    private void repartirCartas() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j <= i; j++) {
                Carta carta = baraja.sacarCarta();
                if (j == i) carta.voltear();
                columnas[i].agregarCarta(carta);
            }
        }
    }

    private void mostrarEstado() {
        System.out.println("\nBARAJA: " + (baraja.cantidad() > 0 ? "[? ?]" : "Vacía"));
        System.out.print("Descarte: ");
        for (Carta c : descarte.verCartas()) System.out.print(c + " ");
        System.out.println();
        for (int i = 0; i < 4; i++)
            System.out.println((i + 1) + "º Palo: " + palos[i]);
        for (int i = 0; i < 7; i++)
            System.out.println("Columna [" + (i + 1) + "]: " + columnas[i].getCartas());
    }

    public void jugar() {
        int opcion = 0;
        do {
            mostrarEstado();
            menu.mostrarOpciones();
            opcion = menu.pedirOpcion();
            switch (opcion) {
                case 1 -> {
                    Carta c = baraja.sacarCarta();
                    if (c != null) descarte.agregar(c);
                }
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

    private void moverDescarteAColumna() {
        int col = menu.pedirNumero("¿A qué columna?", 1, 7) - 1;
        if (!descarte.estaVacio() && columnas[col].puedeAgregar(descarte.verTope()))
            columnas[col].agregarCarta(descarte.sacar());
    }

    private void moverDescarteAPalo() {
        if (descarte.estaVacio()) return;
        Carta c = descarte.verTope();
        for (Palo p : palos) {
            if (p.puedeAgregar(c)) {
                p.agregar(descarte.sacar());
                return;
            }
        }
    }

    private void moverPaloAColumna() {
        int p = menu.pedirNumero("¿Desde qué palo?", 1, 4) - 1;
        int c = menu.pedirNumero("¿A qué columna?", 1, 7) - 1;
        if (!palos[p].estaVacio()) {
            Carta carta = palos[p].verTope();
            if (columnas[c].puedeAgregar(carta)) {
                columnas[c].agregarCarta(palos[p].sacar());
            }
        }
    }

    private void moverColumnaAPalo() {
        int c = menu.pedirNumero("¿Desde qué columna?", 1, 7) - 1;
        Carta carta = columnas[c].verTope();
        for (Palo p : palos) {
            if (p.puedeAgregar(carta)) {
                p.agregar(columnas[c].sacarCarta());
                columnas[c].voltearTope();
                return;
            }
        }
    }

    private void moverColumnaAColumna() {
        int desde = menu.pedirNumero("¿Desde qué columna?", 1, 7) - 1;
        int hasta = menu.pedirNumero("¿A qué columna?", 1, 7) - 1;
        Carta carta = columnas[desde].verTope();
        if (columnas[hasta].puedeAgregar(carta)) {
            columnas[hasta].agregarCarta(columnas[desde].sacarCarta());
            columnas[desde].voltearTope();
        }
    }

    private void voltearColumna() {
        int c = menu.pedirNumero("¿Qué columna?", 1, 7) - 1;
        columnas[c].voltearTope();
    }

    public static void main(String[] args) {
        new Klondike().jugar();
    }
}
