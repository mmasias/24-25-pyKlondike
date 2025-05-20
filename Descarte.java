public class Descarte extends Mazo {  

    private static final int MAXIMO_CARTAS = 26;

    public Descarte() {
        super(MAXIMO_CARTAS);
    }

    public void mostrar() {
        console.write("Descarte: ");
        if (vacia()) {
            console.write("No hay cartas en el descarte!");
        } else {
            int primeraVisible = ultima - 3;
            if (primeraVisible < 0) {
                primeraVisible = 0;
            }

            for (int i = primeraVisible; i < ultima; i++) {
                cartas[i].mostrar();
            }    
        }
        console.writeln();
    }


    public void moverA(Columna columna) {
        if (vacia()) {
            console.write("No hay cartas en el descarte!");
        } else {
            Carta carta = sacar();
            if (columna.apilable(carta)) {
                columna.poner(carta);
            } else {
                poner(carta);
                console.write("No se puede poner");
            }
        }
    }

    public void moverA(Palo palo) {
        if (vacia()) {
            console.write("No hay cartas en el descarte!");
        } else {
            Carta carta = sacar();
            if (palo.apilable(carta)) {
                palo.poner(carta);
            } else {
                poner(carta);
                console.write("No se puede poner");
            }
        }
    }

    public void voltear(Baraja baraja) {

        if (vacia() || !baraja.vacia()){
            console.writeln("No se puede voltear!!!");
        } else {
            while(!vacia()){
                Carta carta = sacar();
                carta.voltear();
                baraja.poner(carta);
            }
        }
    }
}
