public class Carta {
    private String valor;
    private String palo;
    private boolean visible;

    public Carta(String valorCarta, String paloCarta) {
        valor = valorCarta;
        palo = paloCarta;
        visible = false;
    }

    public String obtenerValor() {
        return valor;
    }

    public String obtenerPalo() {
        return palo;
    }

    public boolean estaVisible() {
        return visible;
    }

    public void voltear() {
        visible = true;
    }

    public String mostrar() {
        String texto;
        if (visible) {
            texto = "[" + valor + " " + palo + "]";
        } else {
            texto = "[? ?]";
        }
        return texto;
    }
}
