public class Descarte {
    private final int MAXIMO_NUMERO_DESCARTADAS = 3;
    private Carta[] cartasDescartadas;

    public Descarte() {
        this.cartasDescartadas = new Carta[MAXIMO_NUMERO_DESCARTADAS];
    }

    public void añadirCarta(Carta carta) {
        for (int i = 0; i < cartasDescartadas.length; i++) {
            if (cartasDescartadas[i] == null) {
                cartasDescartadas[i] = carta;
                return;
            }
        }
        System.out.println("El descarte está lleno. No se puede añadir más cartas.");
    }

    public Carta[] obtenerCartas() {
        int contador = 0;

        for (Carta carta : cartasDescartadas) {
            if (carta != null) {
                contador++;
            }
        }

        Carta[] cartasNoNulas = new Carta[contador];
        int indice = 0;

        // Copiar las cartas no nulas al nuevo arreglo
        for (Carta carta : cartasDescartadas) {
            if (carta != null) {
                cartasNoNulas[indice] = carta;
                indice++;
            }
        }

        return cartasNoNulas;
    }
}
