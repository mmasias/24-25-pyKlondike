public enum PaloCarta {
    CORAZONES("♥️"),
    DIAMANTES("♦️"),
    PICAS("♠️"),
    TREBOLES("♣️");

    private String simbolo;

    PaloCarta(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }
}