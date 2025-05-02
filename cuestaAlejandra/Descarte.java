public class Descarte {
    private static final int MAX = 52;
    private Carta[] cartas = new Carta[MAX];
    private int cantidad = 0;

    public void agregar(Carta carta) {
        if (cantidad < MAX) {
            cartas[cantidad] = carta;
            cantidad++;
        }
    }

    public Carta quitarUltima() {
        if (cantidad == 0) return null;
        Carta carta = cartas[cantidad - 1];
        cartas[cantidad - 1] = null;
        cantidad--;
        return carta;
    }

    public boolean estaVacio() {
        return cantidad == 0;
    }

    public String toString() {
        if (cantidad == 0) return "Vacía";
        String texto = "";
        for (int i = 0; i < cantidad; i++) {
            texto += cartas[i];
        }
        return texto;
    }
}
