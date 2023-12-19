package org.example;

public class addSum {
    public static void main(String[] args) {

        System.out.println(sum(5));
    }

    static int sum(int N) {
        if(N <= 0){
            return N;
        }
        return sum(N - 1) + N;
    }
}
