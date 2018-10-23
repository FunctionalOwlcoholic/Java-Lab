public class ArrayQueueTest
{
   public static void main(String[] args)
   {
      ArrayQueue queue = new ArrayQueue(5);
      
      for (int i = 0; i < 3; i++)
      {
         queue.enqueue('A');
         System.out.println("enqueued 'A': " + queue.toString());
         
         queue.enqueue('B');
         System.out.println("enqueued 'B': " + queue.toString());
         
         queue.enqueue('C');
         System.out.println("enqueued 'C': " + queue.toString());
         
         System.out.println("dequeued '" + queue.dequeue() + "': " + queue.toString());
         System.out.println("dequeued '" + queue.dequeue() + "': " + queue.toString());
         System.out.println("dequeued '" + queue.dequeue() + "': " + queue.toString());
      }
   }
}
