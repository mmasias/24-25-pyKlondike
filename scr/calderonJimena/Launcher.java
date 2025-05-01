package scr.calderonJimena;

public class Launcher {
    public static void main(String[] args) {
        Klondike juego = new Klondike();
        Menu menu = new Menu(juego);
        menu.mostrar();
    }
}

