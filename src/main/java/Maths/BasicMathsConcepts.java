package Maths;

import java.util.ArrayList;

public class BasicMathsConcepts {
    public static void main(String[] args) {
//        System.out.println(isPrime(10007));
//        int n = 40;
//         boolean[] primes = new boolean[n + 1];
//        seive(n, primes);

//        System.out.println(squareRoot(20, 3));

//        factor(12);
//        factorOptimized(36);
//        System.out.println(hcf(6, 9));
        System.out.println(lcm(4, 6));
    }



    static boolean isPrime(int num){
        double sqrt = Math.sqrt(num);
        if(num <= 1) return false;
        for (int i = 2; i <= sqrt + 1; i++){
            if(num % i == 0 && num != 2) return false;
        }
        return true;
    }

    static void seive(int n, boolean[] primes){
        /*
         * Given a number n, find the number of prime numbers that
         * are within 1 and n.
         *
         * The main idea here is that will maintain a boolean array
         * that is of the same size with the range and for each element
         * that is a not a prime, we will set to true and others will
         * remain false.
         *
         * Here the first loop looks for prime and the second loop looks
         * for the multiples of the prime numbers and the loop will stop
         * once we have reached the square root of n. This is because for any
         * prime number found the in range, all its multiples in the range
         * can never be prime. Notice here that the search for prime number
         * stops immediately we get a number that is greater than the square
         * root of the given number. This is because beyond this number, the
         * rest are repetition.
         *
         * The second loop checks for the multiple of the prime number found.
         * It should be noted here that this loop starts from i*2 and not i
         * because the very first multiple of any number happens when you
         * double it. Also, it is incremented by adding the prime number to
         * itself (j+=i).
         *
         * The main logic here is that for any number in the range of 2 to
         * n that is a multiple of a number in the range 2 to the square root
         * of n, then that number is not a prime number and thus is boolean in
         * the boolean array representing that number is set to true.
         *
         * Then to print out the all the prime numbers, will loop the range 2
         * to n and use the values in the boolean array as markers to know
         * which one to print. These will be values whose markers are false.
         *
         * Time complexity if O(N * log(log(N))
         */

        for (int i = 2; i*i <= n; i++){
            if(!primes[i]){
                for(int j = i*2; j <= n; j+=i){
                    primes[j] = true;
                }
            }
        }

        for (int i = 2; i <= n ; i++) {
            if(!primes[i]){
                System.out.print(i + " ");
            }
        }
    }

    static double squareRoot(int n, int p){
        /*
         * Find the square root of a given number.
         *
         * The main idea here is that is we will be using binary search
         * to go through the number between 0 and n looking for the root.
         * If the mid squared is greater than n, we shift our focus to
         * the right side. If it is less, we shift to the left and if
         * it is equal, we return the value since this is a perfect square root.
         *
         * Note explanation above only get the whole number part of the
         * root, so in a situation where the root is not a whole number,
         * we will have to run another loop that keeps adding some decimal
         * until n is reached.
         *
         * Here we use a for loop that tracks the number of decimal places
         * we will keep track of. Then we say, for the first decimal place,
         * keep adding 0.1 to the whole number we got from root until either
         * we the value root of root equals the square root of n or the value
         * exceeds it.
         *
         * if the value exceeds, we roll back to the previous value that was
         * just below the root and then start adding 0.01 which is gotten by
         * dividing increment by 10. This pattern of dividing increment by 10
         * continues until we find the root.
         */
        int start = 0;
        int end = n;
        double root = 0.0;
        while (start <= end){
            int mid = start + (end - start)/2;
            if(mid * mid == n){
                return mid;
            }
            if(mid * mid > n){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }


        double increment = 0.1;
        for (int i = 0; i < p; i++){
            while(root * root <= n){
                root += increment;
            }

            root -= increment;
            increment /= 10;
            while(root * root <= n){
                root += increment;
            }
        }

        return root;
    }

    static void factor (int  n){
        for(int i = 1; i <= n; i++){
            if(n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    static void factorOptimized(int n){
        /*
         * The brute method of getting the factors only loops
         * the range between 1 and the number and then prints
         * out those that divide without remainder.
         *
         * To optimise this, we stop the loop once we get to
         * the root n because beyond this value, we will be
         * doing repetition.
         *
         * Notice how the code handles duplicate for numbers with
         * perfect roots and also how we push the bigger values
         * into an array and print it out from the back in order to
         * get a sorted array.
         */
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if(n % i == 0){
                if(n/i == i){
                    System.out.print(i + " ");
                }else{
                    System.out.print(i + " ");
                    list.add(n/i);
                }
            }
        }

        for (int i = list.size() - 1; i >=0 ; i--) {
            System.out.print(list.get(i) + " ");
        }

    }

    static int hcf(int a, int b){
        /*
         * The base case in this recursive method will be once the
         * smaller number reaches 0 then the value of the bigger
         * number is the HCF. This is because the HCF of any
         * non-zero number and 0 is the absolute value of the
         * number itself.
         *
         * Also notice that here that for each recursive call, we
         * ensure that the argument that is passed in as a is the
         * smallest which always the remainder that is gotten from
         * dividing the bigger argument of the previous recursive
         * from the smaller argument of the previous recursive call.
         */
        if(a == 0){
            return b;
        }
        int atemp = b%a;
        int btemp = a;
        return hcf(atemp, btemp);
    }

    static int lcm(int a, int b){
        return (a * b) / hcf(a, b);
    }
}
