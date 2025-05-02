package src.alvaradoCarlos;

public class Baraja {

    private final int MAXIMO_NUMERO_CARTAS = 52;
    private Carta[] cartas;
    private Descarte descarte;
    private int siguienteCarta;

    public Baraja() {
        this.cartas = new Carta[MAXIMO_NUMERO_CARTAS];
        this.descarte = new Descarte();
        this.siguienteCarta = 0;
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

        for (int i = 0; i < columnas.length; i++) {
            for (int j = 0; j <= i; j++) {
                columnas[i].agregarCarta(cartas[indiceCarta]);
                indiceCarta++;
            }
        }

        this.siguienteCarta = 28;
    }

    public Carta sacarCarta() {
        if (siguienteCarta >= MAXIMO_NUMERO_CARTAS) {
            return null;
        }
        Carta carta = cartas[siguienteCarta];
        cartas[siguienteCarta] = null;
        siguienteCarta++;
        return carta;
    }
    
    public boolean estaVacia() {
        return siguienteCarta >= MAXIMO_NUMERO_CARTAS;
    }

    public Carta[] cartasDeDescarte() {
        return descarte.obtenerCartas();
    }

    public void agregarCarta(Carta carta) {
        if (siguienteCarta > 0) {
            siguienteCarta--;
            cartas[siguienteCarta] = carta;
        }
    }
}
