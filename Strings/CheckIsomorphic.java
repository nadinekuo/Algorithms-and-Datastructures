import java.util.HashMap;
import java.util.Map;

public class CheckIsomorphic {

    /**
     * Given two strings - input1 and input2, determine if they are isomorphic.
     * Two strings are isomorphic if the letters in one string can be remapped to get the second string.
     * Remapping a letter means replacing all occurrences of it with another letter.
     * The ordering of the letters remains unchanged.
     * You can also think of isomorphism as it is used in chemistry - i.e. having the same form or overall shape.
     * TIME: O(n)
     * SPACE: 0(n)
     *
     * Input 1 : "css",  Input 2 : "dll" --->  true
     * Input 1 : "css",  Input 2 : "dls" --->  false
     * Input 1 : "abcd", Input 2: "aabb" --> false
     *
     * @param input1 the input 1
     * @param input2 the input 2
     * @return the boolean
     */
    public static boolean isIsomorphic(String input1, String input2) {

        if (input1 == null && input2 == null) return true;
        if (input1 == null || input2 == null || input1.length() != input2.length()) return false;

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < input1.length(); i++) {
            char current1 = input1.charAt(i);
            char current2 = input2.charAt(i);
            if (!map.containsKey(current1)) {
                if (map.containsValue(current2)) return false;      // if another key was already mapped to this value
                map.put(current1, current2);
            } else if (map.get(current1) != current2) {             // if this key was already mapped to another value
                return false;
            }
        }
        return true;
    }

}
