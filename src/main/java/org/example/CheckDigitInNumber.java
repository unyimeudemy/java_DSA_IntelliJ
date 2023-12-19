package org.example;

public class CheckDigitInNumber {

    public static void main (String[] args){
        checkTarget(103050, 0);
    }

    static void checkTarget(int N, int target){
        int counter = 0;
        int num = helper(N, target, counter);
        System.out.println(num);
    }

    static int helper(int N, int target, int counter){
        if(N%10 == N){
            if(N%10 == target){
                counter++;
                return counter;
            }
            return counter;
        }
        if(N%10 == target){
            counter++;
        }
        return helper(N/10, target, counter);
    }
}
