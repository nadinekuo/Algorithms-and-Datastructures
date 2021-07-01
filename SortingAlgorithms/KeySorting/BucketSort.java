import java.util.*;
import java.util.Queue;

public class BucketSort {

    // input array only contains keys, no values
    // Puts elements into corresponding bucket in bucket array (Queues as buckets)
    public static Queue<Integer>[] fillBuckets(int[] array) {

        if (array.length == 0) return new Queue[0];

        int vmin = 0;
        int vmax = 0;

        vmin = Arrays.stream(array).min().getAsInt();
        vmax = Arrays.stream(array).max().getAsInt();

        Queue<Integer>[] buckets = new Queue[vmax - vmin + 1];  //size of bucket array is #keys (N)

        // first initialize all buckets
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (int i = 0; i < array.length; i++) {
            int relativeindex = array[i] - vmin;
            buckets[relativeindex].add(array[i]);
        }

        return buckets;
    }

    // turns the created buckets (passed as parameter) into a sorted array
    public static int[] readBuckets(Queue<Integer>[] buckets) {

        // remove from bucket[i] and insert in result array
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < buckets.length; i++) {
            while (!buckets[i].isEmpty()) {
                temp.add(buckets[i].poll());
            }
        }

        int[] sorted = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            sorted[i] = temp.get(i);
        }
        return sorted;
    }





}
