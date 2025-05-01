package doaltoBienvenido;

public class Columna {

    private Carta[] cartas;
    private int cantidad;
    private final int MAX_CARTAS_POR_COLUMNA = 20;

    public Columna(){
        cartas = new Carta[MAX_CARTAS_POR_COLUMNA]; 
        cantidad = 0;
    }

    public boolean tieneCartas() {
        return cantidad > 0;
    }

    public Carta extraerCarta() {
        if (tieneCartas()) {
            return cartas[--cantidad];
        }
        return null;
    }

    public void agregarCarta(Carta carta) {
        if (cantidad < cartas.length) {
            cartas[cantidad++] = carta;
        }
    }

    public boolean puedeAgregar(Carta carta) {
        if (cantidad == 0) {
            return true; 
        }
        Carta cartaSuperior = cartas[cantidad - 1];
        return cartaSuperior.puedeColocarSobre(carta);
    }

    public void darVueltaCarta() {
        if (tieneCartas()) {
            cartas[cantidad - 1].darVuelta();
        }
    }


    public String toString() {
        String resultado = "";
        
        for (int i = 0; i < cantidad; i++) {
            resultado += cartas[i].toString();
        }
        return resultado;
    }
}
