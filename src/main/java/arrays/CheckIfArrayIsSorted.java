package arrays;

public class CheckIfArrayIsSorted {
    public static void main (String[] args){
        int[] arr = {1, 3, 4, 6, 30};
        boolean check = isSorted2(arr, 0);
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

    static boolean isSorted2 (int[] arr, int index){
        if(index == arr.length - 1){
            return true;
        }
        return arr[index] < arr[index + 1] && isSorted2(arr, index + 1);
    }
}
