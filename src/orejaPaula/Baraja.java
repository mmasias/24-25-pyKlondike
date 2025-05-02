import java.util.*;

public class Baraja {
    private Stack<Carta> cartas;

    public Baraja() {
        cartas = new Stack<>();
        for (Carta.Palo palo : Carta.Palo.values()) {
            for (int i = 1; i <= 13; i++) {
                cartas.push(new Carta(palo, i));
            }
        }
        Collections.shuffle(cartas);
    }

    public boolean estaVacia() {
        return cartas.isEmpty();
    }

    public Carta sacarCarta() {
        return estaVacia() ? null : cartas.pop();
    }

    public void agregarCartas(List<Carta> nuevas) {
        Collections.reverse(nuevas);
        cartas.addAll(nuevas);
    }

    public int cantidad() {
        return cartas.size();
    }

    public List<Carta> verCartas() {
        return new ArrayList<>(cartas);
    }
}
