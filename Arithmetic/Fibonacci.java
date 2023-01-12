public class Fibonacci {



    /**   O(n) using memoization ITERATIVE !!!
     *    {0, 1, 1, 2, 3, 5, 8, 13, 21, 34}     (note that we start counting at zero).
     *
     *    Returns the n'th Fibonacci number
     */
    public static int fibonacciDynamicIterative(int n) {

        // The array in which you must implement your memoization.
        int[] fibonacci = new int[n + 1];

        fibonacci[0] = 0;
        fibonacci[1] = 1;

        // After that, iterate through all fibonacci numbers from index 2 up to n.
        for (int i = 2; i <= n; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];  // Get the values stored for the 2 previous
        }
        // Returning the obtained fibonacci value at index n.
        return fibonacci[n];
    }


    /**
     * @param n - Fib number to compute
     * @return Fib(n) using long, since int may cause overflow for large numbers....
     */
    public static long fibonacciDynamicRecursive(int n) {

        long[] fibMemoization = new long[n+1];

        // Base cases
        fibMemoization[0] = 0;
        fibMemoization[1] = 1;

        for (int i = 2; i < n+1; i++) {
            fibMemoization[i] = -1;    // initialize all uncomputed values to -1 before passing to helper
        }
        return fibonacciDynamicRecursiveHelper(n, new long[n+1]);
    }




    /**   O(n) using memoization RECURSIVE
     *    {0, 1, 1, 2, 3, 5, 8, 13, 21, 34}     (note that we start counting at zero).
     *
     *    Returns the n'th Fibonacci number
     */
    public static long fibonacciDynamicRecursiveHelper(int n, long[] fibMemoization) {

        if (fibMemoization[n] != -1) {  // Pre-computed value exists
            return fibMemoization[n];
        } else {
            long result = fibonacciDynamicRecursive(n-1) + fibonacciDynamicRecursive(n-2);
            fibMemoization[n] = result;   // Store result!!
            return result;
        }
    }




    /** VERSION 1: O(n) TIME + RECURSIVE HELPER
     * Computes the nth number in the Fibonacci sequence.
     * @param n - the index of the number in the Fibonacci sequence.
     * @return nth number in the Fibonacci sequence
     * USING ONLY 1 RECURSIVE CALL; LINEAR RECURSION --> O(n) time!
     */
    public static int fibonacci2(int n) {
        return fibonacci_helper(n, 1, 1);
    }



    /**
     * Helper function for computing the nth number in the Fibonacci sequence.
     * @param n - the index of the number in the Fibonacci sequence.
     * @param acc1 - accumulator for the previous number in the Fibonacci sequence.
     * @param acc2 -accumulator for the previous number in the Fibonacci sequence.
     * @return
     */
    public static int fibonacci_helper(int n, int acc1, int acc2) {
        if (n <= 1) {
            return n;
        } if (n == 3) {
            return acc1 + acc2;
        }
        return fibonacci_helper(n - 1, acc2, acc1 + acc2);  // you change acc2 so it becomes f(n-1)
    }


    /** VERSION 2: O(n) TIME NON-RECURSIVE
     * Computes the nth number in the Fibonacci sequence.
     * @param n - the index of the number in the Fibonacci sequence.
     * @return nth number in the Fibonacci sequence
     */
    public static int betterFibonacci(int n) {
        int n_2 = 0, n_1 = 1;
        int temp;
        if(n == 0) return n_2;
        else if(n == 1) return n_1;
        else {
            for(int i = 2; i <= n; i++){
                temp = n_1 + n_2;
                n_2 = n_1;
                n_1 = temp;
            }
            return n_1;
        }
    }// the new acc1 is the previous acc2







    /** BAD FIBONACCI: BINARY RECURSION --> O(2^n) time...
     * Computes the nth number in the Fibonacci sequence.
     * @param n - the index of the number in the Fibonacci sequence.
     * @return nth number in the Fibonacci sequence
     */
    public static int fibonacciExponential(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacciExponential(n-1) + fibonacciExponential(n-2);
        }
    }


    /** RETURNS  {F(n-1), F(n-2)}
     * LINEAR RECURSION with n-1 --> O(n) time
     * Computes the nth number in the Fibonacci sequence.
     * @param n - the index of the number in the Fibonacci sequence.
     * @return an array containing the pair of f(n) and f(n-1)
     * See book p. 203 and notebook
     */
    public static long[] fibonacciArray(int n) {
        if (n<=1) {
            long[] answer = {n, 0};
            return answer;
        } else {
            long[] temp = fibonacciArray(n-1);              // returns {F(n-1), F(n-2)}
            long[] answer = {temp[0] + temp[1], temp[0]};       // we want {F(n), F(n-1)}
            return answer;
        }

    }



}
