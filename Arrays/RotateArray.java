import java.util.Arrays;

public class RotateArray {



    /** The values are rotated one to the right; the last element is at position 0.
     * @param seq - an array that contains int values
     */
    public static void rotate(int[] seq) {
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
     * @param seq - an array that contains int values
     * @param n - an int value
     */
    public static void rotate(int[] seq, int n) {
        if (seq.length >= 1 && n > 0) {
            for (int j = 0; j < n; j++) {                    //nested for-loop: everything is shifted by 1, n times
                int last = seq[seq.length-1];                //stores the last element of the array
                for (int i = seq.length-1; i > 0; i--) {
                    seq[i] = seq[i - 1];
                }
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
