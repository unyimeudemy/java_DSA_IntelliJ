package org.example;

public class ReduceToZero {
    public static void main (String[] args){
        reduce(14);
    }

    static void reduce(int N){
        int counter = 0;
        int numberOfReduction = reduceHelper(N, counter);

        System.out.println(numberOfReduction);
    }

    static int reduceHelper(int N, int counter){
        if(N == 0){
            return counter;
        }
        if(N%2 == 0){
            counter++;
            return reduceHelper(N/2, counter);
        }else{
            counter++;
            return reduceHelper(N - 1, counter);
        }
    }
}
