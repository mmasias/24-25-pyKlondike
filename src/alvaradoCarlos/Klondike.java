package src.alvaradoCarlos;

import java.util.Scanner;

public class Klondike {

    private final int NUM_COLUMNAS = 7;
    private final int NUM_FUNDACIONES = 4;

    private Baraja baraja;
    private Columna[] columnas;
    private Fundacion[] fundaciones;
    private Scanner scanner;
    private Descarte descarte;

    public Klondike() {
        this.baraja = new Baraja();
        this.columnas = new Columna[NUM_COLUMNAS];
        this.fundaciones = new Fundacion[NUM_FUNDACIONES];
        this.descarte = new Descarte();
        this.scanner = new Scanner(System.in);

        inicializarColumnas();
        inicializarFundaciones();
        prepararBaraja();
    }

    public void jugar() {
        boolean juegoActivo = true;
        System.out.println("¡Bienvenido a Klondike!");
        while (juegoActivo) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();
            procesarOpcion(opcion);
        }
        System.out.println("¡Juego terminado!");
    }

    private void inicializarColumnas() {
        for (int i = 0; i < NUM_COLUMNAS; i++) {
            columnas[i] = new Columna();
        }
    }

    private void inicializarFundaciones() {
        Palo[] palos = baraja.obtenerPalos();
        for (int i = 0; i < NUM_FUNDACIONES; i++) {
            fundaciones[i] = new Fundacion(palos[i]);
        }
    }

    private void prepararBaraja() {
        baraja.mezclar();
        baraja.repartir(columnas);

        for (Columna columna : columnas) {
            Carta[] cartas = columna.cartas();
            if (cartas.length > 0) {
                columna.cartaSuperior().voltear();
            }
        }
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 ->
                moverBarajaADescarte();
            case 2 ->
                moverDescarteAPalo();
            case 9 ->
                System.exit(0);
            default ->
                System.out.println("Opción no válida.");
        }
    }
    
    private void moverBarajaADescarte() {
        Carta carta = baraja.sacarCarta();
    
        if (carta == null) {
            if (descarte.estaVacio()) {
                System.out.println("No hay más cartas en la baraja ni en el descarte.");
                return;
            }
    
            System.out.println("La baraja está vacía. Moviendo cartas del descarte a la baraja...");
            Carta[] cartasDescarte = descarte.obtenerCartas();
            for (Carta cartaDescarte : cartasDescarte) {
                baraja.agregarCarta(cartaDescarte);
            }
            descarte.vaciar();
            System.out.println("Cartas del descarte movidas a la baraja y mezcladas.");
            return;
        }
    
        carta.voltear();
        descarte.añadirCarta(carta);
        System.out.println("Carta movida al descarte: " + carta);
    }
    
    private void moverDescarteAPalo() {
        Carta carta = descarte.sacarCarta();
    
        if (carta == null) {
            System.out.println("No hay más cartas en el descarte.");
            return;
        }
    
        System.out.print("Elige un palo [1-" + NUM_FUNDACIONES + "]: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
    
        if (opcion < 1 || opcion > NUM_FUNDACIONES) {
            System.out.println("Número de palo inválido. Selección cancelada.");
            descarte.añadirCarta(carta);
            return;
        }
    
        Fundacion fundacion = fundaciones[opcion - 1];
    
        if (puedeMoverAFundacion(carta, fundacion)) {
            fundacion.agregarCarta(carta);
            System.out.println("Carta movida al palo: " + carta);
        } else {
            System.out.println("Movimiento inválido. La carta no puede ser movida al palo.");
            descarte.añadirCarta(carta);
        }
    }

    private boolean puedeMoverAFundacion(Carta carta, Fundacion fundacion) {
        if (fundacion.estaVacia()){
            return carta.valor() == 1;
        }

        Carta cartaSuperior = fundacion.cartaSuperior();

        return carta.palo().equals(cartaSuperior.palo()) && carta.valor() == cartaSuperior.valor() + 1;
    }

    private Columna escogerColumna() {
        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion >= 1 && opcion <= NUM_COLUMNAS){
            return columnas[opcion - 1];
        } else {
            System.out.println("Numero de columna inválido. Selección cancelada");
            return null;
        }
    }

    private void mostrarMenu() {
        System.out.println("=== MENÚ DEL JUEGO ===");

        mostrarOpciones();
        mostrarBaraja();
        mostrarDescarte();
        mostrarFundaciones();
        mostrarColumnas();

        System.out.print("\nElige una opción  [1-9]: ");
    }

    private void mostrarOpciones() {
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
    }

    private void mostrarBaraja() {
        System.out.print("BARAJA: ");
        if (baraja.estaVacia()) {
            System.out.println("[]");
        } else {
            System.out.println("[? ?]");
        }
    }

    private void mostrarDescarte() {
        System.out.print("Descarte: ");
        Carta cartaSuperior = descarte.cartaSuperior();
    
        if (cartaSuperior == null) {
            System.out.println("[]");
        } else {
            System.out.println(cartaSuperior);
        }
    }

    private void mostrarFundaciones() {
        for (int i = 0; i < NUM_FUNDACIONES; i++) {
            System.out.print((i + 1) + "º Palo: ");
            if (fundaciones[i].estaVacia()) {
                System.out.println("No hay cartas en el palo");
            } else {
                System.out.println(fundaciones[i].cartaSuperior());
            }
        }
    }

    private void mostrarColumnas() {
        for (int i = 0; i < NUM_COLUMNAS; i++) {
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
    }
}
