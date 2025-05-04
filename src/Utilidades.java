
import java.util.Scanner;


public class Utilidades {

        static Scanner scanner = new Scanner(System.in);

        public static void mostrar(String string) {
                System.out.print(string);
        }

        public static String leerString() {
                String input = scanner.nextLine();
                return input;
        }

        public static int leerInt() {
                int input = scanner.nextInt();
                return input;
        }

        public static int leerInt(int max) {
                int respuesta;
                do { 
                    respuesta = leerInt();
                    if (respuesta < 1 || respuesta > max) {
                        mostrar("Error, elige una opción válida [1-" + max + "]: ");
                    }
                } while (respuesta < 1 || respuesta > max);
                return respuesta;
        }

        public static void mostrarln(String string) {
                System.out.println(string);
        }

        public static void saltarLinea(int numeroDeLineas) {
                for (int linea = 0; linea < numeroDeLineas; linea++) {
                        mostrarln("");
                }
        }

}
