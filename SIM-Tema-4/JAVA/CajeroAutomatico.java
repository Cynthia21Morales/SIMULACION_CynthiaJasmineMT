// Tema 4.3.1 - Problemas con lineas de espera
// Un cajero automatico (1 servidor), simulacion minuto a minuto
import java.util.LinkedList;
import java.util.Random;

public class CajeroAutomatico {
    public static void main(String[] args) {
        Random rnd = new Random(7);

        int tiempoTotal = 20;
        int tiempo = 0;
        LinkedList<Integer> cola = new LinkedList<>();
        int tiempoCajero = 0;
        int clienteId = 0;

        System.out.println("Simulacion de un cajero automatico");
        System.out.println("-----------------------------------");

        while (tiempo < tiempoTotal) {
            if (rnd.nextDouble() < 0.5) {                 // llega un cliente con prob. 0.5
                clienteId++;
                cola.add(clienteId);
                System.out.println("Minuto " + tiempo + ": Llega el Cliente " + clienteId + " (cola = " + cola.size() + ")");
            }

            if (tiempoCajero == 0 && !cola.isEmpty()) {   // cajero libre y hay cola
                int cliente = cola.removeFirst();
                tiempoCajero = rnd.nextInt(4) + 2;        // 2..5
                System.out.println("Minuto " + tiempo + ": Cliente " + cliente + " empieza a usar el cajero (tarda " + tiempoCajero + " min)");
            }

            if (tiempoCajero > 0) {
                tiempoCajero--;
                if (tiempoCajero == 0) {
                    System.out.println("Minuto " + tiempo + ": El cliente termina su operacion");
                }
            }
            tiempo++;
        }

        System.out.println("\nClientes que llegaron: " + clienteId);
        System.out.println("Clientes que quedaron en cola al final: " + cola.size());
    }
}
