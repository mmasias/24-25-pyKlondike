public class Columna extends Mazo {

    private int posicion;
    private static final int MAXIMO_CARTAS = 19;

    public Columna(int numeroColumna, Baraja baraja) {
        super(MAXIMO_CARTAS, "Columna " + numeroColumna);

        posicion = numeroColumna;
        for (int i = 0; i < posicion; i++) {
            Carta carta = baraja.sacar();
            poner(carta);
        }
        cartas[ultima-1].voltear();
    }

    public void moverA(Columna otraColumna) {
        if(vacia()){
            console.writeln("No se puede!");
        } else {
            Carta carta = sacar();
            if (otraColumna.apilable(carta)) {
                otraColumna.poner(carta);
            } else {
                poner(carta);
                console.writeln("Movimiento no válido");
            }
        }
    }

    public boolean apilable(Carta carta) {
        return vacia() && carta.esRey()
                || 
            !vacia() && cima().bocaArriba() && cima().distintoColor(carta) && cima().siguiente(carta);
    }

    public void moverA(Palo unPalo) {
        if (vacia()) {
            console.writeln("No se puede!");
        } else {
            Carta carta = sacar();
            if (unPalo.apilable(carta)) {
                unPalo.poner(carta);
            } else {
                poner(carta);
                console.writeln("No se puede!");
            }
        }
    }

    public void voltear() {
        if (vacia()) {
            console.writeln("No hay carta por voltear");
        } else if (cima().bocaArriba()) {
            console.writeln("Ya está boca arriba");
        } else {
            cima().voltear();
        }
    }

    private Carta cima() {
        return cartas[ultima - 1];
    }

    @Override
    protected void mostrarContenido(){
        for (int i = 0; i < ultima; i++) {
            cartas[i].mostrar();
        }
    }
}
