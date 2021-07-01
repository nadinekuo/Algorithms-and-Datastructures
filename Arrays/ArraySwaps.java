import java.util.Arrays;

public class ArraySwaps {


    /** The values at position 0 and 1 are swapped.
     * @param seq - an array that contains int values
     */
    static void swap(int[] seq) {
        if (seq.length >= 2) {
            int temp = seq[0];
            seq[0] = seq[1];
            seq[1] = temp;
        }
        else {
            throw new IllegalArgumentException();
        }
        System.out.println(Arrays.toString(seq));
    }


    public static void swapChars(char[] input, int i, int j) {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }



}
