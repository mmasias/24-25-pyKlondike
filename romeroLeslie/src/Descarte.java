package romeroLeslie.src;

import java.util.ArrayList;
import java.util.List;

public class Descarte {
    private final List<Carta> cartas;

    public Descarte() {
        this.cartas = new ArrayList<>();
    }

    public void agregarCarta(Carta carta) {
        if (carta != null) {
            carta.voltear();
            cartas.add(carta);
        }
    }

    public Carta verUltimaCarta() {
        if (cartas.isEmpty()) {
          
            return new Carta("?", "?");
        }
        return cartas.get(cartas.size() - 1);
    }

    public boolean estaVacio() {
        return cartas.isEmpty();
    }

    public List<Carta> obtenerCartas() {
       
        return new ArrayList<>(cartas);
    }

    public void limpiar() {
        cartas.clear();
    }

    @Override
    public String toString() {
        if (cartas.isEmpty()) {
            return "[Vacío]";
        }

        String resultado = "";
        for (Carta carta : cartas) {
            resultado += carta.toString() + " ";
        }
        return resultado.trim();
    }
}
