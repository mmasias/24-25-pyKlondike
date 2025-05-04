
public class Carta {

        private int palo;
        private int valor;
        private boolean visible;

        public Carta(int palo, int valor) {
                this.palo = palo;
                this.valor = valor;
                this.visible = false;
        }

        public int getPalo() {
                return palo;
        }

        public int getValor() {
                return valor;
        }

        public void voltear() {
                visible = !visible;
        }

        public void mostrar() {
                System.out.println(visible ? "[" + parsePalo() + " " + parseValor() + "]" : "[? ?]");
        }

        private String parseValor() {
                final String[] valores = { "As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
                return valores[valor - 1];

        }

        private String parsePalo() {
                final String[] palos = { "Corazones", "Diamantes", "Tréboles", "Picas" };
                return palos[palo - 1];
        }

        public void setVisible(boolean valor) {
                this.visible = valor;
        }

}
