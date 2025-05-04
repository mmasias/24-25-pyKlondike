
public class Carta {

        private final int PALO;
        private final int VALOR;
        private boolean visible;

        final static int CORAZONES = 1, DIAMANTES = 2, TREBOLES = 3, PICAS = 4;
        final static int AS = 1, DOS = 2, TRES = 3, CUATRO = 4, CINCO = 5, SEIS = 6, SIETE = 7, OCHO = 8, NUEVE = 9,
                        DIEZ = 10, J = 11, Q = 12, K = 13;
        final int NEGRO = 1, ROJO = 0;

        public Carta(int palo, int valor) {
                this.PALO = palo;
                this.VALOR = valor;
                this.visible = false;
        }

        public int getPalo() {
                return PALO;
        }

        public int getValor() {
                return VALOR;
        }

        public void voltear() {
                visible = !visible;
        }

        public void mostrar() {
                Utilidades.mostrar(visible ? "[" + parsePalo() + " " + parseValor() + "]" : "[? ?]");
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

        public int getColor() {
                return (PALO == CORAZONES || PALO == DIAMANTES) ? ROJO : NEGRO;
        }

}
