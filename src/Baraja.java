
public class Baraja {

        private static final int CARTAS_MAXIMAS = 52;
        private Carta[] cartas = new Carta[CARTAS_MAXIMAS];
        private int ultima = -1;

        public Baraja() {
                for (int palo = 1; palo <= 4; palo++) {
                        for (int valor = 1; valor <= 13; valor++) {
                                Carta carta = new Carta(palo, valor);
                                ultima++;
                                cartas[ultima] = carta;
                        }
                }
        }

        public void barajar() {
                for (int index = 0; index < cartas.length; index++) {
                        int aleatorio = (int) (Math.random() * cartas.length);
                        Carta carta = cartas[index];
                        cartas[index] = cartas[aleatorio];
                        cartas[aleatorio] = carta;
                }
        }

        public void mostrar() {
                Consola.mostrar("Baraja: ");
                if (!vacia()) ultima().mostrar(); else Consola.mostrar("Baraja vacia");
                Consola.saltarLinea();
        }

        private boolean vacia() {
                return ultima == -1;
        }

        private Carta ultima() {
                return cartas[ultima];
        }

        public void moverCarta(Descarte descarte) {
        	for (int i = 0; i < 3; i++) {
        		if (!descarte.estaLleno() && !vacia()) {
        			descarte.poner(sacar());
        		}
        	}
        }

        public Carta sacar() {
        	assert !vacia() : "No se puede sacar carta de baraja vacía";
        	Carta carta = ultima();
        	ultima--;
        	carta.voltear();
        	return carta;
        }

        public void poner(Carta carta) {
                assert ultima < cartas.length - 1 : "Baraja llena, no se puede añadir más cartas";
                ultima++;
                cartas[ultima] = carta;
        }

        public void moverCarta(Columna columna) {
                if (columna.verificar(ultima())) columna.poner(sacar());
        }

}
