package org.example;

public class Factorial {

    public static void main(String[] args){

        System.out.println();
    }

    static int getFactorial(int N){
        if(N <= 1){
            return 1;
        }
        return N * getFactorial(N - 1);
    }






}
