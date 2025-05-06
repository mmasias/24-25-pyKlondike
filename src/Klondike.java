
public class Klondike {

        private Opciones opciones = new Opciones();
        private Tapete tapete = new Tapete();
        private Jugador jugador = new Jugador();

        private boolean jugando = true;

        public void jugar() {
                do {
                        opciones.mostrar();
                        tapete.mostrar();
                        seleccionarOpcion(jugador.preguntar(opciones));
                } while (jugando);
        }

        private void seleccionarOpcion(int respuesta) {
                switch (respuesta) {
                        case 1 -> tapete.moverBarajaDescarte();
                        case 2 -> tapete.moverDescartePalo();
                        case 3 -> tapete.moverDescarteColumna();
                        case 4 -> tapete.moverPaloColumna();
                        case 5 -> tapete.moverColumnaPalo();
                        case 6 -> tapete.moverColumnaColumna();
                        case 7 -> tapete.voltearCartaColumna();
                        case 8 -> tapete.voltearDescarteBaraja();
                        case 9 -> salir();
                        default -> Consola.mostrar("Respuesta Incorrecta [switch seleccionarOpcion]");
                }
        }

        private void salir() {
                jugando = false;
        }

}
