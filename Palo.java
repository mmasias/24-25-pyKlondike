public class Palo {

    private String denominacion;
    private String simbolo;

    public Palo(String denominacion, String simbolo) {
        this.denominacion = denominacion;
        this.simbolo = simbolo;
    }

    public String simbolo(){
        return simbolo;
    }

    

    public String toString(){
        if (denominacion == "Corazones"){
            return "♥️";
        } else if (denominacion == "Diamantes"){
            return "♦️";
        } else if (denominacion == "Tréboles"){
            return "♣️";
        } else if (denominacion == "Picas") {
            return "♠️";
        } else {
            return null;
        }
    }

}
