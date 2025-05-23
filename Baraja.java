public class Baraja extends Mazo {

    private static final int PALOS = 4;
    private static final int NUMEROS = 13;
    private static final int TOTAL_CARTAS = PALOS * NUMEROS;

    public Baraja() {
        super(TOTAL_CARTAS, "Baraja");

        for (int palo = 0; palo < PALOS; palo++) {
            for (int numero = 0; numero < NUMEROS; numero++) {
                poner(new Carta(palo, numero));
            }
        }
        barajar();
    }

    
    private void barajar() {
        for (int i = 0; i < 1000; i++) {
            int origen = (int) (Math.random() * TOTAL_CARTAS);
            int destino = (int) (Math.random() * TOTAL_CARTAS);
            Carta carta = cartas[origen];
            cartas[origen] = cartas[destino];
            cartas[destino] = carta;
        }
    }

    public void moverA(Descarte descarte) {
        if (vacia()) {
            console.writeln("No hay cartas!!!");
        } else {
            int contador = 3;
            while (contador > 0 && !vacia()) {
                Carta carta = sacar();
                carta.voltear();
                descarte.poner(carta);
                contador--;
            }
        }
    }

    @Override
    protected void mostrarContenido() {
        Carta carta = cima();
        carta.mostrar();        
    }

    private Carta cima() {
        return cartas[ultima - 1];
    }
}
