import java.util.ArrayList;

/**
 * La clase Estudiante representa a un estudiante universitario.
 */
public class Estudiante {
    private String nombre; // Nombre del estudiante.
    private String apellido; // Apellido del estudiante.
    private String codigoUnico; // Código único del estudiante.
    private String fechaNacimiento; // Fecha de nacimiento del estudiante.
    private String correoElectronico; // Correo electrónico del estudiante.
    private ArrayList<Double> calificaciones = new ArrayList<>(); // Lista de calificaciones del estudiante.

    /**
     * Constructor de la clase Estudiante.
     *
     * @param nombre           El nombre del estudiante.
     * @param apellido         El apellido del estudiante.
     * @param codigoUnico      El código único del estudiante.
     * @param fechaNacimiento  La fecha de nacimiento del estudiante.
     * @param correoElectronico El correo electrónico del estudiante.
     */
    public Estudiante(String nombre, String apellido, String codigoUnico, String fechaNacimiento, String correoElectronico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoUnico = codigoUnico;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
    }

    /**
     * Agrega una calificación al estudiante.
     *
     * @param calificacion La calificación a agregar.
     */
    public void agregarCalificacion(double calificacion) {
        calificaciones.add(calificacion);
    }

    /**
     * Obtiene la lista de calificaciones del estudiante.
     *
     * @return La lista de calificaciones.
     */
    public ArrayList<Double> getCalificaciones() {
        return calificaciones;
    }

    /**
     * Obtiene el nombre del estudiante.
     *
     * @return El nombre del estudiante.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el apellido del estudiante.
     *
     * @return El apellido del estudiante.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Obtiene el código único del estudiante.
     *
     * @return El código único del estudiante.
     */
    public String getCodigoUnico() {
        return codigoUnico;
    }

    /**
     * Obtiene la fecha de nacimiento del estudiante.
     *
     * @return La fecha de nacimiento del estudiante.
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Obtiene el correo electrónico del estudiante.
     *
     * @return El correo electrónico del estudiante.
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }
}