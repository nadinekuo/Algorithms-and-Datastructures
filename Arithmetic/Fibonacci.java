public class Fibonacci {

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
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
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
