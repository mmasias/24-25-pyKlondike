package romeroLeslie.src;
import java.util.ArrayList;
import java.util.List;

public class Baraja {
    private final List<Carta> cartas;

    public Baraja() {
        this.cartas = new ArrayList<>();
    }

    public void agregarCarta(Carta carta) {
        if (carta != null) {
            cartas.add(carta); 
        }
    }

    public void voltearDescarte(Descarte descarte) {
        if (descarte == null || cartas.isEmpty()) {
            return;
        }
        int ultimoIndice = cartas.size() - 1;
        Carta ultimaCarta = cartas.remove(ultimoIndice);
        descarte.agregarCarta(ultimaCarta);
    }

    public boolean estaVacia() {
        return cartas.isEmpty();
    }

    public int cantidadCartas() {
        return cartas.size();
    }
}