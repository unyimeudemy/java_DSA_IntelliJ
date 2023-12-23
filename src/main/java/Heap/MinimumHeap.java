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
        int min = myHeap.getMin();
        System.out.println(arr);
    }


    public void insert(int numberToInsert){
        arr.add(numberToInsert);
        int indexOfNewElement = arr.size() - 1;
        while(indexOfNewElement > 0){
            int indexOfParent = (indexOfNewElement - 1)/2;
            if(arr.get(indexOfNewElement) >= arr.get(indexOfParent)){
                break;
            }
            swap(indexOfNewElement, indexOfParent);
            indexOfNewElement = indexOfParent;
        }
    }




    public int getMin(){
        if(arr.size() == 0){
            throw new IllegalStateException("Heap is empty");
        }
      int min = arr.get(0);
        int movedElement = arr.remove(arr.size() - 1);
        arr.set(0, movedElement);
      int movedElementIndex = 0;
      while(true){
          int leftChildIndex = 2 * movedElementIndex + 1;
          int rightChildIndex = 2 * movedElementIndex + 2;

          if(leftChildIndex >= arr.size()){
              break;
          }

          int smallerChildIndex = leftChildIndex;
          if(rightChildIndex < arr.size() &&  arr.get(rightChildIndex) < arr.get(leftChildIndex)){
              smallerChildIndex = rightChildIndex;
          }

          if(arr.get(movedElementIndex) <= arr.get(smallerChildIndex)){
              break;
          }

          swap(movedElementIndex, smallerChildIndex);
          movedElementIndex = smallerChildIndex;
      }

      return min;
    }
////


    private void swap (int first, int second){
        int valueAtFirst = arr.get(first);
        arr.set(first, arr.get(second));
        arr.set(second, valueAtFirst);
    }
}
