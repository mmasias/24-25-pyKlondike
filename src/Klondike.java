public class Klondike {

    private Jugador jugador;
    private Tapete tapete;
    private Opciones opciones;

    private boolean estaJugando = true;

    public Klondike() {
        tapete = new Tapete(jugador);
    }

    private void iniciarJugador() {
        jugador = new Jugador();
        jugador.preguntarNombre();
    }

    public void jugar() {
        iniciarJugador();
        while (jugando()) {
            opciones.imprimir();
            tapete.mostrar();
            int opcion = jugador.elegirOpcion(opciones);
            seleccionarAccion(opcion);
        }
    }

    private boolean jugando() {
        return tapete.jugando() || estaJugando;
    }

    private void seleccionarAccion(int opcion) {
        switch (opcion) {
            case 1 -> tapete.moverBarajaDescarte();
            case 2 -> tapete.moverDescartePalo();
            case 3 -> tapete.moverDescarteColumna();
            case 4 -> tapete.moverPaloColumna();
            case 5 -> tapete.moverColumnaPalo();
            case 6 -> tapete.moverColumnaColumna();
            case 7 -> tapete.voltearCartaColumna();
            case 8 -> tapete.voltearDescarteBaraja();
            case 9 -> salir();
            default -> System.out.println("Opción no válida.");
        }
    }

    private void salir() {
        estaJugando = false;
    }

}
