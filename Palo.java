public class Palo extends Mazo {

    private static final int MAXIMO_CARTAS = 13;

    public Palo() {
        super(MAXIMO_CARTAS, "Palo");
    }

    public void moverA(Columna unaColumna) {
        if (vacia()) {
            console.writeln("No se puede");
        } else {
            Carta carta = sacar();
            if (unaColumna.apilable(carta)) {
                unaColumna.poner(carta);
            } else {
                poner(carta);
                console.writeln("Movimiento inválido!");
            }
        }
    }

    @Override
    protected void mostrarContenido(){
        Carta carta = cima();
        carta.mostrar();
    }

    private Carta cima() {
        return cartas[ultima - 1];
    }

    public boolean apilable(Carta carta) {
        return vacia() && carta.esAs()
                ||
                !vacia() && carta.igualPalo(cima()) && carta.siguiente(cima());
    }
}
