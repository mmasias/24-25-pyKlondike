package doaltoBienvenido;

public class Baraja {

    private Carta[] cartas;
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
            for (int valor = VALOR_MINIMO_CARTAS; valor <= VALOR_MAXIMO_CARTAS; valor++) {
                cartas[contador] = new Carta(palo, valor);
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

    public Carta sacarCarta(){
        if (indiceCartaActual < cartas.length) {
            return cartas[indiceCartaActual++];
        } else {
            return null;
        }
    }
    
    public String toString() {
        return "Baraja con " + (cartas.length - indiceCartaActual) + " cartas restantes.";
    }



}
