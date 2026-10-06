package Sortings;

public class BubbleSort{

    public void bubbleSort(int[] arr){
        int n = arr.length;

        for(int i=1; i<n; i++){
            for(int j=1; j<n; j++){
                if(arr[j-1]>arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        
    }
}
