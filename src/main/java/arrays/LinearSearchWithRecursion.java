package arrays;

import java.util.ArrayList;

public class LinearSearchWithRecursion {

    public static void main (String[] args){
        int[] arr = {1, 2, 3, 4, 5, 3};

        ArrayList<Integer> targetIndex = linearSearchWithoutListArgs(arr, 3, 0);
        System.out.println(targetIndex);
    }

    static int linearSearch(int[] arr, int target){
        int currentIndex = 0;
        return searchHelper(arr, target, currentIndex);
    }

    static int searchHelper(int[] arr, int target, int currentIndex){
        if (currentIndex > arr.length - 1){
            return  -1;
        }
        if (target == arr[currentIndex]){
            return currentIndex;
        }
        return searchHelper(arr, target, ++currentIndex);
    }

    static int linearSearch2(int[] arr, int target, int currentIndex){
        if(currentIndex > arr.length - 1){
            return -1;
        }
        if (target == arr[currentIndex]){
            return  currentIndex;
        }
        return linearSearch2(arr, target, ++currentIndex);
    }

    static int linearSearch3(int[] arr, int target, int currentIndex){
        int range = arr.length - currentIndex;
        if(currentIndex < 0){
            return -1;
        }

        if(target == arr[currentIndex]){
            return currentIndex;
        }

        return linearSearch3(arr, target, --currentIndex);
    }

    static ArrayList<Integer> myArray = new ArrayList<>();
    static void findAllIndex(int[] arr, int target, int index){
        if(index > arr.length - 1){
            return;
        }
        if(target == arr[index]){
            myArray.add(index);
        }
        findAllIndex(arr, target, ++index);
    }

    static ArrayList<Integer> findAllIndexAndReturnList(int[] arr, int target){
        ArrayList<Integer> myArray2 = new ArrayList<>();
        int index = 0;
        return returnListHelper(arr, target, index, myArray2);
    }
    static ArrayList<Integer> returnListHelper(int[] arr, int target, int index, ArrayList<Integer> myArray2){
        if(index > arr.length - 1 ){
            return myArray2;
        }
        if(target == arr[index]){
            myArray2.add(index);
        }
        return  returnListHelper(arr, target, ++index, myArray2);
    }

    static ArrayList<Integer> linearSearchWithoutListArgs(int[] arr, int target, int index){
        ArrayList<Integer> myArray2 = new ArrayList<Integer>();

        if(index > arr.length - 1 ){
            return myArray2;//*******************************************
        }
        if(target == arr[index]){
            myArray2.add(index);
        }
        ArrayList<Integer> indexArr = linearSearchWithoutListArgs(arr, target, ++index);
        myArray2.addAll(indexArr);
        return myArray2;
    }

}
