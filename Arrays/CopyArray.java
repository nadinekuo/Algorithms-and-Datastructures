public class CopyArray {



    /** Returns a result with the same values as seq.
     * @param seq - an array that contains int values
     * @return a result array with the same value as seq
     */
    static int[] copy(int[] seq) {
        int[] result = new int[seq.length];
        for (int i = 0; i < seq.length; i++) {
            result[i] = seq[i];
        }
        return result;
    }



}
