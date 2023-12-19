package org.example;

public class PassingNum {
    public static void main(String[] args) {

    }

    static void passingNum(int N){
        if (N == 0){
            System.out.println(N);
            return;
        }
        System.out.println(N);
        passingNum(--N);
    }

    static void passingNumIterative(int N){
        for(int i = N; i > 0; i--){
            System.out.println(i);
        }
    }
}
