import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        // Hash map stores (value, idx) pair so we can lookup key in O(1) time
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        // Loop over array and find the complement
        for (int i = 0; i < nums.length; i++) {
            // If the pair was added already, we fetch it in the map
            if (map.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }


}
