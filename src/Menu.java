
public class Menu {

        private final String[] OPCIONES = {
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

        public void mostrar() {
                System.out.println("OPCIONES>");
                for (int i = 0; i < OPCIONES.length; i++) {
                        System.out.println((i + 1) + ". " + OPCIONES[i]);
                }
        }

        public boolean esValida(int respuesta) {
                return respuesta >= 1 && respuesta <= OPCIONES.length;
        }

}
