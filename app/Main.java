import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear jugadores
        List<Jugador> jugadores = new ArrayList<>();
        String csvFile = "C:/Users/bchamorro/Desktop/STEMDO - Beatriz/Organizacion - CLASE/Semana2/principio principio/principio principio/ejercicio2/FIFA_18_Players2.csv";
        String line = "";
        String cvsSplitBy = ";";
        int lineCount = 0;

        List<String[]> csvList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if (lineCount > 0) {
                    String[] values = line.split(cvsSplitBy);
                    csvList.add(values);
                }
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Realizar operaciones con la lista de datos CSV
        for (String[] row : csvList) {
            System.out.println(row[0] + " " + row[1] + " " + row[2] + " " + row[3] + " " + row[5] + " " + row[6] + " "
                    + row[7] + " "
                    + row[14] + " " + row[46]);
            Jugador n = new Jugador(Integer.parseInt(row[0]), row[1], Integer.parseInt(row[2]), row[3],
                    Integer.parseInt(row[5]), row[6], row[8], Integer.parseInt(row[14]), row[46]);
            jugadores.add(n);
            n.toString();
        }
        // Crear equipos
        Scanner sc = new Scanner(System.in);
        Equipo equipo1;
        Equipo equipo2;
        int contador_jugadores_equipo1 = 0;
        int contador_jugadores_equipo2 = 0;
        System.out.println("¿Quieres jugar con equipos nuevos o con equipos ya creados? nuevo/creado");
        String respuesta = sc.nextLine();
        if (respuesta.equals("creado")) {
            equipo1 = new Equipo("Arsenal");
            equipo2 = new Equipo("Boca Juniors");
            for (int i = 0; i < jugadores.size(); i++) {
                if (jugadores.get(i).getClub().equals(equipo1.getNombre()) && contador_jugadores_equipo1 < 11) {
                    equipo1.añadirJugador(jugadores.get(i));
                    jugadores.remove(jugadores.get(i));
                    contador_jugadores_equipo1++;
                }
                if (jugadores.get(i).getClub().equals(equipo2.getNombre()) && contador_jugadores_equipo2 < 11) {
                    equipo2.añadirJugador(jugadores.get(i));
                    jugadores.remove(jugadores.get(i));
                    contador_jugadores_equipo2++;
                }

            }
        } else {
            System.out.println("Introduce el nombre del equipo 1:");
            String nom_equipo1 = sc.nextLine();
            System.out.println("Introduce el nombre del equipo 2:");
            String nom_equipo2 = sc.nextLine();

            equipo1 = new Equipo(nom_equipo1);
            equipo2 = new Equipo(nom_equipo2);
            Random random = new Random();

            while (contador_jugadores_equipo1 < 11 || contador_jugadores_equipo2 < 11) {
                int numeroAleatorio = random.nextInt(jugadores.size() - 1);

                if (contador_jugadores_equipo1 < 11) {
                    equipo1.añadirJugador(jugadores.get(numeroAleatorio));
                    jugadores.remove(jugadores.get(numeroAleatorio));
                    contador_jugadores_equipo1++;
                }
                if (contador_jugadores_equipo2 < 11) {
                    equipo2.añadirJugador(jugadores.get(numeroAleatorio));
                    jugadores.remove(jugadores.get(numeroAleatorio));
                    contador_jugadores_equipo2++;
                }

            }
        }

        if (contador_jugadores_equipo1 == 0 || contador_jugadores_equipo2 == 0) {
            System.out.println("Debes elegir otros equipos alguno no existe");
        } else {
            Random random = new Random();
            int numeroAleatorio = random.nextInt(jugadores.size() - 1);
            Jugador jugadorTraspaso = jugadores.get(numeroAleatorio);
            equipo1.venderJugador(jugadorTraspaso, 50000000, equipo2);
            System.out.println("Después del traspaso:");
            System.out
                    .println(
                            "++++++++++++++++++++++++++++++++++++++++++EQUIPO 1++++++++++++++++++++++++++++++++++++++++");
            System.out.println(equipo1.getJugadores());
            System.out
                    .println(
                            "++++++++++++++++++++++++++++++++++++++++++EQUIPO 2++++++++++++++++++++++++++++++++++++++++");
            System.out.println(equipo2.getJugadores());
            // Jugar un partido
            System.out.println("Resultado del partido:");
            Partido partido = new Partido(equipo1, equipo2);
            partido.jugar();
            System.out.println(partido.getPuntuacion());
            // Actualizar el dinero de los equipos
            System.out.println("Dinero después del partido:");
            System.out.println(equipo1.getNombre() + ": " + equipo1.getDinero());
            System.out.println(equipo2.getNombre() + ": " + equipo2.getDinero());
        }
    }

}
