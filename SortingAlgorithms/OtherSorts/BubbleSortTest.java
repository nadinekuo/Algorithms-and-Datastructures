import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {


    @Test
    void testBubbleSort() {
        int[] input = {2, 4, 7, 6, 8, 1, 5};
        int[] expected = {1, 2, 4, 5, 6, 7, 8};
        assertEquals(expected, BubbleSort.bubbleSortArray(input));
        System.out.println(Arrays.toString(BubbleSort.bubbleSortArray(input)));
    }


    @Test
    public void test_small() {
        int[] arr = new int[] { 15, 10, 25, 20 };
        int[] res = new int[] { 10, 15, 20, 25 };
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(res, arr);
    }

    @Test
    public void test_duplicate() {
        int[] arr = new int[] { 30, 10, 30, 20 };
        int[] res = new int[] { 10, 20, 30, 30 };
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(res, arr);
    }

    @Test
    public void test_negative() {
        int[] arr = new int[] { -1, -10, -12, -4, -3, -7 };
        int[] res = new int[] { -12, -10, -7, -4, -3, -1 };
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(res, arr);
    }

    @Test
    public void test_reversed() {
        int[] arr = new int[] { 9, 8, 7, 6, 5, 4, 3 };
        int[] res = new int[] { 3, 4, 5, 6, 7, 8, 9 };
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(res, arr);
    }

}