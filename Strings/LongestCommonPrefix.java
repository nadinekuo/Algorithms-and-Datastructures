public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }


    /**
     * Input: strs = ["flower","flow","flight"]
     * Output: "fl"
     *
     * @param strs - array of input strings
     * @return String
     */
    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        // Go over all strings linearly
        String currPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) { // skip first string
            while (strs[i].indexOf(currPrefix) != 0) {
                // As long as prefix is not found in curr word, pop off the last char
                // If no common prefix, "" is left
                currPrefix = currPrefix.substring(0, currPrefix.length() - 1);
            }
        }
        // Return whatever is left of the prefix
        return currPrefix;

    }

}
