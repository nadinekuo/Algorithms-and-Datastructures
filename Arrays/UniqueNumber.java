import java.util.*;

public class UniqueNumber {


    /**
     * MORE EFFICIENT LOOKUP ----> hash table!! (expected O(1) for get(), put(), remove())
     *      * Write a method that returns a number that appears only once in an array.
     *      * Assume the array will surely have a unique value. The array will never be empty.
     *      * {1,2,3,4,1,2,4,3,5} ==> 5
     * @param A the array
     * @return the unique int
     * TIME: O(n)
     */
    public static int singleNumber(int[] A) {
        Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
        int number = 0;
        //iterate through array and populate count for each array element
        for(int i=0; i<A.length; i++) {
            if(ht.containsKey(A[i])) {
                int val = ht.get(A[i]);
                ht.put(A[i], val+1);
            } else {
                ht.put(A[i], 1);
            }
        }
        //iterate Hashtable and find one array element where count = 1;
        Set<Integer> keys = ht.keySet();
        for(Integer key: keys){
            if(ht.get(key) == 1) {
                number = (int)key;
            }
        }
        return number;
    }

    /**
     * Write a method that returns a number that appears only once in an array.
     * Assume the array will surely have a unique value. The array will never be empty.
     * {1,2,3,4,1,2,4,3,5} ==> 5
     * @param A the array
     * @return the unique int
     * TIME: O(n)
     */
    public static int singleNumber2(int[] A) {

        List<Integer> traversed = new ArrayList<>();
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (traversed.contains(A[i])) {
                traversed.remove(Integer.valueOf(A[i]));
                duplicates.add(A[i]);
            } else if (!duplicates.contains(A[i])) {  // if you have an odd no. of duplicates,
                traversed.add(A[i]);
            }
        }
        return traversed.get(0);
    }


}
