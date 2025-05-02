package src.alvaradoCarlos;
public class Columna {

    private Carta[] cartas;

    public Columna(){
        this.cartas = new Carta[0];
    }

    public void agregarCarta(Carta carta) {
        Carta[] nuevoCartas = new Carta[cartas.length + 1];
        for (int i = 0; i < cartas.length; i++) {
            nuevoCartas[i] = cartas[i];
        }
        nuevoCartas[cartas.length] = carta;
        cartas = nuevoCartas;
    }

    public Carta[] cartas() {
        return cartas;
    }
}
