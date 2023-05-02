public class Jugador {
    private int numero;
    private String nombre;
    private int edad;
    private String nacionalidad;
    private int potencial;
    private String club;
    private String liga;
    private int agilidad;
    private String posicion;

    public Jugador(int numero, String nombre, int edad, String nacionalidad, int potencial, String club, String liga,
            int agilidad, String posicion) {
        this.numero = numero;
        this.nombre = nombre;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.potencial = potencial;
        this.club = club;
        this.liga = liga;
        this.agilidad = agilidad;
        this.posicion = posicion;
    }

    public Jugador() {
        numero = 0;
        nombre = "";
        edad = 0;
        nacionalidad = "";
        potencial = 0;
        club = "";
        liga = "";
        agilidad = 0;
        posicion = "";
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public int getPotencial() {
        return potencial;
    }

    public String getClub() {
        return club;
    }

    public String getLiga() {
        return liga;
    }

    public int getAgilidad() {
        return agilidad;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setPotencial(int potencial) {
        this.potencial = potencial;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Jugador [numero=" + numero + ", nombre=" + nombre + ", edad=" + edad + ", nacionalidad=" + nacionalidad
                + ", potencial=" + potencial + ", club=" + club + ", liga=" + liga + ", agilidad=" + agilidad
                + ", posicion=" + posicion + "]";
    }

}