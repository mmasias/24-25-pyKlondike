package src.alvaradoCarlos;

public class Descarte {

    private final int MAXIMO_NUMERO_CARTAS = 52;
    private final int NUM_COLUMNAS = 7;
    private final int MAXIMO_NUMERO_DESCARTES = MAXIMO_NUMERO_CARTAS - (NUM_COLUMNAS * (NUM_COLUMNAS + 1) / 2);
    private Carta[] cartas;

    public Descarte() {
        this.cartas = new Carta[MAXIMO_NUMERO_DESCARTES];
    }

    public void añadirCarta(Carta carta) {
        if (cartaSuperior() != null) {
            for (int i = 0; i < MAXIMO_NUMERO_DESCARTES - 1; i++) {
                cartas[i] = cartas[i + 1];
            }
            cartas[MAXIMO_NUMERO_DESCARTES - 1] = carta;
        } else {
            for (int i = 0; i < MAXIMO_NUMERO_DESCARTES; i++) {
                if (cartas[i] == null) {
                    cartas[i] = carta;
                    return;
                }
            }
        }
    }

    public Carta cartaSuperior() {
        for (int i = cartas.length - 1; i >= 0; i--) {
            if (cartas[i] != null) {
                return cartas[i];
            }
        }
        return null;
    }

    public Carta[] obtenerCartas() {
        int contador = 0;

        for (Carta carta : cartas) {
            if (carta != null) {
                contador++;
            }
        }

        Carta[] cartasNoNulas = new Carta[contador];
        int indice = 0;

        for (Carta carta : cartas) {
            if (carta != null) {
                cartasNoNulas[indice] = carta;
                indice++;
            }
        }

        return cartasNoNulas;
    }

    public Carta sacarCarta() {
        for (int i = MAXIMO_NUMERO_DESCARTES - 1; i >= 0; i--) {
            if (cartas[i] != null) {
                Carta carta = cartas[i];
                cartas[i] = null;
                return carta;
            }
        }
        return null;
    }

    public boolean estaVacio() {
        for (Carta carta : cartas) {
            if (carta != null) {
                return false; 
            }
        }
        return true;
    }

    public void vaciar() {
        for (int i = 0; i < cartas.length; i++) {
            cartas[i] = null;
        }
    }
}
