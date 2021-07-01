import java.util.*;

public class DoctorMSDRadix {

    /**
     * Sorts the list of doctor IDs as defined in the description.
     * @param doctorIds - list of doctor IDs
     * @return sorted list of doctor IDs
     *  4 letters, 2 digits
     * MSD!!!
     * "AA1B3B", "AB2A4B", "BC4D2A", "AB1B3B", "AB2A4A", "AC1B3B", "AC1D4B"
     * becomes
     * "BC4D2A", "AC1D4B", "AC1B3B", "AB1B3B", "AB2A4B", "AB2A4A", "AA1B3B"
     */
    static List<String> sortDoctorIds(List<String> doctorIds) {
        // letters: descending, digits ascending
        if (doctorIds == null) return null;
        return bucketSort(doctorIds, 0);
    }

    private static List<String> bucketSort(List<String> strings, int pos) {
        // base case
        if (strings.size() < 2) return strings;   // trivially sorted

        // Bucket array of 26 + 10 = 36 buckets: one for each letter/digit
        List<List<String>> buckets = new ArrayList<>();   // N = 36
        for (int i = 0; i < 36; i++) {
            buckets.add(new ArrayList<>());   // initialize all buckets
        }
        // ----------------------- INSERT IN RIGHT BUCKET -------------------------//

        List<String> res = new ArrayList<>(strings.size());
        // put each word at the end of a certain bucket --> stable
        for (String w : strings) {   // first check if there are still chars (diff length strings!), so pos valid?
            if (pos < w.length()) {
                // letters Z-A: 0-25 (reversed!)
                // digits 0-9: 26-36
                char symbol = w.charAt(pos);
                int bucketidx;
                if (Character.isDigit(w.charAt(pos))) {
                    bucketidx = 26 + Integer.parseInt(String.valueOf(symbol));
                } else {
                    int offset = symbol - 'A';
                    bucketidx = 25-offset;
                }
                buckets.get(bucketidx).add(w);
                System.out.println("Current pos: " + pos + "\nWord " + w + " added to bucket " + bucketidx);
            } else {
                System.out.println("Identical substring found! (entire string processed) --> " + w);
                res.add(w);      // if no more chars, there are 2 identical strings!! Otherwise, base case would have been reached.
            }  // example: "hell" will be added before "hello", which still has 1 char, and thus will be added to bucket o
        }

        // -------------------- SORT EACH BUCKET RECURSIVELY + ADD TO RESULT LIST --------------------
        for (List<String> bucket : buckets) {
            res.addAll(bucketSort(bucket, pos + 1));  // go to next char
        }
        return res;
    }



}
