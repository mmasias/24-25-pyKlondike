
public class Palo {

        private static final int CARTAS_MAXIMAS = 13;
        private Carta[] cartas = new Carta[CARTAS_MAXIMAS];
        private int ultima = 0;
        int palo;

        public Palo(int palo) {
                this.palo = palo;
        }

        public void mostrar() {
                for (Carta carta : cartas)
                        carta.mostrar();
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
                boolean paloVacio = vacia() && carta.valor() == 1;
                boolean cartaValida = !vacia() && (ultima().valor() + 1) == carta.valor()
                                && ultima().palo() == carta.palo();
                return paloVacio || cartaValida;
        }

        private boolean vacia() {
                return ultima == 0;
        }

}
