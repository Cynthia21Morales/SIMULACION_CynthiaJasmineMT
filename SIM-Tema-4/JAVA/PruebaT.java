// Tema 4.4.1 - Pruebas parametricas
// Prueba t de una muestra: H0: mu = 50
import java.util.Random;

public class PruebaT {
    public static void main(String[] args) {
        Random rnd = new Random(1);
        int n = 30;
        double[] datos = new double[n];
        for (int i = 0; i < n; i++) datos[i] = 50 + 5 * rnd.nextGaussian();   // Normal(50, 5)

        double suma = 0;
        for (double d : datos) suma += d;
        double mediaMuestral = suma / n;
        double mediaHipotesis = 50;
        double ss = 0;
        for (double d : datos) ss += (d - mediaMuestral) * (d - mediaMuestral);
        double desv = Math.sqrt(ss / (n - 1));           // desviacion muestral

        double t = (mediaMuestral - mediaHipotesis) / (desv / Math.sqrt(n));
        double tCritico = 2.045;     // alfa = 0.05 a dos colas, gl = 29

        System.out.println("Media de los datos: " + mediaMuestral);
        System.out.println("Estadistico t: " + t);
        System.out.println("Valor critico (gl = 29, alfa = 0.05): " + tCritico);

        System.out.println("\nInterpretacion:");
        if (Math.abs(t) < tCritico) {
            System.out.println("|t| < valor critico -> no se rechaza H0: no hay diferencia significativa");
        } else {
            System.out.println("|t| >= valor critico -> se rechaza H0: hay diferencia significativa");
        }
    }
}
