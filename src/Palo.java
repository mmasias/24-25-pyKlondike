
public class Palo {

        private static final int CARTAS_MAXIMAS = 13;
        private Carta[] cartas = new Carta[CARTAS_MAXIMAS];
        private int ultima = -1;
        int palo;

        public Palo(int palo) {
                this.palo = palo;
        }

        public void mostrar() {
                Consola.mostrar("Palo " + palo + ": ");
                for (Carta carta : cartas) {
                        if (carta == null)
                                break;
                        carta.mostrar();
                }
                Consola.saltarLinea();
        }

        public void moverCarta(Columna columna) {
                if (columna.verificar(ultima()))
                        columna.poner(sacar());
        }

        private Carta sacar() {
                Carta carta = ultima();
                ultima--;
                return carta;
        }

        private Carta ultima() {
                return cartas[ultima];
        }

        public void poner(Carta carta) {
                ultima++;
                cartas[ultima] = carta;
        }

        public boolean verificar(Carta carta) {
                boolean paloVacio = vacia();
                if (paloVacio){
                        Consola.mostrarln("Palo vacio.");
                        boolean cartaValida = carta.valor() == 0;
                        if (cartaValida) Consola.mostrarln("Carta es un As");
                        Consola.mostrarln("pedo");
                        return cartaValida;
                } else {
                        boolean cartaUnoMasAlto = (ultima().valor() + 1) == carta.valor();
                        if (cartaUnoMasAlto) Consola.mostrarln("Carta es uno más alto.");
                        boolean cartaMismoPalo = ultima().palo() == carta.palo();
                        if (cartaMismoPalo) Consola.mostrarln("Carta es del mismo palo.");
                        boolean cartaValida = cartaUnoMasAlto && cartaMismoPalo;
                        Consola.mostrarln("pedo");
                        return cartaValida;
                }
        }

        private boolean vacia() {
                return ultima == -1;
        }

        public boolean estaVacio() {
                return ultima == -1;
        }

}
