public class Columna {
    private static final int MAX = 52;
    private Carta[] cartas = new Carta[MAX];
    private int cantidad = 0;

    public void agregar(Carta carta) {
        if (cantidad < MAX) {
            cartas[cantidad] = carta;
            cantidad++;
        }
    }

    public String toString() {
        if (cantidad == 0) return "";
        String texto = "";
        for (int i = 0; i < cantidad; i++) {
            texto += cartas[i];
        }
        return texto;
    }
}