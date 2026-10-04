
// Tema 4.4.1 - Pruebas parametricas (validacion de datos simulados)
// Se valida que la media de tiempos de espera simulados coincida con la teorica (20 min)
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class ValidacionT {
    static double percentil(double[] ordenado, double p) {
        double pos = p * (ordenado.length - 1);
        int i = (int) Math.floor(pos);
        double frac = pos - i;
        if (i + 1 < ordenado.length) return ordenado[i] + frac * (ordenado[i + 1] - ordenado[i]);
        return ordenado[i];
    }

    public static void main(String[] args) {
        Random rnd = new Random(1);
        int n = 30;
        double[] tiempos = new double[n];
        for (int i = 0; i < n; i++) tiempos[i] = 20 + 2 * rnd.nextGaussian();   // Normal(20, 2)

        double suma = 0;
        for (double t : tiempos) suma += t;
        double media = suma / n;
        double ss = 0;
        for (double t : tiempos) ss += (t - media) * (t - media);
        double std = Math.sqrt(ss / (n - 1));
        double[] ord = tiempos.clone();
        Arrays.sort(ord);

        System.out.println(String.format(Locale.US,
            "count %d%nmean  %.6f%nstd   %.6f%nmin   %.6f%n25%%   %.6f%n50%%   %.6f%n75%%   %.6f%nmax   %.6f",
            n, media, std, ord[0], percentil(ord, 0.25), percentil(ord, 0.5),
            percentil(ord, 0.75), ord[n - 1]));

        double muTeorica = 20;
        double t = (media - muTeorica) / (std / Math.sqrt(n));
        double tCritico = 2.045;   // gl = 29, alfa = 0.05, dos colas

        System.out.println(String.format(Locale.US, "t=%.3f  (valor critico = %s)", t, tCritico));
        if (Math.abs(t) < tCritico) {
            System.out.println("No se rechaza H0: el simulador reproduce la media teorica");
        } else {
            System.out.println("Se rechaza H0: el simulador NO reproduce la media teorica");
        }
    }
}
