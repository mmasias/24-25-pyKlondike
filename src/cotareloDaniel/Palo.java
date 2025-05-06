public class Palo {
    private Carta[] cartas;
    private int cantidad;

    public Palo() {
        cartas = new Carta[13];
        cantidad = 0;
    }

    public boolean agregarCarta(Carta nuevaCarta) {
        boolean seAgrego;
        seAgrego = false;

        if (cantidad == 0) {
            if (nuevaCarta.obtenerValor().equals("A")) {
                cartas[0] = nuevaCarta;
                cantidad = 1;
                seAgrego = true;
            }
        } else {
            Carta ultima;
            ultima = cartas[cantidad - 1];

            if (ultima.obtenerPalo().equals(nuevaCarta.obtenerPalo())) {
                int valorUltima;
                int valorNueva;
                valorUltima = obtenerValorNumerico(ultima.obtenerValor());
                valorNueva = obtenerValorNumerico(nuevaCarta.obtenerValor());

                if (valorNueva == valorUltima + 1) {
                    cartas[cantidad] = nuevaCarta;
                    cantidad = cantidad + 1;
                    seAgrego = true;
                }
            }
        }

        return seAgrego;
    }

    public int obtenerValorNumerico(String valor) {
        int numero;
        numero = 0;

        switch (valor) {
            case "A":
                numero = 1;
                break;
            case "2":
                numero = 2;
                break;
            case "3":
                numero = 3;
                break;
            case "4":
                numero = 4;
                break;
            case "5":
                numero = 5;
                break;
            case "6":
                numero = 6;
                break;
            case "7":
                numero = 7;
                break;
            case "8":
                numero = 8;
                break;
            case "9":
                numero = 9;
                break;
            case "10":
                numero = 10;
                break;
            case "J":
                numero = 11;
                break;
            case "Q":
                numero = 12;
                break;
            case "K":
                numero = 13;
                break;
        }

        return numero;
    }

    public String mostrar() {
        String texto;
        if (cantidad == 0) {
            texto = "No hay cartas en el palo";
        } else {
            texto = cartas[cantidad - 1].mostrar();
        }
        return texto;
    }
}
