
public class Fundacion {

    private Palo palo;
    private Carta[] cartas;

    public Fundacion(Palo palo){
        this.palo = palo;
        this.cartas = new Carta[13];
    }

    public int numeroCartas() {
        return cartas.length;
    }

    public boolean estaVacia() {
        if (cartas == null || cartas.length == 0){
            return true;
        } else {
            return false;
        }
    }

    public Carta cartaSuperior() {
        for (int i = cartas.length - 1; i >= 0; i--) {
            if (cartas[i] != null) {
                return cartas[i];
            }
        }
        return null;
    }

}
