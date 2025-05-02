
public class Menu {

    public void imprimirOpciones() {
        Utilidades utilidades = new Utilidades();
        String titulo = "OPCIONES>";
        utilidades.imprimirln(titulo);

        String[] opciones = {
            "Mover de Baraja a Descarte",
            "Mover de Descarte a Palo",
            "Mover de Descarte a Columna",
            "Mover de Palo a Columna",
            "Mover de Columna a Palo",
            "Mover de Columna a Columna",
            "Voltear carta de Columna",
            "Voltear Descarte en Baraja",
            "Salir"
        };

        for (int i = 0; i < opciones.length; i++) {
            utilidades.imprimirln("  " + (i + 1) + ". " + opciones[i]);
        }
    }

    public int getOpcion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOpcion'");
    }
}
