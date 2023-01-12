import java.util.*;

public class RomanToInteger {

    public static void main(String[] args) {
//        Input: s = "MCMXCIV"
//        Output: 1994
//        Explanation: M = 1000, CM = 900, XC = 90 and IV = 4
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        // Create map for Roman converted to int
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        // Start from final char, go left
        int n = s.length();
        int finalNum = romanMap.get(s.charAt(n-1));

        for (int i = n-2; i >= 0; i--) {
            // If preceeding symbol is smaller, subtract, else add
            if (romanMap.get(s.charAt(i)) >= romanMap.get(s.charAt(i+1))) {
                finalNum += romanMap.get(s.charAt(i));
            } else {
                finalNum -= romanMap.get(s.charAt(i));
            }
        }
        return finalNum;
    }


}
