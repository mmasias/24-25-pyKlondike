

import java.util.ArrayList;
import java.util.List;

public class Columna {
    private final List<Carta> cartas;

    public Columna(List<Carta> cartasIniciales) {
        if (cartasIniciales == null) {
            this.cartas = new ArrayList<>();
        } else {
            this.cartas = new ArrayList<>(cartasIniciales); 
        }
    }

    public void moverAPalo(Palo palo) {
        if (palo == null || cartas.isEmpty()) {
            return;
        }

        Carta ultimaCarta = cartas.get(cartas.size() - 1);

        if (palo.esValida(ultimaCarta)) {
            cartas.remove(cartas.size() - 1);
            palo.agregarCarta(ultimaCarta);
        }
    }

    public void agregarCarta(Carta carta) {
        if (carta != null) {
            cartas.add(carta);
        }
    }

    public Carta verUltimaCarta() {
        if (cartas.isEmpty()) {
            return null;
        }
        return cartas.get(cartas.size() - 1);
    }

    public boolean estaVacia() {
        return cartas.isEmpty();
    }

    public int cantidadCartas() {
        return cartas.size();
    }
}