package Queue;

public class QueArray<T>{
    private int front;
    private int rear;
    private int capacity;
    private Object[] queue;
    private static final int DEFAULT_CAPACITY = 10;
    private boolean sizeGiven;

    public QueArray(){
        this.capacity = DEFAULT_CAPACITY;
        this.queue = new Object[capacity];
        this.front = -1;
        this.rear = -1;
        this.sizeGiven = false;
    }

    public QueArray(int capacity){
        this.capacity = capacity;
        this.queue = new Object[capacity];
        this.front = -1;
        this.rear = -1;
        this.sizeGiven = true;
    }

    public void enqueue(T val){
        if(isFull()){
            if(sizeGiven) throw new RuntimeException("Queue Overflow");
            else{
                 try {
                    increaseQueueCapacity();
                 } catch (Exception e) {
                    throw new RuntimeException("Queue Overflow"+e.getMessage()); 
                 }
            }
        }
        queue[++rear] = val;
    }
    
    @SuppressWarnings ("unchecked")
    public T dequeue(){
        if(isEmpty()) throw new RuntimeException("Queue Underflow");
        return (T) queue[++front];
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public boolean isFull(){
        return rear == capacity - 1;
    }

    private void increaseQueueCapacity(){
        Object[] newQueue = new Object[capacity*2];
        for(int i=0;i<(rear-front);i++){
            newQueue[i] = queue[front + 1 + i];
        }
        rear = rear - front - 1;
        front = -1;
        queue = newQueue;
        capacity *= 2;
    }
}