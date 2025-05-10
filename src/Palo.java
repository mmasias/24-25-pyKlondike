
public class Palo {

        private static final int CANTIDAD_CARTAS = 19;
        private Carta[] cartas = new Carta[CANTIDAD_CARTAS];
        private int indexUltima = -1;

        private int palo;

        public Palo(int palo) {
                this.palo = palo;
        }

        public void mover(Columna columna) {
                if (valida(columna.ultima()))
                        poner(columna.sacar());
        }

        public void poner(Carta carta) {
                indexUltima++;
                cartas[indexUltima] = carta;
        }

        private boolean valida(Carta carta) {
                if (vacia() && carta.isAs())
                        return true;
                if (!vacia() && carta.palo() == ultima().palo() && carta.valor() + 1 == ultima().valor())
                        return true;
                return false;
        }

        private Carta ultima() {
                return cartas[indexUltima];
        }

        private boolean vacia() {
                return indexUltima == -1;
        }

        public void imprimir() {
                System.out.print(palo+"º Palo: ");
                for (Carta carta : cartas) {
                        carta.imprimir();
                }
        }

}
