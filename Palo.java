
public class Palo extends Mazo {

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


    public boolean apilable(Carta carta) {
        return vacia() && carta.esAs() 
        
        || 

        !vacia() && carta.igualPalo(cima()) && carta.siguiente(cima());
    }
}
