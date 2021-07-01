import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FindSum {

    /**
     * Find sum float
     * @param arr - array of random floats (32-bits, double is 64-bits)
     * @param x
     * @return the PRODUCT of the 2 floats that sum to x
     * MUST BE IN O(n)!!!
     * use hashSet (Java) to make it O(n), don't sort. (We don't need values, just keys.)
     * hashmaps work in O(1)
     */
    public static float findSum(float[] arr, float x) {

        // loop through array, check if complement already is in map, otherwise add the no.

        // we don't need values, just keys, so set is fine
        HashSet<Float> floats = new HashSet<>();

        for (float f : arr) {
            floats.add(f);
            float complement = x-f;
            if (floats.contains(complement)) {      // searching for element in hashset is O(1)
                return complement * f;
            }
        }

        float result = -1f;
        return result;
    }


    /** USING HASHMAP --> O(n)
     * Returns an array with 2 ints; indices of 2 numbers which add up to target
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /** USING DOUBLE FOR-LOOP --> O(n^2)
     * Returns an array with 2 ints; indices of 2 numbers which add up to target
     */
    public int[] twoSum2(int[] nums, int target) {

        if (nums == null || nums.length == 1) return null;
        if (nums.length == 2) return new int[] {0, 1};

        // loop 1: current from idx 0 --> end
        // loop 2: from idx current + 1 --> end

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] + nums[i] == target) {  // check if adds up to target
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1,-1};               // sum not found
    }

}
