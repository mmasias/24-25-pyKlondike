public class Klondike {

    private final Jugador JUGADOR;
    private final Tapete TAPETE;
    private final Opciones OPCIONES;

    private boolean estaJugando = true;

    public Klondike() {
    	JUGADOR = new Jugador();
    	OPCIONES = new Opciones();
    	TAPETE = new Tapete(JUGADOR);
    }

    public void jugar() {
        while (jugando()) {
            Utilidades.saltarLinea(2);

            OPCIONES.imprimir();

            Utilidades.saltarLinea(2);

            TAPETE.mostrar();
            seleccionarAccion(JUGADOR.elegirOpcion(OPCIONES));
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
