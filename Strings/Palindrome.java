import java.util.*;

public class Palindrome {


    /**
     * Is string palindrome?
     * "madam" or " "   --> true
     * "race car"       --> false
     * @param str to check
     * @return the boolean
     * TIME: O(n), SPACE: O(1)
     */
    public static boolean isStringPalindrome(String str){

        if (str == null || str.isEmpty()) return true;

        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length()-1-i)) return false;
        }
        return true;
    }

}
