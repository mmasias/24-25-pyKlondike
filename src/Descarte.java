
public class Descarte {

        private Carta[] cartas = new Carta[26];
        private int ultima = 0;
        private final int CARTAS_VISIBLES = 3;

        public void mostrar() {
                Consola.mostrar("Baraja: ");
                for (int i = 0; i < CARTAS_VISIBLES; i++) {
                        cartas[ultima-i].mostrar();
                }
        }

        public void moverCarta(Baraja baraja) {
                if (baraja.verificar(ultimaCarta())) {
                        baraja.poner(sacar());
                }
        }

        public void poner(Carta carta) {
                ultima++;
                cartas[ultima] = carta;
        }

        private Carta sacar() {
                Carta carta = ultimaCarta();
                ultima--;
                return carta;
        }

        public Carta ultimaCarta() {
                return cartas[ultima];
        }

        public void moverCarta(Columna columna) {
                if (columna.verificar(ultimaCarta())) columna.poner(sacar());
        }

        public void moverCarta(Palo palo) {
                if (palo.verificar(ultimaCarta())) palo.poner(sacar());
        }

        public void vaciarEn(Baraja baraja) {
                while (ultima > 0) baraja.poner(sacar());
        }

}
