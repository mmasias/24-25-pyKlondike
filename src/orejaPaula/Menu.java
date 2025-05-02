import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public static final int OPCION_MINIMA = 1;
    public static final int OPCION_MAXIMA = 9;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public void mostrarOpciones() {
        System.out.println("\nOPCIONES>");
        System.out.println("1. Mover de Baraja a Descarte");
        System.out.println("2. Mover de Descarte a Palo");
        System.out.println("3. Mover de Descarte a Columna");
        System.out.println("4. Mover de Palo a Columna");
        System.out.println("5. Mover de Columna a Palo");
        System.out.println("6. Mover de Columna a Columna");
        System.out.println("7. Voltear carta de Columna");
        System.out.println("8. Voltear Descarte en Baraja");
        System.out.println("9. Salir");
    }

    public int pedirOpcion() {
        return pedirNumero("Elige una opción", OPCION_MINIMA, OPCION_MAXIMA);
    }

    public int pedirNumero(String mensaje, int minimo, int maximo) {
        int numero;
        do {
            System.out.print(mensaje + " [" + minimo + "-" + maximo + "]: ");
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.print(mensaje + " [" + minimo + "-" + maximo + "]: ");
            }
            numero = scanner.nextInt();
        } while (numero < minimo || numero > maximo);
        return numero;
    }
}

