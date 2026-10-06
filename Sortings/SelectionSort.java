package Sortings;

public class SelectionSort {

    public void selectionSort(int[] arr){

        int n = arr.length;

        for(int i=0; i<n-1; i++){
            int minimumInd = i;

            for(int j = i+1; j<n; j++){
                if(arr[j]<arr[minimumInd]){
                    minimumInd = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minimumInd];
            arr[minimumInd] = temp;
        }
    }
}