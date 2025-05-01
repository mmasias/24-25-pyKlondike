
public class Klondike {
    private Baraja baraja;
    private Columna[] columna;
    private Palo[] palo;
    private int puntuacion;

    public Klondike(){
        this.baraja = new Baraja();
        this.columna = new Columna[7];
        this.palo = new Palo[4];
        this.puntuacion = 0;
        mostrarMenu();
    }

    private void mostrarMenu() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'menu'");
    }

    public void jugar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'jugar'");
    }
}
