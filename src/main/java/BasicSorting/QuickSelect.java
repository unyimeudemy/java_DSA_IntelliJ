package BasicSorting;
import java.util.Arrays;

public class QuickSelect {
    public static void main (String[] args){
        int[] arr = {2, 1, 6, 3, 0, 10};
        int k = 1; // Example: Find the 3rd smallest element
        int result = quickSelect(arr, 0, arr.length - 1, k - 1); // k-1 because arrays are zero-indexed
        System.out.println("The " + k +  "th smallest element is: " + result);

    }

    static int quickSelect(int[] arr, int low, int high, int k){

        if(low <= high){
            int partitionIndex = partition(arr, low, high);
            if(partitionIndex == k){
                return arr[partitionIndex];
            } else if (partitionIndex > k) {
                return quickSelect(arr, low, partitionIndex - 1, k);
            }else{
                return quickSelect(arr, partitionIndex + 1, high, k);
            }
        }
        return -1;
    }

    static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j <= high; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

}

