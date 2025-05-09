import java.util.Scanner;

public class Consola {

        static Scanner scanner = new Scanner(System.in);

        public static void mostrar(String string) {
                System.out.print(string);
        }

        public static int preguntarInt() {
                int respuesta = scanner.nextInt();
                return respuesta;
        }

        public static void mostrarln(String string) {
                mostrar(string);
                saltarLinea();
        }

        public static void saltarLinea() {
                System.out.println();
        }

}
