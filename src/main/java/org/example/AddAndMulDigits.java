package org.example;

public class AddAndMulDigits {
    public static void main(String[] args) {
        System.out.println(sumDigit(5422));
    }

    static int sumDigit(int N){
        if(N%10 == N){
            return N;
        }
        return  sumDigit(N/10) + N%10;
    }

    static int mulDigit(int N){
        if(N%10 == N){
            return N;
        }
        return   N%10 * mulDigit(N/10) ;
    }
}
