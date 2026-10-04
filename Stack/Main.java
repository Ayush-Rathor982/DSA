package Stack;

public class Main {
    public static void main(String[] args) {

        System.out.println("Stack using Array:");
        StackArray<Integer> stack = new StackArray<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.pop();
        stack.push(6);
        stack.push(7);
        stack.pop();
        stack.pop();
        stack.push(8);
        System.out.println("Top element is: " + stack.peek());
        System.out.println("Stack is full: " + stack.isFull());
        System.out.println("Popped element is: " + stack.pop());
        System.out.println("Top element is: " + stack.peek());
        System.out.println("Stack is empty: " + stack.isEmpty());


        System.out.println("\nStack using Linked List:");
        StackList<String> stackList = new StackList<>();
        stackList.push("Arpit");
        stackList.push("John");
        stackList.push("Jane");
        stackList.push("Doe");
        stackList.pop();
        stackList.push("Smith");
        stackList.pop();
        stackList.pop();
        stackList.push("Alice");
        stackList.push("Bob");
        stackList.pop();
        System.out.println("Top element is: " + stackList.peek());
        System.out.println("Popped element is: " + stackList.pop());
        System.out.println("Top element is: " + stackList.peek());
        System.out.println("Stack is empty: " + stackList.isEmpty());
    }
}