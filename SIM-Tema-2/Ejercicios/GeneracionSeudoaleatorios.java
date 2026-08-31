import java.util.Random;

public class GeneracionSeudoaleatorios {

	public static void main(String[] args) {

		
		Random randomNumbers = new Random();

		System.out.println("----------Boleano Aleatorio---------" );
		boolean valor = randomNumbers.nextBoolean();
		System.out.println("El valor booleano aleatorio es: " + valor);

	
		System.out.println("\n----------Entero Aleatorio---------" );
		System.out.println("tirada de dato: " + (randomNumbers.nextInt(6)+1) );
		System.out.println("tirata de dato: " + (randomNumbers.nextInt(6)+1) );
		System.out.println("tirada de dato: " + (randomNumbers.nextInt(6)+1) );
		System.out.println("tirada de dato: " + (randomNumbers.nextInt(6)+1) );
		System.out.println("tirada de dato: " + (randomNumbers.nextInt(6)+1) );

		
		Long val = randomNumbers.nextLong();
		System.out.println("\n----------Aleatorio Largo---------" );
		System.out.println("Valor largo aleatorio: " + val);

		
		System.out.println("\n----------Bytes Aleatorios---------" );
		byte[] bytes = new byte[8];
		randomNumbers.nextBytes(bytes);

		System.out.print("Estos son los bytes Aleatorios = [ ");
		for (int i = 0; i < bytes.length; i++) {
			System.out.printf("%d ", bytes[i]);
		}
		System.out.println("]");
	}

}