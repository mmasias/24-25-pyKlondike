public class Palo {
    private static final int MAX = 13;
    private Carta[] cartas = new Carta[MAX];
    private int cantidad = 0;

    public void agregar(Carta carta) {
        if (cantidad < MAX) {
            cartas[cantidad] = carta;
            cantidad++;
        }
    }

    public String toString() {
        if (cantidad == 0) {
            return "No hay cartas en el palo";
        }
        return cartas[cantidad - 1].toString();
    }
}