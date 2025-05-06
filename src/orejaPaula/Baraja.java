import java.util.*;

public class Baraja {
    private Stack<Carta> cartas;

    public Baraja() {
        cartas = new Stack<>();
        for (Carta.Palo palo : Carta.Palo.values()) {
            for (int valor = Carta.VALOR_MINIMO; valor <= Carta.VALOR_MAXIMO; valor++) {
                cartas.push(new Carta(palo, valor));
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

    public void agregarCartas(List<Carta> nuevasCartas) {
        Collections.reverse(nuevasCartas);
        cartas.addAll(nuevasCartas);
    }

    public int cantidadDeCartas() {
        return cartas.size();
    }

    public List<Carta> verCartas() {
        return new ArrayList<>(cartas);
    }
}

