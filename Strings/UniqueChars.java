import java.util.*;

public class UniqueChars {


    /**
     * Find the first non-duplicate character in a string. Return null if no unique character is found.
     * firstNonRepeatedCharacter( "abcdcd" ) --> 'a'
     * firstNonRepeatedCharacter( "cbcd" ) --> 'b'
     * firstNonRepeatedCharacter( "cdcd" ) --> null
     * @param str
     * @return the FIRST unique character
     * TIME: O(n) - traverse string
     * USING HASHMAP --> expected O(1) for get(), put(), remove()
     * KEY: char
     * VALUE: multiplicity
     */
    public static Character firstNonRepeatedCharacter(String str) {

        if (str == null || str.isEmpty()) return null;

        Map<Character, Integer> map = new HashMap<>();

        for (int i= 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (!map.containsKey(current)) {
                map.put(current, 1);
            } else {
                map.put(current, map.get(current) + 1);     // update multiplicity
            }
        }

        for (char key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return null;
    }


    /**
     * First non repeated character 2 character.
     * TIME: O(n)
     * @param str the string
     * @return the character
     * If the current index of a char == the last index of that char,
     * it only occurs 1x!
     */
    public static Character firstNonRepeatedCharacter2(String str) {

        if (str == null || str.isEmpty()) return null;

        for (int i= 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))) {
                return str.charAt(i);
            }
        }
        return null;
    }



    /**
     * Are all characters unique boolean.
     * Write a method that takes in an input String and returns true if all the characters in the String
     * are unique and false if there is even a single repeated character.
     * The method should return true if the input is null or empty String.
     * @param str the str
     * @return the boolean
     * TIME: O(n)
     * SPACE: O(1)
     */
    public static boolean areAllCharactersUnique(String str){

        if (str == null || str.isEmpty()) return true;

        ArrayList<Character> traversed = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (traversed.contains(str.charAt(i))) return false;
            else {
                traversed.add(str.charAt(i));
            }
        }

        return true;
    }


}
