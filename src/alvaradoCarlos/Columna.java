package src.alvaradoCarlos;

public class Columna {

    private Carta[] cartas;

    public Columna() {
        this.cartas = new Carta[0];
    }

    public void agregarCarta(Carta carta) {
        Carta[] nuevoCartas = new Carta[cartas.length + 1];
        for (int i = 0; i < cartas.length; i++) {
            nuevoCartas[i] = cartas[i];
        }
        nuevoCartas[cartas.length] = carta;
        actualizarCartas(nuevoCartas);
    }

    public Carta[] cartas() {
        return cartas;
    }

    public Carta cartaSuperior() {
        return cartas[cartas.length - 1];
    }

    public boolean contieneCarta(Carta cartaEnColumna) {
        for (Carta carta : cartas) {
            if (carta == cartaEnColumna) {
                return true;
            }
        }
        return false;
    }

    public boolean estaVacia() {
        for (Carta carta : cartas) {
            if (carta != null) {
                return false;
            }
        }
        return true;
    }

    public Carta sacarCarta() {
        if (estaVacia()) {
            return null;
        }

        for (int i = 0; i < cartas.length; i++) {
            if (cartas[i].estaDescubierta()) {
                Carta carta = cartas[i];

                Carta[] nuevoCartas = new Carta[cartas.length - 1];
                for (int j = 0, k = 0; j < cartas.length; j++) {
                    if (j != i) {
                        nuevoCartas[k++] = cartas[j];
                    }
                }

                actualizarCartas(nuevoCartas);
                return carta;
            }
        }

        return null;
    }

    private void actualizarCartas(Carta[] nuevoCartas) {
        cartas = nuevoCartas;
    }
}
