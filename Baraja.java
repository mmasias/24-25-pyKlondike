public class Baraja extends Mazo {

    private final int PALOS = 4;
    private final int NUMEROS = 13;
    private final int TOTAL_CARTAS = PALOS * NUMEROS;

    public Baraja() {
        ultima = 0;
        cartas = new Carta[TOTAL_CARTAS];
        for (int palo = 0; palo < PALOS; palo++) {
            for (int numero = 0; numero < NUMEROS; numero++) {
                poner(new Carta(palo, numero));
            }
        }
        barajar();
        console = new Console();
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



    public void mostrar() {
        console.write("BARAJA: ");
        if (vacia()) {
            console.writeln("La baraja está vacía!!!");
        } else {
            Carta carta = cima();
            carta.mostrar();
            console.writeln();
        }

    }

    private Carta cima() {
        return cartas[ultima - 1];
    }

    public static void main(String[] args) {
        Baraja unaBaraja = new Baraja();
        for(int i=0;i<52;i++){
            Carta unaCarta = unaBaraja.sacar();
            unaCarta.voltear();
            unaCarta.mostrar();
        }

    }

}
