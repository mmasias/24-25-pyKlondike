
public class Descarte {

        private static final int CARTAS_MAXIMAS = 26;
        private Carta[] cartas = new Carta[CARTAS_MAXIMAS];
        private int ultima = -1;
        private final int CARTAS_VISIBLES = 3;

        public void mostrar() {
                Consola.mostrar("Descarte: ");
                for (int i = 0; i < CARTAS_VISIBLES; i++) {
                        if (ultima - i < 0) break;
                        cartas[ultima - i].mostrar();
                }
                Consola.saltarLinea();
        }

        public void poner(Carta carta) {
                ultima++;
                cartas[ultima] = carta;
        }

        public boolean estaLleno() {
                return ultima >= cartas.length - 1;
        }

        private Carta sacar() {
                Carta carta = ultima();
                ultima--;
                return carta;
        }

        public Carta ultima() {
                return cartas[ultima];
        }

        public void moverCarta(Columna columna) {
                if (columna.verificar(ultima())) columna.poner(sacar());
        }

        public void moverCarta(Palo palo) {
                if (palo.verificar(ultima())) palo.poner(sacar());
        }

        public void vaciarEn(Baraja baraja) {
                while (ultima >= 0) {
                        Carta carta = sacar();
                        carta.voltear();
                        baraja.poner(carta);
                }
        }

}
