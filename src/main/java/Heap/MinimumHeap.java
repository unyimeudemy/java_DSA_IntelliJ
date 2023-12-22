package Heap;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumHeap {
    static ArrayList<Integer> arr = new ArrayList<Integer>();
    public MinimumHeap(){

    }
    public static void main(String[] args){
        MinimumHeap myHeap = new MinimumHeap();
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

    public void insert1(int numberToInsert) {
        arr.add(numberToInsert);
        int indexOfNewElement = arr.size() - 1;
        while (indexOfNewElement > 0) {
            int indexOfParent = (indexOfNewElement - 1) / 2;
            if (arr.get(indexOfNewElement) >= arr.get(indexOfParent)) {
                break;
            }
            int temp = arr.get(indexOfNewElement);
            arr.set(indexOfNewElement, arr.get(indexOfParent));
            arr.set(indexOfParent, temp);
            indexOfNewElement = indexOfParent;
        }
    }


    public void insert(int numberToInsert){
        arr.add(numberToInsert);
        int indexOfNewElement = arr.size() - 1;
        while(indexOfNewElement > 0){
            int indexOfParent = (indexOfNewElement - 1)/2;
            if(arr.get(indexOfNewElement) >= arr.get(indexOfParent)){
                break;
            }
            int temp = arr.get(indexOfNewElement);
            arr.set(indexOfNewElement, arr.get(indexOfParent));
            arr.set(indexOfParent, temp);
            indexOfNewElement = indexOfParent;
        }
    }
    public int getMin(){
        if(arr.size() == 0){
            return -1;
        }
        int min = arr.get(0);
        if(arr.size() == 1) {
            return min;
        }
        int lastElement = arr.get(arr.size() - 1);
        arr.set(0, lastElement);
        int leftChildIndex = 1;
        int rightChildIndex = 2;
        while(lastElement > arr.get(leftChildIndex) || lastElement > arr.get(rightChildIndex)){
            int leftChild = arr.get(leftChildIndex);
            int rightChild = arr.get(rightChildIndex);
            if(arr.get(leftChildIndex) < arr.get(rightChildIndex)){
                arr.set(arr.indexOf(lastElement), leftChild);
                arr.set(leftChildIndex, lastElement);
                leftChildIndex = arr.indexOf(leftChild);
            }

            if(arr.get(rightChildIndex) < arr.get(leftChildIndex) ){
                arr.set(arr.indexOf(lastElement), rightChild);
                arr.set(arr.indexOf(rightChild), lastElement);
                rightChildIndex = arr.indexOf(rightChild);
            }
        }
        return min;

    }
}
