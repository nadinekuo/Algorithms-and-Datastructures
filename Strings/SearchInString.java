public class SearchInString {


    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
    }


    /**
     * @param haystack - substring to look for
     * @param needle - input string
     * @return idx of first occurrence of needle in haystack (if non-existent, -1)
     *
     *     // EXAMPLES
     *     Input: haystack = "hello", needle = "ll"
     *     Output: 2
     *
     *    Input: haystack = "aaaaa", needle = "bba"
     *    Output: -1
     *
     *    Input: haystack = "", needle = ""
     *    Output: 0
     *
     */
    public static int strStr(String haystack, String needle) {

        if (needle.isEmpty()) {
            return 0;
        }

        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        }
        return -1;
    }

}
