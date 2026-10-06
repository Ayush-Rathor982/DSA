package Sortings;

import java.util.Arrays;

public class Main {

    public static void main(String[] args){

        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        InsertionSort insertionSort = new InsertionSort();
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();


        int[] arr1 = new int[]{5,6,3,8,10,50,30};
        bubbleSort.bubbleSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = new int[]{5,6,3,8,10,50,30};
        selectionSort.selectionSort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = new int[]{5,6,3,8,10,50,30};
        insertionSort.insertionSort(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = new int[]{5,6,3,8,10,50,30};
        mergeSort.mergesort(arr4);
        System.out.println(Arrays.toString(arr4));

        int[] arr5 = new int[]{5,6,3,8,10,50,30};
        quickSort.quickSort(arr5);
        System.out.println(Arrays.toString(arr5));
    }
}