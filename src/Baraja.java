
public class Baraja {

    private static final String ERROR_BARAJA_VACIA = "Baraja vacía";
    private static final int PALOS = 4;
    private static final int NUMEROS_PALO = 13;
    public final int TOTAL_CARTAS = 52;

    public Carta[] cartas;

    private int ultima = 0;

    public Baraja() {
        this.cartas = new Carta[TOTAL_CARTAS];
        for (int palo = 0; palo < PALOS; palo++) {
            for (int valor = 0; valor < NUMEROS_PALO; valor++) {
                poner(new Carta(palo, valor));
            }
        }
        barajar();
    }

    private void barajar() {
        for (int index = 0; index < 1000; index++) {
            int randomIndex = (int) (Math.random() * TOTAL_CARTAS);
            Carta temp = cartas[index];
            cartas[index] = cartas[randomIndex];
            cartas[randomIndex] = temp;
        }
    }

    private void poner(Carta carta) {
        if (ultima < TOTAL_CARTAS) {
            cartas[ultima] = carta;
            ultima++;
        }
    }

    public void mostrar() {
        Utilidades utilidades = new Utilidades();
        if (vacia()) {
            utilidades.imprimirln(ERROR_BARAJA_VACIA);
        } else {
            cartas[ultima - 1].mostrar();
            utilidades.imprimirln();
        }
    }

    private boolean vacia() {
        return ultima == 0;
    }

    public void moverCarta(Descarte descarte) {
        Utilidades utilidades = new Utilidades();
        if (vacia()) {
            utilidades.imprimirln(ERROR_BARAJA_VACIA);
        } else {
            int contador = 3;
            while (contador > 0 && !vacia()) {
                Carta carta = sacar();
                carta.voltear();
                descarte.poner(carta);
                contador--;
            }
            utilidades.imprimirln("Baraja: " + (vacia() ? "vacía" : "no vacía"));
        }
    }

    private Carta sacar() {
        ultima--;
        return cartas[ultima];
    }

}
