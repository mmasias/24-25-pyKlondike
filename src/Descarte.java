
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

        public void poner(Carta carta) {
                ultima++;
                cartas[ultima] = carta;
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
                while (ultima > 0) baraja.poner(sacar());
        }

}
