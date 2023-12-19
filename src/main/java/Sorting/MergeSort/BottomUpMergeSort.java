package Sorting.MergeSort;

import java.util.Arrays;

public class BottomUpMergeSort {
    public static void main (String[] args) {
        int[] a = {10, 2, 3, 4};
        System.out.println(Arrays.toString(Arrays.copyOfRange(a, 0, 1)));
    }

    static void merge(int[] arr){

    }

    static  int[] merge(int[] left, int[] right){
        int[] mix = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < left.length && j < right.length){
            if(left[i] > right[j]){
                mix[k] = right[j];
                ++j;
            }else{
                mix[k] = left[i];
                ++i;
            }
            ++k;
        }

        while(i < left.length){
            mix[k] = left[i];
            ++i;
            ++k;
        }

        while(j < right.length){
            mix[k] = right[j];
            ++j;
            ++k;
        }
        return mix;
    }

}
