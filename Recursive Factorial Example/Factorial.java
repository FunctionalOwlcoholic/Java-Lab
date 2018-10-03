public class Factorial
{
   public static void main(String[] args)
   {
      System.out.println("Recursive:");
      for (int i = 0; i < 13; i++)
      {
         System.out.println(i + "! = " + recursiveFactorial(i));
      }
      System.out.println();
      System.out.println("Iterative:");
      for (int i = 0; i < 13; i++)
      {
         System.out.println(i + "! = " + iterativeFactorial(i));
      }
   }
   
   public static long recursiveFactorial(int n)
   {
      if (n < 1)
      {
         return 1;
      }
      return n * recursiveFactorial(n - 1);
   }
   
   public static long iterativeFactorial(int n)
   {
      if (n < 1)
      {
         return 1;
      }
      long f = n;
      while (n > 1)
      {
         f *= --n;
      }
      return f;
   }
}
