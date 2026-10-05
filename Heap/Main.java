package Heap;

public class Main{
    public static void main(String[] args) {
        MinHeap<Integer> minHeap = new MinHeap<>();
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(20);
        minHeap.insert(3);
        minHeap.insert(15);
        minHeap.insert(7);
        minHeap.insert(8);
        minHeap.insert(1);
        minHeap.insert(12);
        minHeap.insert(6);

        System.out.println("Min element: " + minHeap.removeMin()); // Should print 3
        System.out.println("Min element: " + minHeap.removeMin()); // Should print 5
        System.out.println("Min element: " + minHeap.removeMin()); // Should print 10
        System.out.println("MinHeap Size: " + minHeap.size()); 
        // System.out.println("Min element: " + minHeap.removeMin()); // Should print 15
        // System.out.println("Min element: " + minHeap.removeMin()); // Should print 20

        Integer[] sortedArray = new Integer[minHeap.size()];
        sortedArray = minHeap.heapSort(sortedArray);

        for (Integer num : sortedArray) {
            System.out.print(num + " ");
        }
        System.out.println();




        MaxHeap<String> maxHeap = new MaxHeap<>();
        maxHeap.insert("Apple");
        maxHeap.insert("Banana");
        maxHeap.insert("Cherry");
        maxHeap.insert("Pineapple");
        maxHeap.insert("Mango");
        maxHeap.insert("Grapes");
        maxHeap.insert("Orange");

        System.out.println("Max element: " + maxHeap.removeMax()); // Should print Pineapple
        System.out.println("Max element: " + maxHeap.removeMax()); // Should print Mango
        System.out.println("MaxHeap Size: " + maxHeap.size());

        String[] sortedArrayMax = new String[maxHeap.size()];
        sortedArrayMax = maxHeap.heapSort(sortedArrayMax);
        for (String num : sortedArrayMax) {
            System.out.print(num + " ");
        }


    }
}