package doaltoBienvenido;

public class Descarte {

    private Carta[] cartas;
    private int indiceCarta;
    private final int CARTAS_TOTALES = 52;

    public Descarte() {
        cartas = new Carta[CARTAS_TOTALES];
        indiceCarta = 0;
    }

    public void agregarCarta(Carta carta) {
        if (indiceCarta < cartas.length) {
            carta.darVuelta(); 
            cartas[indiceCarta++] = carta;
        }
    }

    public Carta sacarCarta() {
        if (indiceCarta > 0) {
            return cartas[--indiceCarta];
        }
        return null;
    }

    public String toString() {
        String resultado = "";
        
        for (int i = 0; i < indiceCarta; i++) {
            resultado += cartas[i].toString();
        }
        return resultado;
    }
}
