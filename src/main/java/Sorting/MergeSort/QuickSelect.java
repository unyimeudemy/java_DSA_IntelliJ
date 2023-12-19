package Sorting.MergeSort;

import java.util.Arrays;

public class QuickSelect {

    public static void main (String[] args){
        int[] nums = {2, 1, 6, 3, 9};
//        sort(nums, 0, nums.length - 1);
        int K = findK(nums, 0, nums.length - 1);
        System.out.println(K);

    }

    static void sort(int[] nums, int low, int high){
        if(low >= high){
            return;
        }
        int start = low;
        int end = high;
        int middle = low + (high - low)/2;
        int pivot = nums[middle];

        while(start <= end){
            while(nums[start] < pivot){
                start++;
            }
            while (nums[end] > pivot){
                end--;
            }
            if(start <= end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
        sort(nums, low, end);
        sort(nums, start, high);
    }

    static int findK(int[] nums, int low, int high){
        if(low >= high){
            return -1;
        }
        int start = low;
        int end = high;
        int pivot = nums[1];

        //at any point that the element that was chosen still retains its position,

        while(start <= end){
            while(nums[start] < pivot){
                start++;
            }
            while (nums[end] > pivot){
                end--;
            }
            if(start <= end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

        if(indexOfElement(nums, pivot) == 1){
            return pivot;
        }

        sort(nums, low, end);
        sort(nums, start, high);
        return -1;
    }

    static int indexOfElement(int[] arr, int target){
        int i = 0;
        while(arr[i] != target){
            if(i >= arr.length - 1){
                return  -1;
            }
            i++;
        }
        return i;
    }

}

