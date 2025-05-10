package coboIsmael;

import java.util.Scanner;

public class InterfazTexto {
    private Scanner lector;

    public InterfazTexto() {
        lector = new Scanner(System.in);
    }

    public void mostrarTablero(Juego juego) {
        Baraja mazo = juego.obtenerBaraja();
        Descarte pilaDescarte = juego.obtenerDescarte();

        System.out.println("Baraja: " +
            (mazo.estaVacia() ? "vacía" : mazo.cartasRestantes() + " cartas"));
        Carta cartaDescarte = pilaDescarte.verCartaSuperior();
        System.out.println("Descarte: " +
            (cartaDescarte == null ? "vacío" : cartaDescarte));

        System.out.println("Fundaciones:");
        Palo[] fundaciones = juego.obtenerPalos();
        for (int indice = 0; indice < fundaciones.length; indice++) {
            Carta cartaFundacion = fundaciones[indice].verCartaSuperior();
            String textoFundacion = (cartaFundacion == null ? "[vacío]"
                : cartaFundacion.toString());
            System.out.println((indice + 1) + ". " +
                fundaciones[indice].getNombrePalo() + ": " + textoFundacion);
        }

        System.out.println("Columnas:");
        Columna[] columnas = juego.obtenerColumnas();
        for (int indiceColumna = 0; indiceColumna < columnas.length; indiceColumna++) {
            System.out.print((indiceColumna + 1) + ":");
            int cantidadCartas = columnas[indiceColumna].cantidadCartas();
            if (cantidadCartas == 0) {
                System.out.print(" vacío");
            } else {
                for (int indiceCarta = 0; indiceCarta < cantidadCartas; indiceCarta++) {
                    System.out.print(" " +
                        columnas[indiceColumna].obtenerCartas()[indiceCarta]);
                }
            }
            System.out.println();
        }
    }

    public void mostrarMenu() {
        System.out.println();
        System.out.println("1. Baraja→Descarte");
        System.out.println("2. Descarte→Palo");
        System.out.println("3. Descarte→Columna");
        System.out.println("4. Columna→Columna");
        System.out.println("5. Columna→Palo");
        System.out.println("6. Voltear Columna");
        System.out.println("7. Reiniciar Baraja");
        System.out.println("8. Mostrar Tablero");
        System.out.println("9. Salir");
        System.out.print("Opción: ");
    }

    public int leerOpcion() {
        if (lector.hasNextInt()) {
            int opcion = lector.nextInt();
            lector.nextLine();
            return opcion;
        }
        lector.nextLine();
        return -1;
    }

    public void procesarOpcion(int opcion, Juego juego) {
        switch (opcion) {
            case 1:
                juego.moverBarajaADescarte();
                break;
            case 2:
                juego.moverDescarteAPalo();
                break;
            case 3:
                System.out.print("Columna destino (1-7): ");
                int columnaDestino = leerNumeroColumna();
                juego.moverDescarteAColumna(columnaDestino - 1);
                break;
            case 4:
                System.out.print("Columna origen (1-7): ");
                int columnaOrigen = leerNumeroColumna();
                System.out.print("Columna destino (1-7): ");
                int columnaDestino2 = leerNumeroColumna();
                juego.moverColumnaAColumna(columnaOrigen - 1, columnaDestino2 - 1);
                break;
            case 5:
                System.out.print("Columna origen (1-7): ");
                int columnaOrigen2 = leerNumeroColumna();
                juego.moverColumnaAPalo(columnaOrigen2 - 1);
                break;
            case 6:
                System.out.print("Columna a voltear (1-7): ");
                int columnaVoltear = leerNumeroColumna();
                juego.voltearColumna(columnaVoltear - 1);
                break;
            case 7:
                juego.reiniciarBaraja();
                break;
            case 8:
                break;
        }
    }

    private int leerNumeroColumna() {
        if (lector.hasNextInt()) {
            int numero = lector.nextInt();
            lector.nextLine();
            if (numero >= 1 && numero <= 7) {
                return numero;
            }
        } else {
            lector.nextLine();
        }
        return -1;
    }
}