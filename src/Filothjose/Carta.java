package Filothjose;

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
        String paloMayus = palo.toUpperCase();

        if (paloMayus.equals("PICAS")) {
            return "P";
        } else if (paloMayus.equals("CORAZONES")) {
            return "C";
        } else if (paloMayus.equals("DIAMANTES")) {
            return "D";
        } else if (paloMayus.equals("TREBOLES")) {
            return "T";
        } else {
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