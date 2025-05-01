package scr.calderonJimena;

public enum Palo {
    CORAZONES, DIAMANTES, TREBOLES, PICAS;

    public boolean esRojo() {
        return this == CORAZONES || this == DIAMANTES;
    }

    public String simbolo() {
        return switch (this) {
            case CORAZONES -> "♥️";
            case DIAMANTES -> "♦️";
            case TREBOLES -> "♣️";
            case PICAS -> "♠️";
        };
    }
}


