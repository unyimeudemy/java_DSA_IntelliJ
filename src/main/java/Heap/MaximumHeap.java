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
        downHeap(indexOfNewElement);
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
        upHeap(indexOfMovedElement);
        return max;
    }

    private void handleEmptyArray(){
        if(arr.size() == 0){
            throw new IllegalStateException("Array is empty");
        }
    }

    private void upHeap(int indexOfMovedElement){
        while(true){
            //get left and right children
            int leftChildIndex = 2 * indexOfMovedElement + 1;
            int rightChildIndex = 2 * indexOfMovedElement + 2;


            //ensure heap has at least one child.
            if(leftChildIndex >= arr.size()){
                break;
            }

            //determine the child node to swap depending on which one is bigger
            int biggerChildIndex = leftChildIndex;
            if(rightChildIndex < arr.size() && arr.get(rightChildIndex) > arr.get(leftChildIndex)){
                biggerChildIndex = rightChildIndex;
            }

            //Ensures that the swapping operation meets the condition of a
            //maximum heap. That is, the parent node should be higher
            //to the child node.
            if(arr.get(indexOfMovedElement) >= arr.get(biggerChildIndex)){
                break;
            }

            //swaps the position between the parent ( or index of element moving down the heap )
            //node and the child that is bigger.
            swap(indexOfMovedElement, biggerChildIndex);

            //set the index the parent ( or index of element moving down the heap )
            //to the index of the child node that has just been swapped since the
            // moving node as just come down.
            indexOfMovedElement = biggerChildIndex;
        }
    }

    private void downHeap(int indexOfNewElement){
        while(indexOfNewElement > 0){
            //get parent index
            int indexOfParent = (indexOfNewElement - 1)/2;

            //ensure that the operation satisfies the condition of a maximum
            //heap. The parent node should be greater than the child.
            if(arr.get(indexOfNewElement) <= arr.get(indexOfParent)){
                break;
            }

            //swaps the element in child node with the parent if it child's
            // current position violates the rule of max heap.
            swap(indexOfNewElement, indexOfParent);

            //set the index of the just moved node to the position of
            // parent since it has just moved up.
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
