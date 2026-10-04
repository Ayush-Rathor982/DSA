package LinkedList;

public class Main{
    public static void main(String[] args) {

        System.out.println("Singly Linked List:");
        SinglyLinkedList<Integer> SLlist1 = new SinglyLinkedList<>();

        SLlist1.addFirst(10);
        SLlist1.addFirst(20);
        SLlist1.addLast(30);
        SLlist1.add(40);
        SLlist1.add(50,4);
        SLlist1.add(25,2);
        SLlist1.remove(40);
        SLlist1.add(60, 5);

        SLlist1.printList();

        SLlist1.removeLast();
        SLlist1.addLast(66);

        System.out.println("Is the linked list empty? " + SLlist1.isEmpty());

        System.out.println("Removing first element: " + SLlist1.removeFirst());
        System.out.println("Removing first element: " + SLlist1.removeFirst());
        System.out.println("Contains 30: " + SLlist1.contains(30));
        System.out.println("Contains 10: " + SLlist1.contains(10));

        SLlist1.printList();


        System.out.println("\n\nDoubly Linked List:");
        DoublyLinkedList<Integer> DLlist1 = new DoublyLinkedList<>();

        DLlist1.addFirst(10);
        DLlist1.addFirst(20);            
        DLlist1.addLast(30);
        DLlist1.add(40);
        DLlist1.add(50,4);   
        DLlist1.add(25,2);
        DLlist1.remove(40);
        DLlist1.add(60, 5);

        DLlist1.printList();

        DLlist1.removeLast();
        DLlist1.addLast(66);

        System.out.println("Is the linked list empty? " + DLlist1.isEmpty());

        System.out.println("Removing first element: " + DLlist1.removeFirst());
        System.out.println("Removing first element: " + DLlist1.removeFirst());
        System.out.println("Contains 30: " + DLlist1.contains(30));
        System.out.println("Contains 10: " + DLlist1.contains(10));

        DLlist1.printList();


        System.out.println("\n\nSinglyLinked List with string elements:");
        SinglyLinkedList<String> SLlist2 = new SinglyLinkedList<>();
        SLlist2.addFirst("Rahul");
        SLlist2.addFirst("Ayush");
        SLlist2.addLast("Rohit");
        SLlist2.add("Amit");
        SLlist2.add("Saurabh", 2);
        SLlist2.remove("Amit");
        SLlist2.add("Ankit", 3);

        SLlist2.printList();

        SLlist2.removeLast();
        SLlist2.addLast("Ankit");

        System.out.println("Is the linked list empty? " + SLlist2.isEmpty());

        System.out.println("Removing first element: " + SLlist2.removeFirst());
        System.out.println("Removing first element: " + SLlist2.removeFirst());
        System.out.println("Contains Rohit: " + SLlist2.contains("Rohit"));
        System.out.println("Contains Ayush: " + SLlist2.contains("Ayush"));

        SLlist2.printList();


        System.out.println("\n\nDoublyLinked List with string elements:");
        DoublyLinkedList<String> DLlist2 = new DoublyLinkedList<>();

        DLlist2.addFirst("Rahul");
        DLlist2.addFirst("Ayush");
        DLlist2.addLast("Rohit");
        DLlist2.add("Amit");
        DLlist2.add("Saurabh", 2);
        DLlist2.remove("Amit");
        DLlist2.add("Ankit", 3);

        DLlist2.printList();
        
        DLlist2.removeLast();
        DLlist2.addLast("Ankit");

        System.out.println("Is the linked list empty? " + DLlist2.isEmpty());
        
        System.out.println("Removing first element: " + DLlist2.removeFirst());
        System.out.println("Removing first element: " + DLlist2.removeFirst());
        System.out.println("Contains Rohit: " + DLlist2.contains("Rohit"));
        System.out.println("Contains Ayush: " + DLlist2.contains("Ayush"));

        DLlist2.printList();

    }
}
