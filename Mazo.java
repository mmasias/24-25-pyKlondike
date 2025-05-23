public abstract class Mazo {

    protected Carta[] cartas;
    protected int ultima;
    protected Console console;    
    protected String titulo;

    public Mazo(int numeroDeCartas, String titulo){
        ultima = 0;
        cartas = new Carta[numeroDeCartas];
        console = new Console();        
        this.titulo = titulo;
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

    public void mostrar() {
        console.write(titulo + ": ");
        if (vacia()) {
            console.write("No hay cartas en " + titulo);
        } else {
            mostrarContenido();
        }
        console.writeln();
    }    

    protected abstract void mostrarContenido();
}
