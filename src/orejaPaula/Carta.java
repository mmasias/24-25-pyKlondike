public class Carta {
    public static final int VALOR_MINIMO = 1;
    public static final int VALOR_MAXIMO = 13;

    public enum Palo { CORAZONES, DIAMANTES, TREBOLES, PICAS }

    private Palo palo;
    private int valor;
    private boolean estaBocaArriba;

    public Carta(Palo palo, int valor) {
        this.palo = palo;
        this.valor = valor;
        this.estaBocaArriba = false;
    }

    public Palo getPalo() {
        return palo;
    }

    public int getValor() {
        return valor;
    }

    public boolean estaBocaArriba() {
        return estaBocaArriba;
    }

    public void voltear() {
        estaBocaArriba = !estaBocaArriba;
    }

    public boolean esRoja() {
        return palo == Palo.CORAZONES || palo == Palo.DIAMANTES;
    }

    @Override
    public String toString() {
        if (!estaBocaArriba) return "[? ?]";
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String simbolo = switch (palo) {
            case CORAZONES -> "corazon";
            case DIAMANTES -> "diamante";
            case TREBOLES -> "trebol";
            case PICAS -> "pica";
        };
        return "[" + valores[valor - 1] + " " + simbolo + "]";
    }
}
