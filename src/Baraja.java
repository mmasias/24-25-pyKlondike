
public class Baraja {

        private static final int CARTAS_MAXIMAS = 52;
        private Carta[] cartas = new Carta[CARTAS_MAXIMAS];
        private int ultima = 0;

        public Baraja() {
                for (int palo = 1; palo <= 4; palo++) {
                        for (int valor = 1; valor <= 13; valor++) {
                                cartas[palo*valor] = new Carta(palo-1, valor-1);
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
                ultima().mostrar();
        }

        private Carta ultima() {
                return cartas[ultima];
        }

        public void moverCarta(Descarte descarte) {
                for (int i = 0; i < 3; i++) descarte.poner(sacar());
        }

        private Carta sacar() {
                Carta carta = ultima();
                ultima--;
                carta.voltear();
                return carta;
        }

        public void poner(Carta carta) {
                ultima++;
                cartas[ultima] = carta;
        }

        public void moverCarta(Columna columna) {
                if (columna.verificar(ultima())) columna.poner(sacar());
        }

}
