
public class Opciones {

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

        public void imprimir() {
                Utilidades.mostrar("Opciones> ");
                for (int i = 0; i < opciones.length; i++) {
                        Utilidades.mostrar((i + 1) + ". " + opciones[i]);
                }
        }

        public int numeroDeOpciones() {
                return opciones.length;
        }

}
