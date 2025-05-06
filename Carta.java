public class Carta {

    private int palo;
    private int numero;
    private boolean bocaArriba;

    private final String[] PALOS = { "♠️", "♣️", "♦️", "♥️" };
    private final String[] NUMEROS = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

    private Console console;

    public Carta(int unPalo, int unNumero) {
        palo = unPalo;
        numero = unNumero;
        bocaArriba = false;
        console = new Console();
    }

    public void mostrar() {
        String numero = "?";
        String palo = "?";

        if (bocaArriba) {
            numero = NUMEROS[this.numero];
            palo = PALOS[this.palo];
        }
        console.write(numero + palo);
    }

    public void voltear() {
        bocaArriba = !bocaArriba;
    }


    public static void main(String[] args) {
        Carta cartaPrueba = new Carta(1,0);
        System.out.println();
        cartaPrueba.mostrar();
        System.out.println();
        cartaPrueba.voltear();
        cartaPrueba.voltear();
        cartaPrueba.voltear();
        cartaPrueba.mostrar();
        System.out.println();

    }

    public boolean bocaArriba() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bocaArriba'");
    }

    public boolean esRey() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'esRey'");
    }

    public boolean distintoColor(Carta carta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'distintoColor'");
    }

    public boolean siguiente(Carta carta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'siguiente'");
    }

}
