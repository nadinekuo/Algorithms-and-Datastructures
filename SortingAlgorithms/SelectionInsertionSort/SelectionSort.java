public class SelectionSort {

    /**
     * @param elements
     *     Array of integers to be sorted.
     *     Selection sort is only stable if you insert instead of swap!(here we swap)
     */
    public static void selectionSort(int[] elements) {
        // Start at index 0
        // Find the index with the smallest element
        for (int i = 0; i < elements.length; i++) {
            int currentMin = i;
            int j = i + 1;                          // start searching from element after i
            while (j < elements.length) {           // find INDEX of minimum in the rest of the array
                if (elements[j] < elements[currentMin]) {
                    currentMin = j;       // update currentMin, post-increment j
                }
                j++;
            }
            // minimum found
            int temp = elements[i];                 // Swap the minimum with the element at index i
            elements[i] = elements[currentMin];
            elements[currentMin] = temp;
        }
    }


}
