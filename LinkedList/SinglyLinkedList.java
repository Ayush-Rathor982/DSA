package LinkedList;

// import javax.management.RuntimeErrorException;

public class SinglyLinkedList <T> {

    private Node head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    private class Node {
        private T data;
        private Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T val) {
        try {
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
            ++size;
        } catch (Exception e) {
            throw new RuntimeException("Error while inserting: " + e.getMessage());
        }
    }

    public void addLast(T val) {
        try {
            Node newNode = new Node(val);

            if (head == null) {
                head = newNode;
                ++size;
                return;
            }

            Node temp = head;

            while (temp.next != null)
                temp = temp.next;

            temp.next = newNode;
            ++size;

        } catch (Exception e) {
            throw new RuntimeException("Error while inserting: " + e.getMessage());
        }
    }

    public void add(T val) {
        addLast(val);
    }

    public void add(T val, int index) {
        try {
            if (index < 0 || index > size) {
                throw new RuntimeException("Index out of bounds. Can't insert.");
            }

            if (index == 0) {
                addFirst(val);
                return;
            }

            if (index == size) {
                addLast(val);
                return;
            }

            Node newNode = new Node(val);
            Node temp = head;

            for (int i = 0; i < index - 1; ++i)
                temp = temp.next;

            newNode.next = temp.next;
            temp.next = newNode;
            ++size;

        } catch (Exception e) {
            throw new RuntimeException("Error while inserting: " + e.getMessage());
        }
    }

    public T removeFirst() {
        try {
            if (isEmpty()) {
                throw new RuntimeException("Linked List is Empty. Nothing to remove.");
            }

            T delVal = head.data;
            head = head.next;
            --size;

            return delVal;

        } catch (Exception e) {
            throw new RuntimeException("Error while removing: " + e.getMessage());
        }
    }

    public T removeLast() {
        try {
            if (isEmpty()) {
                throw new RuntimeException("Linked List is Empty. Nothing to remove.");
            }

            if (size == 1) {
                T delVal = head.data;
                head = null;
                --size;
                return delVal;
            }

            Node temp = head;

            while (temp.next.next != null)
                temp = temp.next;

            T delVal = temp.next.data;
            temp.next = null;
            --size;

            return delVal;

        } catch (Exception e) {
            throw new RuntimeException("Error while removing: " + e.getMessage());
        }
    }

    public void remove(T val) {
        try {
            if (isEmpty()) {
                throw new RuntimeException("Linked List is Empty. Nothing to remove.");
            }

            if (head.data == val) {
                head = head.next;
                --size;
                return;
            }

            Node temp = head;
            while (temp.next != null && temp.next.data != val)
                temp = temp.next;

            if (temp.next == null) {
                System.out.println("Value not found. Can't remove.");
                return;
            }

            temp.next = temp.next.next;
            --size;

        } catch (Exception e) {
            throw new RuntimeException("Error while removing: " + e.getMessage());
        }
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Linked List is Empty. Nothing to return.");
        }
        return head.data;
    }

    boolean contains(T val) {
        Node temp = head;
        while (temp != null && temp.data != val)
            temp = temp.next;

        return (temp == null) ? false : true;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}