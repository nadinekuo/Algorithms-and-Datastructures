import java.util.*;

public class ReverseString {

    public static char[] reverseString(char[] input) {
        if (input.length >= 1) {
            for (int i = 0; i < input.length / 2; i++) {
                swap(input, i, input.length-i-1);
            }
        } else {
            throw new IllegalArgumentException();
        }
        return input;
    }


    public static String reverseString(String str){

        if (str == null) return null;

        char[] input = str.toCharArray();
        for (int i = 0; i < input.length/2; i++) {
            swap(input, i, input.length-i-1);
        }
        return new String(input);
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
