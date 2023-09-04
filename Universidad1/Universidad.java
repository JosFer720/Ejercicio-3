import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * La clase Universidad representa una institución universitaria que contiene sedes y estudiantes.
 */
public class Universidad {
    private ArrayList<Sede> sedes = new ArrayList<>();

    /**
     * Agrega una sede a la lista de sedes de la universidad.
     *
     * @param sede La sede a agregar.
     */
    public void agregarSede(Sede sede) {
        sedes.add(sede);
    }

    /**
     * Calcula estadísticas generales para todas las sedes, incluyendo promedio, mediana, moda,
     * y desviación estándar de las calificaciones de los estudiantes.
     */
    public void calcularEstadisticas() {
        for (Sede sede : sedes) {
            ArrayList<Double> calificaciones = new ArrayList<>();
            for (Estudiante estudiante : sede.getEstudiantes()) {
                calificaciones.addAll(estudiante.getCalificaciones());
            }

            double promedio = Estadisticas.calcularPromedio(calificaciones);
            double mediana = Estadisticas.calcularMediana(calificaciones);
            double moda = Estadisticas.calcularModa(calificaciones);
            double desviacionEstandar = Estadisticas.calcularDesviacionEstandar(calificaciones);

            System.out.println("Sede: " + sede.getNombre());
            System.out.println("Promedio: " + promedio);
            System.out.println("Mediana: " + mediana);
            System.out.println("Moda: " + moda);
            System.out.println("Desviación Estándar: " + desviacionEstandar);
            System.out.println("Cantidad de estudiantes: " + sede.getEstudiantes().size());
        }
    }

    /**
     * Obtiene las notas más altas y bajas para un examen específico en todas las sedes.
     *
     * @param examen El nombre del examen para el cual se obtienen las notas altas y bajas.
     */
    public void obtenerNotasAltaBaja(String examen) {
        for (Sede sede : sedes) {
            double notaMasAlta = -1;
            double notaMasBaja = Double.MAX_VALUE;

            for (Estudiante estudiante : sede.getEstudiantes()) {
                ArrayList<Double> calificaciones = estudiante.getCalificaciones();

                for (Double calificacion : calificaciones) {
                    if (calificacion > notaMasAlta && examen.equalsIgnoreCase(calificacion.getExamen())) {
                        notaMasAlta = calificacion;
                    }
                    if (calificacion < notaMasBaja && examen.equalsIgnoreCase(calificacion.getExamen())) {
                        notaMasBaja = calificacion;
                    }
                }
            }

            System.out.println("Sede: " + sede.getNombre());
            System.out.println("Examen: " + examen);
            System.out.println("Nota mas alta: " + notaMasAlta);
            System.out.println("Nota mas baja: " + notaMasBaja);
        }
    }

    /**
     * Método principal que ejecuta el programa.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        Universidad universidad = new Universidad();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Agregar sede");
            System.out.println("2. Agregar estudiante");
            System.out.println("3. Calcular estadisticas");
            System.out.println("4. Notas altas y bajas");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la sede: ");
                    String nombreSede = scanner.nextLine();
                    Sede sede = new Sede(nombreSede);
                    universidad.agregarSede(sede);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre: ");
                    String nombreEstudiante = scanner.nextLine();
                    System.out.print("Ingrese el apellido: ");
                    String apellidoEstudiante = scanner.nextLine();
                    System.out.print("Ingrese el código único: ");
                    String codigoUnico = scanner.nextLine();
                    System.out.print("Ingrese la fecha de nacimiento: ");
                    String fechaNacimiento = scanner.nextLine();
                    System.out.print("Ingrese el correo electrónico: ");
                    String correoElectronico = scanner.nextLine();
                    System.out.print("Ingrese el nombre de la sede: ");
                    String nombreSedeEstudiante = scanner.nextLine();
                    Estudiante estudiante = new Estudiante(nombreEstudiante, apellidoEstudiante, codigoUnico, fechaNacimiento, correoElectronico);

                    // Agregar calificaciones manualmente para cada examen.
                    System.out.print("Ingrese la calificacion de Matematica: ");
                    double calificacionMatematica = scanner.nextDouble();
                    estudiante.agregarCalificacion(calificacionMatematica);

                    System.out.print("Ingrese la calificacion de Lenguaje: ");
                    double calificacionLenguaje = scanner.nextDouble();
                    estudiante.agregarCalificacion(calificacionLenguaje);

                    System.out.print("Ingrese la calificacion de Quimica: ");
                    double calificacionQuimica = scanner.nextDouble();
                    estudiante.agregarCalificacion(calificacionQuimica);

                    System.out.print("Ingrese la calificacion de Fisica: ");
                    double calificacionFisica = scanner.nextDouble();
                    estudiante.agregarCalificacion(calificacionFisica);

                    System.out.print("Ingrese la calificacion de Comprension Lectora: ");
                    double calificacionLectora = scanner.nextDouble();
                    estudiante.agregarCalificacion(calificacionLectora);

                    System.out.print("Ingrese la calificacion de Estadistica: ");
                    double calificacionEstadistica = scanner.nextDouble();
                    estudiante.agregarCalificacion(calificacionEstadistica);

                    for (Sede s : universidad.sedes) {
                        if (s.getNombre().equals(nombreSedeEstudiante)) {
                            s.agregarEstudiante(estudiante);
                        }
                    }
                    break;
                case 3:
                    universidad.calcularEstadisticas();
                    break;
                case 4:
                    System.out.print("Ingrese el examen: ");
                    String nombreExamen = scanner.nextLine();
                    universidad.obtenerNotasAltaBaja(nombreExamen);
                    break;
                case 5:
                    System.out.println("Gracias por usar el programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        }
    }
}