package doaltoBienvenido;

public class Tapete {
    
    private Baraja baraja;
    private Descarte descarte;
    private Palo[] palos;
    private Columna[] columnas;
    private Mensajes mensaje;
    
    private final int NUM_PALOS = 4;
    private final int NUM_COLUMNAS = 7;

    public Tapete(){
        baraja = new Baraja();
        descarte = new Descarte();
        palos = new Palo[NUM_PALOS];
        columnas = new Columna[NUM_COLUMNAS];
        mensaje = new Mensajes();
    }

    public void mostrar() {
        mensaje.mostrarMensajeLn("BARAJA: " + baraja);
        mensaje.mostrarMensajeLn("Descarte: " + descarte);
        for (int i = 0; i < NUM_PALOS; i++) {
            mensaje.mostrarMensaje((i + 1) + "º Palo: ");
            if (palos[i] != null) {
                System.out.println(palos[i]);
            } else {
                mensaje.mostrarMensajeLn("No hay cartas en el palo");
            }
        }
        for (int i = 0; i < NUM_COLUMNAS; i++) {
            mensaje.mostrarMensaje("Columna [" + (i + 1) + "]: ");
            if (columnas[i] != null) {
                System.out.println(columnas[i]);
            } else {
                mensaje.mostrarMensajeLn("Columna Vacia");
            }
        }
    }

    public void moverBarajaADescarte() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moverBarajaADescarte'");
    }

    public void moverDescarteAPalo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moverDescarteAPalo'");
    }

    public void moverPaloAColumna() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moverPaloAColumna'");
    }

    public void moverColumnaAPalo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moverColumnaAPalo'");
    }

    public void darVueltaCartaColumna() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'darVueltaCartaColumna'");
    }

    public void darVueltaDescarteEnBaraja() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'darVueltaDescarteEnBaraja'");
    }

}
