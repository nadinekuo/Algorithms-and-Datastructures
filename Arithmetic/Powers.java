public class Powers {


    /** TIME: O(n)
     * SPACE: O(n)
     * @param x - base
     * @param n - power
     * @return x raised to the power of n using RECURSION (not tail)
     */
    public static double power(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * power(x, n-1);
        }
    }

    /** TIME: O(n)
     * SPACE: O(1)
     * @param x - base
     * @param n - power
     * @return x raised to the power of n ITERATIVELY
     */
    public static int power2(int x, int n) {
        int res = 1;
        while(n > 0) {
            res = x * res;
            n--;
        }
        return res;
    }

    /** TIME: O(log(n)) !!
     * SPACE: O(log(n)) !!
     * @param x - base
     * @param n - power
     * @return x raised to the power of n using RECURSION
     * Repeatedly splits the problem in half
     */
    public static double power3(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            double partial = power3(x, n/2);
            double result = partial * partial;
            if (n % 2 == 1) {
                result *= x;                        // if n is odd, include extra factor of x
            }
            return result;
        }
    }


    /** Computes 2^x in O(n^2) time using binary recursion
     * @param x - exponent
     * @return - 2 raised to the power of x
     */
    public static int powerOfTwo(int x) {
        if (x < 1) {
            return 1;
        } else {
            return powerOfTwo(x-1) + powerOfTwo(x-1);
        }
    }

}
