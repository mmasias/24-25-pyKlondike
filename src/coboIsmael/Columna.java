package coboIsmael;

public class Columna {
    private Carta[] cartas;
    private int cantidadCartas;

    public Columna() {
        cartas = new Carta[52];
        cantidadCartas = 0;
    }

    public boolean estaVacia() {
        return cantidadCartas == 0;
    }

    public void agregarCarta(Carta cartaNueva) {
        if (cantidadCartas < cartas.length) {
            cartas[cantidadCartas++] = cartaNueva;
        }
    }

    public Carta verCartaSuperior() {
        if (cantidadCartas == 0) {
            return null;
        }
        return cartas[cantidadCartas - 1];
    }

    public Carta sacarCartaSuperior() {
        if (cantidadCartas == 0) {
            return null;
        }
        return cartas[--cantidadCartas];
    }

    public Carta[] sacarSecuenciaDesde(int indiceOrigen, int[] cantidadSecuencia) {
        if (indiceOrigen < 0 || indiceOrigen >= cantidadCartas) {
            cantidadSecuencia[0] = 0;
            return null;
        }
        int numeroAMover = cantidadCartas - indiceOrigen;
        Carta[] secuencia = new Carta[numeroAMover];
        for (int indiceSecuencia = 0; indiceSecuencia < numeroAMover; indiceSecuencia++) {
            secuencia[indiceSecuencia] = cartas[indiceOrigen + indiceSecuencia];
        }
        cantidadCartas = indiceOrigen;
        cantidadSecuencia[0] = numeroAMover;
        return secuencia;
    }

    public void agregarSecuencia(Carta[] secuencia, int cantidadSecuencia) {
        for (int indiceSecuencia = 0; indiceSecuencia < cantidadSecuencia; indiceSecuencia++) {
            if (cantidadCartas < cartas.length) {
                cartas[cantidadCartas++] = secuencia[indiceSecuencia];
            }
        }
    }

    public void voltearUltima() {
        if (cantidadCartas > 0) {
            Carta cartaUltima = cartas[cantidadCartas - 1];
            if (!cartaUltima.estaBocaArriba()) {
                cartaUltima.voltear();
            }
        }
    }

    public Carta[] obtenerCartas() {
        return cartas;
    }

    public int cantidadCartas() {
        return cantidadCartas;
    }
}
