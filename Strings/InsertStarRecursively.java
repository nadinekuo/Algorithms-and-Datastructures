public class InsertStarRecursively {


    /**
     * Given a string, recursively compute a new string where the identical adjacent characters
     *  in the original string are separated by a "*".
     * insertPairStar("cac") ==> "cac"
     * insertPairStar("cc") ==> "c*c"
     * @param s the string
     * @return the newly computed string
     */
    public static String insertPairStar(String s) {

        if (s == null || s.length() == 1) {
            return s;
        }

        if (s.charAt(0) == s.charAt(1)) {
            return s.substring(0, 1) + "*" + insertPairStar(s.substring(1, s.length()));
        } else {
            return s.substring(0, 1) + insertPairStar(s.substring(1, s.length()));
        }

    }

}
