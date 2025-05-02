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

    public boolean darVueltaCarta() {
        for (int i = cantidad - 1; i >= 0; i--) {
            if (!cartas[i].esVisible()) {
                cartas[i].darVuelta();
                return true;
            }
        }
        return false;
    }


    public String toString() {
        String resultado = "";
        
        for (int i = 0; i < cantidad; i++) {
            resultado += cartas[i].toString();
        }
        return resultado;
    }
}
