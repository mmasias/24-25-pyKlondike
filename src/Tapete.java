
public class Tapete {

        private final int NUM_PALOS = 4;
        private final int NUM_COLUMNAS = 7;

        private Baraja baraja;
        private Descarte descarte;
        private Palo[] palos;
        private Columna[] columnas;

        private Jugador jugador;

        public Tapete() {
                iniciarBaraja();
                iniciarDescarte();
                iniciarPalos();
                iniciarColumnas();
        }

        public Tapete(Jugador jugador) {
                this();
                this.jugador = jugador;
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
        	for (int i = 0; i < palos.length; i++) {
        		palos[i] = new Palo();
        	}
        }

        private void iniciarColumnas() {
                columnas = new Columna[NUM_COLUMNAS];
                final int[] CARTAS_COLUMNA = { 1, 1, 3, 3, 5, 6, 7 };
                for (int columna = 0; columna < columnas.length; columna++) {
                        Carta[] cartas = baraja.sacarCarta(CARTAS_COLUMNA[columna]);
                        columnas[columna] = new Columna(cartas);
                }
        }

        public void mostrar() {
                Utilidades.mostrar("Baraja: ");
                baraja.mostrar();
                Utilidades.saltarLinea(2);

                Utilidades.mostrar("Descarte: ");
                descarte.mostrar();
                Utilidades.saltarLinea(2);

                for (int palo = 1; palo <= palos.length; palo++) {
                        Utilidades.mostrar("Palo " + palo + ": ");
                        palos[palo-1].mostrar();
                        Utilidades.saltarLinea(2);
                }
                for (int columna = 1; columna <= columnas.length; columna++) {
                        Utilidades.mostrar("Columna " + columna + ": ");
                        columnas[columna-1].mostrar();
                        Utilidades.saltarLinea(2);
                }
        }

        public boolean jugando() {
                for (Palo palo : palos) {
                        if (palo.estaCompleto()) {
                                return false;
                        }
                }
                for (Columna columna : columnas) {
                        if (columna.estaCompleto()) {
                                return false;
                        }
                }
                return true;
        }

        public void moverBarajaDescarte() {
                Carta[] cartas = baraja.sacarCarta(3);
                descarte.ponerCarta(cartas);
        }

        public void moverDescartePalo() {
                Carta carta = descarte.sacarCarta();
                Palo palo = seleccionarPalo("A");
                palo.ponerCarta(carta);
        }

        public void moverDescarteColumna() {
                Carta carta = descarte.sacarCarta();
                Columna columna = seleccionarColumna("A");
                columna.ponerCarta(carta);
        }

        public void moverPaloColumna() {
                Palo palo = seleccionarPalo("De");
                Columna columna = seleccionarColumna("A");

                Carta carta = palo.sacarCarta();
                columna.ponerCarta(carta);
        }

        public void moverColumnaPalo() {
                Columna columna = seleccionarColumna("De");
                Palo palo = seleccionarPalo("A");

                Carta carta = columna.sacarCarta();
                palo.ponerCarta(carta);
        }

        private Columna seleccionarColumna(String prefijo) {
                int columna = jugador.pedirColumna(prefijo, columnas.length);
                return columnas[columna];
        }

        private Palo seleccionarPalo(String prefijo) {
                int palo = jugador.pedirPalo(prefijo, palos.length);
                return palos[palo];
        }

        public void moverColumnaColumna() {
                Columna columnaOrigen = seleccionarColumna("De");
                Columna columnaDestino = seleccionarColumna("A");

                Carta carta = columnaOrigen.sacarCarta();
                columnaDestino.ponerCarta(carta);
        }

        public void voltearCartaColumna() {
                Columna columna = seleccionarColumna("De");
                columna.getUltimaCarta().voltear();
        }

        public void voltearDescarteBaraja() {
                if (baraja.estaVacio()) {
                        Carta[] cartas = descarte.vaciar();
                        baraja.ponerCarta(cartas);
                } else {
                        System.out.println("La baraja no está vacía, no se puede voltear.");
                }
        }

}
