public class Tablero {
    private Baraja baraja;
    private Descarte descarte;
    private Palo[] palos;
    private Columna[] columnas;

    public Tablero() {
        baraja = new Baraja();
        descarte = new Descarte();

        palos = new Palo[4];
        columnas = new Columna[7];

        int i;

        for (i = 0; i < 4; i++) {
            palos[i] = new Palo();
        }

        for (i = 0; i < 7; i++) {
            columnas[i] = new Columna();
        }

        repartirCartasIniciales();
    }

    private void repartirCartasIniciales() {
        int i;
        int j;

        for (i = 0; i < 7; i++) {
            for (j = 0; j <= i; j++) {
                Carta carta;
                carta = baraja.sacarCarta();
                columnas[i].agregarCarta(carta);
            }
            columnas[i].voltearUltimaCarta();
        }
    }

    public Baraja getBaraja() {
        return baraja;
    }

    public Descarte getDescarte() {
        return descarte;
    }

    public Palo[] getPalos() {
        return palos;
    }

    public Columna[] getColumnas() {
        return columnas;
    }

    public void mostrarEstado() {
        System.out.println(baraja.mostrar());
        System.out.println(descarte.mostrar());

        int i;
        for (i = 0; i < palos.length; i++) {
            System.out.println((i + 1) + "º Palo: " + palos[i].mostrar());
        }

        for (i = 0; i < columnas.length; i++) {
            System.out.println("Columna [" + (i + 1) + "]: " + columnas[i].mostrar());
        }
    }
}
