import java.util.*;
import java.util.Arrays;

class SearchArray {

    public static void main(String[] args) {
//        run();
        int[] grades = {4, 77, 2, -11, -14, -18, -3, -8, 22, 5, -21, 1, 65};
        int[] repetition = {0, 0, 1, 3, 5, 1, 2, 6, 7};
        System.out.println(Arrays.toString(count(repetition, 0)));
//        System.out.println(min(grades));
//        System.out.println(contains(grades, 9));
//        int[] positiveGrades = filterPositives(grades);
//        System.out.println(Arrays.toString(positiveGrades));
//        System.out.println(max(0, grades));
    }




    /**
     * Calculates the number of occurrences of integers from the range
     * {0, ..., r} within a given array of integer elements. Returns
     * the array of counts: a new array of integers of size r + 1, where the
     * element at index i denotes the number occurrences of elements equal
     * to i in the given input array (with i in {0, ..., r}).
     * If the input array is null or of length 0, this will return null.
     *
     * @param arr the array of integer elements to be counted.
     * @param r the integer indicating the last element of the range.
     * @return a new array containing the number of occurrences of each
     * integer {0, ..., r} in the input array (index i has the
     * count of elements equal to i in the input array, with i
     * in {0, ..., r})
     * SPACE: The method should only use additional space for the count array!!!
     * TIME: Counts should be calculated in a SINGLE PASS through the input array!!
     */
    public static int[] count(int[] arr, int r) {
        if (arr == null || arr.length == 0) {
            return null;
        } else {
            int[] count = new int[r + 1];
            for (int i = 0; i < arr.length; i++) {
                if( arr[i] <= r && arr[i] >= 0) {                  // if the number is in the array
                    count[arr[i]]++;                     // increment the value in the new array at the index, belonging to that no.
                }
            }
            return count;
        }
    }



    /**
     * Merges two sorted arrays such that the resulting array has all elements
     * from both arrays and is also sorted. Assumes that the elements in the
     * given arrays are sorted in non-decreasing order. If there are duplicate
     * elements in the input arrays, these should also be present in the
     * resulting array.
     * If both arrays are null the result should be null, or a
     * copy of the non-null array if only one is null.
     * Efficiency requirements: merge the two arrays in a SINGLE PASS!!!
     * @param arr1 first sorted array to be merged
     * @param arr2 second sorted array to be merged
     * @return sorted array containing all elements from both arrays --> O(2n) --> O(n)
     */
    public static int[] merge(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return null;
        } if (arr1 == null) {
            return arr2.clone();
        } if (arr2 == null) {
            return arr1.clone();
        } else {
            int[] merged = new int[arr1.length + arr2.length];

            int index1, index2, indexmerged;
            index1 = index2 = indexmerged = 0;

            while(index1 < arr1.length && index2 < arr2.length) {
                if (arr1[index1] < arr2[index2]) {
                    merged[indexmerged++] = arr1[index1++];         // post increment
                } else {
                    merged[indexmerged++] = arr2[index2++];
                }
            }
// these final 2 while-loops make sure the leftover digits in the longest array get added as well 
            while (index1 < arr1.length) {
                merged[indexmerged++] = arr1[index1++];
            }

            while (index2 < arr2.length) {
                merged[indexmerged++] = arr2[index2++];
            }
            return merged;
        }
    }


    public static void run() {
        // Declare, initialize and bind an array with five spaces.
        int[] numbers = new int[5];

        // Fill the array with the numbers 1 through 5.
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        // Print the number in the 4th position.
        System.out.println(numbers[3]);

    }

    /**Find and return the lowest number in the input array.
     * @param numbers - an array that contains int values
     * @return the lowest number in the input array, or Integer.MAX_VALUE if the array has length 0.
     */
    public static int min(int[] numbers) {
        int n = numbers.length;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    /** Finding the max value using recursion
     * @param i - the starting index for searching through the array
     * @param row - the array of ints
     * @return the max value in the array
     */
    public static int max(int i, int[] row) {
        if (i >= row.length) {
            return Integer.MIN_VALUE;
        } else {
            int max = max(i+1, row);
         if (row[i] > max) {
             return row[i];
         } else {
             return max;
         }
        }
    }

    /** Returns the maximum number in seq.
     * @param seq - an array that contains int values
     * @return an int as maximum number in seq, or Integer.MIN_VALUE if seq has 0 values.
     */
    public static int max(int[] seq) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] > max) {
                max = seq[i];
            }
        }
        return max;
    }


    /** Returns the first index which has the same value as el.
     * @param seq - an array that contains int values
     * @param el - an int value
     * @return the first index which has the same value as el, or -1 if no such value exists.
     */
    public static int index(int[] seq, int el) {
        int index = -1;
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == el) {
                index = i;
                return index;
            }
        }
        return index;
    }


    /** Indicates whether the value el is in seq.
     * @param seq - an array that contains int values
     * @param el - an int value
     * @return a boolean value which is true when el is in seq, else otherwise
     */
    public static boolean contains(int[] seq, int el) {
        boolean res = false;
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == el) {
                res = true;
            }
        }
        return res;
    }


//    /**Indicates whether a specific int value is present in the input array.
//     * @param numbers - an array that contains int values
//     * @param n - an int value
//     * @return a boolean value that is true when n is present in numbers, else otherwise.
//     */
//    public static boolean contains(int[] numbers, int n) {
//        int end = numbers.length;
//        int i = 0;
//
//        while (i != end && numbers[i] != n) {
//            i = i + 1;
//            if (i == n) {
//                return true;
//            } else {
//                return false;
//            }
//            }
//        return false;
//        }


        /** Returns the number of positive int numbers in the array.
         * A number is positive when it is greater than 0.
         * @param numbers - the input array with numbers.
         * @return the number of positive numbers in numbers.
         */
        public static int countPositives(int[] numbers){
            int  n = numbers.length;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (numbers[i] > 0) {
                    count = count + 1;
                }
            }
            return count;
        }

        /** Filters the input array and returns an array that exactly contains the
         * positive numbers in the input array (without additional empty spaces).
         * @param numbers - the input array with numbers.
         * @return An array that contains only the positive numbers in numbers.
         */
        public static int[] filterPositives(int[] numbers){
            int n = numbers.length;
            int[] filtertemp = new int[n];
            int count = 0;

            for (int i = 0; i < n; i++) {       //filtering/copying
                if (numbers[i] > 0) {
                    filtertemp[count] = numbers[i];
                    count = count + 1;
                }
            }

            int[] filter = new int[count];      //compacting
            for (int i = 0; i < count; i++) {
                filter[i] = filtertemp[i];
            }
            return filter;
        }


    public static void addSorted(int[] array, int value, int nElements) {
        if (array.length == nElements) {
            System.out.println("FULL");
            return;
        }
        array[nElements] = value;
        for (int i = nElements; i > 0; i--) {
            if(array[i] < array[i-1]) {
                int temp = array[i];
                array [i] = array[i-1];
                array[i-1] = temp;
            } else {
                break;
            }
        }
    }


}
