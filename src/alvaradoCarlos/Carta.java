package src.alvaradoCarlos;

public class Carta {

    private int valor;
    private Palo palo;
    private boolean descubierta;

    public Carta(int valor, Palo palo) {
        this.valor = valor;
        this.palo = palo;
        this.descubierta = false;
    }

    public int valor() {
        return valor;
    }

    public Palo palo() {
        return palo;
    }

    public void voltear() {
        descubierta = true;
    }

    public boolean estaDescubierta() {
        return descubierta;
    }

    public String toString() {

        if (!descubierta) {
            return "[? ?]";
        }

        if (valor == 1) {
            return "[A " + palo + "]";
        } else if (valor == 11) {
            return "[J " + palo + "]";
        } else if (valor == 12) {
            return "[Q " + palo + "]";
        } else if (valor == 13) {
            return "[K " + palo + "]";
        } else {
            return "[" + valor + " " + palo + "]";
        }
    }

}
