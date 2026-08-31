import java.util.Arrays;
import java.util.Random;

public class Uniformidad {

    public static void main(String[] args) {
        
        int n = 1000;
        double[] numeros = new double[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            numeros[i] = random.nextDouble();
        }

        int m = (int) Math.ceil(Math.sqrt(n));

       
        double tamanoIntervalo = 1.0 / m;

        int[] observados = new int[m];
        for (double num : numeros) {
            int intervalo = (int) (num / tamanoIntervalo);
            
            if (intervalo == m) {
                intervalo--;
            }
            observados[intervalo]++;
        }
        
        double esperado = (double) n / m;

        double estadisticoChi = 0.0;
        for (int i = 0; i < m; i++) {
            estadisticoChi += Math.pow(observados[i] - esperado, 2) / esperado;
        }

        System.out.println("Estadístico Chi-cuadrado: " + estadisticoChi);
    
        System.out.println("Frecuencias Observadas: " + Arrays.toString(observados));
        System.out.println("Frecuencia Esperada por intervalo: " + esperado);
        
        double valorCritico = 1118.9; 

        if (estadisticoChi < valorCritico) {
            System.out.println("\nConclusión: No hay evidencia para rechazar la hipótesis de que los números siguen una distribución uniforme.");
        } else {
            System.out.println("\nConclusión: Hay evidencia para rechazar la hipótesis de que los números siguen una distribución uniforme.");
        }
    }
}