package doaltoBienvenido;

public class Columna {

    private Carta[] cartas;
    private int indiceCarta;
    private final int MAX_CARTAS_POR_COLUMNA = 19;

    public Columna(){
        cartas = new Carta[MAX_CARTAS_POR_COLUMNA]; 
        indiceCarta = 0;
    }

    public void agregarCarta(Carta carta) {
        if (indiceCarta < cartas.length) {
            cartas[indiceCarta++] = carta;
        }
    }

    public Carta sacarCarta() {
        if (indiceCarta > 0) {
            return cartas[--indiceCarta];
        }
        return null;
    }

    public void darVueltaUltimaCarta() {
        if (indiceCarta > 0 && !cartas[indiceCarta - 1].esVisible()) {
            cartas[indiceCarta - 1].darVuelta();
        }
    }

    public String toString() {
        String resultado = "";
        
        for (int i = 0; i < indiceCarta; i++) {
            resultado += cartas[i].toString();
        }
        return resultado;
    }
}
