public class Main {
   public static void main(String[] args) {
      // write code to manually test your required methods
      Node head = new Node(3);
      head = addAtFront(head, 4);
      printList(head);

   }

   // Implement the required methods here
   public static void printList(Node head) {
      System.out.print("{");
      while (head != null) {
         System.out.print(head.data);

         if (head.next != null)
            System.out.print(", ");
         head = head.next;
      }
      System.out.println("}");
   }

   public static Node addAtFront(Node head, int newValue) {
      Node newNode = new Node(newValue);

      newNode.next = head;

      return newNode;
   }

   public static int getSize(Node head) {
      int size = 0;

      while (head != null) {
         size++;
         head = head.next;
      }

      return size;
   }

   public static Node addToEnd(Node head, int newValue) {
      Node newNode = new Node(newValue);

      if (head == null)
         return newNode;

      // find the tail
      Node tail = head;

      while (tail.next != null)
         tail = tail.next;

      // attach new node
      tail.next = newNode;

      return head;
   }

   public static Node removeFromEnd(Node head) {
      if (head == null || head.next == null)
         return null;

      // find Node before tail
      Node nodeBeforeTail = head;
      while (nodeBeforeTail.next.next != null)
         nodeBeforeTail = nodeBeforeTail.next;
      // make node before tail the tail
      nodeBeforeTail.next = null;

      return head;
   }

   public static Node removeFromFront(Node head) {
      if (head == null)
         return head;

      return head.next;
   }

   public static Node insertAtIndex(Node head, int index, int newValue) {
      if (index < 0 || index > getSize(head))
         return head;

      Node newNode = new Node(newValue);

      if (index == 0) {
         newNode.next = head;
         return newNode;
      }

      // find node befor insertion point
      Node nodeBefore = head;
      while (index > 1) {
         nodeBefore = nodeBefore.next;
         index--;
      }

      newNode.next = nodeBefore.next;
      nodeBefore.next = newNode;

      return head;
   }

   public static Node removeAtIndex(Node head, int index) {
      if (index < 0 || index >= getSize(head))
         return head;

      if (index == 0) {
         head = head.next;
         return head;
      }

      // find node befor removal point
      Node nodeBefore = head;
      while (index > 1) {
         nodeBefore = nodeBefore.next;
         index--;
      }

      nodeBefore.next = nodeBefore.next.next;

      return head;
   }
}

class Node {
   int data;
   Node next;

   Node(int data) {
      this.data = data;
   }
}