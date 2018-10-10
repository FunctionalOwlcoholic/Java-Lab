/*
   a 'linked list' is a data structure that consist of a sequence nodes
   each 'node' has access to the next node, and or previous node as well as whatever data you want to store in them
   
   in a 'singly linked list' each node only has access to the 'next node'
   therefore you can only traverse the linked list in a single direction
   
   a 'node' in a singly linked list should be thought of as an object such as:
   
   Node
   {
      Node nextNode;
      
      data...
   }
   
   when we use a linked list, we only keep reference of the first node, and or last node in the linked list
   the first node in a linked list is refered to as the 'head' and the last is called the 'tail'
   to traverse through a linked list we start at either the 'head' or the 'tail' and loop through each node
   
   a 'stack data structure' can be implemented with a 'singly linked list'
   a stack is 'LIFO' (last in, first out) data structure which means-
   the last element added to the stack is the first element removed from the stack
   adding an element to a stack is called 'push'
   removing an element from a stack is called 'pop'
   
   example:       [A, B, C, D, E]
   
   push 'F' -> [F, A, B, C, D, E]
   
   pop 'F'   <-   [A, B, C, D, E]
   
   pop 'A'     <-    [B, C, D, E]
   
*/
public class LinkedListStack
{
   class Node // a nested class that will be the node of our linked list
   {
      String data; // the node holds whatever data you want, for this example we are using a single string
      
      Node next = null; // this is singly linked list so we only keep reference of the next node
      
      Node(String data) // a constructor that initilizes whatever data you have in the node
      {
         this.data = data;
      }
   }
   
   
   Node head = null; // since this is a stack data structure, we only need access to the first node in the linked list
   
   
   /* adds a node to the beginning of the linked list */
   public void push(String data)
   {
      Node newNode = new Node(data);
      newNode.next = head;
      head = newNode;
   }
   
   
   /* removes a node from the beginning of the linked list and returns the data it held */
   public String pop()
   {
      if (head == null)
      {
         return null;
      }
      
      String data = head.data;
      head = head.next;
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
      
      Node nextNode = head;
      while (nextNode != null)
      {
         str += nextNode.data + ", ";
         nextNode = nextNode.next;
      }
      
      return str.substring(0, str.length() - 2) + "]";
   }
}
