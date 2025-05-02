
public class Baraja {



    private Carta[] cartas;

    private final int PALOS = 4;
    private final int NUMEROS = 13;
    private final int TOTAL_CARTAS = 52;

    public Baraja(){

        cartas = new Carta[TOTAL_CARTAS];
        for (int palo=0;palo<PALOS, palo++){
            for(int numero=0;numero<NUMEROS;numero++)
            poner(new Carta(palo, numero))
        }
    }

    public void moverA(Descarte descarte) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moverA'");
    }

    public void mostrar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrar'");
    }

}
