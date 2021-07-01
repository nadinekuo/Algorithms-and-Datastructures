import org.junit.jupiter.api.Test;


import java.util.Arrays;

class ReverseArrayTest {




    @Test
    public void reverseTest() {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] empty = {};
        ReverseArray.reverse(empty);
        System.out.println(Arrays.toString(empty));
        int[] result = { 5, 4, 3, 2, 1 };
//        assertArrayEquals(result, arr);
    }

}