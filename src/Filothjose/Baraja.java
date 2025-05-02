package Filothjose;

public class Baraja {

    private final Carta[] cartas;
    private int indiceCartaActual;

    private final int CARTAS_TOTALES = 52;
    private final int VALOR_MINIMO_CARTAS = 1;
    private final int VALOR_MAXIMO_CARTAS = 13;


    public Baraja(){
        cartas = new Carta[CARTAS_TOTALES];
        indiceCartaActual = 0;
        inicializarBaraja();
        mezclarBaraja();
    }

    private void inicializarBaraja(){
        String[] palos = {"Corazones", "Diamantes", "Picas", "Treboles"};
        int contador = 0;
        for (String palo : palos) {
            for (int valorCarta = VALOR_MINIMO_CARTAS; valorCarta <= VALOR_MAXIMO_CARTAS; valorCarta++) {
                cartas[contador] = new Carta(palo, valorCarta);
                contador++;
            }
        }
    }

    private void mezclarBaraja(){
        for (int i = 0; i < cartas.length; i++) {
            int j = (int) (Math.random() * cartas.length);
            Carta temporal = cartas[i];
            cartas[i] = cartas[j];
            cartas[j] = temporal;
        }
    }

    public boolean tieneCartas() {
        return indiceCartaActual < cartas.length;
    }

    public Carta sacarCarta(){
        if (tieneCartas()) {
            return cartas[indiceCartaActual++];
        } else {
            return null;
        }
    }

    public void agregarCarta(Carta carta) {
        if (indiceCartaActual > 0) {
            cartas[--indiceCartaActual] = carta;
        }
    }

    public String toString() {
        return "Baraja con " + (cartas.length - indiceCartaActual) + " cartas restantes.";
    }

}