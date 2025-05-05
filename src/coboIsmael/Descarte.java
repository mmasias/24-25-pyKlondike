package coboIsmael;

public class Descarte {
    private Carta[] cartas;
    private int cantidadCartas;

    public Descarte() {
        cartas = new Carta[52];
        cantidadCartas = 0;
    }

    public boolean estaVacia() {
        return cantidadCartas == 0;
    }

    public Carta verCartaSuperior() {
        if (cantidadCartas == 0) {
            return null;
        }
        return cartas[cantidadCartas - 1];
    }

    public Carta sacarCarta() {
        if (cantidadCartas == 0) {
            return null;
        }
        return cartas[--cantidadCartas];
    }

    public void agregarCarta(Carta cartaNueva) {
        if (cantidadCartas < cartas.length) {
            cartas[cantidadCartas++] = cartaNueva;
        }
    }
}