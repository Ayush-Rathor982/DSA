package LinkedList;

// import javax.management.RuntimeErrorException;

public class DoublyLinkedList<T>{

    private Node front;
    private Node rear;
    private int size;

    public DoublyLinkedList(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    private class Node{
        private T data;
        private Node next;
        private Node prev;

        Node(T data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void addFirst(T val){
        try {
            Node newNode = new Node(val);
            newNode.next = front;
            front = newNode;
            if(front.next!=null)front.next.prev = front;
            if(rear==null)rear = front;
            ++size;
        } catch (Exception e) {
            throw new RuntimeException("Error while inserting: "+e.getMessage());
        }
    }

    public void addLast(T val){
        try {
            Node newNode = new Node(val);
            newNode.prev = rear;
            if(rear!=null)rear.next = newNode;
            rear = newNode;
            if(front==null)front = rear;
            ++size;
        } catch (Exception e) {
            throw new RuntimeException("Error while inserting: "+e.getMessage());
        }
    }

    public void add(T val){
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
            Node temp = front;

            for (int i = 0; i < index - 1; ++i)
                temp = temp.next;

            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
            ++size;

        } catch (Exception e) {
            throw new RuntimeException("Error while inserting: " + e.getMessage());
        }
    }

    public T removeFirst(){
        try {
            if(isEmpty()){
                throw new RuntimeException("Linked List is Empty. Nothing to remove.");
            }
            
            T delVal = front.data;
            front = front.next;
            if(front!=null){
                front.prev.next = null;
                front.prev = null;
            }
            if(front==null)rear = null;
            --size;

            return delVal;

        } catch (Exception e) {
            throw new RuntimeException("Error while removing: "+e.getMessage());          
        }
    }

    public T removeLast(){
        try {
            if(isEmpty()){
                throw new RuntimeException("Linked List is Empty. Nothing to remove.");
            }

            T delVal = rear.data;

            rear = rear.prev;
            if(rear==null)front=null;
            else if(rear.next!=null){
                rear.next.prev = null;
                rear.next = null;
            }

            --size;

            return delVal;

        } catch (Exception e) {
            throw new RuntimeException("Error while removing: "+e.getMessage());
        }
    }


    public void remove(T val){
        try {
            if(isEmpty()){
                throw new RuntimeException("Linked List is Empty. Nothing to remove.");
            }
            if(front.data==val){
                removeFirst();
                return;
            }
            
            if(rear.data==val){
                removeLast();
                return ;
            }

            Node temp = front;
            while(temp!=null && temp.data != val) temp = temp.next;

            if(temp==null){
                System.out.println("Value not found. Can't remove.");
                return;
            }

            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            temp.prev = null;
            temp.next = null;
            --size;

        } catch (Exception e) {
            throw new RuntimeException("Error while removing: "+e.getMessage());
        }
    }


    boolean contains(T val){
        Node temp = front;
        while(temp!=null && temp.data!=val)temp=temp.next;

        return (temp==null) ? false : true;
    }

    void printList(){
        Node temp = front;
        while(temp!=null){
            System.out.print(temp.data+" <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}