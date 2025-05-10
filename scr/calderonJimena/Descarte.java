package scr.calderonJimena;

public class Descarte {
    private final Carta[] pila = new Carta[52];
    private int tope = 0;

    public void agregar(Carta carta) {
        carta.voltear();
        pila[tope++] = carta;
    }

    public Carta verUltima() {
        return tope == 0 ? null : pila[tope - 1];
    }

    public Carta sacar() {
        return tope == 0 ? null : pila[--tope];
    }

    public boolean estaVacia() {
        return tope == 0;
    }

    public void mostrar() {
        if (tope == 0) {
            System.out.println("[Vacío]");
        } else {
            for (int i = 0; i < tope; i++) {
                System.out.print(pila[i]);
            }
            System.out.println();
        }
    }
}

