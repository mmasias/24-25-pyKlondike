package scr.calderonJimena;

public class Carta {
    private final Palo palo;
    private final int valor;
    private boolean visible;

    public Carta(Palo palo, int valor) {
        this.palo = palo;
        this.valor = valor;
        this.visible = false;
    }

    public Palo getPalo() {
        return palo;
    }

    public int getValor() {
        return valor;
    }

    public boolean esVisible() {
        return visible;
    }

    public void voltear() {
        visible = !visible;
    }

    @Override
    public String toString() {
        if (!visible) return "[? ?]";
        String[] nombres = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
        return "[" + nombres[valor - 1] + " " + palo.simbolo() + "]";
    }
}

