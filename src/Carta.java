
public class Carta {

        private final int PALO;
        private final int VALOR;
        private boolean visible;

        public Carta(int palo, int valor) {
                this.PALO = palo;
                this.VALOR = valor;
                this.visible = false;
        }

        public int getPALO() {
                return PALO;
        }

        public int getVALOR() {
                return VALOR;
        }

        public void voltear() {
                visible = !visible;
        }

        public void mostrar() {
                System.out.println(visible ? "[" + parsePalo() + " " + parseValor() + "]" : "[? ?]");
        }

        private String parseValor() {
                final String[] valores = { "As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
                return valores[VALOR - 1];

        }

        private String parsePalo() {
                final String[] palos = { "Corazones", "Diamantes", "Tréboles", "Picas" };
                return palos[PALO - 1];
        }

        public void setVisible(boolean valor) {
                this.visible = valor;
        }

}
