import java.util.Arrays;
import java.util.Locale;

public class IntroEstadisticas {
    // percentil con interpolacion lineal (igual que pandas y R)
    static double percentil(double[] ordenado, double p) {
        double pos = p * (ordenado.length - 1);
        int i = (int) Math.floor(pos);
        double frac = pos - i;
        if (i + 1 < ordenado.length) return ordenado[i] + frac * (ordenado[i + 1] - ordenado[i]);
        return ordenado[i];
    }

    public static void main(String[] args) {
        String[] clientes = {"C1", "C2", "C3"};
        double[] tiempos = {5, 7, 4};

        System.out.println("Datos de servicio:");
        for (int i = 0; i < clientes.length; i++)
            System.out.println(clientes[i] + "  " + (int) tiempos[i]);

        int n = tiempos.length;
        double suma = 0;
        for (double t : tiempos) suma += t;
        double media = suma / n;
        double ss = 0;
        for (double t : tiempos) ss += (t - media) * (t - media);
        double desv = Math.sqrt(ss / (n - 1));
        double[] ord = tiempos.clone();
        Arrays.sort(ord);

        System.out.println("\nEstadisticas:");
        System.out.println(String.format(Locale.US,
            "count %d%nmean  %.6f%nstd   %.6f%nmin   %.6f%n25%%   %.6f%n50%%   %.6f%n75%%   %.6f%nmax   %.6f",
            n, media, desv, ord[0], percentil(ord, 0.25), percentil(ord, 0.5),
            percentil(ord, 0.75), ord[n - 1]));
    }
}
