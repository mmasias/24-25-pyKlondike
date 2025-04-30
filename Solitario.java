import java.util.*;

public class Solitario {
    private Mazo baraja;
    private Stack<Carta> descarte;
    private Stack<Carta>[] palos;
    private Stack<Carta>[] columnas;

    public Solitario() {
        baraja = new Mazo();
        descarte = new Stack<>();
        palos = new Stack[4];
        columnas = new Stack[7];
        for (int i = 0; i < 4; i++) palos[i] = new Stack<>();
        for (int i = 0; i < 7; i++) columnas[i] = new Stack<>();
        repartirColumnas();
    }

    private void repartirColumnas() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j <= i; j++) {
                Carta c = baraja.sacar();
                if (j == i) c.voltear();
                columnas[i].push(c);
            }
        }
    }

    public void mostrarEstado() {
        System.out.println("\nOPCIONES>");
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
        System.out.println(baraja.estaVacio() ? "No hay cartas" : "[? ?][? ?]");

        System.out.print("Descarte: ");
        if (descarte.isEmpty()) System.out.println("No hay cartas");
        else {
            for (Carta c : descarte) System.out.print(c.mostrar());
            System.out.println();
        }

        for (int i = 0; i < 4; i++) {
            System.out.print((i + 1) + "º Palo: ");
            if (palos[i].isEmpty()) System.out.println("No hay cartas en el palo");
            else System.out.println(palos[i].peek().mostrar());
        }

        for (int i = 0; i < 7; i++) {
            System.out.print("Columna [" + (i + 1) + "]: ");
            for (Carta c : columnas[i]) {
                System.out.print(c.mostrar());
            }
            System.out.println();
        }

        System.out.print("\nElige una opción  [1-9]: ");
    }

    public void moverBarajaADescarte() {
        if (!baraja.estaVacio()) {
            Carta c = baraja.sacar();
            c.voltear();
            descarte.push(c);
        } else {
            System.out.println("La baraja está vacía.");
        }
    }

    public void moverDescarteAPalo() {
        if (descarte.isEmpty()) {
            System.out.println("No hay cartas en el descarte.");
            return;
        }

        Carta carta = descarte.peek();
        for (int i = 0; i < palos.length; i++) {
            if (puedePonerEnPalo(carta, palos[i])) {
                palos[i].push(descarte.pop());
                System.out.println("Carta movida al palo " + (i + 1));
                return;
            }
        }
        System.out.println("No se puede mover la carta al palo.");
    }

    public void moverColumnaAColumna(int origen, int destino) {
        if (origen < 1 || origen > 7 || destino < 1 || destino > 7) {
            System.out.println("Número de columna inválido.");
            return;
        }

        Stack<Carta> colOrigen = columnas[origen - 1];
        Stack<Carta> colDestino = columnas[destino - 1];

        if (colOrigen.isEmpty()) {
            System.out.println("Columna de origen vacía.");
            return;
        }

        Carta carta = colOrigen.peek();

        if (!carta.estaBocaArriba()) {
            System.out.println("La carta superior está boca abajo.");
            return;
        }

        if (colDestino.isEmpty() || puedeApilarEnColumna(carta, colDestino.peek())) {
            colDestino.push(colOrigen.pop());
            System.out.println("Carta movida de columna " + origen + " a columna " + destino);
        } else {
            System.out.println("Movimiento inválido.");
        }
    }

    public void voltearColumna(int columna) {
        if (columna < 1 || columna > 7) {
            System.out.println("Columna inválida.");
            return;
        }

        Stack<Carta> col = columnas[columna - 1];
        if (!col.isEmpty() && !col.peek().estaBocaArriba()) {
            col.peek().voltear();
            System.out.println("Carta volteada.");
        } else {
            System.out.println("No se puede voltear.");
        }
    }

    private boolean puedePonerEnPalo(Carta carta, Stack<Carta> palo) {
        if (palo.isEmpty()) {
            return carta.getValor().equals("A");
        }

        Carta cima = palo.peek();
        return carta.getPalo().equals(cima.getPalo()) &&
               siguienteValor(cima.getValor()).equals(carta.getValor());
    }

    private boolean puedeApilarEnColumna(Carta mover, Carta destino) {
        return mover.esRojo() != destino.esRojo() &&
               valorComoNumero(mover.getValor()) + 1 == valorComoNumero(destino.getValor());
    }

    private int valorComoNumero(String valor) {
        switch (valor) {
            case "A": return 1;
            case "2": return 2;
            case "3": return 3;
            case "4": return 4;
            case "5": return 5;
            case "6": return 6;
            case "7": return 7;
            case "8": return 8;
            case "9": return 9;
            case "10": return 10;
            case "J": return 11;
            case "Q": return 12;
            case "K": return 13;
            default: return 0;
        }
    }

    private String siguienteValor(String valor) {
        switch (valor) {
            case "A": return "2";
            case "2": return "3";
            case "3": return "4";
            case "4": return "5";
            case "5": return "6";
            case "6": return "7";
            case "7": return "8";
            case "8": return "9";
            case "9": return "10";
            case "10": return "J";
            case "J": return "Q";
            case "Q": return "K";
            default: return "";
        }
    }
}
