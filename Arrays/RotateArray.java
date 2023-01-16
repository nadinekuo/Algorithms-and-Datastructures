import java.util.Arrays;

public class RotateArray {


    /** The trick is to do 3 separate reverses
     * Takes 3 * O(n/2) time = O(n)!
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int[] nums, int start, int end) {
        // Keep on reversing until middle of array is hit
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    /** The values are rotated one to the right; the last element is at position 0.
     * Takes O(n^2) time! Will timeout on large inputs...
     * @param seq - an array that contains int values
     */
    public static void rotateSlow(int[] seq) {
        if (seq.length >= 1) {
            int last = seq[seq.length-1];
            for (int i = seq.length-1; i > 0; i--) {
                seq[i] = seq[i-1];
            }
            seq[0] = last;
        }
        else {
            throw new IllegalArgumentException();
        }
        System.out.println(Arrays.toString(seq));
    }





    /** The values are rotated n times to the right.
     * In-place with O(1) extra memory
     * @param seq - an array that contains int values
     * @param n - an int value
     *
     *  Input: nums = [-1,-100,3,99], k = 2
     * Output: [3,99,-1,-100]
     * Explanation:
     * rotate 1 steps to the right: [99,-1,-100,3]
     * rotate 2 steps to the right: [3,99,-1,-100]
     */
    public static void rotateSlow(int[] seq, int n) {
        if (seq.length >= 1 && n > 0) {
            for (int j = 0; j < n; j++) {                    // Nested for-loop: everything is shifted by 1, n times
                int last = seq[seq.length-1];                // Stores the last element of the array
                for (int i = seq.length-1; i > 0; i--) {
                    seq[i] = seq[i - 1];
                }
                // Swap the first and final element separately
                seq[0] = last;
            }
        }
        else {
            throw new IllegalArgumentException();
        }
        System.out.println(Arrays.toString(seq));
    }


    /** Print the values in seq on 1 line, separated by a space.
     * @param seq - an array that contains int values
     */
    public static void println(int[] seq) {
        for (int i = 0; i < seq.length; i++) {
            System.out.print(seq[i]);
            System.out.print(" ");
        }
    }



}
