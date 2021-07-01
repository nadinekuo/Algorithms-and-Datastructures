public class Arithmetics {


    public static void main(String[] args) {
        System.out.println(multiply(2, 5));
    }


    /** Recursive method multiplying num1 and num2
     * without using *
     * You can use +, -, ==, <
     */
    static int multiply(int num1, int num2) {
        if (num2 == 0) {
            return 0;
        } if (num2 > 0) {
            return num1 + multiply(num1, num2-1);
        } else {
            return -multiply(num1, -num2);
        }
    }







}
