import java.util.*;
import java.util.Queue;

public class LSDRadixSort {


    /**
     * Sorts a list of Dutch mobile phone numbers using LSD radix sort.
     * SORT elementary keys (ints) FROM RIGHT TO LEFT.
     * @param phoneNumbers OF EQUAL LENGTH! (LSD) All start with 06.
     *     The list of phone numbers to sort.
     * @return The sorted list of phone numbers.
     * @throws NullPointerException
     *     If `phoneNumbers` equals `null`.
     * For example, if the content of the input array is [0687654321, 0612301345, 0612300123, 0612345678],
     * the content of the output array should be [0612300123, 0612301345, 0612345678, 0687654321].
     * Bucket sort applied 8 times ---> O(d(n+N)) --> O(n)
     * d = 8
     * n = list.size()
     * N = 10 (elementary keys 0-9)
     */
    static List<String> radixSortLSD(List<String> phoneNumbers) {

        if (phoneNumbers == null) {
            throw new NullPointerException();
        }
        if (phoneNumbers.size() < 2) return phoneNumbers;   // trivially sorted

        List<String> result = phoneNumbers;
        for (int pos = 9; pos > 1; pos--) {           // start from last digit, end at 3rd digit (06 doesn't have to be sorted)
            result = bucketSort(result, pos);              // result list processed for each digit
        }
        return result;
    }


    /**
     * Bucket sort: sorts list based on 1 DIGIT. (pos)
     * @param phoneNumbers the phone numbers
     * @param pos - index of the 1 digit we sort on.
     * PROCESSES THE INPUT LIST.
     *            Bucket array consists of 10 Queues (LinkedLists), 1 for each digit.
     */
    private static List<String> bucketSort(List<String> phoneNumbers, int pos) {

        Queue<String>[] bucketArray = new Queue[10];    // we store 10 buckets, 1 for each digit (0, 1, ...8, 9)

        // initialize all buckets
        for (int i = 0; i < bucketArray.length; i++) {
            bucketArray[i] = new LinkedList<>();
        }

        // insert all keys into proper bucket --> there can be multiple strings in the same bucket!
        for (int i = 0; i < phoneNumbers.size(); i++) {
            String currentNumber = phoneNumbers.get(i);
            char digit = currentNumber.charAt(pos);       // the digit determines which bucket
            int bucketno = Integer.parseInt(String.valueOf(digit));
                System.out.println("String " + currentNumber + " is put in bucket " + bucketno + " >> Current digit pos: " + pos);
            bucketArray[bucketno].add(currentNumber);
        }

        // loop through whole bucket array, put in result list. (stably sorted)
        List<String> result = new ArrayList<>();

        for (int i = 0; i < bucketArray.length; i++) {
            while (!bucketArray[i].isEmpty()) {         // Make each bucket empty, add strings to result.
                result.add(bucketArray[i].poll());      // FIFO, so stable.
            }
        }
                System.out.println("Current result: " + result);
        return result;
    }

}
