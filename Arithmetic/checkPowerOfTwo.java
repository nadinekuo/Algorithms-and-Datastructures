
public class checkPowerOfTwo {


    /**
     * Is pow of two ?? (1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048 ...)
     * @param num the num to check
     * @return the boolean
     *  The trick here is that if a number n is a power of two, the bitwise & of it with n-1 will always return 0.
     *  Let's take a look at 4 in binary. 4 = 100. Now, 4-1=3, and 3=011 in binary.
     *  The bitwise & of 100 & 011 = 000
     *  BUT
     *  9 = 1001 and 9-1 = 8 = 1000
     *  1001 & 1000 = 1000 != 0000 !! So not power of 2.
     */
    public static boolean isPowOfTwo(int num) {

        if (num <= 0) return false;
        return (num & (num-1)) == 0;

    }
}
