import java.util.Arrays;

public class BaseConverter
{
   /* constant array of char symbols where the index corresponds to the decimal value
   */
   private static final char[] SYMBOLS = {
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
      'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
      'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
      'U', 'V', 'W', 'X', 'Y', 'Z'
   };
   
   /* returns the value (index) of the char symbol from the constant SYMBOLS array
      otherwise returns -1 if the symbol is not found
   */
   public static int getValueOfSymbol(char symbol)
   {
      for (int i = 0; i < SYMBOLS.length; i++)
      {
         if (SYMBOLS[i] == symbol)
         {
            return i;
         }
      }
      return -1;
   }
   
   /* returns a string of the decimal number converted to the base
      otherwise return null if parameters are invalid
   */
   public static String convertFromDecimcal(long decimal, int base)
   {
      if (base < 2 || base > SYMBOLS.length)
      {
         return null;
      }
      
      boolean isNegative = false;
      if (decimal < 0)
      {
         isNegative = true;
         decimal = -1 * decimal;
      }
      
      char[] number = new char[65];
      int index = number.length - 1;
      
      do
      {
         number[index--] = SYMBOLS[(int)(decimal % base)];
      }
      while ((decimal /= base) != 0);
      
      if (isNegative)
      {
         number[index--] = '-';
      }
      
      return String.valueOf(Arrays.copyOfRange(number, index + 1, number.length));
   }
   
   /* returns the decimal number from the given number with base
   */
   public static long convertToDecimal(String number, int base)
   {
      long decimal = 0;
      int length = number.length();
      int index = 0;
      
      boolean isNegative = false;
      if (number.charAt(0) == '-')
      {
         isNegative = true;
         index = 1;
      }
      
      while (index < length)
      {
         int value = getValueOfSymbol(number.charAt(index));
         if (value == -1) // invalid symbol
         {
            return 0;
         }
         
         long power = 1;
         for (int i = index; i < length - 1; i++)
         {
            power *= base;
         }
         
         decimal += value * power;
         index++;
      }
      
      return isNegative ? -1 * decimal : decimal;
   }
}
