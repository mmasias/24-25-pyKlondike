package scr.calderonJimena;

public class Klondike {
    private final Baraja baraja = new Baraja();
    private final Descarte descarte = new Descarte();
    public final Columna[] columnas = new Columna[7];

    public Klondike() {
        for (int i = 0; i < 7; i++) {
            columnas[i] = new Columna();
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j <= i; j++) {
                Carta carta = baraja.sacarCarta();
                columnas[i].agregar(carta);
            }
            columnas[i].voltearUltima();
        }
    }

    public void robar() {
        if (!baraja.estaVacia()) {
            Carta carta = baraja.sacarCarta();
            descarte.agregar(carta);
        } else {
            System.out.println("Baraja vacía.");
        }
    }

    public void mostrarEstado() {
        System.out.print("BARAJA: ");
        System.out.println(baraja.estaVacia() ? "[Vacía]" : "[? ?]");

        System.out.print("Descarte: ");
        descarte.mostrar();

        System.out.println();
        for (int i = 0; i < 4; i++) {
            System.out.print((i + 1) + "º Palo: ");
            System.out.println("No hay cartas en el palo");
        }

        System.out.println();
        for (int i = 0; i < columnas.length; i++) {
            System.out.print("Columna [" + (i + 1) + "]: ");
            columnas[i].mostrar();
        }
    }
}

