public class Columna {

    private Carta[] cartas;
    private int ultima;
    private int posicion;
    private final int MAXIMO_CARTAS = 19;

    private Console console;

    public Columna(int numeroColumna, Baraja baraja) {
        posicion = numeroColumna;
        ultima = 0;
        cartas = new Carta[MAXIMO_CARTAS];
        for (int i = 0; i < posicion; i++) {
            Carta carta = baraja.sacar();
            if (i == posicion) {
                carta.voltear();
            }
            poner(carta);
        }
        console = new Console();
    }

    public void poner(Carta carta) {
        cartas[ultima] = carta;
        ultima++;
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

        if (this.vacia() && carta.esRey()) {
            return true;
        }

        if (!vacia() && cima().bocaArriba() && cima().distintoColor(carta) && cima().siguiente(carta)) {
            return true;
        }

        return false;
    }

    private Carta sacar() {
        ultima--;
        return cartas[ultima];
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

    public void mostrar() {
        console.write("Columna [" + posicion + "]:");
        if (vacia()) {
            console.write("No hay nada");
        } else {
            for (int i = 0; i < ultima; i++) {
                cartas[i].mostrar();
            }
        }
        console.writeln();
    }

    private boolean vacia() {
        return ultima == 0;
    }
}
