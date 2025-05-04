public class Klondike {

    private Jugador jugador;
    private final Tapete TAPETE;
    private Opciones opciones;

    private boolean estaJugando = true;

    public Klondike() {
        TAPETE = new Tapete(jugador);
    }

    public void jugar() {
        while (jugando()) {
            opciones.imprimir();
            TAPETE.mostrar();
            int opcion = jugador.elegirOpcion(opciones);
            seleccionarAccion(opcion);
        }
    }

    private boolean jugando() {
        return TAPETE.jugando() || estaJugando;
    }

    private void seleccionarAccion(int opcion) {
        switch (opcion) {
            case 1 -> TAPETE.moverBarajaDescarte();
            case 2 -> TAPETE.moverDescartePalo();
            case 3 -> TAPETE.moverDescarteColumna();
            case 4 -> TAPETE.moverPaloColumna();
            case 5 -> TAPETE.moverColumnaPalo();
            case 6 -> TAPETE.moverColumnaColumna();
            case 7 -> TAPETE.voltearCartaColumna();
            case 8 -> TAPETE.voltearDescarteBaraja();
            case 9 -> salir();
            default -> System.out.println("Opción no válida.");
        }
    }

    private void salir() {
        estaJugando = false;
    }

}
