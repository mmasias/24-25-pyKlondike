package src.alvaradoCarlos;

public class Baraja {
    private final int MAXIMO_NUMERO_CARTAS = 52;
    private Carta[] cartas;
    private Descarte descarte;

    public Baraja() {
        this.cartas = new Carta[MAXIMO_NUMERO_CARTAS];
        this.descarte = new Descarte();
        inicializarCartas();
    }

    public void mezclar() {
        for (int i = cartas.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
    
            Carta temp = cartas[i];
            cartas[i] = cartas[j];
            cartas[j] = temp;
        }
    }

    private void inicializarCartas() {
        Palo[] palos = generarPalos();
        int indice = 0;

        for (Palo palo : palos) {
            for (int valor = 1; valor <= 13; valor++) {
                cartas[indice] = new Carta(valor, palo);
                indice++;
            }
        }
    }

    private Palo[] generarPalos() {
        Palo[] palos = {
            new Palo("Corazones", "♥️"),
            new Palo("Diamantes", "♦️"),
            new Palo("Tréboles", "♣️"),
            new Palo("Picas", "♠️")
        };

        return palos;
    }

    public Palo[] obtenerPalos() {
        return generarPalos();
    }

    public void repartir(Columna[] columnas) {
        int indiceCarta = 0;

        for (int i = 0; i < columnas.length; i++){
            for (int j = 0; j <= i; j++) {
                columnas[i].agregarCarta(cartas[indiceCarta]);
                indiceCarta++;
            }
        }
    }

    public Carta sacarCarta() {
        for (int i = cartas.length - 1; i >= 0; i--) {
            if (cartas[i] != null) {
                Carta carta = cartas[i];
                cartas[i] = null;

                descarte.añadirCarta(carta);
                return carta;
            }
        }
        return null;
    }

    public boolean estaVacia() {
        if (cartas == null || cartas.length == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Carta[] cartasDeDescarte() {
        return descarte.obtenerCartas();
    }
}
