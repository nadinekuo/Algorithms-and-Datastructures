public class QuickSortInPlace {

    /**
     * @param elements
     *     Array of integers to be sorted.
     * IN PLACE QUICKSORT (no returning)
     */
    public static void quickSort(int[] elements) {
        quickSort(elements, 0, elements.length-1);
    }

    public static void quickSort(int[] elements, int a, int b) {

        // base case
        if (a >= b) return;              // trivially sorted / have crossed

        // 1. Select pivot
        int left = a;
        int right = b-1;                      // last is pivot
        int pivot = elements[b];

        // 2. Partition array into 2, larger/smaller than pivot
        while (left <= right) {
            while (left <= right && elements[left] < pivot) left++;
            // scans array from L to R, looking for el > pivot
            while (left <= right && elements[right] > pivot) right--;
            // scans array from R to L, looking for el < pivot

            // both have stopped moving and have not strictly crossed yet
            if (left <= right) {
                swap(elements, left, right);    // swap and shrink range
                left++;
                right--;
            }
        }
        // swap pivot with left
        swap(elements, left, b);

        // 3. Recur on 2 partitions
        // 4. Merge small, pivot, large
        quickSort(elements, a, left-1); // excluding pivot! (left is now index of pivot)
        quickSort(elements, left+1, b);
    }


    public static void swap(int[] elements, int i, int j) {
        int temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

}
