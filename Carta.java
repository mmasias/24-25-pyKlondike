public class Carta {
    private String valor;
    private String palo;
    private boolean bocaArriba;

    public Carta(String valor, String palo) {
        this.valor = valor;
        this.palo = palo;
        this.bocaArriba = false;
    }

    public void voltear() {
        bocaArriba = !bocaArriba;
    }

    public boolean estaBocaArriba() {
        return bocaArriba;
    }

    public String mostrar() {
        return bocaArriba ? "[" + valor + " " + palo + "]" : "[? ?]";
    }

    public String getValor() {
        return valor;
    }

    public String getPalo() {
        return palo;
    }

    public boolean esRojo() {
        return palo.equals("♥️") || palo.equals("♦️");
    }
}
