public class Descarte {
    private Carta[] cartas;
    private int cantidad;

    public Descarte() {
        cartas = new Carta[52];
        cantidad = 0;
    }

    public void agregarCarta(Carta nuevaCarta) {
        nuevaCarta.voltear();
        cartas[cantidad] = nuevaCarta;
        cantidad = cantidad + 1;
    }

    public Carta obtenerUltimaCarta() {
        Carta carta;
        carta = null;
        if (cantidad > 0) {
            carta = cartas[cantidad - 1];
        }
        return carta;
    }

    public Carta sacarUltimaCarta() {
        Carta carta;
        carta = null;
        if (cantidad > 0) {
            carta = cartas[cantidad - 1];
            cantidad = cantidad - 1;
        }
        return carta;
    }

    public boolean estaVacia() {
        return cantidad == 0;
    }

    public String mostrar() {
        String texto;
        texto = "Descarte: ";
        int i;
        for (i = 0; i < cantidad; i++) {
            texto = texto + cartas[i].mostrar();
        }
        return texto;
    }
}
