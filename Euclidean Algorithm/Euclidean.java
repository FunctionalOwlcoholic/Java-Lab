public class Euclidean
{
   public static int iterativeGCD(int a, int b)
   {
      if (a < 0)
      {
         a *= -1;
      }
      if (b < 0)
      {
         b *= -1;
      }
      if (a > b)
      {
         int t = a;
         a = b;
         b = t;
      }
      if (a == 0)
      {
         return b;
      }
      
      for (;;)
      {
         int r = b % a;
         
         if (r == 0)
         {
            return a;
         }
         
         b = a;
         a = r;
      }
   }
   
   public static int recursiveGCD(int a, int b)
   {
      if (a < 0)
      {
         a *= -1;
      }
      if (b < 0)
      {
         b *= -1;
      }
      if (a > b)
      {
         int t = a;
         a = b;
         b = t;
      }
      if (a == 0)
      {
         return b;
      }
      
      return rgcd(a, b);
   }
   
   private static int rgcd(int a, int b)
   {
      if (a == 0)
      {
         return b;
      }
      
      return rgcd(b % a, a);
   }
   
   public static long iterativeLCM(int a, int b)
   {
      return lcm(a, b, iterativeGCD(a, b));
   }
   
   public static long recursiveLCM(int a, int b)
   {
      return lcm(a, b, recursiveGCD(a, b));
   }
   
   private static long lcm(int a, int b, int gcd)
   {
      if (gcd == 0)
      {
         return 0;
      }
      
      long lcm = ( (long)a * (long)b ) / (long)gcd;
      
      if (lcm < 0)
      {
         lcm *= -1;
      }
      
      return lcm;
   }
}
