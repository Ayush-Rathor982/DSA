package Queue;

public class CircularQue<T>{
    private int front;
    private int rear;
    private int capacity;
    private Object[] queue;
    private static final int DEFAULT_CAPACITY = 10+1;

    public CircularQue(){
        this.capacity = DEFAULT_CAPACITY;
        this.queue = new Object[capacity];
        this.front = 0;
        this.rear = 0;
    }

    public CircularQue(int capacity){
        this.capacity = capacity+1;
        this.queue = new Object[this.capacity];
        this.front = 0;
        this.rear = 0;
    }

    public void enqueue(T val){
        if(isFull()) throw new RuntimeException("Queue Overflow");
        rear = (rear + 1) % capacity;
        queue[rear] = val;
    }
    
    @SuppressWarnings ("unchecked")
    public T dequeue(){
        if(isEmpty()) throw new RuntimeException("Queue Underflow");
        T val = (T) queue[++front];
        return val;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public boolean isFull(){
        return (rear + 1) % capacity == front;
    }
}