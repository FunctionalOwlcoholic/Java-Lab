import java.util.Random;

public class EuclideanTester
{
   public static void main(String[] args)
   {
      Random r = new Random();
      
      for (int i = 0; i < 100; i++)
      {
         int a = r.nextInt();
         int b = r.nextInt();
         
         System.out.println("iterativeGCD(" + a + ", " + b + ") = " + Euclidean.iterativeGCD(a, b));
         System.out.println("recursiveGCD(" + a + ", " + b + ") = " + Euclidean.recursiveGCD(a, b));
         System.out.println("iterativeLCM(" + a + ", " + b + ") = " + Euclidean.iterativeLCM(a, b));
         System.out.println("recursiveLCM(" + a + ", " + b + ") = " + Euclidean.recursiveLCM(a, b) + "\n");
      }
   }
}
