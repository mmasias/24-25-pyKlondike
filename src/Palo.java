class Palo {

        private final int CARTAS_MAXIMAS = 13;
        private int palo;
        private final Carta[] cartas = new Carta[CARTAS_MAXIMAS];
        private int numeroCartas = 0;

        public int getPalo() {
                return palo;
        }

        public boolean estaVacio() {
                return numeroCartas == 0;
        }

        public Carta getUltimaCarta() {
                return cartas[numeroCartas];
        }

        public void ponerCarta(Carta carta) {
                boolean cartaValida = carta.getPALO() == palo
                                && carta.getVALOR() == cartas[numeroCartas].getVALOR() + 1
                                && numeroCartas < CARTAS_MAXIMAS;
                if (cartaValida) {
                        cartas[numeroCartas] = carta;
                        numeroCartas++;
                }
        }

        public Carta sacarCarta() {
                if (numeroCartas != 0) {
                        Carta carta = cartas[numeroCartas];
                        numeroCartas--;
                        return carta;
                } else {
                        return null;
                }
        }

        public void mostrar() {
                Utilidades.mostrarln("Palo " + palo + ": ");
                for (int carta = 0; carta < numeroCartas; carta++) {
                        cartas[carta].mostrar();
                }
        }

        public boolean estaCompleto() {
                return numeroCartas == CARTAS_MAXIMAS;
        }

}
