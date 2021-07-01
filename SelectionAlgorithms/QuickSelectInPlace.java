import java.util.Collections;
import java.util.List;


public class QuickSelectInPlace {


    /**
     * * Randomnized: O(1) time
     * * In-place: O(1) space
     * Quick select in place (very SIMILAR to QUICK SORT in place)
     *
     * @param l the list to select from
     * @param k the kth smallest element in l
     * @return the integer WE WORK WITH INDICES! Rankindex is the INDEX belonging to RANK k, so k-1
     */
    public static Integer quickSelectInPlace(List<Integer> l, int k) {
//        return quickSelectHelperList(l, k-1, 0, l.size()-1);

        int[] array = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            array[i] = l.get(i);
        }
        return quickSelectHelper(array, k-1, 0, array.length-1);
    }

    /**
     * FIRST COPY EVERYTHING FROM LIST INTO ARRAY, THEN CALL THIS HELPER METHOD.
     */
    private static Integer quickSelectHelper(int[] arr, int rankidx, int a, int b) {

        if (arr == null || arr.length == 0 || rankidx >= arr.length) return null;
        if (a == b) return arr[a];

        // choose middle element as pivot (first swap middle with last element)
        // TO PREVENT TIMEOUT ERROR (worst case: choosing last as pivot when S is already sorted!)
//        swap(arr, (a+b)/2, b);
        int pivotidx = b;
        int left = a;
        int right = b-1;

        // partition
        while (left <= right) {
            while (left <= right && arr[left] < arr[pivotidx]) {    // left scans forward until element found >= pivot
                left++;
            }
            while (left <= right && arr[right] > arr[pivotidx]) {   // right scans backward until element found <= pivot
                right--;
            }
            if (left <= right) {                        // swap left and right VALUES if not strictly crossed yet + shrink range
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        swap(arr, left, pivotidx);    // swap left and pivot
        pivotidx = left;                        // assign UPDATED pivot INDEX; FINAL PIVOT INDEX is where left was

        if (rankidx == pivotidx) return arr[rankidx];                                        // base case: kth element is the pivot
        else if (rankidx < pivotidx) return quickSelectHelper(arr, rankidx, a, pivotidx-1);     // kth element is <= pivot
        else return quickSelectHelper(arr, rankidx, pivotidx+1, b);                           // kth element is >= pivot
    }

    /** using LIST (adds quite some overhead...)
     */
    private static Integer quickSelectHelperList(List<Integer> l, int rankindex, int a, int b) {

        if (l == null || l.isEmpty() || rankindex >= l.size()) return null;     // when rankidx is larger than size, it does not exist. In this case you can return null because you’re using the Integer class, but if you were working with primitive type integers you might want to throw an exception (as returning any other integer would make it unclear whether this integer would be an error or just an actual element in the array).
        if (a == b) return l.get(a);                            // base case

        // choose middle element as pivot (first swap middle with last element)
        // TO PREVENT TIMEOUT ERROR (worst case: choosing last as pivot when S is already sorted!)
        Collections.swap(l, (a+b)/2, b);
        int pivotindex = b;                  // pivot INDEX! WE WORK WITH INDICES!
        int left = a;
        int right = b-1;

        // partition
        while (left <= right) {
            while (left <= right && l.get(left) < l.get(pivotindex)) {    // left scans forward until element found >= pivot
                left++;
            }
            while (left <= right && l.get(right) > l.get(pivotindex)) {   // right scans backward until element found <= pivot
                right--;
            }
            if (left <= right) {                        // swap left and right VALUES if not strictly crossed yet + shrink range
                Collections.swap(l, left, right);
                left++;
                right--;
            }
        }
        Collections.swap(l, left, pivotindex);    // swap left and pivot
        pivotindex = left;                        // assign UPDATED pivot INDEX; FINAL PIVOT INDEX is where left was

        if (rankindex == pivotindex) return l.get(rankindex);                                        // base case: kth element is the pivot
        else if (rankindex < pivotindex) return quickSelectHelperList(l, rankindex, a, pivotindex-1);     // kth element is <= pivot
        else return quickSelectHelperList(l, rankindex, pivotindex+1, b);                           // kth element is >= pivot
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


//    public static void swap(List<Integer> list, int i, int j) {
//        int temp = list.get(i);
//        list.set(i, list.get(j));
//        list.set(j, temp);
//    }

}
