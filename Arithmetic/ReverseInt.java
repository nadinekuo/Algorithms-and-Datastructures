public class ReverseInt {


    public static void main(String[] args) {
        System.out.println(reverse(-123));
        System.out.println(-123 % 10);
    }

    /**
     * Reverse 32-bit integer.
     * Input: x = -123
     * Output: -321
     * Input: x = 120
     * Output: 21
     */
    public static int reverse(int x) {
        long res = 0;
        while (x != 0) {
            int digit = x % 10;         // pops off last digit of x
            res = res * 10 + digit;     // makes sure res gets "extended"
            x = x / 10;                 // remove last digit from x (int division rounds down)
        }

        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int)res;
        }
    }


}
