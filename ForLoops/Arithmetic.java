import java.util.Arrays;

public class Arithmetic {

    public static void main(String[] args) {
        int[] test = {2, 3, 5, 6, 34};
    }



    /** Runs in O(n) time
     * @param arr - array
     * @return product of all digits in the array
     */
    public static int product(int[] arr) {
        int n = arr.length;
        int total = 1;
        for (int j = 0; j < n; j++) {
            total *= arr[j];
        }
        return total;
    }


    /** Returns cumulative Gauss sums added to tot, but each Gauss sum is 1 smaller
     *  in O(n^2) time
     * @param tot - starting value
     * @param n - largest n for Gauss sum, the next sum will go until n-1...
     * @return
     */
    public static int f1(int tot, int n) {
        if(n == 0){
            return tot;
        }
        for(int i = 1; i <= n; i++) {
            tot += i;
        }
        return f1(tot, n-1);
    }


    /** Returns cumulative Gauss sums added to tot, but each Gauss sum is 1 smaller
     * in O(n) time
     * @param tot - starting value
     * @param n - largest n for Gauss sum, the next sum will go until n-1...
     * @return
     */
    public static int f2(int tot, int n) {
        if(n == 0) {
            return tot;
        }

        tot += n*(n+1)/2;

        return f2(tot, n-1);
    }

}
