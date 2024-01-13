
import java.util.ArrayList;

public class Maths {

    public static void main(String[] args) {
//        int n = 23;
//        System.out.println(isOdd(n));

        Integer[] arr = {2, 2, 3, 2, 7, 7, 8, 7, 8, 8};
//        System.out.println(checkDuplicate2(arr));

//        getBit(4, 97);
//        System.out.println(threeDuplicate(arr));
//        System.out.println(magicNumber(4));
//        System.out.println(numberOfBits(10, 2));
//        System.out.println(sumInEachRowOfPascalTriangle(4));
//        System.out.println(isPowerOfTwo(0));
//        System.out.println(isPowerOfTwo2(8));
//        System.out.println(powerOfNumber(3, 5));
//        System.out.println(p(3, 5));
//        System.out.println(Math.pow(3, 5));
        System.out.println(bitsInNum(21));

    }


    private static boolean isOdd(int n) {
        return (n & 1) == 1;
    }


    static int checkDuplicate2(Integer[] arr){
        /*
         * Given an array with elements existing two times, get
         * the element that exist only once.
         */
        int sum = 0;
        for(Integer i: arr){
            sum = sum ^ i;
        }
        return sum;
    }


    static void getBit(int n, int data){
        /*
         * Given the location of a bit in a binary number, find the bit
         * at that location. What we do here is to perform an operation
         * that will turn all other bits to zero but return the origin
         * bit at that location. This operation will be the & operation.
         *
         * The idea here is that when & is used as an operator between a
         * number and a 1, the number is returned. The problem here is that
         * we have to find a mask that have one at the location we are
         * targeting.
         */
        int mask = 1 << (n - 1);
        int result = data & mask;
        System.out.println(result);
    }

    static void setBit(int n, int data){
        /*
         * Given a binary number, set the value of a bit at a particular
         * location to 1.
         * Recall that when OR | is used as an operator between a bit and 0,
         * the bit is returned. But when it is operated with 1, the value is
         * changed to 1 if it was 0 and will remain 1 if it was 1.
         * Thus, our goal here is to operate the rest of the bit with 0 and our
         * target location with 1. To achieve this, we will create a mask that
         * only has a value at the target location.
         */

        int target = 1 << (n - 1);
        int result = data | target;
        System.out.println(result);
    }

    static void resetBit(int n, int data){
        /*
         * Given a binary number, reset the bit at a particular
         * location.
         * Recall that when AND & is used as an operator between a bit and 0,
         * it will return 0 no matter what the bit. Thus, it is used for resetting.
         *
         * The problem now is how to get the mask binary number that will have all other
         * bits as 1 and the target bit as 0. The way to do this is to get a binary
         * number with only 1 at target location and then running the Bitwise NOT ~
         * on the result before using it for the operation.
         */

        System.out.println("data: " + Integer.toBinaryString(data));
        System.out.println("n: " + Integer.toBinaryString(n));

        int target = ~(1 << (n - 1));
        int result = data & target;

        System.out.println("target: " + Integer.toBinaryString(target));
        System.out.println("~target: " + Integer.toBinaryString(data));
        System.out.println("result: " + Integer.toBinaryString(result));

    }

    static Integer threeDuplicate(Integer[] arr){
        Integer sum = 0;
        for (Integer i: arr){
            sum += i;
        }

        return sum % 3;
    }

     static void loop() {
        int num = 42; // Example number
        System.out.println("Original number: " + num);

         /*
          * The loop will keep running while num still has a value or
          * set bit, meaning while all the bits in num has not been
          * & with the mask.
          *
          * Note that the goal of operating each bit with & is to
          * get the last bit of the current state of num. Then we print
          * it and right shift again.
          *
          * Recall that right shifting by 1 basically cuts the last
          *  bit off num thus num keeps reducing until nothing is
          * there so the while loop breaks.
          *
          */
        while (num != 0) {
            int lastBit = num & 1; // Get the rightmost bit
            System.out.print(lastBit);
            num = num >>> 1; // Right shift by 1 bit
        }
    }

    static double magicNumber(int num){
        int power = 1;
        double sum = 0;
        int base = 5;

        while(num != 0){
            int lastBit = num & 1;
            double product = lastBit * Math.pow(base, power);
            sum = sum + product;
            num = num >>> 1;
            power++;
        }
        return sum;
    }

    static int numberOfBits(int number, int base){
        /*
         * FIND THE NUMBER OF BITS IN A PARTICULAR NUMBER
         *
         * The idea here is that given any number and its base lets
         * say binary (base 2), return the number of bits in the
         * number.
         *
         * It should be noted the method here will be generic and
         * can work for any base apart from binary.
         */

        return (int)(Math.log(number) / Math.log(base)) + 1;
    }

    static int sumInEachRowOfPascalTriangle(int n){
        return 1 << (n - 1);
    }

    static boolean isPowerOfTwo(int num){
        /*
         * Any binary number with more than one set bit is not
         * a power of two. That is, any number that has more than
         * one 1 as a bit is not a power of 2. This is why by mere
         * shifting, we can always get the next power of two.
         *
         * The main idea here is that while the power of two
         * that we have created is less than or equal to the
         * number provide, the variable powerOfTwo to the next
         * power of two. if at any point there is a match, return
         * true but if we eventually get a powerOfTwo that is greater
         * that num, then num is not a power of two and so the
         * loop breaks and false is returned.
         */
        int powerOfTwo = 0;
        int shift = 0;
        if(num == 0) return false;
        while(powerOfTwo <= num){
            if(num == powerOfTwo) return true;
            powerOfTwo = 1 << shift;
            shift++;
        }
        return false;
    }

    static boolean isPowerOfTwo2(int num){
        /*
         *The idea here is that for any given number that is
         * a power of two, it will have one 1 and the rest bit as
         * 0. Then the number minus one will be 1's throughout.
         *
         * This means that if both are operated with &, the result will
         * be 0. But if the result is not 0, then it is not a power
         * of two.
         */
        return num == 0 ? false : (num & (num - 1)) == 0;
    }


    static double p (int base, int power){
        int product = 1;
        while(power > 0){
            int lastBit = power & 1;
            if(lastBit == 1){
                product = product * base;
            }
            base = base * base;
            power = power >> 1;
        }
        return product;
    }

    static int  bitsInNum(int num){
        int c = 0;
        while(num > 0){
            c++;
            num = num & (num - 1);
        }
        return c;
    }
}


