import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSortSplitInThree {


    public static int[] mergeSort(int[] elements){

        // trivially sorted
        if (elements == null || elements.length < 2) {
            return elements;
        }

        // if length is 2, and you do split1*2, you get 0 again!!
        // So if size=2, it never gets split in half!! And thus you never reach base case.
        if (elements.length == 2) {
            if (elements[0] > elements[1]) {
                int temp = elements[0];
                elements[0] = elements[1];
                elements[1] = temp;
            }
            return elements;
        }

        int split1 = elements.length/3;
        int split2 = split1*2;

        // divide
        int[] s1 = Arrays.copyOfRange(elements, 0, split1);
        int[] s2 = Arrays.copyOfRange(elements, split1, split2);
        int[] s3 = Arrays.copyOfRange(elements, split2, elements.length);

        s1 = mergeSort(s1);
        s2 = mergeSort(s2);
        s3 = mergeSort(s3);

        // combine (merge): METHOD CALL IN METHOD CALL
//        return merge(merge(s1, s2), s3);
        return merge2(s1, s2, s3);
    }



    // helper method: MERGES 2 SUB-ARRAYS (normal)
    private static int[] merge(int[] s1, int[] s2) {
        int[] result = new int[s1.length + s2.length]; // enough capacity
        int i = 0;            // index array s1
        int j = 0;            // index array s2
        int r = 0;             // index result array
        while (i < s1.length && j < s2.length) {
            if (s1[i] < s2[j]) {          // if s1 has smallest currently
                result[r++] = s1[i++];    // insert smallest into larger res array and post-increment both indices
            } else {
                result[r++] = s2[j++];
            }
        }
        while (i < s1.length) result[r++] = s1[i++];       // if elements left still
        while (j < s2.length) result[r++] = s2[j++];
        return result;

    }


    // helper method: MERGES 3 SUB-ARRAYS
    // assumes input arrays are sorted
// will be executed for arrays with at least 2 elements
    private static int[] merge2(int[] s1, int[] s2, int[] s3) {

        int[] result = new int[s1.length + s2.length + s3.length];
        int i = 0;
        int j = 0;
        int k = 0;
        int r = 0;

        while (i < s1.length || j < s2.length || k < s3.length) {       // keep looping until ALL 3 arrays have reached end

            int min = Integer.MAX_VALUE;
            int[] minArray = null;              // gets assigned to array with min value at current idx, WHILE end of array not reached

            if (i < s1.length) {                        // s1 has min for now
                min = s1[i];
                minArray = s1;
            } if (j < s2.length && s2[j] < min) {    // s2 has min
                min = s2[j];
                minArray = s2;
            } if (k < s3.length && s3[k] < min) {       // s3 has min
                min = s3[k];
                minArray = s3;
            }

            if (minArray == s1) {
                result[r++] = s1[i++];
            } else if (minArray == s2) {
                result[r++] = s2[j++];
            } else {
                result[r++] = s3[k++];
            }

        }

        return result;

    }



}
