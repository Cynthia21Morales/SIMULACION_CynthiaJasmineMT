public class MonteCarlo {
   
   public static void main(String[] args) {
      
      int nLanzamientos = 0;   
      int nExito = 0;          
      
      double x, y;             
      int i;                   
      
      for (i = 0; i < 1000000; i++) {
         x = Math.random(); 
         y = Math.random(); 
         
         nLanzamientos++;
         
         if (x * x + y * y <= 1) {             
            nExito++;                                               
         }
      }                                                            
      
    
      double pi_cuartos = (double)nExito / (double)nLanzamientos;
      double pi = 4 * pi_cuartos;

      System.out.println("Estimación de Pi/4 = " + pi_cuartos);
      System.out.println("Estimación de Pi = " + pi);
   }
}