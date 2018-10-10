/*
   a 'linked list' is a data structure that consist of a sequence of nodes
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
   the first node in a linked list is referred to as the 'head' and the last node is called the 'tail'
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
   class Node // a nested class will be the node of our linked list
   {
      String data; // the node holds whatever data you want, for this example we are using a string
      
      Node next = null; // this node is for a singly linked list so we only keep reference of the next node
      
      Node(String data) // a constructor that initilizes whatever data you have in the node
      {
         this.data = data;
      }
   }
   
   
   Node head = null; // since this is a stack data structure, we only need access to the first node in the linked list
   
   
   /* adds a node to the beginning of the linked list */
   public void push(String data)
   {
      Node newNode = new Node(data); // create a new node with the given data
      newNode.next = head; // the node (or lack of node) that is currently at the head will be pushed back by the new node
      head = newNode; // override the head since our new node now links to the previous head
   }
   
   
   /* removes a node from the beginning of the linked list and returns the data it held */
   public String pop()
   {
      if (head == null) // check if the head exist before trying to access its data
      {
         return null;
      }
      
      String data = head.data; // get the data from the head node before we loose access to it
      head = head.next; // remove the current head node by setting the node that comes after the head as our new head
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
