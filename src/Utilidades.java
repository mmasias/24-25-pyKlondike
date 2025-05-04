
import java.util.Scanner;


public class Utilidades {

        public static void mostrar(String string) {
                System.out.print(string);
        }

        public static String leerString() {
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                scanner.close();
                return input;
        }

        public static int leerInt() {
                Scanner scanner = new Scanner(System.in);
                int input = scanner.nextInt();
                scanner.close();
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
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'mostrarln'");
        }

}
