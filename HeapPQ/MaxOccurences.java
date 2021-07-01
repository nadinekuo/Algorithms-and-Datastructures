public class MaxOccurences {


    /**
     * Checks if every integer element in the array `a` appears at most `k` times.
     * This method should have a worst-case time complexity of O(n log n).
     * If the input array is null, return true.
     * @param a - the array to search
     * @param k - the MAXIMUM number of times EACH element should appear in the array
     * @return true if EACH INTEGER element appears AT MOST 'k' times in 'a', false otherwise
     * USES HEAP PRIORITY QUEUE (MAX-heap) --> so all duplicate ints follow each other!
     * HEAP SORT --> O(n log n)
     *
     * Given the array declaration int[] a = {2, 3, 1, 4, 5, 1, 7, 0};,
     * the call upperCount(a,2) should return true, while the call upperCount(a,1) should return false.
     */
    public static boolean upperCount(int[] a, int k) {

        if (a == null || k == 0) return true;

        // Create new PQ (MAX heap) + Insert all elements
        ListHeapMax heap = new ListHeapMax();
        for (int i = 0; i < a.length; i++) {
            heap.insert(a[i]);
        }

        int previous = heap.removeMax();
        System.out.println("First removed: " + previous);
        int current = heap.removeMax();

        while (!heap.isEmpty()) {

            // if current and prev not equal, "shift 1 spot to the right" until they ARE equal! --> inner loop executed
            // Else, you get infinite loop!!!!
            if (current != previous) {
                previous = current;
                current = heap.removeMax();
            }

            int count = 1;
            while (current == previous && !heap.isEmpty()) {        // if equal, start counting occurrences
                count++;
                System.out.println("Current count of occurrences: " + count);
                if (count > k) return false;       // AT MOST k occurrences allowed

                previous = current;
                current = heap.removeMax();
                System.out.println("Next removed: " + current);
            }

        }
        return true;
    }

}
