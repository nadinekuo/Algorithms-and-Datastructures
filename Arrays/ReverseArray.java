public class ReverseArray {


    public static void main(String[] args) {

        int[] digits = {2, 5, 4, 2, 5, 32, 76, 14};
        char[] harry = {'H', 'a', 'r', 'r', 'y'};
        System.out.println(reverseString(harry));

    }

    /**
     * Reverses the order of the elements of the given array.
     * @param arr - array to be reversed
     * When array is null, nothing should happen and algorithm should terminate.
     *            WHILE LOOP
     */
    public static void reverse2(int[] arr) {
        int low = 0;
        int high = arr.length-1;
        while (low < high) {
            int temp = arr[low];
            arr[low++] = arr[high];
            arr[high--] = temp;
        }
    }


    /**
     * Reverses the order of the elements of the given array.
     * @param arr - array to be reversed
     * When array is null, nothing should happen and algorithm should terminate.
     *            RECURSION --> O(n) time
     * @param low - index 0
     * @param high - last index, arr.length-1
     */
    public static void recursiveReverse(int[] arr, int low, int high) {
        if (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            recursiveReverse(arr, low + 1, high - 1);
        }
    }


    /**
     * Reverses the order of the elements of the given array.
     * @param arr - array to be reversed
     * When array is null, nothing should happen and algorithm should terminate.
     *            FOR LOOP
     */
    public static void reverse(int[] arr) {
        if (arr != null) {
            for (int i = 0; i < arr.length/2; i++) {
                int temp = arr[i];
                arr[i] = arr[arr.length-i-1];
                arr[arr.length-i-1] = temp;
            }
        }
    }

    public static char[] reverseString(char[] input) {
        if (input.length >= 1) {
            for (int i = 0; i < input.length/2; i++) {
                char temp = input[i];
                input[i] = input[input.length-i-1];
                input[input.length-i-1] = temp;
            }
        } else {
            throw new IllegalArgumentException();
        }
        return input;
    }

}
