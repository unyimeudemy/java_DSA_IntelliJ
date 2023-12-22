package Heap;

import java.util.ArrayList;

public class MaximumHeap {
    static ArrayList<Integer> arr = new ArrayList<Integer>();

    public static void main(String[] args){
        MaximumHeap myHeap = new MaximumHeap();
        myHeap.insert(2);
        myHeap.insert(5);
        myHeap.insert(1);
        myHeap.insert(9);
        myHeap.insert(4);
        myHeap.insert(0);
        myHeap.insert(3);
        myHeap.insert(7);

        System.out.println(arr);
    }

    public void insert(int numberToInsert){
        arr.add(numberToInsert);
        int indexOfNewElement = arr.size() - 1;
        while(indexOfNewElement > 0){
            int indexOfParent = (indexOfNewElement - 1)/2;
            if(arr.get(indexOfNewElement) <= arr.get(indexOfParent)){
                break;
            }
            swap(indexOfNewElement, indexOfParent);
            indexOfNewElement = indexOfParent;
        }
    }

    private void swap(int first, int second){
        int valueAtFirst = arr.get(first);
        arr.set(first, arr.get(second));
        arr.set(second, valueAtFirst);
    }
}
