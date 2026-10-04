// Tema 4.4.2 - Pruebas no parametricas
// Prueba de la mediana: ji-cuadrada sobre la tabla 2x2 (grupo x arriba/abajo de la mediana)
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class PruebaMediana {
    public static void main(String[] args) {
        Random rnd = new Random(42);
        int[] grupoA = new int[15], grupoB = new int[15];
        for (int i = 0; i < 15; i++) grupoA[i] = rnd.nextInt(10) + 1;   // 1..10
        for (int i = 0; i < 15; i++) grupoB[i] = rnd.nextInt(10) + 1;

        int[] todos = new int[30];
        System.arraycopy(grupoA, 0, todos, 0, 15);
        System.arraycopy(grupoB, 0, todos, 15, 15);
        int[] ord = todos.clone();
        Arrays.sort(ord);
        double mediana = (ord[14] + ord[15]) / 2.0;      // 30 datos: promedio de los dos centrales
        System.out.println("Mediana global: " + mediana);

        int menoresA = 0, menoresB = 0;
        for (int v : grupoA) if (v < mediana) menoresA++;
        for (int v : grupoB) if (v < mediana) menoresB++;
        int mayoresA = 15 - menoresA, mayoresB = 15 - menoresB;

        System.out.println("\nGrupo A -> menores: " + menoresA + "  mayores o iguales: " + mayoresA);
        System.out.println("Grupo B -> menores: " + menoresB + "  mayores o iguales: " + mayoresB);

        // Ji-cuadrada
        int[][] tabla = {{menoresA, mayoresA}, {menoresB, mayoresB}};
        double total = 30, chi2 = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                double esperado = (tabla[i][0] + tabla[i][1]) * (double) (tabla[0][j] + tabla[1][j]) / total;
                chi2 += Math.pow(tabla[i][j] - esperado, 2) / esperado;
            }
        }

        System.out.println(String.format(Locale.US,
            "%nJi-cuadrada = %.3f  (valor critico gl=1, alfa=0.05: 3.841)", chi2));
        if (chi2 < 3.841) {
            System.out.println("No se rechaza H0: ambos grupos tienen la misma mediana");
        } else {
            System.out.println("Se rechaza H0: las medianas son diferentes");
        }
    }
}
