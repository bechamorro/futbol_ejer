public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private int puntuacion;

    public Partido(Equipo equipo1, Equipo equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void jugar() {
        int valorLocal = valorEquipo(equipo1);
        int valorVisitante = valorEquipo(equipo2);

        if (valorLocal > valorVisitante) {
            equipo1.ganarPartido();
            equipo2.perderPartido();
            setPuntuacion(valorLocal);
            System.out.println(
                    "El equipo local " + equipo1.getNombre() + " gana al equipo visitante " + equipo2.getNombre());
        } else if (valorLocal < valorVisitante) {
            equipo2.ganarPartido();
            equipo1.perderPartido();
            setPuntuacion(valorVisitante);
            System.out.println(
                    "El equipo visitante " + equipo2.getNombre() + " gana al equipo local " + equipo1.getNombre());
        } else {
            System.out.println("Empate entre el equipo local " + equipo1.getNombre() + " y el equipo visitante "
                    + equipo2.getNombre());
            setPuntuacion(valorVisitante);
        }
    }

    private int valorEquipo(Equipo equipo) {

        int valorPortero = equipo.getMediaPortero();
        int valorEquipo = equipo.getMediaEquipo();
        if (valorPortero > 85) {
            valorEquipo += valorPortero * 2;
        } else {
            valorEquipo += valorPortero;
        }

        return valorEquipo;
    }
}
