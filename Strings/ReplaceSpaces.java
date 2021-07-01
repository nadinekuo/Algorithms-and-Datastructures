public class ReplaceSpaces {

    public static String replace(String a, String b) {

        // replace("This is a test","/") --> "This/is/a/test"

        if (a == null) return null;
        if (a.isEmpty()) return "";
//        if (a.equals(" ")) return b;

        StringBuilder sb = new StringBuilder();
        int startidx = 0;

        // loop until space found --> store substring
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == ' ') {
                sb.append(a.substring(startidx, i));      // exclusive end index, so ' ' not included.
                sb.append(b);
                startidx = i + 1;                         // update start index for substring
            } else if (i == a.length() - 1) {
                sb.append(a.substring(startidx));       // takes substring until end
            }
        }
        // append the remaining part of the string
        return sb.toString();
    }

}
