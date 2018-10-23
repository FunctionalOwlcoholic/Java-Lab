// implements a 'queue' data structure using a 'circular array'
public class ArrayQueue
{
   private final char[] array;
   private int front = 0;
   private int rear = 0;
   private int count = 0;
   
   // constructor
   public ArrayQueue(int size)
   {
      array = new char[size];
   }
   
   // adds the char to the rear of the queue
   public void enqueue(char c)
   {
      if (count == array.length) // check if the array is at max capacity before adding another element
      {
         return;
      }
      count++;
      
      if (rear < 0) // if the rear index has gone below zero,
      {             // we loop around to the other side of the array, hence the term 'circular' array
         rear = array.length - 1;
      }
      array[rear] = c; // 'enqueue' our char by adding it to the array at the rear index
      
      rear--;
   }
   
   // removes and returns a char from the front of the queue
   public char dequeue()
   {
      if (count == 0) // check if the array is empty before removing an element
      {
         return '\0';
      }
      count--;
      
      if (front < 0) // if the rear index has gone below zero,
      {              // we loop around to the other side of the array, hence the term 'circular' array
         front = array.length - 1;
      }
      
      // the following 3 statements can be shortened a single statement 'return array[front--];'
      
      char c = array[front];
      front--; // decrementing the front index frees up space in the array, basically deletes the element
      return c; // we return the char that we just removed
   }
   // NOTE: if this was a 'peek' method, then we would just return the front element without removing it
   
   // returns a string of the queue
   public String toString()
   {
      String str = "";
      
      int index = front;
      for (int i = 0; i < count; i++)
      {
         if (index < 0)
         {
            index = array.length - 1;
         }
         str += array[index] + ", ";
         index--;
      }
      
      return str;
   }
}
