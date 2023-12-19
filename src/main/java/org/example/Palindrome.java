package org.example;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class Palindrome {

    public static void main (String[] args){
        System.out.println();
        isPalindrome2(1234);
    }

    static Boolean isPalindrome(int number){
        return number == Integer.parseInt(reverseNum2(number));
    }

    static String  reverseNum2(int N){
        int lastDigit;
        if(N%10 == N){
            lastDigit = N;
            return String.valueOf(lastDigit);
        }
        lastDigit = N%10;
        return lastDigit + reverseNum2(N/10);
    }

    static void isPalindrome2(int N){
        List<Character> numArr = pushToList(N);
        System.out.println(numArr.toArray().length);

    }

    static List<Character> pushToList(int N){
        List<Character> numArr = new ArrayList<Character>();
        String strNum = Integer.toString(N);
        for(int i = 0; i < 3; i++){
            numArr.add(strNum.charAt(i));
        }
        return  numArr;
    }

}
