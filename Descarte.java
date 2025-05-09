public class Descarte {

    private Carta[] cartas;
    private int ultima;
    private Console console;

    public Descarte() {
        ultima = 0;
        final int DICE_JAVIER = 26;
        cartas = new Carta[DICE_JAVIER];
        console = new Console();
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
            console.writeln();
        }
    }

    private boolean vacia() {
        return ultima == 0;
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
            console.writeln("No se puede");
        } else {
            while(!vacia()){
                Carta carta = sacar();
                carta.voltear();
                baraja.poner(carta);
            }
        }
    }

    private Carta sacar() {
        ultima--;
        return cartas[ultima];
    }

    public void poner(Carta carta) {
        cartas[ultima]=carta;
        ultima++;
    }
}
