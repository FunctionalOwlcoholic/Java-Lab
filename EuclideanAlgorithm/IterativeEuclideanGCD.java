public class IterativeEuclideanGCD
{
   public int GCD(int a, int b)
   {
      if (a == 0 || b == 0) // divide by zero undefined
      {
         return -1;
      }
      
      if (a > b)
      {
         int swap = a;
         a = b;
         b = swap;
      }
      
      for (;;)
      {
         int r = b % a;
         
         if (r == 0)
            return a;
         
         b = a;
         a = r;
      }
   }
}
