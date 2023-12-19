package org.example;

public class NumberCountDown {
    public static void main(String[] args) {
        countDown(5);

    }

    static void countDown(int N){
        if(N == 0){
            return;
        }
        System.out.println(N);
        countDown(N - 1);
        System.out.println(N);
    }
}
