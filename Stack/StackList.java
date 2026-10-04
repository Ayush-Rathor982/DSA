package Stack;

import LinkedList.SinglyLinkedList;

public class StackList<T>{
    private SinglyLinkedList<T> stack;

    public StackList(){
        this.stack = new SinglyLinkedList<>();
    }

    public void push(T val){
        try {
            stack.addFirst(val);
        } catch (Exception e) {
            throw new RuntimeException("Error while pushing: " + e.getMessage());
        }
    }

    public T pop(){
        if(stack.isEmpty()) throw new RuntimeException("Stack Underflow");
        try {
            return stack.removeFirst();
        } catch (Exception e) {
            throw new RuntimeException("Error while popping: " + e.getMessage());
        }
    }

    public T peek(){
        if(stack.isEmpty()) throw new RuntimeException("Stack is empty");
        try {
            return stack.getFirst();
        } catch (Exception e) {
            throw new RuntimeException("Error while peeking: " + e.getMessage());
        }
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
}