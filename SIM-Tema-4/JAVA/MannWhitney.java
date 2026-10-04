// Tema 4.4.2 - Pruebas no parametricas
// U de Mann-Whitney para dos grupos independientes (n1 = n2 = 10)
import java.util.Random;

public class MannWhitney {
    public static void main(String[] args) {
        Random rnd = new Random(3);
        int n1 = 10, n2 = 10, n = n1 + n2;
        double[] datos = new double[n];
        for (int i = 0; i < n1; i++) datos[i] = 50 + 5 * rnd.nextGaussian();        // grupo A
        for (int i = n1; i < n; i++) datos[i] = 55 + 5 * rnd.nextGaussian();        // grupo B

        // rango de cada dato = 1 + cuantos datos son menores (no hay empates en datos continuos)
        double R1 = 0;
        for (int i = 0; i < n1; i++) {
            int rango = 1;
            for (int j = 0; j < n; j++) if (datos[j] < datos[i]) rango++;
            R1 += rango;
        }

        double U1 = R1 - n1 * (n1 + 1) / 2.0;
        double U2 = (double) n1 * n2 - U1;
        double U = Math.min(U1, U2);

        // Aproximacion normal
        double mediaU = n1 * n2 / 2.0;
        double desvU = Math.sqrt(n1 * n2 * (n1 + n2 + 1) / 12.0);
        double z = (U - mediaU) / desvU;

        System.out.println("U1 = " + U1 + "  U2 = " + U2);
        System.out.println("U = " + U + "  z = " + Math.round(z * 1000) / 1000.0);
        if (Math.abs(z) < 1.96) {
            System.out.println("|z| < 1.96 -> no se rechaza H0: no hay diferencia entre los grupos");
        } else {
            System.out.println("|z| >= 1.96 -> se rechaza H0: los grupos son diferentes");
        }
    }
}
