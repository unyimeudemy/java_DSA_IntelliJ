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
//        int max = myHeap.getMax();
//        System.out.println("max: " + max);
        ArrayList<Integer> sortedList = myHeap.heapSort();
        System.out.println(sortedList);
    }

    public void insert(int numberToInsert){
        arr.add(numberToInsert);
        int indexOfNewElement = arr.size() - 1;
        upHeap(indexOfNewElement);
    }

    public int getMax(){
        handleEmptyArray();
        if(arr.size() == 1){
            return arr.get(0);
        }
        int max = arr.get(0);
        int lastElement = arr.remove(arr.size() - 1);
        arr.set(0, lastElement);
        int indexOfMovedElement = 0;
        downHeap(indexOfMovedElement);
        return max;
    }

    private void handleEmptyArray(){
        if(arr.size() == 0){
            throw new IllegalStateException("Array is empty");
        }
    }

    private void downHeap(int indexOfMovedElement){
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
    }

    private void upHeap(int indexOfNewElement){
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

    private ArrayList<Integer> heapSort(){
        ArrayList<Integer> sortedList = new ArrayList<>();

        System.out.println(arr.size());
        int size = arr.size();
        for (int i = 0; i < size; i++){
            sortedList.add(this.getMax());
        }

        return sortedList;
    }
}
