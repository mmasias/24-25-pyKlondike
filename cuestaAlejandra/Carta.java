public class Carta {
    private String valor;
    private PaloCarta palo;
    private boolean visible;

    public Carta(String valor, PaloCarta palo, boolean visible) {
        this.valor = valor;
        this.palo = palo;
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public void voltear() {
        this.visible = true;
    }

    public String getValor() {
        return valor;
    }

    public PaloCarta getPalo() {
        return palo;
    }

    public String toString() {
        return visible ? "[" + valor + " " + palo.getSimbolo() + "]" : "[? ?]";
    }
}