package coboIsmael;

public class ClienteKlondike {
    public static void main(String[] args) {
        Juego juego = new Juego();
        InterfazTexto interfaz = new InterfazTexto();
        int opcionUsuario;
        do {
            interfaz.mostrarTablero(juego);
            interfaz.mostrarMenu();
            opcionUsuario = interfaz.leerOpcion();
            interfaz.procesarOpcion(opcionUsuario, juego);
        } while (opcionUsuario != 9 && !juego.victoria());
        if (juego.victoria()) {
            System.out.println("¡Has ganado!");
        }
    }
}