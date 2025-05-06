
public class Carta {

        private final String[] PALOS = {"Corazones", "Diamates", "Picas", "Treboles"};
        private final String[] VALORES = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

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

}
