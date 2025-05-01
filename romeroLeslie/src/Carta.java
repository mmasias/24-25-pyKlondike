public class Carta {
    private final String valor;
    private final String palo;
    private boolean visible;

    public Carta(String valor, String palo) {
      
        this.valor = valor.isEmpty() ? "?" : valor;
        this.palo = palo.isEmpty() ? "?" : palo;
        this.visible = false;
    }

    public void voltear() {
        visible = !visible;
    }

    public boolean esVisible() {
        return visible;
    }

    public String getValor() {
        return valor;
    }

    public String getPalo() {
        return palo;
    }

    @Override
    public String toString() {
        return visible ? "[" + valor + " " + palo + "]" : "[? ?]";
    }
}
