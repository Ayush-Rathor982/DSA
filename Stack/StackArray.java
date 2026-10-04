package Stack;

public class StackArray<T> {
    private int top;
    private int capacity;
    private Object[] stack;
    private static final int DEFAULT_CAPACITY = 10;

    public StackArray(){
        this.capacity = DEFAULT_CAPACITY;
        this.stack = new Object[capacity];
        this.top = -1;
    }

    public StackArray(int size){
        this.capacity = size;
        this.stack = new Object[capacity];
        this.top = -1;
    }
    
    private void makeStackBigger(){
        try {
            Object[] newStack = new Object[capacity*2];
            for(int i=0;i<=top;i++){
                newStack[i] = stack[i];
            }
            stack = newStack;
            capacity *= 2;
        } catch (Exception e) {
            throw new RuntimeException("Error while making stack bigger: "+e.getMessage());
        }
    }

    public void push(T val){
        if(top==capacity-1){
            try {
                makeStackBigger();
            } catch (Exception e) {
                throw new RuntimeException("Stack Overflow: "+e.getMessage());
            }
        }
        stack[++top] = val;
    }
    
    @SuppressWarnings("unchecked")
    public T pop(){
        if(top==-1) throw new RuntimeException("Stack Underflow");
        T val = (T)stack[top];
        top--;
        return val;
    }
    
    @SuppressWarnings("unchecked")
    public T peek(){
        if(top==-1) throw new RuntimeException("Stack is empty");
        T val = (T)stack[top];
        return val;
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public boolean isFull(){
        return top==capacity-1;
    }
}
