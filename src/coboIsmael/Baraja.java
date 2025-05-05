package coboIsmael;

public class Baraja {
    private Carta[] cartas;
    private int totalCartas;

    public Baraja() {
        cartas = new Carta[52];
        totalCartas = 0;
        String[] nombresPalos = {"Picas", "Corazones", "Treboles", "Diamantes"};
        for (int indicePalo = 0; indicePalo < nombresPalos.length; indicePalo++) {
            for (int valorCarta = 1; valorCarta <= 13; valorCarta++) {
                cartas[totalCartas++] = new Carta(nombresPalos[indicePalo], valorCarta, false);
            }
        }
        barajar();
    }

    private void barajar() {
        for (int numeroIntercambios = 0; numeroIntercambios < 1000; numeroIntercambios++) {
            int posicionOrigen  = (int)(Math.random() * totalCartas);
            int posicionDestino = (int)(Math.random() * totalCartas);
            Carta cartaTemporal = cartas[posicionOrigen];
            cartas[posicionOrigen]  = cartas[posicionDestino];
            cartas[posicionDestino] = cartaTemporal;
        }
    }

    public boolean estaVacia() {
        return totalCartas == 0;
    }

    public Carta sacarCarta() {
        if (totalCartas == 0) {
            return null;
        }
        return cartas[--totalCartas];
    }

    public void agregarCarta(Carta cartaNueva) {
        if (totalCartas < cartas.length) {
            cartas[totalCartas++] = cartaNueva;
        }
    }

    public int cartasRestantes() {
        return totalCartas;
    }
}
