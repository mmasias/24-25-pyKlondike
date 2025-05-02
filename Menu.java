
public class Menu {

    public void imprimeOpciones() {
        Console console = new Console();
        console.writeln("OPCIONES>");
        console.writeln("1. Mover de Baraja a Descarte");
        console.writeln("2. Mover de Descarte a Palo");
        console.writeln("3. Mover de Descarte a Columna");
        console.writeln("4. Mover de Palo a Columna");
        console.writeln("5. Mover de Columna a Palo");
        console.writeln("6. Mover de Columna a Columna");
        console.writeln("7. Voltear carta de Columna");
        console.writeln("8. Voltear Descarte en Baraja");
        console.writeln("9. Salir            ");  
    }

    public int getOpcion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOpcion'");
    }

}
