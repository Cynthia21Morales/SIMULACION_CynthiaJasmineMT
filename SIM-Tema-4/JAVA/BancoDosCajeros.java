// Tema 4.3.1 - Problemas con lineas de espera
// Banco con 2 cajeros (2 servidores) y una sola cola
import java.util.LinkedList;
import java.util.Random;

public class BancoDosCajeros {
    public static void main(String[] args) {
        Random rnd = new Random(11);

        int tiempoTotal = 30;
        int tiempo = 0;
        LinkedList<Integer> cola = new LinkedList<>();
        int[] tiemposCajeros = {0, 0};
        int clienteId = 0;

        System.out.println("Simulacion de un banco con 2 cajeros");
        System.out.println("------------------------------------");

        while (tiempo < tiempoTotal) {
            if (rnd.nextDouble() < 0.6) {                 // llegada con prob. 0.6 por minuto
                clienteId++;
                cola.add(clienteId);
                System.out.println("Minuto " + tiempo + ": Llega el Cliente " + clienteId + " (cola = " + cola.size() + ")");
            }

            for (int i = 0; i < tiemposCajeros.length; i++) {
                if (tiemposCajeros[i] == 0 && !cola.isEmpty()) {
                    int cliente = cola.removeFirst();
                    tiemposCajeros[i] = rnd.nextInt(4) + 3;   // 3..6
                    System.out.println("Minuto " + tiempo + ": Cliente " + cliente + " empieza en Cajero " + (i + 1) + " (tarda " + tiemposCajeros[i] + " min)");
                }
                if (tiemposCajeros[i] > 0) {
                    tiemposCajeros[i]--;
                    if (tiemposCajeros[i] == 0) {
                        System.out.println("Minuto " + tiempo + ": El Cajero " + (i + 1) + " termina con un cliente");
                    }
                }
            }
            tiempo++;
        }

        System.out.println("\nClientes que llegaron: " + clienteId);
        System.out.println("Clientes que quedaron en cola al final: " + cola.size());
    }
}
