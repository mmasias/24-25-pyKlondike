
public class Menu {

        final private String[] OPCIONES = {
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
                int cuenta = 1;
                for (String opcion : OPCIONES) {
                        System.out.println(cuenta+"."+opcion);
                        cuenta++;
                }
        }

}
