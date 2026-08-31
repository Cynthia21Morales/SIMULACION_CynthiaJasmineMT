import java.util.Random;

public class independencia {

    public static void main(String[] args) {
        
        int n = 1000;
        double[] numeros = new double[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            numeros[i] = rand.nextDouble();
        }

        int[] signos = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            if (numeros[i + 1] > numeros[i]) {
                signos[i] = 1; 
            } else {
                signos[i] = -1; 
            }
        }

        int r = 1;
        for (int i = 0; i < n - 2; i++) {
            if (signos[i] != signos[i + 1]) {
                r++;
            }
        }
        
        double esperada = (2.0 * n - 1.0) / 3.0;
        double varianza = (16.0 * n - 29.0) / 90.0;
        
        double z = (r - esperada) / Math.sqrt(varianza);

        System.out.println("Número de rachas (R): " + r);
        System.out.println("Número esperado de rachas (E[R]): " + esperada);
        System.out.println("Varianza de las rachas (Var[R]): " + varianza);
        System.out.println("Estadístico Z: " + z);

        if (z > 1.96 || z < -1.96) {
            System.out.println("\nConclusión: Se rechaza la hipótesis de independencia.");
        } else {
            System.out.println("\nConclusión: No hay evidencia para rechazar la hipótesis de independencia. La secuencia parece ser independiente.");
        }
    }
}