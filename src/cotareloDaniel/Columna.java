public class Columna {
    private Carta[] cartas;
    private int cantidad;

    public Columna() {
        cartas = new Carta[20];
        cantidad = 0;
    }

    public void agregarCarta(Carta nuevaCarta) {
        cartas[cantidad] = nuevaCarta;
        cantidad = cantidad + 1;
    }

    public void voltearUltimaCarta() {
        if (cantidad > 0) {
            Carta ultimaCarta;
            ultimaCarta = cartas[cantidad - 1];
            ultimaCarta.voltear();
        }
    }

    public String mostrar() {
        String texto;
        texto = "";
        int i;
        for (i = 0; i < cantidad; i++) {
            texto = texto + cartas[i].mostrar();
        }
        return texto;
    }
}
