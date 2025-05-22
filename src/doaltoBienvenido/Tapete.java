package doaltoBienvenido;

public class Tapete {

    private Baraja baraja;
    private Descarte descarte;
    private Palo[] palos;
    private Columna[] columnas;
    private Mensajes mensaje;

    private final int NUM_PALOS = 4;
    private final int NUM_COLUMNAS = 7;

    public Tapete() {
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
            boolean cartaColocada = false;
            int i = 0;
            while (i < NUM_PALOS && !cartaColocada) {
                if (palos[i].puedeAgregar(carta)) {
                    palos[i].agregarCarta(carta);
                    mensaje.mostrarMensajeLn("Carta movida de descarte a palo: " + carta);
                    cartaColocada = true;
                }
                i++;
            }
            if (!cartaColocada) {
                descarte.agregarCarta(carta);
                mensaje.mostrarMensajeLn("No se pudo mover la carta al palo.");
            }
        } else {
            mensaje.mostrarMensajeLn("No hay cartas en el descarte.");
        }
    }

    public void moverDescarteAColumna() {
        if (descarte.tieneCartas()) {
            Carta carta = descarte.sacarCarta();
            boolean cartaColocada = false;
            int i = 0;
            while (i < NUM_COLUMNAS && !cartaColocada) {
                if (columnas[i].puedeAgregar(carta)) {
                    columnas[i].agregarCarta(carta);
                    mensaje.mostrarMensajeLn("Carta movida de descarte a columna: " + carta);
                    cartaColocada = true;
                }
                i++;
            }
            if (!cartaColocada) {
                descarte.agregarCarta(carta);
                mensaje.mostrarMensajeLn("No se pudo mover la carta a la columna.");
            }
        } else {
            mensaje.mostrarMensajeLn("No hay cartas en el descarte.");
        }
    }

    public void moverPaloAColumna() {
        boolean cartaMovida = false;
        int i = 0;
        while (i < NUM_PALOS && !cartaMovida) {
            if (palos[i].tieneCartas()) {
                Carta carta = palos[i].extraerCarta();
                int j = 0;
                while (j < NUM_COLUMNAS && !cartaMovida) {
                    if (columnas[j].puedeAgregar(carta)) {
                        columnas[j].agregarCarta(carta);
                        mensaje.mostrarMensajeLn("Carta movida de palo a columna: " + carta);
                        cartaMovida = true;
                    }
                    j++;
                }
                if (!cartaMovida) {
                    palos[i].agregarCarta(carta);
                }
            }
            i++;
        }
        if (!cartaMovida) {
            mensaje.mostrarMensajeLn("No se pudo mover la carta de palo a columna.");
        }
    }

    public void moverColumnaAPalo() {
        boolean cartaMovida = false;
        int i = 0;
        while (i < NUM_COLUMNAS && !cartaMovida) {
            if (columnas[i].tieneCartas()) {
                Carta carta = columnas[i].extraerCarta();
                int j = 0;
                while (j < NUM_PALOS && !cartaMovida) {
                    if (palos[j].puedeAgregar(carta)) {
                        palos[j].agregarCarta(carta);
                        mensaje.mostrarMensajeLn("Carta movida de columna a palo: " + carta);
                        cartaMovida = true;
                    }
                    j++;
                }
                if (!cartaMovida) {
                    columnas[i].agregarCarta(carta);
                }
            }
            i++;
        }
        if (!cartaMovida) {
            mensaje.mostrarMensajeLn("No se pudo mover la carta de columna a palo.");
        }
    }

    public void moverColumnaAColumna() {
        boolean cartaMovida = false;
        int i = 0;
        while (i < NUM_COLUMNAS && !cartaMovida) {
            if (columnas[i].tieneCartas()) {
                Carta carta = columnas[i].extraerCarta();
                int j = 0;
                while (j < NUM_COLUMNAS && !cartaMovida) {
                    if (i != j && columnas[j].puedeAgregar(carta)) {
                        columnas[j].agregarCarta(carta);
                        mensaje.mostrarMensajeLn("Carta movida de columna a columna: " + carta);
                        cartaMovida = true;
                    }
                    j++;
                }
                if (!cartaMovida) {
                    columnas[i].agregarCarta(carta);
                }
            }
            i++;
        }
        if (!cartaMovida) {
            mensaje.mostrarMensajeLn("No se pudo mover la carta de columna a columna.");
        }
    }

    public void darVueltaCartaColumna() {
        int i = 0;
        boolean dadaVuelta = false;
        while (i < NUM_COLUMNAS && !dadaVuelta) {
            if (columnas[i].tieneCartas()) {
                dadaVuelta = columnas[i].darVueltaCarta();
                if (dadaVuelta) {
                    mensaje.mostrarMensajeLn("Carta dada la vuelta en la columna [" + (i + 1) + "]");
                }
            }
            i++;
        }
        if (!dadaVuelta) {
            mensaje.mostrarMensajeLn("No se pudo dar la vuelta a ninguna carta.");
        }
    }

    public void darVueltaDescarteEnBaraja() {
        if (descarte.tieneCartas()) {
            Carta carta = descarte.sacarCarta();
            baraja.agregarCarta(carta);
            mensaje.mostrarMensajeLn("Carta dada la vuelta del descarte a la baraja: " + carta);
        } else {
            mensaje.mostrarMensajeLn("No hay cartas en el descarte.");
        }
    }
}
