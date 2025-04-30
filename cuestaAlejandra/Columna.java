public class Columna {
    private static final int MAX = 20;
    private Carta[] cartas = new Carta[MAX];
    private int cantidad = 0;

    public void agregar(Carta carta) {
        if (cantidad < MAX) {
            cartas[cantidad] = carta;
            cantidad++;
        }
    }

    public String toString() {
        String resultado = "";
        for (int i = 0; i < cantidad; i++) {
            resultado = resultado + cartas[i].toString();
        }
        return resultado;
    }
}