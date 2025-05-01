package doaltoBienvenido;

public class Carta {

    private String palo;
    private int valorCarta;
    private boolean cartaVisible;

    public Carta() {

    }

    public Carta(String palo, int valorCarta) {
        this.palo = palo;
        this.valorCarta = valorCarta;
        this.cartaVisible = false;
    }

    public String getEmojiPalo() {
        switch (palo) {
            case "Corazones":
                return "♥️";
            case "Diamantes":
                return "♦️";
            case "Treboles":
                return "♣️";
            case "Picas":
                return "♠️";
            default:
                return "?";
        }
    }

    public String getPalo() {
        return palo;
    }

    public int getValor() {
        return valorCarta;
    }

    public int getValorCarta() {
        return valorCarta;
    }

    public boolean esVisible() {
        return cartaVisible;
    }

    public void darVuelta() {
        cartaVisible = true;
    }

    public boolean puedeColocarSobre(Carta otraCarta) {
        if (otraCarta == null) {
            return false;
        }
        return (this.valorCarta == otraCarta.valorCarta - 1);
    }

    public String toString() {
        if (!cartaVisible) {
            return "[? ?]";
        }

        String valorCartaAlta;

        if (valorCarta == 1) {
            valorCartaAlta = "A";
        } else if (valorCarta == 11) {
            valorCartaAlta = "J";
        } else if (valorCarta == 12) {
            valorCartaAlta = "Q";
        } else if (valorCarta == 13) {
            valorCartaAlta = "K";
        } else {
            valorCartaAlta = String.valueOf(valorCarta);
        }

        return "[" + valorCartaAlta + " " + getEmojiPalo() + "]";
    }
}