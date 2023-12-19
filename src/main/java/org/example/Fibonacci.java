package org.example;

public class Fibonacci {
    public static void main (String[] args){
        int ans = fibonacci(5);
        System.out.println("Answer: " + ans);
    }

    static int fibonacci(int n){
         if(n < 2){
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
