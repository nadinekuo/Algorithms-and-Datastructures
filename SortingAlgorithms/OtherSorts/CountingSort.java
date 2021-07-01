public class CountingSort {

    // bit similar to bucket sort, but you don't put things in buckets, the bucket array just has the counts.
    public static int[] countingSort(int[] arr) {
        if (arr == null || arr.length == 0) return arr;

        // find min and max
        // if you let bucket array start at 1, it would be really large; not efficient
        int min = arr[0];
        int max = arr[0];
        for (int x : arr) {
            if (x > max)
                max = x;
            if (x < min)
                min = x;
        }

        // count number of occurences
        int[] count = new int[max - min + 1];
        for (int x : arr) {
            count[x - min]++;   // relative index (offset), min doesnt have to be 0
        }
        // now we have the number of occurences in arr PER INDEX.

        // CHANGE values at indices into cumulative sums
        // count[i] tells you how many elements are <= to i, so you know at what index you need to insert.
        for (int i = 1; i < count.length; i++) {  // start at index 1
            count[i] += count[i-1];
        }

        int[] res = new int[arr.length];
        for (int x : arr) {
            res[count[x-min] - 1] = x;  // count - 1 gives the index for the result array
            count[x-min]--;             // decrease count by 1, so a duplicate int doesnt end up at the same index in res, but will be inserted in front
        }
        return res;

    }

}
