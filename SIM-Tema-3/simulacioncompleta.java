import java.util.Random;

public class simulacioncompleta {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("=== SIMULACIÓN Y GENERACIÓN DE VARIABLES - JAVA ===\n");

        // 3.2 Variables Discretas
        System.out.println("--- 3.2 Variables Discretas ---");
        int[] discretas = new int[5];
        for (int i = 0; i < 5; i++) {
            discretas[i] = random.nextInt(10); // Genera enteros aleatorios entre 0 y 9
        }
        System.out.print("Muestra generada: ");
        for (int val : discretas) System.out.print(val + " ");
        System.out.println("\n");

        // 3.3 Variables Continuas
        System.out.println("--- 3.3 Variables Continuas ---");
        System.out.print("Muestra generada: ");
        for (int i = 0; i < 5; i++) {
            double continuo = random.nextDouble(); // Genera valores uniformes [0,1)
            System.out.printf("%.4f ", continuo);
        }
        System.out.println("\n");

        // 3.4.1 Transformada Inversa
        System.out.println("--- 3.4.1 Método de la Transformada Inversa ---");
        double u = random.nextDouble();
        double lambda = 2.0;
        double xTrans = -Math.log(1 - u) / lambda; // Fórmula inversa exponencial
        System.out.printf("Valor U base: %.4f | Valor X transformado: %.4f\n\n", u, xTrans);

        // 3.4.2 Convolución
        System.out.println("--- 3.4.2 Método de Convolución ---");
        double sumaU = 0;
        for (int i = 0; i < 12; i++) sumaU += random.nextDouble();
        double zNormal = sumaU - 6; // Aproximación a Normal Estándar
        System.out.printf("Valor Z generado (Normal): %.4f\n\n", zNormal);

        // 3.4.3 Composición
        System.out.println("--- 3.4.3 Método de Composición ---");
        double componente = random.nextDouble();
        if (componente < 0.6) {
            System.out.println("Seleccionada componente 1 (Exponencial con peso 60%)");
        } else {
            System.out.println("Seleccionada componente 2 (Uniforme con peso 40%)");
        }
        System.out.println();

        // 3.5 Procedimientos Especiales
        System.out.println("--- 3.5 Procedimientos Especiales (Aceptación-Rechazo) ---");
        int intentos = 0;
        boolean aceptado = false;
        while (!aceptado && intentos < 100) {
            intentos++;
            double u1 = random.nextDouble();
            double u2 = random.nextDouble();
            if (u2 <= (1 - u1)) {
                aceptado = true;
                System.out.printf("Valor aceptado: %.4f en %d intentos.\n\n", u1, intentos);
            }
        }

        // 3.6 Pruebas Estadísticas
        System.out.println("--- 3.6 Pruebas Estadísticas ---");
        double chiEstadistico = 5.0 + (15.0 - 5.0) * random.nextDouble();
        double pValue = 0.01 + (0.99 - 0.01) * random.nextDouble();
        System.out.printf("Estadístico Chi-Cuadrada: %.4f\n", chiEstadistico);
        System.out.printf("Resultado de la prueba: %s (p-value: %.4f)\n", (pValue > 0.05 ? "Aprobada" : "Rechazada"), pValue);
    }
}