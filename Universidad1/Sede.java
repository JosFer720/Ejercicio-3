import java.util.ArrayList;

/**
 * La clase Sede representa una sede universitaria.
 */
class Sede {
    private String nombre; // Nombre de la sede.
    private ArrayList<Estudiante> estudiantes = new ArrayList<>(); // Lista de estudiantes en la sede.

    /**
     * Constructor de la clase Sede.
     *
     * @param nombre El nombre de la sede.
     */
    public Sede(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre de la sede.
     *
     * @return El nombre de la sede.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Agrega un estudiante a la lista de estudiantes de la sede.
     *
     * @param estudiante El estudiante a agregar.
     */
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    /**
     * Obtiene la lista de estudiantes de la sede.
     *
     * @return La lista de estudiantes.
     */
    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}