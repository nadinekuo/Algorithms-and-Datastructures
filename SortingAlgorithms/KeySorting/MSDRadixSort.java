import java.util.ArrayList;
import java.util.List;

public class MSDRadixSort {


    /**
     * O(n * l)  --> even tho we use res.addAll, it's still below this
     * n = amount of strings to sort
     * l = average word length (but with MSD we don't have to process whole words!)
     * Sorts a list of words using MSD radix sort. <-- RECURSIVELY SORT EACH BUCKET (holding 1 letter)
     * FASTER THAN LSD: not all letters have to be processed.
     * @param words
     *     The list of words to sort. <-- the keys (words) can have DIFFERENT LENGTH
     *     WE APPLY BUCKET SORT AT MOST ON EACH LETTER, starting from letter 0. L -----> R
     * @return The sorted list of words.
     * @throws NullPointerException
     *     If `words` equals `null`.
     */
    static List<String> radixSortMSD(List<String> words) {
        if (words == null) throw new NullPointerException("Input is null!!");
        return bucketSort(words, 0);
    }


    // recursive helper
    // we can now sort WITHIN 1 bucket established in previous call, sort by char (elementary key)
    // different length words, to check if pos of char is valid
    // WE DON'T COMPARE LETTERS, WE JUST PLACE THEM IN THE RIGHT BUCKET (0-25)
    private static List<String> bucketSort(List<String> words, int pos) {
        // base case
        if (words.size() < 2) return words;   // trivially sorted

        // Bucket array of 26 buckets for each letter
        List<List<String>> buckets = new ArrayList<>(26);   // N = 26
        for (int i = 0; i < 26; i++) {
            buckets.add(new ArrayList<>());   // initialize all buckets
        }
    // ----------------------- INSERT IN RIGHT BUCKET -------------------------//

        List<String> res = new ArrayList<>(words.size());
        // put each word at the end of a certain bucket --> stable
        for (String w : words) {   // first check if there are still chars (diff length words!), so pos valid?
            if (pos < w.length()) {
                int bucketidx = w.charAt(pos) - 'a';  // offset (each char has a value!)
                buckets.get(bucketidx).add(w);
                System.out.println("Current pos: " + pos + "\nWord " + w + " added to bucket " + bucketidx);
            } else {
                System.out.println("Identical substring found! (entire word processed) --> " + w);
                res.add(w);      // if no more chars, there are 2 identical words!! Otherwise, base case would have been reached.
            }  // example: "hell" will be added before "hello", which still has 1 char, and thus will be added to bucket o
        }

        // -------------------- SORT EACH BUCKET RECURSIVELY + ADD TO RESULT LIST --------------------
        for (List<String> bucket : buckets) {
            res.addAll(bucketSort(bucket, pos + 1));  // go to next char
        }
        return res;
    }

}
