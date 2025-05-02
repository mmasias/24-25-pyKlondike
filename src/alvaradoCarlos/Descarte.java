package src.alvaradoCarlos;

public class Descarte {

    private final int MAXIMO_NUMERO_DESCARTES = 3;
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

    private Carta cartaSuperior() {
        return cartas[MAXIMO_NUMERO_DESCARTES - 1];
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
}
