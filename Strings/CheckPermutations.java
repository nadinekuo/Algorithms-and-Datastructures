import java.util.ArrayList;
import java.util.List;

public class CheckPermutations {

    /**
     * Implement a method that checks if two strings are permutations of each other.
     *
     * permutation("CAT","ACT") --> true
     * permutation("hello","aloha") --> false
     *
     * @param str1 the str 1
     * @param str2 the str 2   ---> if both null, return true
     * @return the boolean
     *
     * TIME: O(n)
     * SPACE: O(n)
     */
    public static boolean permutation(String str1, String str2) {

        if (str1 == null && str2 == null) return true;
        if (str1 == null || str2 == null) return false;
        if (str1.length() != str2.length()) return false;

        // now we know they are of equal length
        List<Character> traversed = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            traversed.add(str1.charAt(i));              // add all chars of string 1 to arraylist
        }

        for (int i = 0; i < str2.length(); i++) {
            if (!traversed.contains(str2.charAt(i))) return false;
            else {
                char current = str2.charAt(i);
                traversed.remove(traversed.indexOf(current));
            }
        }

        if (!traversed.isEmpty()) return false;
        return true;
    }


    public static boolean permutation2(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] letters = new int[256];
        char[] str1_arr = str1.toCharArray();
        // Record all the characters which are in the first string.
        for (char c : str1_arr) {
            letters[c]++;
        }
        // Remove all the characters of second string from records.
        for (int i = 0; i < str2.length(); i++) {
            int c = (int) str2.charAt(i);
            // If any character is not found or found more than the number of times
            // in the second string, strings are not permutation of each other
            if (--letters[c] < 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * Write a method isAnagram that checks if two lowercase input Strings are anagrams of each other.
     * An anagram of a String is a String that is formed by simply re-arranging its letters, using each letter exactly once.
     * Your algorithm should run in linear O(n) time and use constant O(1) space.
     *
     * @param input1 the input 1
     * @param input2 the input 2  ----->  If both null, return false.
     * @return the boolean
     */
    public static boolean isAnagram(String input1, String input2) {

        if (input1 == null && input2 == null) return false;
        if (input1 == null || input2 == null) return false;
        if (input1.length() != input2.length()) return false;

        int[] occurrences = new int[26];
        char[] chars1 = input1.toCharArray();
        for (char c : chars1) {
            int index = c - 'a';        // convert 'a' - 'z' to 0-25
            occurrences[index]++;
        }

        char[] chars2 = input2.toCharArray();
        for (char c : chars2) {
            int index = c - 'a';        // convert 'a' - 'z' to 0-25
            if (--occurrences[index] < 0) return false;
        }
        return true;
    }

}
