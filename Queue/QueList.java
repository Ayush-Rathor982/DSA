package Queue;

import LinkedList.SinglyLinkedList;

public class QueList<T>{
    private SinglyLinkedList<T> queue;

    public QueList(){
        this.queue = new SinglyLinkedList<>();
    }

    public void enqueue(T val){
        try {
            queue.addFirst(val);
        } catch (Exception e) {
            throw new RuntimeException("Error while enqueuing: " + e.getMessage());
        }
    }

    public T dequeue(){
        if(queue.isEmpty()) throw new RuntimeException("Queue Underflow");
        try {
            return queue.removeLast();
        } catch (Exception e) {
            throw new RuntimeException("Error while dequeuing: " + e.getMessage());
        }
    }

    public Boolean isEmpty(){
        return queue.isEmpty();
    }
} 