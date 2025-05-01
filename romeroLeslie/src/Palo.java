package romeroLeslie.src;

import java.util.ArrayList;
import java.util.List;

public class Palo {
    private final String nombre;
    private final List<Carta> cartas;

    public Palo(String nombre) {
        this.nombre = nombre;
        this.cartas = new ArrayList<>();
    }

    public void agregarCarta(Carta carta) {
        if (carta != null) {
            cartas.add(carta);
        }
    }

    public Carta verUltimaCarta() {
        if (cartas.isEmpty()) {
            return new Carta("?", "?");
        }
        return cartas.get(cartas.size() - 1);
    }

    @Override
    public String toString() {
        if (cartas.isEmpty()) {
            return nombre + ": Vacío";
        }
        return nombre + ": " + cartas.get(cartas.size() - 1).toString();
    }
}
