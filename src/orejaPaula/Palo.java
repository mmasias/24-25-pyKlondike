import java.util.*;

public class Palo {
    private Stack<Carta> cartas;
    private Carta.Palo palo;

    public Palo(Carta.Palo palo) {
        this.palo = palo;
        this.cartas = new Stack<>();
    }

    public boolean puedeAgregar(Carta carta) {
        if (carta.getPalo() != palo) return false;
        if (cartas.isEmpty()) return carta.getValor() == 1;
        return carta.getValor() == cartas.peek().getValor() + 1;
    }

    public void agregar(Carta carta) {
        if (puedeAgregar(carta)) cartas.push(carta);
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

    public String toString() {
        return cartas.isEmpty() ? "No hay cartas en el palo" : cartas.peek().toString();
    }
}
