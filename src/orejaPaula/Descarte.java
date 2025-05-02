import java.util.*;

public class Descarte {
    private Stack<Carta> cartas;

    public Descarte() {
        cartas = new Stack<>();
    }

    public void agregar(Carta carta) {
        carta.voltear();
        cartas.push(carta);
    }

    public Carta sacar() {
        return cartas.isEmpty() ? null : cartas.pop();
    }

    public Carta verTope() {
        return cartas.isEmpty() ? null : cartas.peek();
    }

    public boolean estaVacio() {
        return cartas.isEmpty();
    }

    public List<Carta> vaciar() {
        List<Carta> copia = new ArrayList<>(cartas);
        cartas.clear();
        return copia;
    }

    public List<Carta> verCartas() {
        return new ArrayList<>(cartas);
    }
}
