
public class Carta {

    final private int PALO;
    final private int VALOR;
    private boolean visible;

    final String[] palos = {"♥", "♦", "♣", "♠"};
    final String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    public Carta(int palo, int valor) {
        this.PALO = palo;
        this.VALOR = valor;
        this.visible = false;
    }

    public void mostrar() {
        Utilidades utilidades = new Utilidades();
        if (visible) {
            utilidades.imprimir("[" + parsePalo() + " " + parseValor() + "]");
        } else {
            System.out.println("Carta oculta");
        }
    }

    private String parsePalo() {
        return switch (PALO) {
            case 0 -> palos[0];
            case 1 -> palos[1];
            case 2 -> palos[2];
            case 3 -> palos[3];
            default -> "Error";
        };
    }

    public void voltear() {
        visible = !visible;
    }

    private String parseValor() {
        return switch (VALOR) {
            case 0 -> valores[0];
            case 1 -> valores[1];
            case 2 -> valores[2];
            case 3 -> valores[3];
            case 4 -> valores[4];
            case 5 -> valores[5];
            case 6 -> valores[6];
            case 7 -> valores[7];
            case 8 -> valores[8];
            case 9 -> valores[9];
            case 10 -> valores[10];
            case 11 -> valores[11];
            case 12 -> valores[12];
            default -> "Error";
        };
    }

}
