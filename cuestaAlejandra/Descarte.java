public class Descarte {
    private static final int MAX_DESCARTE = 52;
    private Carta[] cartas = new Carta[MAX_DESCARTE];
    private int cantidad = 0;

    public void agregar(Carta carta) {
        if (cantidad < MAX_DESCARTE) {
            cartas[cantidad] = carta;
            cantidad++;
        }
    }

    public boolean estaVacio() {
        return cantidad == 0;
    }

    public Carta quitarUltima() {
        if (!estaVacio()) {
            cantidad--;
            return cartas[cantidad];
        }
        return null;
    }

    public String toString() {
        String resultado = "";
        for (int i = 0; i < cantidad; i++) {
            resultado = resultado + cartas[i].toString();
        }
        return resultado;
    }
}