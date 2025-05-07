
public class Columna {

        private static final int CARTAS_MAXIMAS = 19;
        private Carta[] cartas = new Carta[CARTAS_MAXIMAS];
        private int ultima = -1;
        private int columna;

        private int[] CARTAS_INICIALES = { 1, 1, 3, 3, 5, 6, 7 };

        public Columna(int columna, Baraja baraja) {
                this.columna = columna;
                for (int carta = 0; carta < CARTAS_INICIALES[columna-1]; carta++) {
                        poner(baraja.sacar());
                        ultima().voltear();
                }
                ultima().voltear();
        }

        public void mostrar() {
                Consola.mostrar("Columna " + columna + ": ");
                for (int carta = 0; carta <= ultima; carta++) {
                        cartas[carta].mostrar();
                }
                Consola.saltarLinea();
        }

        public void moverCarta(Columna columna) {
                if (columna.verificar(ultima())) columna.poner(sacar());
        }

        private Carta sacar() {
                Carta carta = ultima();
                ultima--;
                return carta;
        }

        public void moverCarta(Palo palo) {
                if (palo.verificar(ultima())) palo.poner(sacar());
        }

        public Carta ultima() {
                return cartas[ultima];
        }

        public boolean verificar(Carta carta) {
                return vacia() && carta.valor() == 13 || (ultima().valor() - 1) == carta.valor() && ultima().color() != carta.color();
        }

        public boolean vacia() {
                return ultima == -1;
        }

        public void poner(Carta carta) {
                ultima++;
                cartas[ultima] = carta;
        }

}
