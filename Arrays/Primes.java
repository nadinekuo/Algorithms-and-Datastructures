import java.util.Arrays;

public class Primes {

    public static void main(String[] args) {
        int[] numbers = {3, 5, 11, 2, 2, 344};
        int[] primes = {2, 3, 5, 7};
//        System.out.println(max(numbers));
//        System.out.println(index(numbers, 2));
        System.out.println(isPrime(3));
        System.out.println(numPrimes(10));
//        System.out.println(countPrimes(numbers));
    }



    /**
     * Checks whether the given integer value is a prime number.
     * @param n integer value to be checked if it is a prime number or not
     * @return returns true if n is prime, false otherwise
     * COUNTING DIVISORS. This loop repeats n-1 times.
     * (2 and 3 are the first primes)
     */
    public static boolean isPrime(int n) {
        int number = 1;                                     // every number is divisible by 1
        for (int divisor = 2; divisor <= n; divisor++ ) {
            if (n % divisor == 0) {
                number += 1;
            }
        }
        return number == 2;   // primes have 2 divisors
    }



    /**
     * FIND FIRST DIVISOR GREATER THAN 1.
     * This loop repeats at most n-1 times.
     */
    public static boolean isPrime2(int n) {
        int divisor = 2;
        while (n % divisor != 0) {
            divisor += 1;
        }
        return (divisor == n);
    }




    public static boolean isPrime3(int el) {
        if (el > 1) {
            boolean result = true;
            for (int i = 2; i <= Math.sqrt(el); i++) {        //so 2 and 3 will never be evaluated --> true
                if (el % i == 0) {
                    result = false;
                }
            }
            return result;
        }
        return false;
    }



    /**
     * Counts and returns the number of prime numbers that are less or equal
     * than the given integer value.
     * @param n - integer value defining an upper bound on the set of prime number to count
     * @return returns the number of prime numbers that are less or equal than n
     */
    public static int numPrimes(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }




    /** Returns the number of primes in seq.
     * @param seq - an array that contains int values
     * @return the number of primes in seq as int
     */
    public static int countPrimes(int[] seq) {
        int count = 0;
        for (int i = 0; i < seq.length; i++) {
                if (isPrime(seq[i])) {              //reusing previous method:)
                    count++;
                }
        }
        return count;
    }


    /** Returns a new array with all primes in seq.
     * @param seq - an array that contains int values
     * @return a new array
     */
    public static int[] primesIn(int[] seq) {
        int[] temp = new int[seq.length];
        int number = 0;

        for (int i = 0; i < seq.length; i++) {    //copying, filtering
            if (isPrime(seq[i])) {
                temp[number] = seq[i];
                number++;
            }
        }
        int[] primes = new int[number];           //compacting
        for (int i = 0; i < number; i++) {
            primes[i] = temp[i];
        }
        return primes;
    }


    /** Returns an array with all primes up to, but excluding n.
     * @param n - an int value
     * @return an array with int values
     */
    public static int[] primesUpTo(int n) {
        int[] temp = new int[n-1];
        int number = 0;

        for (int i = 2; i < n; i++) {           //copying, filtering
            if (isPrime(i)) {
                temp[number] = i;
                number++;
            }
        }
        int[] primes = new int[number];         //compacting
        for (int i = 0; i < number; i++) {
            primes[i] = temp[i];
        }
        return primes;
    }





}
