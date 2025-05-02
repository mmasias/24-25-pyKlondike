import java.util.Scanner;

public class Utilidades {

    Scanner scanner = new Scanner(System.in);

    public void imprimirln(String mensaje) {
        System.out.println(mensaje);
    }

    public void imprimir(String mensaje) {
        System.out.print(mensaje);
    }

    public int preguntarInt(String mensaje, int[] limites) {
        int resultado;
        do {
            resultado = scanner.nextInt();
            if (resultado < limites[0] || resultado > limites[1]) {
                System.out.println("El número debe estar entre " + limites[0] + " y " + limites[1]);
            }
        } while (resultado < limites[0] || resultado > limites[1]);
        return resultado;
    }

    public void imprimirln() {
        imprimirln("");
    }

}
