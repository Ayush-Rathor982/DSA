package Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Queue using Array:");
        QueArray<Float> queue = new QueArray<>(10);
        queue.enqueue(1.0f);
        queue.enqueue(2.2f);
        queue.enqueue(3.4f);
        queue.enqueue(4.5f);
        queue.dequeue();
        queue.enqueue(5.6f);
        queue.enqueue(6.7f);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(7.8f);
        System.out.println("Queue is full: " + queue.isFull());
        System.out.println("Dequeued element is: " + queue.dequeue());
        System.out.println("Queue is empty: " + queue.isEmpty());


        System.out.println("\nQueue using Linked List:");
        QueList<String> queueList = new QueList<>();
        queueList.enqueue("Joe");
        queueList.enqueue("John");
        queueList.enqueue("Jane");
        queueList.dequeue();
        queueList.enqueue("Doe");
        queueList.dequeue();
        queueList.enqueue("Smith");
        queueList.dequeue();
        System.out.println("Dequeued element is: " + queueList.dequeue());
        System.out.println("Queue is empty: " + queueList.isEmpty());


        System.out.println("\nQueue using Circular Array:");
        CircularQue<Double> circularQueue = new CircularQue<>(5);
        circularQueue.enqueue(5.573);
        circularQueue.enqueue(6.234);
        circularQueue.enqueue(7.123);
        circularQueue.dequeue();
        circularQueue.enqueue(8.456);
        circularQueue.dequeue();
        circularQueue.enqueue(9.789);
        circularQueue.enqueue(10.345);
        circularQueue.enqueue(11.340);
        System.out.println("Queue is full: " + circularQueue.isFull());
        System.out.println("Dequeued element is: " + circularQueue.dequeue());
        System.out.println("Queue is empty: " + circularQueue.isEmpty());


        System.out.println("\nDeque:");
        Deque<Long> deque = new Deque<>();
        deque.addFront(100L);
        deque.addRear(200L);
        deque.addFront(50L);
        deque.addRear(3000000000L);
        deque.addRear(9223372036854775807L);
        deque.addFront(194337207685775807L);
        System.out.println("Dequeued from front: " + deque.removeFront());
        System.out.println("Dequeued from rear: " + deque.removeRear());
        System.out.println("Deque is empty: " + deque.isEmpty());


    }
}