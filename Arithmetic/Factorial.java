public class Factorial {


    /** Using recursion runs in O(n) time and has O(n) space complexity
     * @param n -
     * @return
     */
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        else {
            return n * factorial(n-1);
        }
    }

    /** Using loop runs in O(n) time but has O(1) space complexity!
     * @param n -
     * @return
     */
    public static int factorialLoop(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;}
        return res;
    }

}
