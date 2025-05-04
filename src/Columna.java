class Columna {

        final int MAX_CARDS = 7;
        private Carta[] cartas = new Carta[MAX_CARDS];
        private int numCartas = 0;

        public Columna(Carta[] cartas) {
                for (Carta carta : cartas) {
                        if (numCartas < MAX_CARDS) {
                                this.cartas[numCartas] = carta;
                                numCartas++;
                        }
                }
                numCartas = cartas.length;
        }

        public Carta sacarCarta() {
                if (numCartas > 0) {
                        Carta carta = cartas[numCartas - 1];
                        cartas[numCartas - 1] = null;
                        numCartas--;
                        return carta;
                } else {
                        return null;
                }
        }

        public void ponerCarta(Carta carta) {
                if (numCartas < MAX_CARDS) {
                        cartas[numCartas] = carta;
                        numCartas++;
                } else {
                        System.out.println("No se pueden poner más cartas en la columna.");
                }
        }

        public Carta getUltimaCarta() {
                if (numCartas > 0) {
                        return cartas[numCartas - 1];
                } else {
                        return null;
                }
        }

        public int getPalo() {
                if (numCartas > 0) {
                        return cartas[numCartas - 1].getPalo();
                } else {
                        return -1;
                }
        }

        public void mostrar() {
                for (Carta carta : cartas) {
                        if (carta != null) {
                                carta.mostrar();
                        }
                }
        }

        public boolean estaCompleto() {
                return numCartas == MAX_CARDS;
        }

}
