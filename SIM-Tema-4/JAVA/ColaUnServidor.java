// Tema 4.3.1 - Problemas con lineas de espera
// Cola de un servidor con llegadas y servicios exponenciales
import java.util.Locale;
import java.util.Random;

public class ColaUnServidor {
    static double exponencial(Random rnd, double media) {
        return -media * Math.log(1 - rnd.nextDouble());
    }

    public static void main(String[] args) {
        Random rnd = new Random(123);
        int n = 50;
        double[] llegadas = new double[n];
        double[] servicios = new double[n];

        double acumulado = 0;
        for (int i = 0; i < n; i++) {
            acumulado += exponencial(rnd, 4);        // llega 1 cliente cada 4 min en promedio
            llegadas[i] = acumulado;
        }
        for (int i = 0; i < n; i++) {
            servicios[i] = exponencial(rnd, 3);      // se atiende en 3 min en promedio (rho = 0.75)
        }

        double[] inicio = new double[n], fin = new double[n];
        double actual = 0, sumaEspera = 0, sumaSistema = 0;
        for (int i = 0; i < n; i++) {
            inicio[i] = Math.max(llegadas[i], actual);
            fin[i] = inicio[i] + servicios[i];
            actual = fin[i];
            sumaEspera += inicio[i] - llegadas[i];
            sumaSistema += fin[i] - llegadas[i];
        }

        System.out.println("   Llegada     Inicio        Fin     Espera  TiempoSistema");
        for (int i = 0; i < 5; i++) {
            System.out.println(String.format(Locale.US, "%9.6f  %9.6f  %9.6f  %9.6f  %9.6f",
                llegadas[i], inicio[i], fin[i], inicio[i] - llegadas[i], fin[i] - llegadas[i]));
        }
        System.out.println(String.format(Locale.US, "%nTiempo medio de espera en cola: %.6f", sumaEspera / n));
        System.out.println(String.format(Locale.US, "Tiempo medio en sistema: %.6f", sumaSistema / n));
    }
}
