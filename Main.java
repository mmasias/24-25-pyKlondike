import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solitario juego = new Solitario();
        boolean salir = false;

        while (!salir) {
            juego.mostrarEstado();
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    juego.moverBarajaADescarte();
                    break;
                case 2:
                    juego.moverDescarteAPalo();
                    break;
                case 6:
                    System.out.print("Columna origen (1-7): ");
                    int origen = sc.nextInt();
                    System.out.print("Columna destino (1-7): ");
                    int destino = sc.nextInt();
                    juego.moverColumnaAColumna(origen, destino);
                    break;
                case 7:
                    System.out.print("¿Qué columna quieres voltear (1-7)?: ");
                    int col = sc.nextInt();
                    juego.voltearColumna(col);
                    break;
                case 9:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción aún no implementada.");
            }
        }

        sc.close();
        System.out.println("Gracias por jugar.");
    }
}
