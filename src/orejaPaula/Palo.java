import java.util.*;

public class Palo {
    private Stack<Carta> cartas;
    private Carta.Palo tipoDePalo;

    public Palo(Carta.Palo tipoDePalo) {
        this.tipoDePalo = tipoDePalo;
        this.cartas = new Stack<>();
    }

    public boolean puedeAgregar(Carta carta) {
        if (carta.getPalo() != tipoDePalo) return false;
        if (cartas.isEmpty()) return carta.getValor() == Carta.VALOR_MINIMO;
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
