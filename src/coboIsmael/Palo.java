package coboIsmael;

public class Palo {
    private String nombrePalo;
    private Carta[] cartas;
    private int cantidadCartas;

    public Palo(String nombrePalo) {
        this.nombrePalo = nombrePalo;
        cartas = new Carta[13];
        cantidadCartas = 0;
    }

    public String getNombrePalo() {
        return nombrePalo;
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

    public boolean colocarCarta(Carta cartaNueva) {
        if (!cartaNueva.getPalo().equalsIgnoreCase(nombrePalo)) {
            return false;
        }
        if (cantidadCartas == 0) {
            if (cartaNueva.getValor() == 1) {
                cartas[cantidadCartas++] = cartaNueva;
                return true;
            }
            return false;
        }
        Carta cartaSuperior = cartas[cantidadCartas - 1];
        if (cartaNueva.getValor() == cartaSuperior.getValor() + 1) {
            cartas[cantidadCartas++] = cartaNueva;
            return true;
        }
        return false;
    }
}