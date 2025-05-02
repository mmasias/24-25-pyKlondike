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

    public String denominacion(){
        return denominacion;
    }

    public String toString(){
        return simbolo;
    }

}
