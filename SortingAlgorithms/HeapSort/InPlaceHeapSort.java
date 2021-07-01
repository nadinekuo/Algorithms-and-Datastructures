public class InPlaceHeapSort {

    /**
     * Swaps two elements in an array.
     *
     * @param a
     *     The array to swap elements in.
     * @param i
     *     Position of element to swap in a.
     * @param j
     *     Position of element to swap in a.
     */
    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * Restores the heap property in a heap represented as an array.
     * When the heap property is invalid at root,
     * the method fixes the heap first locally before fixing the affected subtree.
     * MAX-HEAP
     * @param heap
     *     Array representation of a heap, which might be invalidated.
     * @param root
     *     Index of the root of the heap, which might be a subtree of the overall heap.
     * @param range
     *     Index of the last element in the heap, array elements with an index > range are not part of the heap.
     */
    public static void downHeap(int[] heap, int root, int range) { // "current root"
        // index of left and right children
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        int largest;
        if (left <= range && heap[left] > heap[root])
            largest = left;
        else
            largest = root;
        if (right <= range && heap[right] > heap[largest])
            largest = right;
        // heap property invalid at root
        if (largest != root) {
            swap(heap, root, largest);
            downHeap(heap, largest, range); // continue at the child again
        }
    }

    /**
     * Turns an array of integers into a heap.
     * This is an in-place algorithm, the heap is built in the array itself.
     *
     * @param array
     *     an array of integer numbers.
     *     On return, this array represents a valid heap.
     */
    public static void heapify(int[] array) {
        int n = array.length - 1; // last element
        // start at index parent of last element, loop until processing the root
        for (int i = (n-1)/2; i >= 0; i--) {
            downHeap(array, i, n);
        }
    }

    /**
     * Sorts an array of integer numbers.
     * This is an in-place algorithm, the elements inside the array are being sorted without creating a copy of the array.
     * ASCENDING ORDER: MAX-HEAP (otherwise min-heap)
     * @param array <-- NOT NECESSARILY A HEAP, SO FIRST HEAPIFY (build heap of arr)
     *     An array of integer numbers.
     *     On return, this array is sorted.
     *              1. BUILD HEAP: CALL HEAPIFY()
     *              2. "REMOVE MAX" --> by SWAPPING ROOT (0) AND LAST INDEX (i)
     *                  HEAP SHRINKS BY 1 EACH REMOVAL!
     *              3. DOWNHEAP HEAP PART (0 - i-1)
     */
    public static void inPlaceHeapSort(int[] array) {
        heapify(array); // build heap from array
        // swap root (index 0) with last element (index array.length-1) constantly
        // start: heap occupies entire array
        for (int i = array.length-1; i > 0; i--) {
            swap(array, 0, i);        // index 0 is max (root)
            downHeap(array, 0, i-1); // heap has decreased by 1, you need to sort the heap part of the array
        }

    }


}
