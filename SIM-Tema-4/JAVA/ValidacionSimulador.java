// Tema 4.4 - Validacion de un simulador
// Compara el resultado del simulador contra un valor real (valorReal es un dato de ejemplo)
import java.util.Locale;
import java.util.Random;

public class ValidacionSimulador {
    static Random rnd = new Random(9);

    static int simulador(int dias) {
        int inventario = 50;
        for (int i = 0; i < dias; i++) {
            inventario -= rnd.nextInt(11) + 5;
            if (inventario < 20) inventario += 40;
        }
        return inventario;
    }

    public static void main(String[] args) {
        double valorReal = 45;
        double tolerancia = 5;

        int resultadoSim = simulador(10);
        System.out.println("Resultado de una corrida: " + resultadoSim);
        System.out.println("Diferencia con valor real: " + (int) Math.abs(resultadoSim - valorReal));

        // Una sola corrida no basta para validar: se promedian 30 replicas
        double suma = 0;
        for (int i = 0; i < 30; i++) suma += simulador(10);
        double promedio = suma / 30;
        System.out.println(String.format(Locale.US, "Promedio de 30 replicas: %.2f", promedio));
        System.out.println(String.format(Locale.US, "Diferencia con valor real: %.2f", Math.abs(promedio - valorReal)));

        if (Math.abs(promedio - valorReal) < tolerancia) {
            System.out.println("Validacion exitosa");
        } else {
            System.out.println("Validacion fallida");
        }
    }
}
