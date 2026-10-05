package Heap;

public class MaxHeap<T extends Comparable<T>> {
    private T[] heap;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;

    public MaxHeap() {
        this(DEFAULT_CAPACITY);
    }
    
    @SuppressWarnings ("unchecked")
    public MaxHeap(int capacity) {
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

    public T removeMax() {
        if (isEmpty()) throw new RuntimeException("Heap Underflow");
        T max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
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
            if (heap[index].compareTo(heap[parentIndex]) > 0) {
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
            int largestIndex = index;

            if (leftChildIndex < size && heap[leftChildIndex].compareTo(heap[largestIndex]) > 0) {
                largestIndex = leftChildIndex;
            }
            if (rightChildIndex < size && heap[rightChildIndex].compareTo(heap[largestIndex]) > 0) {
                largestIndex = rightChildIndex;
            }
            if (largestIndex != index) {
                swap(index, largestIndex);
                index = largestIndex;
            } else {
                break;
            }
        }
    }

    private void swap(int index1, int index2) {
        T temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T[] heapSort(T[] sortedArray) {
        int originalSize = size;
        for (int i = 0; i < originalSize; i++) {
            sortedArray[i] = removeMax();
        }
        return sortedArray;
    }

}   