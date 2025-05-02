import java.util.Scanner;

public class Klondike {
    private Baraja baraja = new Baraja();
    private Descarte descarte = new Descarte();
    private Palo[] palo = new Palo[4];
    private Columna[] columna = new Columna[7];

    public void ejecutar() {
        inicializarEjemplo();
        Scanner scanner = new Scanner(System.in);
        boolean jugando = true;

        while (jugando) {
            mostrarEstado();
            mostrarMenu();

            System.out.print("Elige una opción [1-9]: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                baraja.voltear(descarte);
            } else if (opcion == 2) {
                System.out.println("Mover de Descarte a Palo (no implementado aún).");
            } else if (opcion == 3) {
                if (descarte.estaVacio()) {
                    System.out.println("No hay cartas en el descarte.");
                } else {
                    System.out.print("¿A qué columna deseas mover la carta? [1-7]: ");
                    int col = scanner.nextInt();
                    scanner.nextLine();
                    if (col >= 1 && col <= 7) {
                        Carta carta = descarte.quitarUltima();
                        columna[col - 1].agregar(carta);
                        System.out.println("Carta movida a la columna " + col + ".");
                    } else {
                        System.out.println("Columna inválida.");
                    }
                }
            } else if (opcion == 4) {
                System.out.println("Mover de Palo a Columna (no implementado aún).");
            } else if (opcion == 5) {
                System.out.println("Mover de Columna a Palo (no implementado aún).");
            } else if (opcion == 6) {
                System.out.println("Mover de Columna a Columna (no implementado aún).");
            } else if (opcion == 7) {
                System.out.println("Voltear carta de Columna (no implementado aún).");
            } else if (opcion == 8) {
                baraja.reiniciarDesdeDescarte(descarte);
            } else if (opcion == 9) {
                System.out.println("Gracias por jugar.");
                jugando = false;
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }

    private void mostrarEstado() {
        System.out.println("BARAJA: " + baraja);
        System.out.println("Descarte: " + descarte);
        for (int i = 0; i < 4; i++) {
            System.out.print((i + 1) + "º Palo: ");
            if (palo[i] != null) {
                System.out.println(palo[i]);
            } else {
                System.out.println("No hay cartas en el palo");
            }
        }
        for (int i = 0; i < 7; i++) {
            System.out.print("Columna [" + (i + 1) + "]: ");
            if (columna[i] != null) {
                System.out.println(columna[i]);
            } else {
                System.out.println("Vacía");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("OPCIONES>");
        System.out.println("  1. Mover de Baraja a Descarte");
        System.out.println("  2. Mover de Descarte a Palo");
        System.out.println("  3. Mover de Descarte a Columna");
        System.out.println("  4. Mover de Palo a Columna");
        System.out.println("  5. Mover de Columna a Palo");
        System.out.println("  6. Mover de Columna a Columna");
        System.out.println("  7. Voltear carta de Columna");
        System.out.println("  8. Voltear Descarte en Baraja");
        System.out.println("  9. Salir");
    }

    private void inicializarEjemplo() {
    
    String[] valores = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
    PaloCarta[] palos = { PaloCarta.CORAZONES, PaloCarta.DIAMANTES, PaloCarta.TREBOLES, PaloCarta.PICAS };
    Carta[] todasLasCartas = new Carta[52];
    int index = 0;

    for (int i = 0; i < valores.length; i++) {
        for (int j = 0; j < palos.length; j++) {
            todasLasCartas[index++] = new Carta(valores[i], palos[j], false);
        }
    }

    
    mezclarCartas(todasLasCartas);

    
    for (int i = 0; i < todasLasCartas.length; i++) {
        baraja.agregar(todasLasCartas[i]);
    }

    
    for (int i = 0; i < 4; i++) {
        palo[i] = new Palo();
    }

    for (int i = 0; i < 7; i++) {
        columna[i] = new Columna();
    }

    
    columna[0].agregar(new Carta("3", PaloCarta.PICAS, true));
    columna[1].agregar(new Carta("K", PaloCarta.CORAZONES, true));
    }

    private void mezclarCartas(Carta[] cartas) {
    for (int i = cartas.length - 1; i > 0; i--) {
        int j = (int)(Math.random() * (i + 1));
        Carta temp = cartas[i];
        cartas[i] = cartas[j];
        cartas[j] = temp;
    }
}

    public static void main(String[] args) {
        new Klondike().ejecutar();
    }
}
