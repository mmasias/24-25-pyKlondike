
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
                for (Palo palo : palos) {
                        palo = new Palo();
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
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'mostrar'");
        }

        public boolean jugando() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'jugando'");
        }

        public void moverBarajaDescarte() {
                Carta[] cartas = baraja.sacarCarta(3);
                descarte.ponerCarta(cartas);
                if (cartas[0] != null) {
                        baraja.ponerCarta(cartas);
                }
        }

        public void moverDescartePalo() {
                Carta carta = descarte.sacarCarta();
                int palo = 0;
                do {
                        Palo paloActivo = palos[palo];
                        if (paloActivo.estaVacio()) {
                                paloActivo.ponerCarta(carta);
                        } else {
                                boolean esMismoPalo = paloActivo.getPalo() == carta.getPalo();
                                boolean esUnValorMenos = paloActivo.getUltimaCarta().getValor() == carta.getValor() + 1;
                                boolean movimientoValido = esMismoPalo
                                                && esUnValorMenos;
                                if (movimientoValido) {
                                        paloActivo.ponerCarta(carta);
                                }
                        }
                        palo++;
                } while (palo < palos.length);
        }

        public void moverDescarteColumna() {
                Carta carta = descarte.sacarCarta();
                int columna = 0;
                do {
                        Columna columnaActiva = columnas[columna];
                        if (columnaActiva.estaVacio()) {
                                columnaActiva.ponerCarta(carta);
                        } else {
                                boolean esMismoPalo = columnaActiva.getPalo() == carta.getPalo();
                                boolean esUnValorMenos = columnaActiva.getUltimaCarta().getValor() == carta.getValor()
                                                + 1;
                                boolean movimientoValido = esMismoPalo
                                                && esUnValorMenos;
                                if (movimientoValido) {
                                        columnaActiva.ponerCarta(carta);
                                }
                        }
                        columna++;
                } while (columna < columnas.length);
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
