public class MergeSortQueues {


    /**
     * @param queue1 first SORTED Queue to be merged --> so you can take FIRST
     * @param queue2 second SORTED Queue to be merged
     * @return sorted Queue containing all elements from both Queues
     * NON-INCREASING ORDER
     * If either queue is NULL, return other one as COPY.
     * THE ORIGINAL QUEUES SHOULD STAY THE SAME.
     * MERGES 2 QUEUES INTO NEW SORTED QUEUE: Merge step (not base case / splitting)
     */
    public static ReverseQueue<Integer> merge(ReverseQueue<Integer> queue1, ReverseQueue<Integer> queue2) {

         // SAME QUEUE (same memory location) GIVEN TWICE???

        if (queue1 == null && queue2 == null) { // or isEmpty?
            return null;
        }
        if (queue1 == null) {
            ReverseQueue<Integer> copy2 = new ReverseQueue<>();
            for (int i = 1; i <= queue2.size(); i++) {      // dequeue and enqueue all elements
                int temp = queue2.dequeue();
                copy2.enqueue(temp);
                queue2.enqueue(temp);                       // preserve elements in original queue
            }
            return copy2;
        }

        if (queue2 == null) {
            ReverseQueue<Integer> copy1 = new ReverseQueue<>();
            for (int i = 1; i <= queue1.size(); i++) {      // dequeue and enqueue all elements
                int temp = queue1.dequeue();
                copy1.enqueue(temp);
                queue1.enqueue(temp);                       // preserve elements in original queue
            }
            return copy1;
        }

        ReverseQueue<Integer> result = new ReverseQueue<>();

        // USING !notEmpty as condition GIVES AN INFINITE LOOP! as we enqueue again (to preserve original queue)
        // create 2 counters, for both queues, to make sure you process each element 1x
        int count1 = 0;
        int count2 = 0;
        while (count1 < queue1.size() && count2 < queue2.size()) {
            if (queue1.front() > queue2.front()) {           // Add the largest int first to the result
                int temp = queue1.dequeue();
                result.enqueue(temp);
                queue1.enqueue(temp);                        // preserve elements
                count1++;                                    // update counter after having processed 1 element
            } else {
                int temp = queue2.dequeue();
                result.enqueue(temp);
                queue2.enqueue(temp);
                count2++;
            }
        }
        while (count1 < queue1.size()) {                         // Add remaining elements to result
            int temp = queue1.dequeue();
            result.enqueue(temp);
            queue1.enqueue(temp);
            count1++;
        }
        while (count2 < queue2.size()) {
            int temp = queue2.dequeue();
            result.enqueue(temp);
            queue2.enqueue(temp);
            count2++;
        }

        return result;
    }



}
