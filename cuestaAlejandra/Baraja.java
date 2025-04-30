public class Baraja {
    private static final int MAX_CARTAS = 52;
    private Carta[] cartas = new Carta[MAX_CARTAS];
    private int cantidad = 0;

    public void agregar(Carta carta) {
        if (cantidad < MAX_CARTAS) {
            cartas[cantidad] = carta;
            cantidad++;
        }
    }

    public boolean estaVacia() {
        return cantidad == 0;
    }

    public void voltear(Descarte descarte) {
        if (!estaVacia()) {
            cantidad--;
            Carta carta = cartas[cantidad];
            carta.voltear();
            descarte.agregar(carta);
        } else {
            System.out.println("Baraja vacía.");
        }
    }