package scr.calderonJimena;

public class Columna {
    private final Carta[] cartas = new Carta[52];
    private int tope = 0;

    public void agregar(Carta carta) {
        cartas[tope++] = carta;
    }

    public Carta verUltima() {
        return tope == 0 ? null : cartas[tope - 1];
    }

    public void voltearUltima() {
        if (tope > 0) {
            cartas[tope - 1].voltear();
        }
    }

    public void mostrar() {
        for (int i = 0; i < tope; i++) {
            System.out.print(cartas[i] + " ");
        }
        System.out.println();
    }

    public boolean estaVacia() {
        return tope == 0;
    }
}

