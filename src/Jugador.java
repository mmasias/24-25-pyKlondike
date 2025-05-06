public class Jugador {

        public int preguntar(Opciones opciones) {
                int respuesta = Consola.preguntarInt();
                if (!opciones.esValida(respuesta)) {
                        Consola.mostrarln("Respuesta no valida");
                        return preguntar(opciones);
                }
                return respuesta;
        }

}
