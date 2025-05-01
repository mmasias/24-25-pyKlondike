package Filothjose;

public class Descarte {

    private final Carta[] cartas;
    private int cantidad;
    private final int CARTAS_TOTALES = 52;

    public Descarte() {
        cartas = new Carta[CARTAS_TOTALES];
        cantidad = 0;
    }

    public void agregarCarta(Carta carta) {
        if (cantidad < cartas.length) {
            carta.darVuelta(); 
            cartas[cantidad++] = carta;
        }
    }

    public Carta sacarCarta() {
        if (cantidad > 0) {
            return cartas[--cantidad];
        }
        return null;
    }

    public boolean tieneCartas() {
        return cantidad > 0;
    }

    public String toString() {
        String resultado = "";

        for (int i = 0; i < cantidad; i++) {
            resultado += cartas[i].toString();
        }
        return resultado;
    }
}