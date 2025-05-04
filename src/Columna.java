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
                if (numCartas > 0) {
                        CARTAS[numCartas - 1].voltear();
                }
        }

        public Carta sacarCarta() {
                if (numCartas > 0) {
                        getUltimaCarta().setVisible(false);
                        Carta carta = CARTAS[numCartas - 1];
                        CARTAS[numCartas - 1] = null;
                        numCartas--;
                        if (numCartas > 0) {
                                getUltimaCarta().setVisible(true);
                        }
                        return carta;
                } else {
                        return null;
                }
        }

        public void ponerCarta(Carta carta) {
                if (numCartas < MAX_CARDS) {
                        if (numCartas == 0) {
                                final int K = 13;
                                if (carta.getValor() == K) {
                                        CARTAS[numCartas] = carta;
                                        numCartas++;
                                } else {
                                        System.out.println("Solo se pueden colocar cartas K en una columna vacía.");
                                }
                        } else if (carta.getValor() == getUltimaCarta().getValor() - 1 &&
                                        carta.getColor() != getUltimaCarta().getColor()) {
                                getUltimaCarta().voltear();
                                CARTAS[numCartas] = carta;
                                numCartas++;
                                getUltimaCarta().voltear();
                        } else {
                                System.out.println("La carta no cumple las reglas para ser colocada en la columna.");
                        }
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
                        return CARTAS[numCartas - 1].getPalo();
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
