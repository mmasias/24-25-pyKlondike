class Descarte {

        private static final int MAXIMO_CARTAS = 26;
        private final int CARTAS_VISIBLES = 3;
        private final Carta[] CARTAS = new Carta[MAXIMO_CARTAS];
        private int numeroCartas;

        public Carta sacarCarta() {
                if (numeroCartas > 0) {
                        ultimaCarta().setVisible(false);
                        Carta carta = CARTAS[numeroCartas - 1];
                        CARTAS[numeroCartas - 1] = null;
                        numeroCartas--;
                        if (numeroCartas > 0) {
                                ultimaCarta().setVisible(true);
                        }
                        return carta;
                } else {
                        return null;
                }
        }

        public void ponerCarta(Carta[] cartas) {
                int inicio = Math.max(0, numeroCartas - CARTAS_VISIBLES);
                int fin = numeroCartas;
                for (int i = inicio; i < fin; i++) {
                        if (CARTAS[i] != null) {
                                CARTAS[i].setVisible(false);
                        }
                }
                for (Carta carta : cartas) {
                        ponerCarta(carta);
                }
                inicio = Math.max(0, numeroCartas - CARTAS_VISIBLES);
                fin = numeroCartas;
                for (int i = inicio; i < fin; i++) {
                        if (CARTAS[i] != null) {
                                CARTAS[i].setVisible(true);
                        }
                }
        }

        private void ponerCarta(Carta carta) {
                if (numeroCartas < MAXIMO_CARTAS) {
                        this.CARTAS[numeroCartas] = carta;
                        numeroCartas++;
                } else {
                        System.out.println("No se pueden poner más cartas en el descarte.");
                }
        }

        private Carta ultimaCarta() {
                if (numeroCartas > 0) {
                        return CARTAS[numeroCartas - 1];
                } else {
                        return null;
                }
        }

        public Carta[] vaciar() {
                Carta[] cartasVacias = new Carta[numeroCartas];
                for (int i = 0; i < numeroCartas; i++) {
                        ultimaCarta().setVisible(false);
                        cartasVacias[i] = CARTAS[i];
                        CARTAS[i] = null;
                }
                numeroCartas = 0;
                return cartasVacias;
        }

        public void mostrar() {
                for (int i = numeroCartas - 1; i >= Math.max(0, numeroCartas - 3); i--) {
                        if (CARTAS[i] != null) {
                                CARTAS[i].mostrar();
                        }
                }
        }

}
