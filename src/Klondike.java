
public class Klondike {

        private Menu menu = new Menu();
        private Jugador jugador = new Jugador();

        private Baraja baraja;
        private Descarte descarte;
        private Palo[] palos;
        private Columna[] columnas;

        private boolean jugando = true;

        public Klondike() {
                iniciarBaraja();
                iniciarDescarte();
                iniciarPalos();
                iniciarColumnas();
        }

        private void iniciarBaraja() {
                baraja = new Baraja();
                baraja.barajar();
        }

        private void iniciarDescarte() {
                descarte = new Descarte();
        }

        private void iniciarColumnas() {
                columnas = new Columna[7];
                for (int columna = 0; columna < columnas.length; columna++) {
                        columnas[columna] = new Columna(columna);
                }
        }

        private void iniciarPalos() {
                palos = new Palo[4];
                for (int palo = 0; palo < palos.length; palo++) {
                        palos[palo] = new Palo(palo);
                }
        }

        public void mostrar() {
                baraja.mostrar();
                descarte.mostrar();
                for (Palo palo : palos) {
                        palo.mostrar();
                }
                for (Columna columna : columnas) {
                        columna.mostrar();
                }
        }

        public void jugar() {
                do {
                        menu.mostrar();
                        mostrar();
                        seleccionarOpcion(jugador.preguntar(menu));
                } while (jugando);
        }

        private void seleccionarOpcion(int respuesta) {
                switch (respuesta) {
                        case 1 -> baraja.moverCarta(descarte);
                        case 2 -> descarte.moverCarta(elegirPalo("A"));
                        case 3 -> descarte.moverCarta(elegirColumna("A"));
                        case 4 -> elegirPalo("De").moverCarta(elegirColumna("A"));
                        case 5 -> elegirColumna("De").moverCarta(elegirPalo("A"));
                        case 6 -> elegirColumna("De").moverCarta(elegirColumna("A"));
                        case 7 -> elegirColumna("De").ultimaCarta().voltear();
                        case 8 -> descarte.vaciarEn(baraja);
                        case 9 -> salir();
                        default -> Consola.mostrar("Respuesta Incorrecta [switch seleccionarOpcion]");
                }
        }

        private Columna elegirColumna(String prefijo) {
                Consola.mostrar(prefijo + "qué columna?" + " " + "[1-" + columnas.length + "]");
                int respuesta = Consola.preguntarInt();
                if (respuesta < 1 || respuesta > columnas.length) {
                        Consola.mostrarln("Columna erronea.");
                        return elegirColumna(prefijo);
                }
                return columnas[respuesta];
        }

        private Palo elegirPalo(String prefijo) {
                Consola.mostrar(prefijo + "qué palo?" + " " + "[1-" + palos.length + "]");
                int respuesta = Consola.preguntarInt();
                if (respuesta < 1 || respuesta > palos.length) {
                        Consola.mostrarln("Columna erronea.");
                        return elegirPalo(prefijo);
                }
                return palos[respuesta];
        }

        private void salir() {
                jugando = false;
        }

}
