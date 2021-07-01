public class InsertionSort {

    /**
     * @param elements
     *     - array of integers to be sorted.
     * in-place INSERTION SORT: increasing order
     */
    public static void insertionSort(int[] elements) {
        // start at index 1
        for (int i = 1; i < elements.length; i++) {
            int current = elements[i];
            // iterate backwards
            int j = i;
            while (j > 0 && elements[j - 1] > current) { // if any of previous elements larger, shift to right
                elements[j] = elements[j - 1]; // shift to right to make space for current (copy! Not swap)
                j--;
            }
            elements[j] = current;              // insert at right index
        }
    }

}
