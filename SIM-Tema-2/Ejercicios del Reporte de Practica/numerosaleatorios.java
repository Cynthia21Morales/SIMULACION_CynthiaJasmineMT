public class numerosaleatorios {
    // Parámetros del generador de números pseudoaleatorios
    public static final int A = 41;
    public static final int C = 11; 
    public static final int M = 11113;
    public static int seed = 1;

    // Método para obtener el siguiente número pseudoaleatorio
    public static int getNextRandom() {
        seed = (A * seed + C) % M;
        return seed;
    }

    // Método principal
    public static void main(String[] args) {
        // Genera e imprime los primeros 100 números pseudoaleatorios
        for (int i = 0; i < 100; i++) {
            System.out.println(getNextRandom());
        }
    }
}