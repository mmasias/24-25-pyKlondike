import java.util.Scanner;

public class Klondike {
    private Baraja baraja;
    private Columna[] columnas;
    private Palo[] palos;
    private int puntuacion;
    private Scanner scanner;
    private Descarte descarte;

    public Klondike() {
        this.baraja = new Baraja();
        this.columnas = new Columna[7];
        this.palos = new Palo[4];
        this.descarte = new Descarte();
        this.puntuacion = 0;
        this.scanner = new Scanner(System.in);
    
        inicializarColumnas();
        inicializarPalos();
        prepararBaraja();
    }

    public void jugar() {
        while (!haGanado()) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();
            procesarOpcion(opcion);
        }
    }

    private boolean haGanado() {
        for (Palo palo : palos) {
            if (palo.numeroCartas() < 13) {
                return false;
            }
        }
        return true;
    }
    

    private void inicializarColumnas() {
        for (int i = 0; i < columnas.length; i++) {
            columnas[i] = new Columna();
        }
    }

    private void inicializarPalos(){
        for (int i = 0; i < palos.length; i++) {
            palos[i] = new Palo();
        }
    }

    private void prepararBaraja(){
        baraja.mezclar();
        baraja.repartir(columnas);
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> moverBarajaADescarte();
            case 2 -> moverDescarteAPalo();
            case 3 -> moverDescarteAColumna();
            case 4 -> moverPaloAColumna();
            case 5 -> moverColumnaAFundacion();
            case 6 -> moverColumnaAColumna();
            case 7 -> voltearCartaColumna();
            case 8 -> voltearDescarte();
            case 9 -> System.exit(0);
            default -> System.out.println("Opción no válida.");
        }
    }
    

    private void moverBarajaADescarte() {
        Carta carta = baraja.sacarCarta();
        descarte.añadir(carta);
    }

    private void mostrarMenu() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'menu'");
    }

}
