package Queue;

import LinkedList.DoublyLinkedList;

public class Deque<T>{
    private DoublyLinkedList<T> deque;

    public Deque(){
        this.deque = new DoublyLinkedList<>();
    }

    public void addFront(T val){
        try {
            deque.addFirst(val);
        } catch (Exception e) {
            throw new RuntimeException("Error while adding to front: " + e.getMessage());
        }
    }

    public void addRear(T val){
        try {
            deque.addLast(val);
        } catch (Exception e) {
            throw new RuntimeException("Error while adding to rear: " + e.getMessage());
        }
    }

    public T removeFront(){
        if(deque.isEmpty()) throw new RuntimeException("Deque Underflow");
        try {
            return deque.removeFirst();
        } catch (Exception e) {
            throw new RuntimeException("Error while removing from front: " + e.getMessage());
        }
    }

    public T removeRear(){
        if(deque.isEmpty()) throw new RuntimeException("Deque Underflow");
        try {
            return deque.removeLast();
        } catch (Exception e) {
            throw new RuntimeException("Error while removing from rear: " + e.getMessage());
        }
    }

    public boolean isEmpty(){
        return deque.isEmpty();
    }

}