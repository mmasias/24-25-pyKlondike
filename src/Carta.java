public class Carta {

    private int palo;
    private int numero;
    private boolean bocaArriba;

    private final String[] PALOS = { "♠️ ", "♣️ ", "♦️ ", "♥️ " };
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
        console.write("[" + numero + palo + "]");
    }

    public void voltear() {
        bocaArriba = !bocaArriba;
    }

    public static void main(String[] args) {
        Carta cartaPrueba = new Carta(1, 0);
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
        return bocaArriba;
    }

    public boolean esRey() {
        return numero == 12;
    }

    public boolean distintoColor(Carta carta) {
        return this.rojo() && carta.negro() || this.negro() && carta.rojo();
    }

    private boolean rojo() {
        return palo == 2 || palo == 3;
    }

    private boolean negro() {
        return !rojo();
    }

    public boolean siguiente(Carta carta) {
        return this.numero == carta.numero + 1;
    }

    public boolean esAs() {
        return numero == 0;
    }

    public boolean igualPalo(Carta carta) {
        return palo == carta.palo;
    }
}
