// Tema 4.1 - Lenguaje de simulacion y simuladores
// Simulacion Monte Carlo: lanzamiento de un dado
import java.util.Arrays;
import java.util.Random;

public class SimularDado {
    static Random rnd = new Random(42);   // semilla fija

    static void simularDado(int n) {
        int[] resultados = new int[n];
        int[] frecuencias = new int[7];
        for (int i = 0; i < n; i++) {
            resultados[i] = rnd.nextInt(6) + 1;   // 1..6
            frecuencias[resultados[i]]++;
        }
        System.out.println("Resultados de " + n + " lanzamientos: " + Arrays.toString(resultados));
        StringBuilder sb = new StringBuilder("Frecuencias: {");
        for (int i = 1; i <= 6; i++) {
            sb.append(i).append(": ").append(frecuencias[i]);
            if (i < 6) sb.append(", ");
        }
        System.out.println(sb.append("}"));
    }

    public static void main(String[] args) {
        simularDado(20);
    }
}
