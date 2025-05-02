package src.alvaradoCarlos;

public class Fundacion {

    private final int MAXIMO_CARTAS_FUNDACION = 13;
    private Palo palo;
    private Carta[] cartas;

    public Fundacion(Palo palo) {
        this.palo = palo;
        this.cartas = new Carta[MAXIMO_CARTAS_FUNDACION];
    }

    public int numeroCartas() {
        return cartas.length;
    }

    public boolean estaVacia() {
        for (Carta carta : cartas) {
            if (carta != null) {
                return false;
            }
        }
        return true;
    }

    public Carta cartaSuperior() {
        for (int i = cartas.length - 1; i >= 0; i--) {
            if (cartas[i] != null) {
                return cartas[i];
            }
        }
        return null;
    }

}
