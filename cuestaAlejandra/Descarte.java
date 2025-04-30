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