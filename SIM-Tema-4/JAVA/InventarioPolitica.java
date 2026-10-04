// Tema 4.3.2 - Problemas con sistemas de inventarios
// Inventario a 10 dias con demanda uniforme (5 a 15) y reorden bajo 20
import java.util.Random;

public class InventarioPolitica {
    public static void main(String[] args) {
        Random rnd = new Random(5);
        int inventario = 50;

        for (int dia = 1; dia <= 10; dia++) {
            inventario -= rnd.nextInt(11) + 5;     // 5..15
            if (inventario < 20) inventario += 40;
            System.out.println("Dia " + dia + ": Inventario = " + inventario);
        }
    }
}
