public class sumElementsUpTo {


    /**
     * Returns the sum of all elements in the array up to (and including) the `n`th element
     * @param arr the array of integers that needs to be summed
     * @param n the index of the last item to consider
     *          ITERATIVE
     */
    public static int sumElementsUpTo(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += arr[i];
        }
        return sum;
    }


    /**
     * Returns the sum of all elements in the array up to (and including) the `n`th element
     *
     * @param arr the array of integers that needs to be summed
     * @param n the index of the last item to consider
     *          RECURSIVE
     *          helper method allowed
     */
    public static int sumElementsUpTo2(int[] arr, int n) {
        if (n < 0) {
            return 0;
        } else {
            return sumElementsUpTo3(arr, n-1) + arr[n];
        }
    }


    /**
     * @param arr - array
     * @param n - the number of the last digit to count (not index!)
     * @return the sum of the first n digits in the array (not index!)
     * RECURSIVE
     */
    public static int sumElementsUpTo3(int[] arr, int n) {
        if (n == 0) {
            return 0;
        } else {
            return sumElementsUpTo3(arr, n-1) + arr[n-1];
        }
    }





}
