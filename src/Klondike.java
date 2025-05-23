
public class Klondike {

        private final Menu menu = new Menu();
        private final Jugador jugador = new Jugador();

        private boolean jugando = true;

        private Baraja baraja = new Baraja();
        private Descarte descarte = new Descarte();
        private static final int CANTIDAD_COLUMNAS = 7;
        private Columna[] columnas = new Columna[CANTIDAD_COLUMNAS];
        private static final int CANTIDAD_PALOS = 4;
        private Palo[] palos = new Palo[CANTIDAD_PALOS];

        public void jugar() {
                do {
                        menu.imprimir();
                        imprimir();
                        int respuesta = jugador.preguntarOpcion();
                        seleccionarOpcion(respuesta);
                } while (jugando);
        }

        private void imprimir() {
                baraja.imprimir();
                descarte.imprimir();
                imprimirPalos();
                imprimirColumnas();
        }

        private void imprimirColumnas() {
                for (Columna columna : columnas) {
                        columna.imprimir();
                }
        }

        private void imprimirPalos() {
                for (Palo palo : palos) {
                        palo.imprimir();
                }
        }

        private void seleccionarOpcion(int respuesta) {
                switch (respuesta) {
                        case 1 -> baraja.mover(descarte);
                        case 2 -> descarte.mover(seleccionarPalo("A"));
                        case 3 -> descarte.mover(seleccionarColumna("A"));
                        case 4 -> seleccionarPalo("De").mover(seleccionarColumna("A"));
                        case 5 -> seleccionarColumna("De").mover(seleccionarPalo("A"));
                        case 6 -> seleccionarColumna("De").mover(seleccionarColumna("A"));
                        case 7 -> seleccionarColumna("De").ultima().voltear();
                        case 8 -> descarte.voltear(baraja);
                        case 9 -> salir();
                }
        }

        private void salir() {
                jugando = false;
        }

        private Columna seleccionarColumna(String string) {
                int respuesta = jugador.preguntarColumna(CANTIDAD_COLUMNAS);
                return columnas[respuesta];
        }

        private Palo seleccionarPalo(String string) {
                int respuesta = jugador.preguntarPalo(CANTIDAD_PALOS);
                return palos[respuesta];
        }

}
