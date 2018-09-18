/* abstract class that will be extended by the Octagon class */
public abstract class GeometricObject
{
   //the protected modifier is used instead of private because it allows subclasses to access these members
   protected int numberOfSides;
   protected double sideLength;
   
   
   //abstract classes can also have constructors in case you didn't know
   public GeometricObject(int numberOfSides, double sideLength)
   {
      //the keyword 'this' allows us to use the same variable name in the parameter and also refer to the members in 'this' class
      this.numberOfSides = numberOfSides;
      this.sideLength = sideLength;
   }
   
   
   //abstract methods that force the subclasses to define them
   public abstract double calculateArea();
   public abstract double calculatePerimeter();
}


/* this class extends the abstract class GeometricObject and,
   also implements two Java pre-defined interfaces, these interfaces DO NOT need to be created by you
   
   The Comparable interface declares the abstract method: public int compareTo(Object)
   The Cloneable interface declares the abstract method: public Object clone()
   
   When implementing the Comparable interface, you must add <Octagon> which is a type parameter,
   it allows you to use this class as a type
*/
public class Octagon extends GeometricObject implements Cloneable, Comparable<Octagon>
{
   /* constructor */
   public Octagon(double sideLength)
   {
      super(8, sideLength); //call to super constructor
   }
   
   
   /* returns the area of the octogon */
   public double calculateArea()
   {
      return (2 + 4/Math.sqrt(2) ) * sideLength * sideLength;
   }
   
   
   /* returns the perimeter of the octogon */
   public double calculatePerimeter()
   {
      return sideLength * 8;
   }
   
   
   /* clones the Octagon object and returns the reference to it
      this method definition is forced by the implementation of the Cloneable interface
   */
   public Octagon clone()
   {
      return new Octagon(sideLength);
   }
   
   
   /* returns 1 if the two Octagons are equal or 0 if not equal
      this method definition is forced by the implementation of the Comparable interface
   */
   public int compareTo(Octagon comparedOctagon)
   {
      /* note that because we are using a double here, you cannot use == because floating point numbers are imprecise,
         to compare two floating point numbers, you take the difference and check if it is less than a small number like 0.0001,
         that way two numbers like 2.99999 and 2.99998 can be considered equal
      */
      if (comparedOctagon.numberOfSides == numberOfSides && Math.abs(comparedOctagon.sideLength - sideLength) <= 0.0001)
      {
         return 1;
      }
      return 0;
   }
   
   
   /* wrapper method for compareTo() that returns a boolean instead of an integer
   
      the instructions for this lab mention that the Octagon comparison method should return true or false, however
      the compareTo() method only returns int and you cannot change the return type by overriding it,
      so this method is just a "wrapper" method for the previous method
   */
   public boolean isEqual(Octagon comparedOctagon)
   {
      if (this.compareTo(comparedOctagon) == 1)
      {
         return true;
      }
      return false;
   }
}
