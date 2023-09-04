import java.util.ArrayList;
import java.util.Collections;

/**
 * La clase Estadisticas proporciona métodos para calcular estadísticas básicas
 * como el promedio, la mediana, la moda y la desviación estándar de un conjunto de datos.
 */
public class Estadisticas {
    
    /**
     * Calcula el promedio de un conjunto de datos.
     *
     * @param datos La lista de datos de la que se calculará el promedio.
     * @return El valor del promedio.
     */
    public static double calcularPromedio(ArrayList<Double> datos) {
        if (datos.isEmpty()) {
            return 0.0;
        }

        double suma = 0;
        for (double dato : datos) {
            suma += dato;
        }

        return suma / datos.size();
    }

    /**
     * Calcula la mediana de un conjunto de datos.
     *
     * @param datos La lista de datos de la que se calculará la mediana.
     * @return El valor de la mediana.
     */
    public static double calcularMediana(ArrayList<Double> datos) {
        if (datos.isEmpty()) {
            return 0.0;
        }

        Collections.sort(datos);

        int n = datos.size();
        if (n % 2 == 0) {
            int medio1 = n / 2 - 1;
            int medio2 = n / 2;
            return (datos.get(medio1) + datos.get(medio2)) / 2.0;
        } else {
            int medio = n / 2;
            return datos.get(medio);
        }
    }

    /**
     * Calcula la moda de un conjunto de datos.
     *
     * @param datos La lista de datos de la que se calculará la moda.
     * @return El valor de la moda.
     */
    public static double calcularModa(ArrayList<Double> datos) {
        if (datos.isEmpty()) {
            return 0.0;
        }

        Collections.sort(datos);

        double moda = 0.0;
        double modaActual = 0.0;
        int frecuencia = 0;
        int frecuenciaMaxima = 0;

        for (int i = 0; i < datos.size(); i++) {
            if (i == 0 || datos.get(i) != datos.get(i - 1)) {
                frecuencia = 1;
            } else {
                frecuencia++;
            }

            if (frecuencia > frecuenciaMaxima) {
                frecuenciaMaxima = frecuencia;
                moda = datos.get(i);
            }
        }

        return moda;
    }

    /**
     * Calcula la desviación estándar de un conjunto de datos.
     *
     * @param datos La lista de datos de la que se calculará la desviación estándar.
     * @return El valor de la desviación estándar.
     */
    public static double calcularDesviacionEstandar(ArrayList<Double> datos) {
        if (datos.isEmpty()) {
            return 0.0;
        }

        double promedio = calcularPromedio(datos);
        double sumaCuadrados = 0;

        for (double dato : datos) {
            sumaCuadrados += Math.pow(dato - promedio, 2);
        }

        double varianza = sumaCuadrados / datos.size();
        return Math.sqrt(varianza);
    }
}