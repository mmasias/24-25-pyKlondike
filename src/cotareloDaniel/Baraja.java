public class Baraja {
    private Carta[] cartas;
    private int cantidad;

    public Baraja() {
        cartas = new Carta[52];
        cantidad = 0;

        String[] palos;
        String[] valores;
        palos = new String[4];
        valores = new String[13];

        palos[0] = "corazones";
        palos[1] = "diamantes";
        palos[2] = "treboles";
        palos[3] = "picas";

        valores[0] = "A";
        valores[1] = "2";
        valores[2] = "3";
        valores[3] = "4";
        valores[4] = "5";
        valores[5] = "6";
        valores[6] = "7";
        valores[7] = "8";
        valores[8] = "9";
        valores[9] = "10";
        valores[10] = "J";
        valores[11] = "Q";
        valores[12] = "K";

        int indice;
        indice = 0;

        int i;
        int j;

        for (i = 0; i < 4; i++) {
            for (j = 0; j < 13; j++) {
                Carta nuevaCarta;
                nuevaCarta = new Carta(valores[j], palos[i]);
                cartas[indice] = nuevaCarta;
                indice = indice + 1;
            }
        }

        cantidad = 52;
    }

    public Carta sacarCarta() {
        Carta cartaSacada;
        cartaSacada = null;

        if (cantidad > 0) {
            cartaSacada = cartas[cantidad - 1];
            cantidad = cantidad - 1;
        }

        return cartaSacada;
    }

    public boolean estaVacia() {
        return cantidad == 0;
    }

    public String mostrar() {
        String texto;
        texto = "BARAJA: ";
        if (estaVacia()) {
            texto = texto + "No hay cartas en la baraja";
        } else {
            texto = texto + "[? ?]";
        }
        return texto;
    }
}
