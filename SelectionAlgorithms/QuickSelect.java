import java.util.ArrayList;
import java.util.List;

public class QuickSelect {

    /**
     * Randomnized: O(1) time
     * NOT IN PLACE: O(n) space
     * very SIMILAR to QUICK SORT, but only 1 recursive call here (PRUNE AND SEARCH) <--- O(n) instead of O(n log n) for quick sort, which has 2 recursive calls
     * @param l the list to select from
     * @param k the kth smallest element in l
     * @return the integer
     */
    public static Integer quickSelect(List<Integer> l, int k) {
        if (l == null || l.isEmpty()) return null;

        // base case
        if (l.size() == 1) {
            return l.get(0);      // only 1 element
        }

        int pivot = l.get(0);     // pick first as pivot

        // partition
        List<Integer> lesser = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for (int i : l) {
            if (i < pivot) {
                lesser.add(i);
            } else if (i > pivot) {
                greater.add(i);
            } else {
                equal.add(i);
            }
        }

        // recur on ONE sub-sequence only: prune and search
        if (k <= lesser.size()) return quickSelect(lesser, k);
        else if (k <= lesser.size() + equal.size()) return pivot;
        else return quickSelect(greater, k - lesser.size() - equal.size()); // relative index in the greater list (if sorted) !!!!

    }
}
