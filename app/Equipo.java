import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombre;
    private List<Jugador> jugadores;
    private int dinero;
    private int partidosGanados;
    private int partidosPerdidos;
    private int clasificacion;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
        this.dinero = 100_000_000;
        clasificacion = 0;
        partidosGanados = 0;
        partidosPerdidos = 0;
    }

    public void añadirJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void eliminarJugador(Jugador jugador) {
        jugadores.remove(jugador);
    }

    public void comprarJugador(Jugador jugador, int precio) {
        if (dinero >= precio) {
            añadirJugador(jugador);
            dinero -= precio;
        }
    }

    public void venderJugador(Jugador jugador, int precio, Equipo equipo2) {
        if (jugadores.contains(jugador)) {
            eliminarJugador(jugador);
            equipo2.añadirJugador(jugador);
            dinero += precio;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public int getDinero() {
        return dinero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public int getClasificacion() {
        return clasificacion;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public int getMediaPortero() {
        int media = 0;
        int contador = 0;
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getPosicion() == "GK") {
                media = media + jugadores.get(i).getPotencial();
                contador++;
            }
        }
        int solucion = 0;
        if (contador > 0) {
            solucion = media / contador;
        }
        return solucion;
    }

    public int getMediaEquipo() {
        int media = 0;
        int contador = 0;
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getPosicion() != "GK") {
                media = media + jugadores.get(i).getPotencial();
                contador++;
            }
        }
        int solucion = 0;
        if (contador > 0) {
            solucion = media / contador;
        }
        return solucion;
    }

    public void ganarPartido() {
        this.dinero += 100000; // aumenta el dinero en 100.000
        this.partidosGanados++; // aumenta el número de partidos ganados
        this.clasificacion += 3; // aumenta la clasificación en 3 puntos
    }

    public void perderPartido() {
        this.partidosPerdidos++;
        this.dinero -= 100000;
    }

}