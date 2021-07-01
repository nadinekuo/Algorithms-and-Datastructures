import java.util.ArrayList;
import java.util.List;

class PQSort extends ListHeapMax {

    /**
     * Takes a list and returns a new list sorted in DESCENDING order.
     * This is done by using the priority queue `queue`. <-- MAX-HEAP
     * Return null if list is null.
     * @param list
     *     the arrayList that needs to be sorted.
     * Time insertion: O (n log n) <-- UPHEAP
     * Time removal: O (n log n) <-- DOWNHEAP (called in library)
     * Space Heap Sort: O(n) <-- linear on #elements to sort
     */
    public static List<Integer> pqSort(List<Integer> list) {
        if (list == null) {
            return null;
        }
        ListHeapMax queue = new PQSort(); // PQ used to sort the input list

        // 1. Insertion
        for (int i = 0; i < list.size(); i++) {     // insert all elements into PQ
            queue.insert(list.get(i));              // insert() calls upHeap()
        }
        // Now all elements are inserted into PQ and heap-order is restored.

        // 2. Removal: repeatedly call removeMax
        // MAX-HEAP, so descending order established
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            result.add(queue.removeMax());          // removeMax() calls downHeap()
        }
        return result;
    }


//    /**
//     * Restores the heap property in a heap represented as an arraylist.
//     * The method compares the node to its parent and SWAPS if necessary.
//     * @param - int i
//     *     INDEX of the node that has been ADDDED to the heap (always heap.size()-1)
//     */
//    @Override
//    public void upHeap(int i) {
//        if (i == 0) {               // if root passed (1 element in heap)
//            return;
//        }
//        while (i > 0) {             // until root
//             int parent = (i-1)/2;  // parent index
//            // heap has private access, so via this method.
//            if (getInHeap(parent) > getInHeap(i)) break;   // heap property verified
//             swap(i, parent);
//             i = parent;            // continue at the parent
//         }
//    }


}