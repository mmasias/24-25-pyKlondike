
public class Columna {

        private static final int CARTAS_MAXIMAS = 19;
        private Carta[] cartas = new Carta[CARTAS_MAXIMAS];
        private int ultima = 0;

        private int[] CARTAS_INICIALES = { 1, 1, 3, 3, 5, 6, 7 };

        public Columna(int columna, Baraja baraja) {
                for (int carta = 0; carta < CARTAS_INICIALES[columna-1]; carta++) {
                        baraja.moverCarta(this);
                } 
                ultima().voltear();
        }

        public void mostrar() {
                for (Carta carta : cartas) carta.mostrar();
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
                boolean paloVacio = vacia() && carta.valor() == 1;
                boolean cartaValida = !vacia() && (ultima().valor() + 1) == carta.valor()
                                && ultima().color() != carta.color();
                return paloVacio || cartaValida;
        }

        private boolean vacia() {
                return ultima == 0;
        }

        public void poner(Carta carta) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'poner'");
        }

}
