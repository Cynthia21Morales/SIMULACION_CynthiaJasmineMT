import java.util.Random;

public class Aleatoriedad {
    public static void main(String[] args) {
        
        Random aleatorio = new Random();

        int intAleatorio = aleatorio.nextInt(100);
        System.out.println("Número aleatorio: " + intAleatorio);
 
        int otroNumero = aleatorio.nextInt(100);
        System.out.println("Otro número aleatorio: " + otroNumero);

    }
}
