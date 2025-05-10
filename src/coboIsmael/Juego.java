package coboIsmael;

public class Juego {
    private Baraja baraja;
    private Descarte descarte;
    private Columna[] columnas;
    private Palo[] palos;

    public Juego() {
        baraja = new Baraja();
        descarte = new Descarte();

        columnas = new Columna[7];
        for (int indiceColumna = 0; indiceColumna < columnas.length; indiceColumna++) {
            columnas[indiceColumna] = new Columna();
            for (int fila = 0; fila <= indiceColumna; fila++) {
                Carta carta = baraja.sacarCarta();
                if (fila == indiceColumna) {
                    carta.voltear();
                }
                columnas[indiceColumna].agregarCarta(carta);
            }
        }

        String[] nombresPalos = {"Picas", "Corazones", "Treboles", "Diamantes"};
        palos = new Palo[nombresPalos.length];
        for (int indicePalo = 0; indicePalo < palos.length; indicePalo++) {
            palos[indicePalo] = new Palo(nombresPalos[indicePalo]);
        }
    }

    public boolean moverBarajaADescarte() {
        if (baraja.estaVacia()) {
            return false;
        }
        Carta carta = baraja.sacarCarta();
        if (!carta.estaBocaArriba()) {
            carta.voltear();
        }
        descarte.agregarCarta(carta);
        return true;
    }

    public boolean moverDescarteAPalo() {
        Carta carta = descarte.verCartaSuperior();
        if (carta == null) {
            return false;
        }
        for (Palo fundacion : palos) {
            if (fundacion.getNombrePalo().equalsIgnoreCase(carta.getPalo())
                    && fundacion.colocarCarta(carta)) {
                descarte.sacarCarta();
                return true;
            }
        }
        return false;
    }

    public boolean moverDescarteAColumna(int indiceColumnaDestino) {
        Carta carta = descarte.verCartaSuperior();
        if (carta == null) {
            return false;
        }
        Columna columnaDestino = columnas[indiceColumnaDestino];
        if (columnaDestino.estaVacia()) {
            if (carta.getValor() == 13) {
                descarte.sacarCarta();
                columnaDestino.agregarCarta(carta);
                return true;
            }
            return false;
        }
        Carta cartaTope = columnaDestino.verCartaSuperior();
        if (cartaTope.estaBocaArriba()
                && cartaTope.getValor() == carta.getValor() + 1
                && cartaTope.esRojo() != carta.esRojo()) {
            descarte.sacarCarta();
            columnaDestino.agregarCarta(carta);
            return true;
        }
        return false;
    }

    public boolean moverColumnaAColumna(int indiceColumnaOrigen, int indiceColumnaDestino) {
        Columna columnaOrigen = columnas[indiceColumnaOrigen];
        Columna columnaDestino = columnas[indiceColumnaDestino];
        if (columnaOrigen.estaVacia() || indiceColumnaOrigen == indiceColumnaDestino) {
            return false;
        }
        Carta cartaTopeDestino = columnaDestino.verCartaSuperior();
        int indiceInicioSecuencia = -1;
        for (int indiceCarta = 0; indiceCarta < columnaOrigen.cantidadCartas(); indiceCarta++) {
            Carta cartaActual = columnaOrigen.obtenerCartas()[indiceCarta];
            if (!cartaActual.estaBocaArriba()) {
                continue;
            }
            if (columnaDestino.estaVacia() && cartaActual.getValor() == 13) {
                indiceInicioSecuencia = indiceCarta;
                break;
            }
            if (cartaTopeDestino != null
                    && cartaTopeDestino.getValor() == cartaActual.getValor() + 1
                    && cartaTopeDestino.esRojo() != cartaActual.esRojo()) {
                indiceInicioSecuencia = indiceCarta;
                break;
            }
        }
        if (indiceInicioSecuencia < 0) {
            return false;
        }
        int[] cantidadSecuencia = new int[1];
        Carta[] secuencia = columnaOrigen.sacarSecuenciaDesde(indiceInicioSecuencia, cantidadSecuencia);
        for (int offset = 0; offset < cantidadSecuencia[0]; offset++) {
            Carta cartaMover = secuencia[offset];
            if (!cartaMover.estaBocaArriba()) {
                cartaMover.voltear();
            }
            columnaDestino.agregarCarta(cartaMover);
        }
        columnaOrigen.voltearUltima();
        return true;
    }

    public boolean moverColumnaAPalo(int indiceColumnaOrigen) {
        Columna columnaOrigen = columnas[indiceColumnaOrigen];
        if (columnaOrigen.estaVacia()) {
            return false;
        }
        Carta carta = columnaOrigen.verCartaSuperior();
        if (!carta.estaBocaArriba()) {
            return false;
        }
        for (Palo fundacion : palos) {
            if (fundacion.getNombrePalo().equalsIgnoreCase(carta.getPalo())
                    && fundacion.colocarCarta(carta)) {
                columnaOrigen.sacarCartaSuperior();
                columnaOrigen.voltearUltima();
                return true;
            }
        }
        return false;
    }

    public boolean voltearColumna(int indiceColumna) {
        Columna columna = columnas[indiceColumna];
        if (columna.estaVacia()) {
            return false;
        }
        Carta carta = columna.verCartaSuperior();
        if (carta.estaBocaArriba()) {
            return false;
        }
        carta.voltear();
        return true;
    }

    public boolean reiniciarBaraja() {
        if (!baraja.estaVacia()) {
            return false;
        }
        while (!descarte.estaVacia()) {
            Carta carta = descarte.sacarCarta();
            if (carta.estaBocaArriba()) {
                carta.voltear();
            }
            baraja.agregarCarta(carta);
        }
        return true;
    }

    public boolean victoria() {
        for (Palo fundacion : palos) {
            Carta carta = fundacion.verCartaSuperior();
            if (carta == null || carta.getValor() != 13) {
                return false;
            }
        }
        return true;
    }

    public Baraja obtenerBaraja() {
        return baraja;
    }

    public Descarte obtenerDescarte() {
        return descarte;
    }

    public Columna[] obtenerColumnas() {
        return columnas;
    }

    public Palo[] obtenerPalos() {
        return palos;
    }
}