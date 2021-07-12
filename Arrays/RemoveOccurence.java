import java.util.ArrayList;

public class RemoveOccurence {


    public static void main(String[] args) {

        int[] test = new int[]{0, 4, 4, 0, 4, 4, 4, 0, 2};
        int[] test2 = new int[]{4, 2, 0, 2, 2, 1, 4, 4, 1, 4, 3, 2};
        int[] test3 = new int[]{};
        System.out.println("k = " + removeElement(test2, 4));

    }



    /**
     * @param nums -  modify in-place! Length array stays the same
     * @param val - no. of elements left (first k in nums, order doesn't matter)
     * @return
     */
    public static int removeElement(int[] nums, int val) {

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];  // we just override all duplicates (doesn't matter!)
                i++;
            }
        }
        return i;

    }





    /**
     * Takes the array and the last occurring element x,
     * shifting the rest of the elements left. I.e.
     * [1, 4, 7, 9], with x=7 would result in:
     * [1, 4, 9].
     *
     * @param x - the entry to remove from the array
     * @param arr - to remove an entry from
     * @return the updated array, without the last occurrence of x
     */
    public static int[] removeLastOccurrence(int x, int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int[] result = new int[arr.length-1];
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                index = i;          // will get updated constantly
            }
        }
        if (index == -1) {
            return arr;
        }
        for (int i = 0; i < index; i++) {
            result[i] = arr[i];
        }
        for (int i = index; i < result.length; i++) {
            result[i] = arr[i + 1];
        }
        return result;
    }


    /**
     * Removes all elements from the ArrayList, using the removeLastOccurrence method.
     * @param list - to remove the elements from.
     */
    public static void removeAll(ArrayList<Integer> list) {
        for (int i = list.size()-1; i >= 0; i--) {
            removeLastOccurrence(list.get(i), list);
        }
    }

    /**
     * Takes an ArrayList and removes last occurrence of x,
     * shifting the rest of the elements left.
     * I.e. [5, 1, 5, 9, 8], with x = 5
     * would result in: [5, 1, 9, 8].
     * Note that this method does not return a new list.
     * Instead, the list that is passed as a parameter is changed.
     *
     * @param list - to remove an element from.
     * @param x - element value to look for
     */
    public static void removeLastOccurrence(int x, ArrayList<Integer> list) {
        if (list != null) {
            int index = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == x) {
                    index = i;
                }
            }
            if (index != -1) {
                list.remove(index);
             }
        }
    }


}
