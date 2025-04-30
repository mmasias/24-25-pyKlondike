public class Carta {
    private String valor;
    private PaloCarta palo;
    private boolean visible;

    public Carta(String valor, PaloCarta palo, boolean visible) {
        this.valor = valor;
        this.palo = palo;
        this.visible = visible;
    }