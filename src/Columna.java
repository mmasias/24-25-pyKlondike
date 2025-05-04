class Columna {

        final int MAX_CARDS = 7;
        private final Carta[] CARTAS = new Carta[MAX_CARDS];
        private int numCartas = 0;

        public Columna(Carta[] cartas) {
                for (Carta carta : cartas) {
                        if (numCartas < MAX_CARDS) {
                                this.CARTAS[numCartas] = carta;
                                numCartas++;
                        }
                }
                numCartas = cartas.length;
        }

        public Carta sacarCarta() {
                if (numCartas > 0) {
                        Carta carta = CARTAS[numCartas - 1];
                        CARTAS[numCartas - 1] = null;
                        numCartas--;
                        return carta;
                } else {
                        return null;
                }
        }

        public void ponerCarta(Carta carta) {
                if (numCartas < MAX_CARDS) {
                        CARTAS[numCartas] = carta;
                        numCartas++;
                } else {
                        System.out.println("No se pueden poner más cartas en la columna.");
                }
        }

        public Carta getUltimaCarta() {
                if (numCartas > 0) {
                        return CARTAS[numCartas - 1];
                } else {
                        return null;
                }
        }

        public int getPalo() {
                if (numCartas > 0) {
                        return CARTAS[numCartas - 1].getPALO();
                } else {
                        return -1;
                }
        }

        public void mostrar() {
                for (Carta carta : CARTAS) {
                        if (carta != null) {
                                carta.mostrar();
                        }
                }
        }

        public boolean estaCompleto() {
                return numCartas == MAX_CARDS;
        }

}
