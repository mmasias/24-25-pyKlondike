# Diagrama Mermaid del Proyecto Klondike

```mermaid
classDiagram
    class Baraja {
        - static final int CARTAS_MAXIMAS = 52
        - Carta[] cartas
        - int ultima
        + Baraja()
        + void barajar()
        + void mostrar()
        - Carta ultima()
        + void moverCarta(Descarte)
        - Carta sacar()
        + void poner(Carta)
        + void moverCarta(Columna)
    }

    class Carta {
        - final String[] PALOS
        - final String[] VALORES
        - final String NO_VISIBLE
        - int palo
        - int valor
        - boolean visible
        + Carta(int, int)
        + void voltear()
        + void mostrar()
        - String parse(String, String)
        + int valor()
        + int palo()
        + int color()
    }

    class Columna {
        - static final int CARTAS_MAXIMAS = 19
        - Carta[] cartas
        - int ultima
        - int[] CARTAS_INICIALES
        + Columna(int, Baraja)
        + void mostrar()
        + void moverCarta(Columna)
        - Carta sacar()
        + void moverCarta(Palo)
        + Carta ultima()
        + boolean verificar(Carta)
        - boolean vacia()
        + void poner(Carta)
    }

    class Descarte {
        - Carta[] cartas
        - int ultima
        - final int CARTAS_VISIBLES
        + void mostrar()
        + void poner(Carta)
        - Carta sacar()
        + Carta ultima()
        + void moverCarta(Columna)
        + void moverCarta(Palo)
        + void vaciarEn(Baraja)
    }

    class Palo {
        - static final int CARTAS_MAXIMAS = 13
        - Carta[] cartas
        - int ultima
        - int palo
        + Palo(int)
        + void mostrar()
        + void moverCarta(Columna)
        - Carta sacar()
        - Carta ultima()
        + void poner(Carta)
        + boolean verificar(Carta)
        - boolean vacia()
    }

    class Menu {
        - final String[] OPCIONES
        + void mostrar()
        + boolean esValida(int)
    }

    class Jugador {
        + int preguntar(Menu)
    }

    class Klondike {
        - Menu menu
        - Jugador jugador
        - Baraja baraja
        - Descarte descarte
        - Palo[] palos
        - Columna[] columnas
        - boolean jugando
        + Klondike()
        - void iniciarBaraja()
        - void iniciarDescarte()
        - void iniciarPalos()
        - void iniciarColumnas()
        + void mostrar()
        + void jugar()
        - void seleccionarOpcion(int)
        - Columna elegirColumna(String)
        - Palo elegirPalo(String)
        - void salir()
    }

    Baraja "1" *-- "*" Carta : contiene
    Columna "1" *-- "*" Carta : contiene
    Descarte "1" *-- "*" Carta : contiene
    Palo "1" *-- "*" Carta : contiene
    Klondike "1" o-- "1" Menu : usa
    Klondike "1" o-- "1" Jugador : usa
    Klondike "1" o-- "1" Baraja : usa
    Klondike "1" o-- "1" Descarte : usa
    Klondike "1" o-- "4" Palo : usa
    Klondike "1" o-- "7" Columna : usa
```

```mermaid
sequenceDiagram
    participant J as Jugador
    participant K as Klondike
    participant M as Menu
    participant B as Baraja
    participant D as Descarte
    participant C as Columna
    participant P as Palo

    J->>K: iniciar juego
    K->>B: iniciarBaraja()
    K->>D: iniciarDescarte()
    K->>P: iniciarPalos()
    K->>C: iniciarColumnas()
    loop mientras jugando
        K->>M: mostrar opciones
        M->>J: mostrar menú
        J->>K: seleccionar opción
        alt opción 1
            K->>B: moverCarta a Descarte
        else opción 2
            K->>D: moverCarta a Palo
        else opción 3
            K->>D: moverCarta a Columna
        else opción 4
            K->>P: moverCarta a Columna
        else opción 5
            K->>C: moverCarta a Palo
        else opción 6
            K->>C: moverCarta a Columna
        else opción 7
            K->>C: voltear carta
        else opción 8
            K->>D: vaciarEn Baraja
        else opción 9
            K->>K: salir()
        end
        K->>K: mostrar estado
    end