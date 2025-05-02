
public class Carta {

    final private int PALO;
    final private int VALOR;
    private boolean visible;

    final String[] palos = {"♥", "♦", "♣", "♠"};

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
            case 1 -> "A";
            case 11 -> "J";
            case 12 -> "Q";
            case 13 -> "K";
            default -> String.valueOf(VALOR);
        };
    }

}
