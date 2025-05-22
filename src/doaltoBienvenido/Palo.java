package doaltoBienvenido;

public class Palo {
    private Carta[] cartas;
    private int cantidad;
    private final int CARTAS_POR_PALO = 13;

    public Palo() {
        cartas = new Carta[CARTAS_POR_PALO]; 
        cantidad = 0;
    }

    public boolean tieneCartas() {
        return cantidad > 0;
    }

    public void agregarCarta(Carta carta) {
        if (cantidad < cartas.length) {
            cartas[cantidad++] = carta;
        }
    }

    public Carta extraerCarta() {
        if (tieneCartas()) {
            return cartas[--cantidad];
        }
        return null;
    }

    public boolean puedeAgregar(Carta carta) {
        if (cantidad == 0) {
            return carta.getValor() == 1; 
        }
        Carta cartaSuperior = cartas[cantidad - 1]; 
        return carta.getValor() == cartaSuperior.getValor() + 1; 
    }

    public String toString() {
        String resultado = "";
        for (int i = 0; i < cantidad; i++) {
            resultado += cartas[i].toString() + " ";
        }
        return resultado;
    }
}   
