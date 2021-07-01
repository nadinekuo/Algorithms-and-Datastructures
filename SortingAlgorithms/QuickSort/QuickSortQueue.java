import java.util.LinkedList;
import java.util.Queue;

public class QuickSortQueue {


    /**
     * Sorts the queue using quicksort.
     * @param q - the input queue that needs to be sorted
     * @return a sorted queue containing the elements from q
     */
    public static Queue<Integer> queueSort(Queue<Integer> q) {

        if (q == null) {
            return null;
        }
        // 1. BASE CASE
        if (q.size() < 2) {   // trivially sorted
            return q;
        }
        // 2. DIVIDE
        int pivot = q.peek();                            // pick pivot (first)
        Queue<Integer> less = new LinkedList<>();
        Queue<Integer> equal = new LinkedList<>();
        Queue<Integer> greater = new LinkedList<>();

        while(!q.isEmpty()) {
            Integer el = q.poll(); //dequeue
            if (el < pivot) {
                less.add(el);
            } else if (el > pivot) {
                greater.add(el);
            } else {
                equal.add(el);
            }
        }
            // 3. CONQUER
            less = queueSort(less);
            greater = queueSort(greater);

            // 4. COMBINE RESULTS INTO FINAL LIST (now less and greater are sorted)
            while(!less.isEmpty()) {
                q.add(less.poll());
            }
            while (!equal.isEmpty()) {
                q.add(equal.poll());
            }
            while (!greater.isEmpty()) {
                q.add(greater.poll());
            }
        return q;
    }

}
