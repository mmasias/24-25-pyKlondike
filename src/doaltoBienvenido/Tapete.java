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

        for (int i = 0; i < NUM_PALOS; i++) {
            palos[i] = new Palo();
        }
        for (int i = 0; i < NUM_COLUMNAS; i++) {
            columnas[i] = new Columna();
        }
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

    public void repartirCartasIniciales() {
        for (int i = 0; i < columnas.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (baraja.tieneCartas()) {
                    Carta carta = baraja.sacarCarta();
                    if (j == i) {
                        carta.darVuelta();
                    }
                    columnas[i].agregarCarta(carta);
                }
            }
        }
    }

    public void moverBarajaADescarte() {
        if (baraja.tieneCartas()) {
            Carta carta = baraja.sacarCarta();
            descarte.agregarCarta(carta);
            mensaje.mostrarMensajeLn("Carta movida de la baraja al descarte: " + carta);
        } else {
            mensaje.mostrarMensajeLn("No hay cartas en la baraja.");
        }
    }

    public void moverDescarteAPalo() {
        if (descarte.tieneCartas()) {
            Carta carta = descarte.sacarCarta();
            boolean colocado = false;
            for (int i = 0; i < NUM_PALOS; i++) {
                if (palos[i].puedeAgregar(carta)) {
                    palos[i].agregarCarta(carta);
                    mensaje.mostrarMensajeLn("Carta movida de descarte a palo: " + carta);
                    colocado = true;
                    break;
                }
            }
            if (!colocado) {
                mensaje.mostrarMensajeLn("No se pudo mover la carta al palo.");
            }
        } else {
            mensaje.mostrarMensajeLn("No hay cartas en el descarte.");
        }
    }

    public void moverDescarteAColumna() {
        if (descarte.tieneCartas()) {
            Carta carta = descarte.sacarCarta();
            boolean colocado = false;
            for (int i = 0; i < NUM_COLUMNAS; i++) {
                if (columnas[i].puedeAgregar(carta)) {
                    columnas[i].agregarCarta(carta);
                    mensaje.mostrarMensajeLn("Carta movida de descarte a columna: " + carta);
                    colocado = true;
                    break;
                }
            }
            if (!colocado) {
                mensaje.mostrarMensajeLn("No se pudo mover la carta a la columna.");
            }
        } else {
            mensaje.mostrarMensajeLn("No hay cartas en el descarte.");
        }
    }

    public void moverPaloAColumna() {
        boolean movido = false;
        for (int i = 0; i < NUM_PALOS; i++) {
            if (palos[i].tieneCartas()) {
                Carta carta = palos[i].extraerCarta();
                for (int j = 0; j < NUM_COLUMNAS; j++) {
                    if (columnas[j].puedeAgregar(carta)) {
                        columnas[j].agregarCarta(carta);
                        mensaje.mostrarMensajeLn("Carta movida de palo a columna: " + carta);
                        movido = true;
                        break;
                    }
                }
                if (movido) {
                    break;
                }
            }
        }
        if (!movido) {
            mensaje.mostrarMensajeLn("No se pudo mover la carta de palo a columna.");
        }
    }

    public void moverColumnaAPalo() {
        boolean movido = false;
        for (int i = 0; i < NUM_COLUMNAS; i++) {
            if (columnas[i].tieneCartas()) {
                Carta carta = columnas[i].extraerCarta();
                for (int j = 0; j < NUM_PALOS; j++) {
                    if (palos[j].puedeAgregar(carta)) {
                        palos[j].agregarCarta(carta);
                        mensaje.mostrarMensajeLn("Carta movida de columna a palo: " + carta);
                        movido = true;
                        break;
                    }
                }
                if (movido) {
                    break;
                }
            }
        }
        if (!movido) {
            mensaje.mostrarMensajeLn("No se pudo mover la carta de columna a palo.");
        }
    }

    public void moverColumnaAColumna() {
        boolean movido = false;
        for (int i = 0; i < NUM_COLUMNAS; i++) {
            if (columnas[i].tieneCartas()) {
                Carta carta = columnas[i].extraerCarta();
                for (int j = 0; j < NUM_COLUMNAS; j++) {
                    if (i != j && columnas[j].puedeAgregar(carta)) {
                        columnas[j].agregarCarta(carta);
                        mensaje.mostrarMensajeLn("Carta movida de columna a columna: " + carta);
                        movido = true;
                        break;
                    }
                }
                if (movido) {
                    break;
                }
            }
        }
        if (!movido) {
            mensaje.mostrarMensajeLn("No se pudo mover la carta de columna a columna.");
        }
    }

    public void darVueltaCartaColumna() {
        for (int i = 0; i < NUM_COLUMNAS; i++) {
            if (columnas[i].tieneCartas()) {
                columnas[i].darVueltaCarta();
                mensaje.mostrarMensajeLn("Carta volteada en la columna [" + (i + 1) + "]");
                break;
            }
        }
    }

    public void darVueltaDescarteEnBaraja() {
        if (descarte.tieneCartas()) {
            Carta carta = descarte.sacarCarta();
            baraja.agregarCarta(carta);
            mensaje.mostrarMensajeLn("Carta volteada del descarte a la baraja: " + carta);
        } else {
            mensaje.mostrarMensajeLn("No hay cartas en el descarte.");
        }
    }
}
