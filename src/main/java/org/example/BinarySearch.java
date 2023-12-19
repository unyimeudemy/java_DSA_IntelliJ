package org.example;

public class BinarySearch {

    public static void main (String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 11 };
        int left = 0;
        int right = arr.length - 1;
        System.out.println(right);
        int targetIndex = search(arr, 4, left, right);
        System.out.println("target index: " + targetIndex);
    }

    static int search (int[] arr, int target, int left, int right){
        int middle = left + (right - left) / 2;
        int tracker = right - left;

        if(left <= right) {
            if (target == arr[middle]) {
                return middle;
            }
            if (target < arr[middle]) {
                return search(arr, target, left, middle - 1);
            }
            if (target > arr[middle]) {
                return search(arr, target, middle + 1, right);
            }
        }
        return -1;
    }

}
