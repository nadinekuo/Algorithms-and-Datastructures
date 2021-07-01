public class BubbleSort {




    /**
     * 1.  Start from index 0 in the array and check every two consecutive elements,
     *      if the left element is greater than the right element, swap the two elements.
     * 2.  When the bubble is at the end of the array, the largest element will be in the last position of the array.
     * 3.   Repeat this process from step 2, however this time only up until the last element in the previous iteration.
     *
     * Sorts an array of integers in ascending order, this operation needs to be IN-PLACE.
     * O(n^2) time <-- NOT EFFICIENT
     * STABLE.
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


    public static int[] bubbleSortArray(int[] arr){

        if (arr == null) return null;
        if (arr.length < 2) return arr; // trivially sorted

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++ ) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
        return arr;
    }

    public static int[] bubbleSortArray2(int[] arr){
        // Find the length of the input array
        int len = arr.length;

        // Run a for loop from the end to the first element. The index will be
        // the tail pointer. Everything to the right of the tail pointer will be
        // assumed sorted as the largest elements would bubble to the tail pointer.
        for(int bubblePosition = len-1; bubblePosition >= 0;bubblePosition--){
            // Run an inner for loop from 0 to the current position of the tail
            // pointer.
            for(int i=0;i<bubblePosition;i++){
                // If the current element > next element, swap the two
                if(arr[i]>arr[i+1]){
                    swap(arr, i, i+1);
                }
            }
        }
        return arr;
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
