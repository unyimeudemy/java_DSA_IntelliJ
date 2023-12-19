package org.example;

public class CheckIfArrayIsSorted {
    public static void main (String[] args){
        int[] arr = {1, 3, 7, 6, 3};
        boolean check = isSorted(arr);
        System.out.println(check);
    }

    static Boolean isSorted (int[] arr){
        int a = 0;
        int b = a + 1;
        return checkFirstAndLast(a, b, arr);
    }

    static Boolean checkFirstAndLast (int first, int second,  int[] arr) {
        int arrLength = arr.length;
        int range = arrLength - first;
        if (second == arrLength){
            return true;
        }
        if( arr[first] > arr[second] ){
            return  false;
        }
        return checkFirstAndLast(++first, ++second,  arr);
    }
}
