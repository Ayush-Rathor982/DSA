package Heap;

public class MinHeap<T extends Comparable<T>> {
    private T[] heap;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;

    public MinHeap() {
        this(DEFAULT_CAPACITY);
    }
    
    @SuppressWarnings ("unchecked")
    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = (T[]) new Comparable[capacity];
    }

    public void insert(T val) {
        if (size == capacity) {
            try {
                increaseCapacity();
            } catch (Exception e) {
                throw new RuntimeException("Heap Overflow: " + e.getMessage());
            }
        }
        heap[size] = val;
        size++;
        heapifyUp(size - 1);
    }

    public T removeMin() {
        if (size == 0) throw new RuntimeException("Heap Underflow");
        T min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return min;
    }
    
    @SuppressWarnings ("unchecked")
    private void increaseCapacity() {
        capacity *= 2;
        T[] newHeap = (T[]) new Comparable[capacity];
        System.arraycopy(heap, 0, newHeap, 0, size);
        heap = newHeap;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap[index].compareTo(heap[parentIndex]) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        while (index < size) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallestIndex = index;

            if (leftChildIndex < size && heap[leftChildIndex].compareTo(heap[smallestIndex]) < 0) {
                smallestIndex = leftChildIndex;
            }
            if (rightChildIndex < size && heap[rightChildIndex].compareTo(heap[smallestIndex]) < 0) {
                smallestIndex = rightChildIndex;
            }
            if (smallestIndex != index) {
                swap(index, smallestIndex);
                index = smallestIndex;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    public T[] heapSort(T[] sortedArray) {
        int originalSize = size; 
        for (int i = 0; i < originalSize; i++) {
            sortedArray[i] = removeMin();
        }
        return sortedArray;
    }
}