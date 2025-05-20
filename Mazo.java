public class Mazo {

    protected Carta[] cartas;
    protected int ultima;
    protected Console console;    

    public Mazo(int numeroDeCartas){
        ultima = 0;
        cartas = new Carta[numeroDeCartas];
        console = new Console();        
    }
    
    public void poner(Carta carta) {
        cartas[ultima]=carta;
        ultima++;
    }

    public boolean vacia() {
        return ultima ==0;
    }
    
    public Carta sacar() {
        ultima--;
        return cartas[ultima];
    }    
}
