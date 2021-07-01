import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class HashMapArray {


    public static void main(String[] args) {
        float test = 6.66f;
        System.out.println(test);
        int conversion = Float.floatToIntBits(test);
        System.out.println(conversion);
        System.out.println(findSum(new float[]{3, 4, 6}, 10));
    }

    /**
     * Find sum float
     * @param arr - array of random floats (32-bits, double is 64-bits)
     * @param x
     * @return the PRODUCT of the 2 floats that sum to x
     * MUST BE IN 0(n)
     * use hashSet (Java) to make it O(n), don't sort. (We don't need values, just keys.)
     * hashmaps work in O(1)
     */
    public static float findSum(float[] arr, float x) {

        ArrayList<Float> bucket = new ArrayList<>();
        for (float f : arr) {
            bucket.add(f);
        }

        HashSet<Float> floats = new HashSet<>();

        for (float f : bucket) {
            floats.add(f);
            float complement = x-f;
            if (bucket.contains(complement)) {
                return complement*f;
            }
        }

        float result = 0;
        return result;
    }


    /**
     * Couple sum int [ ] <--- find the 2 ints that sum to target (1 solution!)
     * @param numbers the numbers to search in
     * @param target  the target
     * @return the 2 indices containing the 2 ints (in array where lowest no. comes first)
     * TIME: O(n) <--- single pass
     * HashMap: O(1) for put, get!!!
     *           key: target - arr[i]   <--- complement
     *          value: i + 1           <----- non-zero based index to return
     */
    public static int[] coupleSum(int[] numbers, int target) {

        HashMap<Integer, Integer> complements = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < numbers.length; i++) {

            int complement = target - numbers[i];

            if (complements.containsKey(complement)) {                   // if i is the complement of a previously visited int
                result[0] = complements.get(complement);
                result[1] = i+1;
                return result;      // the index in the map must be lower!
            } else {
                complements.put(numbers[i], i+1);
            }
        }
        return null;        // sum not found

    }

}
