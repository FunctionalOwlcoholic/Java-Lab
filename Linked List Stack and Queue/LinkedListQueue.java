/*
   a 'linked list' is a data structure that consist of a sequence nodes
   each 'node' has access to the next node, and or previous node as well as whatever data you want to store in them
   
   in a 'doubly linked list' each node has access to the 'next node' and 'previous node'
   therefore you can traverse the linked list forwards and backwards
   
   a 'node' in a doubly linked list should be thought of as an object such as:
   
   Node
   {
      Node nextNode;
      Node prevNode;
      
      data...
   }

   when we use a linked list, we only keep reference of the first node, and or last node in the linked list
   the first node in a linked list is refered to as the 'head' and the last is called the 'tail'
   to traverse through a linked list we start at either the 'head' or the 'tail' and loop through each node
   
   a 'queue data structure' can be implemented with a 'doubly linked list'
   a queue is 'FIFO' (first in, first out) data structure which means-
   the first element added to the queue is the first element removed from the queue
   adding an element to a queue is called 'enqueue'
   removing an element from a queue is called 'dequeue'
   
   example:       [A, B, C, D, E]
   
   enqueue 'F' -> [A, B, C, D, E, F]
   
   dequeue 'A'  <-   [B, C, D, E, F]
   
   dequeue 'B'    <-    [C, D, E, F]
*/
public class LinkedListQueue
{
   class Node
   {
      String data;
      
      Node next = null;
      Node prev = null;
      
      Node(String data)
      {
         this.data = data;
      }
   }
   
   
   Node head = null;
   Node tail = null;
   
   
   public void enqueue(String data)
   {
      Node newNode = new Node(data);
      
      if (tail != null)
      {
         newNode.next = tail;
         tail.prev = newNode;
      }
      
      tail = newNode;
      
      if (head == null)
      {
         head = newNode;
      }
   }
   
   
   public String dequeue()
   {
      if (head == null)
      {
         return null;
      }
      
      String data = head.data;
      
      if (head == tail)
      {
         head = null;
         tail = null;
      }
      else
      {
         head = head.prev;
      }
      
      return data;
   }
   
   
   /* returns a string of the data from each node in the linked list */
   public String toString()
   {
      if (head == null)
      {
         return "[]";
      }
      
      String str = "[";
      
      Node prevNode = head;
      while (prevNode != null)
      {
         str += prevNode.data + ", ";
         prevNode = prevNode.prev;
      }
      
      return str.substring(0, str.length() - 2) + "]";
   }
}
