// Tema 4.2 - Aprendizaje y uso de un lenguaje de simulacion
// Replicas independientes de una simulacion (tiempos de espera exponenciales)
import java.util.Locale;
import java.util.Random;

public class Replicas {
    public static void main(String[] args) {
        Random rnd = new Random(42);
        int replicas = 10, clientes = 20;
        double media = 5;                       // media 5 min
        double[] promedios = new double[replicas];

        for (int r = 0; r < replicas; r++) {
            double suma = 0;
            for (int c = 0; c < clientes; c++) {
                suma += -media * Math.log(1 - rnd.nextDouble());   // exponencial
            }
            promedios[r] = suma / clientes;
        }

        System.out.println("Promedio de cada replica:");
        double total = 0;
        for (int r = 0; r < replicas; r++) {
            System.out.println(String.format(Locale.US, "Replica %2d  %.6f", r + 1, promedios[r]));
            total += promedios[r];
        }
        System.out.println(String.format(Locale.US, "%nPromedio global de las replicas: %.6f", total / replicas));
    }
}
