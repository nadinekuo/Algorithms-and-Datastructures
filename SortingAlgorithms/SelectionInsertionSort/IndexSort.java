public class IndexSort {

    /**
     * Sorts the indices of the array based on the corresponding value in alphabetical order.
     * Returns null if the input array is null.
     *
     * Example: The array ["c","a","b"] will result in [1, 2, 0].
     *
     * @param arr array of Strings that stored the values
     * @return the indices in sorted order
     *
    // we insert 0,1,2,... into indices
    // we COMPARE the contents of ARR! But SWAP the contents of INDICES!
     */
    public static int[] indexSort(String[] arr) {
        if (arr == null) {
            return null;
        }
        int[] indices = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            indices[i] = i;
        }
        insertionSort(arr, indices);  // in-place
        return indices;
    }

    // in-place insertion sort
    // (going backward is more efficient than forward when almost sorted!)
    // will sort indices (update indices array in-place)
    // original array is unchanged

    private static void insertionSort(String[] arr, int[] indices) {
        for (int i = 1; i < arr.length; i++) {      //start at 2nd element
            // we use string array as reference to sort indices array!
            String current = arr[indices[i]];     // Index in indices array!! To get proper index.
            int j = i;        // i is current, j is previous
            // alphabetical order comparison
            while (j > 0 && current.compareTo(arr[indices[j-1]]) < 0) { // previous (j) larger than i
                indices[j] = indices[j-1];      // you don't wanna change the original string array! We sort indices.
                j--;
            }
            indices[j] = i;
        }
    }

    // different version (where j starts at i-1)
//    private static void insertionSort(String[] arr, int[] indices) {
//        for (int i = 1; i < arr.length; i++) {
//            String current = arr[indices[i]];
//            int j = i-1;
//            while (j >= 0 && current.compareTo(arr[indices[j]]) <= 0) {
//                indices[j+1] = indices[j];
//                j--;
//            }
//            indices[j+1] = i;
//        }
//    }

}
