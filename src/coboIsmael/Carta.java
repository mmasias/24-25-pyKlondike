package coboIsmael;

public class Carta {
    private String palo;
    private int valor;
    private boolean bocaArriba;

    public Carta(String palo, int valor, boolean bocaArriba) {
        this.palo = palo;
        this.valor = valor;
        this.bocaArriba = bocaArriba;
    }

    public String getPalo() {
        return palo;
    }

    public int getValor() {
        return valor;
    }

    public boolean estaBocaArriba() {
        return bocaArriba;
    }

    public void voltear() {
        bocaArriba = !bocaArriba;
    }

    public boolean esRojo() {
        String nombre = palo.toLowerCase();
        return nombre.contains("corazones") || nombre.contains("diamantes");
    }

    @Override
    public String toString() {
        if (!bocaArriba) {
            return "[X]";
        }
        String simbolo;
        if (valor == 1) simbolo = "A";
        else if (valor == 11) simbolo = "J";
        else if (valor == 12) simbolo = "Q";
        else if (valor == 13) simbolo = "K";
        else simbolo = String.valueOf(valor);
        char inicialPalo = palo.charAt(0);
        return "[" + simbolo + inicialPalo + "]";
    }
}