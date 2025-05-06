
public class Klondike {

        Opciones opciones;
        Tapete tapete;
        Jugador jugador;

        public void jugar() {
                opciones = new Opciones();
                tapete = new Tapete();
                opciones.mostrarOpciones();
                tapete.mostrarTapete();
                jugador = new Jugador();
                int opcion = jugador.elegir(opciones);
                elegirOpcion(opcion);
        }

        private void elegirOpcion(int opcion) {
                switch (opcion) {
                        case 1 -> tapete.moverBarajaDescarte();
                        case 2 -> tapete.moverDescartePalo();
                        case 3 -> tapete.moverDescarteColumna();
                        case 4 -> tapete.moverPaloColumna();
                        case 5 -> tapete.moverColumnaPalo();
                        case 6 -> tapete.moverColumnaColumna();
                        case 7 -> tapete.voltearcartaColumna();
                        case 8 -> tapete.voltearDescarteBaraja();
                        case 9 -> tapete.salir();
                        default -> System.out.println("Opción no válida. Intente de nuevo.");
                }
        }

}
