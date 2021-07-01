import java.util.Comparator;

public class NonRecursiveMergeSort {


    /**
     * Merge sort bottom up for contents of array
     * Not in-place: auxiliary array stores the merged runs
     *      * Starts by merging every successive pair of elements into runs of 2
     *      * Then merges these runs into runs of length 4, 8 etc...
     *      * Until array is sorted
     * Stable??
     */
    public static <K> void mergeSortBottomUp(K[] orig, Comparator<K> comp) {
        int n = orig.length;
        K[] src = orig;                     // reference alias for original
        K[] dest = (K[]) new Object[n];     // new temporary array
        K[] temp;                           // reference used only for swapping
        for (int i = 1; i < n; i *= 2) {        // each iteration sorts all runs of length i
            for (int j=0; j < n; j += 2*i) {    // each pass merges 2 runs of length i
                merge(src, dest, comp, j, i);
            }
            temp = src;
            src = dest;
            dest = temp;    // reverse roles of the arrays
        }
        if (orig != src) {
            System.arraycopy(src, 0, orig, 0, n); // additional copy to get result to original
        }

    }


    /** A bit faster than recursive merge sort (no overhead due to recursive calls)
     */
    public static <K> void merge(K[] in, K[] out, Comparator<K> comp, int start, int inc) {
        int end1 = Math.min(start+inc, in.length);      // boundary for run1
        int end2 = Math.min(start+2*inc, in.length);    // boundary for run2
        int x = start;                                   // index into run1
        int y = start+inc;                              // index into run2
        int z = start;                                   // index into output
        while (x < end1 && y < end2) {
            if (comp.compare(in[x], in[y]) < 0) {
                out[z++] = in[x++];                     // take next from run1
            } else {
                out[z++] = in[y++];                     // take next from run2
            }
        }
        if (x < end1) {                                     // copy rest of run1
            System.arraycopy(in, x, out, z, end1-x);
        } else if (y < end2) {                              // copy rest of run2
            System.arraycopy(in, y, out, z, end2-y);
        }

    }


}
