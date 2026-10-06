package Sortings;

public class MergeSort{

    public void mergesort(int[] arr){

        sort(arr,0,arr.length-1);
    }

    private void sort(int[] arr, int left, int right){

        if (left>=right) {
            return ;
        }

        int mid = left + (right - left)/2;

        sort(arr,left,mid);
        sort(arr,mid+1,right);

        merge(arr,left,right, mid);
    }

 private static void merge(int[] arr, int left, int right, int mid) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];


        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }

        for (int i = 0; i < n2; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {

            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }

            k++;
        }


        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

}