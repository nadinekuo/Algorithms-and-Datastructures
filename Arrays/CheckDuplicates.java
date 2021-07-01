import java.util.*;

public class CheckDuplicates {


    /** Remove duplicates in-place!! So length does not actually change.
     * 11156778 --> 15678
     * @param nums - SORTED input array
     * @return - "length" of "new" array (only left part occupied)
     */
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }


    /**
     * Return all duplicates
     * @param numbers - unsorted array which may contain duplicates
     * @return the string representation of a collection containing all duplicates
     * TIME: O(n log n) <-- Arrays.sort
     * SPACE: O(n)
     * TreeSet: prevents same numbers from added 2x (when an int in numbers is duplicated more than 2x)
     */
    public static String duplicate(int[] numbers){
        TreeSet<Integer> result = new TreeSet<Integer>();
        // Sort the array
        Arrays.sort(numbers);
        //Iterate over the array
        for(int i = 1; i < numbers.length; i++) {
            // If previous element is the same as current, its the duplicate element
            if(numbers[i] == numbers[i - 1]) {
                result.add(numbers[i]);
            }
        }
        return result.toString();
    }

}
