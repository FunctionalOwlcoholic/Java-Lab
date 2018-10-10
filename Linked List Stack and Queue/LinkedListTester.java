public class LinkedListTester
{
   public static void main(String[] args)
   {
      // stack data structure demonstration
      LinkedListStack stack = new LinkedListStack();
      System.out.println("Created stack: " + stack.toString());
      
      stack.push("A");
      System.out.println("Push 'A' onto the stack: " + stack.toString());
      stack.push("B");
      System.out.println("Push 'B' onto the stack: " + stack.toString());
      stack.push("C");
      System.out.println("Push 'C' onto the stack: " + stack.toString());
      
      System.out.println("Pop '" + stack.pop() + "' from the stack: " + stack.toString());
      System.out.println("Pop '" + stack.pop() + "' from the stack: " + stack.toString());
      System.out.println("Pop '" + stack.pop() + "' from the stack: " + stack.toString());
      
      stack.push("D");
      System.out.println("Push 'D' onto the stack: " + stack.toString());
      stack.push("F");
      System.out.println("Push 'F' onto the stack: " + stack.toString());
      
      System.out.println("Pop '" + stack.pop() + "' from the stack: " + stack.toString());
      System.out.println("Pop '" + stack.pop() + "' from the stack: " + stack.toString());
      
      System.out.println("\n");
      
      // queue data structure demonstration
      LinkedListQueue queue = new LinkedListQueue();
      System.out.println("Created queue: " + queue.toString());
      
      queue.enqueue("A");
      System.out.println("Enqueue 'A' onto the queue: " + queue.toString());
      queue.enqueue("B");
      System.out.println("Enqueue 'B' onto the queue: " + queue.toString());
      queue.enqueue("C");
      System.out.println("Enqueue 'C' onto the queue: " + queue.toString());
      
      System.out.println("Dequeue '" + queue.dequeue() + "' from the queue: " + queue.toString());
      System.out.println("Dequeue '" + queue.dequeue() + "' from the queue: " + queue.toString());
      System.out.println("Dequeue '" + queue.dequeue() + "' from the queue: " + queue.toString());
      
      queue.enqueue("D");
      System.out.println("Enqueue 'D' onto the queue: " + queue.toString());
      queue.enqueue("E");
      System.out.println("Enqueue 'E' onto the queue: " + queue.toString());
      
      System.out.println("Dequeue '" + queue.dequeue() + "' from the queue: " + queue.toString());
      System.out.println("Dequeue '" + queue.dequeue() + "' from the queue: " + queue.toString());
   }
}
