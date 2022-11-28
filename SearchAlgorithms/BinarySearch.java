public class BinarySearch {

    /**
     * Checks if the element `x` is in the sorted array `a`, given that `a` is sorted in descending order.
     * This method should have a worst-case time complexity of O(log n)!!!!
     * If the input array is null, return false.
     * @param a - the array that needs to be searched <-- SORTED IN DESCENDING ORDER
     * @param x - the element we are trying to find
     * @return true if `a` contains `x`, false otherwise
     */
    public static boolean search(int[] a, int x) { // calls BinarySearch
        if (a == null) return false;
        return binarySearch(a, x, 0, a.length-1);

    }


    // RECURSIVE helper method
    // BINARY SEARCH in O(log n) time
    public static boolean binarySearch(int[] arr, int target, int low, int high) {

        if (low > high) return false; // not found: low and high have crossed

        int mid = (low + high)/2;
        if (target == arr[mid]) return true;
        if (target < arr[mid]) {
            return binarySearch(arr, target, low, mid-1);
        } else {                                                 // if not found, low and high will cross
            return binarySearch(arr, target, mid+1, high);  // or if arr is empty, low > high!
        }
    }


    /**
     * NON-RECURSIVE Binary search
     * TIME: O(log n)
     * @param arr - sorted array
     * @param n   - value to find
     * @return  boolean
     */
    public static Boolean binarySearch(int[] arr, int n){
        // Think about maintaining the boundaries of your array with a lo
        // index and a hi index. lo=0; hi=length - 1;
        int lo = 0;
        int hi = arr.length - 1;
        // Use a while loop to iterate until lo <= hi. The moment that lo exceeds
        // hi, we can be sure that the entire array has been searched.
        while(lo <= hi){
            // Create a mid index. int mid = lo + (hi-lo)/2;
            int mid = lo + (hi-lo)/2;
            // If arr[mid] < n, set lo = mid+1 to divide the array
            if(arr[mid] < n) lo = mid+1;
                // Else If arr[mid] > n, set hi = mid - 1 to divide the array
            else if(arr[mid] > n) hi = mid-1;
                // Otherwise, return true!
            else return true;
        }
        return false;
    }





}
