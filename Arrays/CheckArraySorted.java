import java.util.HashSet;

public class CheckArraySorted {


    /** Helper: checks whether array (keys) is SORTED and contains NO DUPLICATES
     * It's  either unsorted, or sorted, but then duplicates would be next to each other!!
     * @param array - to check
     * @return - true/false
     */
    public static boolean isArraySorted(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            int current = array[i];
            int next = array[i+1];
            if (next <= current) {
                return false;
            }
        }
        return true;
    }

}
