import java.util.Scanner;

public class Klondike {
    private Baraja baraja;
    private Columna[] columnas;
    private Fundacion[] fundaciones;
    private Scanner scanner;
    private Descarte descarte;

    public Klondike() {
        this.baraja = new Baraja();
        this.columnas = new Columna[7];
        this.fundaciones = new Fundacion[4];
        this.descarte = new Descarte();
        this.scanner = new Scanner(System.in);
    
        inicializarColumnas();
        inicializarPalos();
        prepararBaraja();
    }

    public void jugar() {
        System.out.println("Iniciando juego...");
        while (!haGanado()) {
            System.out.println("Mostrando menú...");
            mostrarMenu();
            System.out.println("Esperando entrada del usuario...");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Procesando opción: " + opcion);
            procesarOpcion(opcion);
        }
        System.out.println("¡Juego terminado!");
    }

    private boolean haGanado() {
        return false;
    }
    

    private void inicializarColumnas() {
        for (int i = 0; i < columnas.length; i++) {
            columnas[i] = new Columna();
        }
    }

    private void inicializarPalos(){
        Palo[] palos = baraja.obtenerPalos();
        for (int i = 0; i < fundaciones.length; i++) {
            fundaciones[i] = new Fundacion(palos[i]);
        }
    }

    private void prepararBaraja(){
        baraja.mezclar();
        baraja.repartir(columnas);

        for (Columna columna : columnas) {
            Carta[] cartas = columna.cartas();
            if (cartas.length > 0) {
                cartas[cartas.length - 1].voltear();
            }
        }
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1: moverBarajaADescarte();
            case 9: System.exit(0);
            default: System.out.println("Opción no válida.");
        }
    }
    

    private void moverBarajaADescarte() {
        Carta carta = baraja.sacarCarta();
        descarte.añadirCarta(carta);
    }

    private void mostrarMenu() {
        System.out.println("=== MENÚ DEL JUEGO ===");
        System.out.println("OPCIONES>");
        System.out.println("  1. Mover de Baraja a Descarte");
        System.out.println("  2. Mover de Descarte a Palo");
        System.out.println("  3. Mover de Descarte a Columna");
        System.out.println("  4. Mover de Palo a Columna");
        System.out.println("  5. Mover de Columna a Palo");
        System.out.println("  6. Mover de Columna a Columna");
        System.out.println("  7. Voltear carta de Columna");
        System.out.println("  8. Voltear Descarte en Baraja");
        System.out.println("  9. Salir\n");

        System.out.print("BARAJA: ");
        if (baraja.estaVacia()) {
            System.out.println("[]");
        } else {
            System.out.println("[? ?]");
        }

        System.out.print("Descarte: ");
        for (Carta carta : baraja.cartasDeDescarte()) {
            System.out.print(carta);
        }
        System.out.println();

        for (int i = 0; i < fundaciones.length; i++) {
            System.out.print((i + 1) + "º Palo: ");
            if (fundaciones[i].estaVacia()) {
                System.out.println("No hay cartas en el palo");
            } else {
                System.out.println(fundaciones[i].cartaSuperior());
            }
        }

        for (int i = 0; i < columnas.length; i++) {
            System.out.print("Columna [" + (i + 1) + "]: ");
            for (Carta carta : columnas[i].cartas()) {
                if (!carta.estaDescubierta()) {
                    System.out.print("[? ?]");
                } else {
                    System.out.print(carta);
                }
            }
            System.out.println();
        }

        System.out.print("\nElige una opción  [1-9]: ");
    }
    

}
