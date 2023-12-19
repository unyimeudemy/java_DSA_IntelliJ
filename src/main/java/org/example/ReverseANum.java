package org.example;

public class ReverseANum {

    public static void main (String[] args){
//        reverseNum2(1234);
        System.out.println(reverseNum3(1234));
    }

    static void  reverseNum1(int N){
        int lastDigit;
        if(N%10 == N){
            lastDigit = N;
            System.out.print(lastDigit);
            return ;
        }
         lastDigit = N%10;
         reverseNum1(N/10);
    }

    static String  reverseNum2(int N){
        int lastDigit;
        int test = (int)(Math.log10(N));
        System.out.println(test);
        if(N%10 == N){
            lastDigit = N;
            return String.valueOf(lastDigit);
        }
        lastDigit = N%10;
        return lastDigit + reverseNum2(N/10);
    }

    static int reverseNum3(int N){
//        System.out.println(1%10);
        int exponent = (int)(Math.log10(N)) + 1;
        return  helper(N, exponent);
    }

    static  int helper(int N, int exponent){
        if(N%10 == N){
            return N;
        }
        int remainder = N%10;
        return remainder * (int)(Math.pow(10, exponent - 1)) + helper(N/10, exponent - 1);
    }
}
