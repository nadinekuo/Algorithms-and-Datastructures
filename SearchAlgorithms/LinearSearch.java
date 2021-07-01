public class LinearSearch {

    /** Return 1 if x is in arr, else 0
     * Linear Search in O(n) time
     * Linear recursion
     * where n-2
     * **/

    public static int search(int[] arr, int low, int high, int x) {
        if (high < low) // when they have crossed and x has still not been found
            return 0;
        if (arr[low] == x)
            return 1;
        if (arr[high] == x)
            return 1;
        return search(arr, low+1, high-1, x);
    }

}
