class Palo {

        private final int CARTAS_MAXIMAS = 13;
        private final Carta[] CARTAS = new Carta[CARTAS_MAXIMAS];
        private int numeroCartas = 0;

        public boolean estaVacio() {
                return numeroCartas == 0;
        }

        public Carta getUltimaCarta() {
                return numeroCartas > 0 ? CARTAS[numeroCartas - 1] : null;
        }

        public void ponerCarta(Carta carta) {
                boolean cartaValida = getUltimaCarta() == null || (carta.getPalo() == getUltimaCarta().getPalo()
                                && carta.getValor() == CARTAS[numeroCartas - 1].getValor() + 1
                                && numeroCartas < CARTAS_MAXIMAS);
                if (cartaValida) {
                        CARTAS[numeroCartas] = carta;
                        numeroCartas++;
                        getUltimaCarta().setVisible(true);
                }
        }

        public Carta sacarCarta() {
                if (numeroCartas != 0) {
                        Carta carta = CARTAS[numeroCartas - 1];
                        numeroCartas--;
                        return carta;
                } else {
                        return null;
                }
        }

        public void mostrar() {
                for (int carta = 0; carta < numeroCartas; carta++) {
                        CARTAS[carta].mostrar();
                }
        }

        public boolean estaCompleto() {
                return numeroCartas == CARTAS_MAXIMAS;
        }

}
