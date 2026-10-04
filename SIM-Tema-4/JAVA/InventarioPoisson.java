// Tema 4.3.2 - Problemas con sistemas de inventarios
// Inventario a 30 dias con demanda Poisson y politica de reorden
import java.util.Locale;
import java.util.Random;

public class InventarioPoisson {
    // Poisson por el metodo de Knuth
    static int poisson(Random rnd, double lambda) {
        double L = Math.exp(-lambda), p = 1.0;
        int k = 0;
        do {
            k++;
            p *= rnd.nextDouble();
        } while (p > L);
        return k - 1;
    }

    public static void main(String[] args) {
        Random rnd = new Random(2025);
        int dias = 30;
        int inv = 50;
        double suma = 0;

        System.out.println("Dia  Demanda  Inventario");
        for (int d = 1; d <= dias; d++) {
            int demanda = poisson(rnd, 3);
            inv -= demanda;
            if (inv < 10) {          // politica de reorden: si baja de 10, se piden 40
                inv += 40;
            }
            suma += inv;
            System.out.println(String.format("%3d  %7d  %10d", d, demanda, inv));
        }
        System.out.println(String.format(Locale.US, "%nInventario promedio: %.2f", suma / dias));
    }
}
