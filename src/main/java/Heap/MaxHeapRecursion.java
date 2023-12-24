package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxHeapRecursion {
    public static void main(String[] args){
        Heap<Integer> myHeap = new Heap<Integer>();
//        MaxHeapRecursion myHeap = new MaxHeapRecursion();
        myHeap.insert(2);
        myHeap.insert(5);
        myHeap.insert(1);
        myHeap.insert(9);
        myHeap.insert(4);
        myHeap.insert(0);
        myHeap.insert(3);
        myHeap.insert(7);

        ArrayList<Integer> numList = myHeap.returnArray();
        System.out.println(numList);
    }
}

class Heap <T extends Comparable<T>>{
    private ArrayList<T> list;

    public Heap(){
        list = new ArrayList<>();
    }

    public void insert(T value){
        list.add(value);
        upheap(list.size() - 1);
    }

    public T remove() throws Exception {
        if(list.isEmpty()){
            throw new Exception("Removing from an empty list");
        }

        T temp = list.get(0);
        T last = list.remove(list.size() - 1);
        if(!list.isEmpty()){
            list.set(0, last);
        }
        downHeap(0);

        return temp;
    }

    private void upheap(int index) {
        if(index == 0){
            return;
        }
        int p = getParentIndex(index);
        if(list.get(index).compareTo(list.get(p)) < 0){
            swap(index, p);
            upheap(index);
        }
    }

    private void downHeap(int index){
        int min = index;
        int left = getLeftChildIndex(index);
        int right = getRightChildIndex(index);

        if(left < list.size() && list.get(min).compareTo(list.get(left)) > 0){
            min = left;
        }

        if(right < list.size() && list.get(min).compareTo(list.get(right)) > 0){
            min = right;
        }

        if(min != index){
            swap(min, index);
            downHeap(min);
        }
    }

    public void swap(int  first, int second){
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    public int getParentIndex (int i){
        return (i - 1)/2;
    }

    public int getLeftChildIndex(int i){
        return 2 * i + 1;
    }

    public int getRightChildIndex(int i){
        return 2 * i + 2;
    }

    public ArrayList<T> returnArray (){
        return list;
    }
}
