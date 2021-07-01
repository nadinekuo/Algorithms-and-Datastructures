public class ArrayHeapMax {

    public int[] heap;

    public ArrayHeapMax(int[] arr) {
        heap = arr;
    }

    /**
     * Turns an array of integers into a heap.
     * This is an in-place algorithm, the heap is built in the array itself.
     */
    public void heapify() {
        int n = heap.length - 1;
        for (int root = n / 2; root >= 0; root--) downHeap(root, n);
    }

    /**
     * Restores the heap property in a heap represented as an array.
     * When the heap property is invalid at root,
     * the method fixes the heap first locally before fixing the affected subtree.
     *
     * @param root
     *     Index of the root of the heap, which might be a subtree of the overall heap.
     * @param range
     *     Index of the last element in the heap, array elements with an index > range are not part of the heap.
     */
    public void downHeap(int root, int range) { // starting from node at index root
        // root must be larger than children
        int left = 2*root+1;
        int right = 2*root+2;

        // check the largest of the 3 nodes
        int largest = root;
        if (left <= range && heap[left] > heap[root]) {
            largest = left;
        }
        if (right <= range && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != root) {
            swap(heap, root, largest);  // swap root with largest, if not equal
            downHeap(largest, range);   // single path, cause you choose the largest (O(logn))
        }
        // you can also do it iteratively (better space complexity)
    }

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
     * MAX-HEAP: does it satisfy heap-property? Children smaller than or equal to parent?
     * @param arr integer array to be checked (root at index 0)
     * @param n the size of the array to be checked
     * @return true if the array satisfied the heap property, false otherwise
     * Example: [99, 64, 5, 36, 8, 1] should return true.
     * On the other hand, [99, 36, 5, 64, 8, 1] should return false.
     */
    public static boolean isHeap(int[] arr, int n) {
        if (arr == null) {
            return false;
        }
        boolean result = true;
        for (int entry = 1; entry < arr.length; entry++) {
            if (arr[getParent(arr,entry)] < arr[entry]) {
                result = false;
            }
        }
        return result;
    }

    /**
     * @param arr array representation of a heap (you may assume it is a valid heap)
     * @param i index of node whose parent we're looking for (make no assumptions about it's validity)
     * @return index of the parent of node i, or -1 if: (a) i is not a valid index, (b) i doesn't have a parent
     * Example: getParent([99, 64, 5, 36, 8, 1], 3) should return 1.
     */
    public static int getParent(int[] arr, int i) {
        if (i == 0 || i < 0 || i >= arr.length) {
            return -1;
        }
        return (i-1)/2;
    }


}
