public class MultipleKeysSort {


    // sort rows (which are all different arrays) based on 1 column (passed)
    // could be any strings --> use Comparators, based on natural ordering
    public static void stableSort(String[][] table, int column) {

        int length = table.length;
//        int width = table[0].length;    // table, so all rows should have same length

        // Bubble sort (stable!) --> swaps ENTIRE ROWS
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length-i-1; j++) {      // amount of comparisons shrinks per iteration
                if (table[j][column].compareTo(table[j+1][column]) > 0) {
                    swap(table, j, j+1);
                }
            }
        }


    }

    // Swaps ENTIRE ROWS (row i swaps with row j)
    public static void swap(String[][] arr, int i, int j) {
        String[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Sorts an array of integers in ascending order, this operation needs to be IN-PLACE.
     * O(n^2) time
     * @param arr the array of integers that needs to be sorted in ascending order.
     */
    public static void bubbleSort(int[] arr) {
        // outer loop: make sure entire array is sorted (each iteration, 1 more largest element established)
        // inner loop: where the bubble is, you only compare until the last element of the previous iteration
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {  // amount of comparisons shrinks per iteration
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

// normal swap method
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
