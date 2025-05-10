package scr.calderonJimena;

public class Baraja {
    private final Carta[] cartas = new Carta[52];
    private int tope = 0;

    public Baraja() {
        int index = 0;
        for (Palo palo : Palo.values()) {
            for (int i = 1; i <= 13; i++) {
                cartas[index++] = new Carta(palo, i);
            }
        }
        mezclar();
    }

    private void mezclar() {
        for (int i = 0; i < cartas.length; i++) {
            int j = (int)(Math.random() * cartas.length);
            Carta temp = cartas[i];
            cartas[i] = cartas[j];
            cartas[j] = temp;
        }
    }

    public boolean estaVacia() {
        return tope >= cartas.length;
    }

    public Carta sacarCarta() {
        return estaVacia() ? null : cartas[tope++];
    }
}


