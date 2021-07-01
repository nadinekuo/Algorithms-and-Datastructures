public class MessageGarbler {

    // The size of the blocks used in this MessageGarbler
    public int m;

    /**
     * Creates a MessageGarbler that splits any messages it receives into blocks of size m, the last block will contain the remainder
     *
     * @param m
     */
    public MessageGarbler(int m) {
        this.m = m;
    }

    /**
     * Encrypts a message by splitting the message into blocks of size m and reversing each block.
     * @param message
     *     the message to be encrypted
     * @return
     */
    public char[] encrypt(char[] message) {
//        return encryptWithPointers(message);
        return encryptWithSB(message);

    }

    public char[] encryptWithPointers(char[] message) {

        int n = message.length;
        char[] res = message;
        int pointer;

        // reverses first m-1 blocks IN PLACE (loop stops when remainder part reached)
        for (pointer = 0; pointer + m < n; pointer += m) {
            for (int j = 0; j < m/2; j++) {
                swapChars(res, pointer+j , pointer+m-1-j);
            }
        }
//        System.out.println(pointer);
        // reverses LAST block (remainder): now pointer is at first idx of last block
//        int remaindersize = n % m; <---- this doesn't work because it could be 0 if all equal sized blocks!
        int remainder = n - pointer;
        for (int j = 0; j < (remainder)/2; j++) {
            swapChars(res, pointer+j, n-1-j);
        }

        return res;
    }


    public static void swapChars(char[] input, int i, int j) {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public char[] encryptWithSB(char[] message) {
        // The length of the message, note that the last index of the array is at n - 1
        int n = message.length;
        StringBuilder res = new StringBuilder();
        String msg = new String(message);               // turns char[] array into String!
        int pointer;
        // Treat the first m - 1 chunks as is
        // YOU NEED TO APPEND A NEW STRINGBUILDER WHEN CALLING reverse() <-- it replaces the WHOLE sequence by its reverse!
        // But we only want to reverse 1 block! (not those already reversed..)
        for (pointer = 0; pointer + this.m < n; pointer += this.m) {
            res.append(new StringBuilder(msg.substring(pointer, pointer + this.m)).reverse().toString());
            System.out.println(res.toString());
        }
        // Last chunk reverse whole chunk
        res.append(new StringBuilder(msg.substring(pointer)).reverse().toString());
        System.out.println(res.toString());
        return res.toString().toCharArray();            // turn String into char[] array again
    }


    // (not used, bc we swapped in place)
    // until the middle of the array, you swap the outermost pairs (where i is).
    public static char[] reverseString(char[] input) {
        if (input.length >= 1) {
            for (int i = 0; i < input.length/2; i++) {
                char temp = input[i];
                input[i] = input[input.length-i-1];
                input[input.length-i-1] = temp;
            }
        } else {
            throw new IllegalArgumentException();
        }
        return input;
    }

}
