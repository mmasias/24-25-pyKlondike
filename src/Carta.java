
public class Carta {

        private final String[] PALOS = {"Corazones", "Diamates", "Picas", "Treboles"};
        private final String[] VALORES = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        private final String NO_VISIBLE = "?";

        private int palo;
        private int valor;
        private boolean visible;

        public Carta(int palo, int valor) {
                this.palo = palo;
                this.valor = valor;

                visible = false;
        }

        public void voltear() {
                visible = !visible;
        }

        public void mostrar() {
                Consola.mostrar(visible ? parse(VALORES[valor], PALOS[palo]) : parse(NO_VISIBLE, NO_VISIBLE));
        }

        private String parse(String valor, String palo) {
                return "["+valor+" "+palo+"]";
        }

        public int valor() {
                return valor;
        }

        public int palo() {
                return palo;
        }

        public int color() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'color'");
        }

}
