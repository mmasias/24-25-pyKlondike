
public class Tapete {

        private final int NUM_PALOS = 4;
        private final int NUM_COLUMNAS = 7;

        private Baraja baraja;
        private Descarte descarte;
        private Palo[] palos;
        private Columna[] columnas;

        public Tapete() {
                iniciarBaraja();
                iniciarDescarte();
                iniciarPalos();
                iniciarColumnas();

                repartir();
        }

        private void iniciarDescarte() {
                descarte = new Descarte();
        }

        private void iniciarBaraja() {
                baraja = new Baraja();
                baraja.barajar();
        }

        private void iniciarPalos() {
                palos = new Palo[NUM_PALOS];
                for (Palo palo : palos) {
                        palo = new Palo();
                }
        }

        private void iniciarColumnas() {
                columnas = new Columna[NUM_COLUMNAS];
                for (Columna columna : columnas) {
                        columna = new Columna();
                }
        }

        private void repartir() {
                final int[] CARTAS_COLUMNA = { 1, 1, 3, 3, 5, 6, 7 };
                for (int columna = 0; columna < columnas.length; columna++) {
                        for (int carta = 0; carta < CARTAS_COLUMNA[columna]; carta++) {
                                columnas[columna].ponerCarta(baraja.sacarCarta());
                        }
                }
        }

        public void mostrar() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'mostrar'");
        }

        public boolean jugando() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'jugando'");
        }

        public void moverBarajaDescarte() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'moverBarajaDescarte'");
        }

        public void moverDescartePalo() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'moverDescartePalo'");
        }

        public void moverDescarteColumna() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'moverDescarteColumna'");
        }

        public void moverPaloColumna() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'moverPaloColumna'");
        }

        public void moverColumnaPalo() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'moverColumnaPalo'");
        }

        public void moverColumnaColumna() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'moverColumnaColumna'");
        }

        public void voltearCartaColumna() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'voltearCartaColumna'");
        }

        public void voltearDescarteBaraja() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'voltearDescarteBaraja'");
        }

}
