
public class Jugador {

        public int elegirOpcion(Opciones opciones) {
                Utilidades.mostrar("Elija una opción [1-" + opciones.numeroDeOpciones() + "]: ");
                int opcion = Utilidades.leerInt(opciones.numeroDeOpciones());
                return opcion - 1;
        }

        public int pedirColumna(String prefijo, int columnas) {
                Utilidades.mostrar(prefijo + "qué columna? [1-" + columnas + "]: ");
                int columna = Utilidades.leerInt(columnas);
                return columna - 1;
        }

        public int pedirPalo(String prefijo, int length) {
                Utilidades.mostrar(prefijo + "qué palo? [1-" + length + "]: ");
                int palo = Utilidades.leerInt(length);
                return palo - 1;
        }

}
