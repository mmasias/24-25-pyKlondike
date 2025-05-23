class Blackjack {

    private Baraja baraja;
    private Mano mano;
    private Console console;

    public Blackjack() {
        baraja = new Baraja();
        mano = new Mano(baraja);
        console = new Console();
    }

    public void jugar() {
        boolean estaJugando = true;
        do {
            console.clearScreen();
            mano.mostrar();
            mostrarMenu();
            switch (console.readInt("Elija una opción: ")) {
                case 1:
                    if (!mano.haGanado() && !mano.haPerdido()) {
                        mano.pedir(baraja);
                    }
                    break;
                case 2:
                    baraja = new Baraja();
                    mano = new Mano(baraja);
                    break;
                case 3:
                    estaJugando = false;
                    break;
            }
        } while (estaJugando);
    }

    private void mostrarMenu() {
        console.writeln("1. Pedir");
        console.writeln("2. Empezar de nuevo");
        console.writeln("3. Salir");
    }
}
