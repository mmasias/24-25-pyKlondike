import java.util.*;

public class Columna {
    private Stack<Carta> cartas;

    public Columna() {
        cartas = new Stack<>();
    }

    public void agregarCarta(Carta carta) {
        cartas.push(carta);
    }

    public boolean puedeAgregar(Carta carta) {
        if (cartas.isEmpty()) return carta.getValor() == Carta.VALOR_MAXIMO;
        Carta cartaTope = cartas.peek();
        return cartaTope.estaBocaArriba() &&
               carta.getValor() == cartaTope.getValor() - 1 &&
               carta.esRoja() != cartaTope.esRoja();
    }

    public Carta sacarCarta() {
        return cartas.pop();
    }

    public Carta verTope() {
        return cartas.isEmpty() ? null : cartas.peek();
    }

    public void voltearTope() {
        if (!cartas.isEmpty() && !cartas.peek().estaBocaArriba())
            cartas.peek().voltear();
    }

    public List<Carta> getCartas() {
        return new ArrayList<>(cartas);
    }

    public boolean estaVacia() {
        return cartas.isEmpty();
    }

    public String toString() {
        return cartas.toString();
    }
}
