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
        myHeap.getMax();
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

    public int getMax(){
        if(arr.size() == 0){
            throw new IllegalStateException("Array is empty");
        }
        int max = arr.get(0);
        int lastElement = arr.remove(arr.size() - 1);
        arr.set(0, lastElement);
        int indexOfMovedElement = 0;

        while(true){
            int leftChildIndex = 2 * indexOfMovedElement + 1;
            int rightChildIndex = 2 * indexOfMovedElement + 2;

            if(leftChildIndex >= arr.size()){
                break;
            }
            int biggerChildIndex = leftChildIndex;
            if(rightChildIndex < arr.size() && arr.get(rightChildIndex) > arr.get(leftChildIndex)){
                biggerChildIndex = rightChildIndex;
            }

            if(arr.get(indexOfMovedElement) >= arr.get(biggerChildIndex)){
                break;
            }
            swap(indexOfMovedElement, biggerChildIndex);
            indexOfMovedElement = biggerChildIndex;
        }
        return max;
    }


    private void swap(int first, int second){
        int valueAtFirst = arr.get(first);
        arr.set(first, arr.get(second));
        arr.set(second, valueAtFirst);
    }
}
