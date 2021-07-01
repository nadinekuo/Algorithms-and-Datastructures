public class QuackSortInPlace {

    /**
     * Sorts an array using a modified quicksort.
     * @param arr the array to be sorted
     * IN-PLACE Quick Sort
     * Swap pivot (middle) with last element, so it doesn't get in the way.
     * If (almost( sorted it's not efficient to immediately choose the last element (unbalanced)
     * Bad case too: max in middle (when pivot is middle)
     */
    public static void quackSort(int[] arr) {
        quackSort(arr, 0, arr.length-1);
    }

    // indices low and high will change (recursive calls)
    private static void quackSort(int[] arr, int a, int b) {
        // BASE CASE (a and b have crossed)
        if (a >= b) return;
        // CHOOSE PIVOT, PARTITION
        swap(arr, (a+b)/2, b);      // swap middle and last
        // you wanna have the middle as pivot, cause bigger chance of balanced subsequences
        // but it has to be swapped with the last, cause it stands in the way
        int pivot = arr[b];         // so essentially middle is pivot

        int left = a;
        int right = b-1;            // the pivot is at b!
        while (left <= right) {
            while (left <= right && arr[left] < pivot) {  // find first element >= pivot
                left++; // scan forward
            }
            while (left <= right && arr[right] > pivot) { // find first element <= pivot
                right--; // scan backward
            }
            if (left <= right) {    // if left and right have not strictly crossed, swap
                swap(arr, left, right);
                left++;                 // shrink range
                right--;
            }
        }
        swap(arr, left, b);     // swap left and pivot
        // RECURSIVE CALLS
        quackSort(arr, a, left-1);  // pivot doesn't count
        quackSort(arr, left+1, b);
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
