package Maths;

public class BasicMathsConcepts {
    public static void main(String[] args) {
//        System.out.println(isPrime(10007));
//        int n = 40;
//         boolean[] primes = new boolean[n + 1];
//        seive(n, primes);

        System.out.println(squareRoot(20, 3));
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
}
