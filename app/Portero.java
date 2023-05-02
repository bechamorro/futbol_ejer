public class Portero extends Jugador {
    private int diving;
    private int handling;

    public Portero(int numero, String nombre, int edad, String nacionalidad, int potencia, String club, String liga,
            int agilidad, int diving, int handling) {
        super(numero, nombre, edad, nacionalidad, potencia, club, liga, agilidad, "GK");
        this.diving = diving;
        this.handling = handling;
    }

    public int getDiving() {
        return diving;
    }

    public int getHandling() {
        return handling;
    }

    public void setDiving(int diving) {
        this.diving = diving;
    }

    public void setHandling(int handling) {
        this.handling = handling;
    }

    @Override
    public String toString() {
        return "Portero [diving=" + diving + ", handling=" + handling + "]";
    }
}