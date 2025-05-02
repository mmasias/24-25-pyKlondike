
public class Baraja {

    private Carta[] cartas;
    private int ultima;

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
    }

    private void barajar() {
        for(int i=0;i<1000;i++){
            int origen = (int)(Math.random()*TOTAL_CARTAS);
            int destino = (int)(Math.random()*TOTAL_CARTAS);
            Carta carta = cartas[origen];
            cartas[origen] = cartas[destino];
            cartas[destino] = carta;
        }
    }

    private void poner(Carta carta) {
        cartas[ultima] = carta;
        ultima++;
    }

    public void moverA(Descarte descarte) {
        Console console = new Console();
        if(vacia()){
            console.writeln("No hay cartas!!!");    
        }else{
            int contador = 3;
            while (contador>0 && !vacia()){
                Carta carta = sacar();
                carta.voltear();
                descarte.poner(carta);
                contador--;
            }
        }
    }

    private Carta sacar() {
        ultima--;
        return cartas[ultima];
    }

    public void mostrar() {
        Console console = new Console();
        console.write("BARAJA: ");

        if(vacia()) {
            console.writeln("La baraja está vacía!!!");
        } else {
            Carta carta = cima();
            carta.mostrar();
            console.writeln();
        }


    }

    private boolean vacia() {
        return ultima==0;
    }

    private Carta cima() {
        return cartas[ultima-1];
    }

}
