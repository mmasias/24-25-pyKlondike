
public class Palo {

    private Carta[] cartas;
    private int ultima;
    Console console;

    public Palo() {
        ultima = 0;
        cartas = new Carta[13];
        console = new Console();
    }

    public void moverA(Columna unaColumna) {
        if (vacia()) {
            console.writeln("No se puede");
        } else {
            Carta carta = sacar();
            if(unaColumna.apilable(carta)){
                unaColumna.poner(carta);
            } else {
                poner(carta);
                console.writeln("Movimiento inválido!");
            }
        }
    }

    private Carta sacar() {
        ultima--;
        return cartas[ultima];
    }

    public void mostrar() {
        console.write("Palo: ");
        if(vacia()){
            console.write("No hay cartas en el palo");
        } else {
            Carta carta = cima();
            carta.mostrar();    
        }
        console.writeln();
    }

    private Carta cima() {
        return cartas[ultima -1];
    }

    private boolean vacia() {
        return ultima ==0;
    }

    public boolean apilable(Carta carta) {

        return vacia() && carta.esAs() || 
        !vacia() && carta.igualPalo(this.cima()) && carta.siguiente(cima());
    }

    public void poner(Carta carta) {
        cartas[ultima] = carta;
        ultima++;
    }
}