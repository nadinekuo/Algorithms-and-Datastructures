import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    /**
     * sorting an unsorted array
     */
    @Test
    public void testNormal() {
        int[] data = {71, 21, 11, 15, 30, 33, 90, 50, 35, 24};
        int[] data2 = {11, 15, 21, 24, 30, 33, 35, 50, 71, 90};
//        int[] result = MergeSortSplitInThree.mergeSort(data);
        int[] result = MergeSortStacks.mergeSort(data);
        ArrayList<Integer> list = new ArrayList<>(result.length);
        for (int i : result) {
            list.add(i);
        }
        System.out.println(list);
//        assertArrayEquals(data2, result);
    }

    /**
     * sorting an unsorted array
     */
    @Test
    public void testNormalVoid() {
        int[] data = {71, 21, 11, 15, 30, 33, 90, 50, 35, 24};
        int[] data2 = {11, 15, 21, 24, 30, 33, 35, 50, 71, 90};
        MergeSortArray.mergeSort2(data);
        ArrayList<Integer> list = new ArrayList<>(data.length);
        for (int i : data) {
            list.add(i);
        }
        System.out.println(list);
    }

}