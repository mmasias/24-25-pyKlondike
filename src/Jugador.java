public class Jugador {

        public int preguntar(Menu opciones) {
                Consola.mostrarln("Selecciona una opción: [1-" + opciones.tamaño() + "]");
                int respuesta = Consola.preguntarInt();
                if (!opciones.esValida(respuesta)) {
                        Consola.mostrarln("Respuesta no valida");
                        return preguntar(opciones);
                }
                return respuesta;
        }

}
