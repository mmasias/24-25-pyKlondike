package src.klondike.utils;

public class Menu {

    public void imprimeOpciones() {
        Console console = new Console();
        console.clearScreen();
        console.writeln("OPCIONES>");
        console.writeln("1. Mover de Baraja a Descarte    2. Mover de Descarte a Palo     3. Mover de Descarte a Columna");
        console.writeln("4. Mover de Palo a Columna       5. Mover de Columna a Palo      6. Mover de Columna a Columna");
        console.writeln("7. Voltear carta de Columna      8. Voltear Descarte en Baraja   9. Salir            ");
    }
    private final Intervalo OPCIONES = new Intervalo(1, 9);

    public int getOpcion() {
        Console console = new Console();
        int opcion;
        boolean error;
        do {
            opcion = console.readInt("Elige una opción  [1-9]");
            error = !OPCIONES.incluye(opcion);
        } while (error);
        return opcion;
    }
}
