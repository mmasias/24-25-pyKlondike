public class Carta {
    public enum Palo { CORAZONES, DIAMANTES, TREBOLES, PICAS }

    private Palo palo;
    private int valor;
    private boolean bocaArriba;

    public Carta(Palo palo, int valor) {
        this.palo = palo;
        this.valor = valor;
        this.bocaArriba = false;
    }

    public Palo getPalo() {
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

    public boolean esRoja() {
        return palo == Palo.CORAZONES || palo == Palo.DIAMANTES;
    }

    @Override
    public String toString() {
        if (!bocaArriba) return "[? ?]";
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String simbolo = switch (palo) {
            case CORAZONES -> "♥️";
            case DIAMANTES -> "♦️";
            case TREBOLES -> "♣️";
            case PICAS -> "♠️";
        };
        return "[" + valores[valor - 1] + " " + simbolo + "]";
    }
}

