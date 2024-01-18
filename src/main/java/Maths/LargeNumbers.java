package Maths;

import java.math.BigDecimal;
import java.math.BigInteger;

public class LargeNumbers {

    public static void main(String[] args) {
//        bigInteger();
        bigDecimal();
    }

    static void bigInteger(){

        /*
         * For creating a new BigInteger value. Note that is just
         * one of the methods of creating new BigInteger.
         */
        BigInteger str1 = new BigInteger("235452325343424334");
        BigInteger str2 = new BigInteger("235452325");
        System.out.println(str1.multiply(str2));



        /*
         * For converting integer value to BigInteger.
         * The number passed in as argument can only be of type integer
         * Note here that we do not need the new key word
         * because the valueOf method is a static method
         */
        BigInteger A = BigInteger.valueOf(245252543);
        BigInteger B = BigInteger.valueOf(245252543);
        BigInteger sum = A.add(B);
        System.out.println(sum);

        /*
         * For converting BigInteger value to integer.
         */
        int a = str2.intValue();
        System.out.println(a);
    }

    static void bigDecimal(){

        BigDecimal a = new BigDecimal("0.03");
        BigDecimal b = new BigDecimal("0.04");
        BigDecimal c = b.subtract(a);

        BigDecimal k = BigDecimal.TWO;


        System.out.println(k);
    }
    
    static void bigO(int N){
        for (int i = 0; i <= N;) {
            int k = 8;
            for(int j = 0; j <= k; j++) {
                //some operation
            }
            i = i + k;
        }
    }
}
