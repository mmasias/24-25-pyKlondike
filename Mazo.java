import java.util.*;

public class Mazo {
    private List<Carta> cartas;

    public Mazo() {
        cartas = new ArrayList<>();
        String[] valores = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
        String[] palos = { "♠️", "♥️", "♦️", "♣️" };
        for (String palo : palos) {
            for (String valor : valores) {
                cartas.add(new Carta(valor, palo));
            }
        }
        Collections.shuffle(cartas);
    }

    public boolean estaVacio() {
        return cartas.isEmpty();
    }

    public Carta sacar() {
        return estaVacio() ? null : cartas.remove(cartas.size() - 1);
    }

    public void devolver(Carta c) {
        cartas.add(0, c);
    }
}
