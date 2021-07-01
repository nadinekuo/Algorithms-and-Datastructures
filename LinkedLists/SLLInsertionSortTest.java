import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SLLInsertionSortTest {

    @Test
    public void myTest() {
        int[] sorted = {1, 2, 3};
        IntSLList test = new IntSLList(sorted);
        System.out.println(test);
        IntSLList input = new IntSLList(4, 3, 5, 6, 72, 0);
        IntSLList expected = new IntSLList(0, 3, 4, 5, 6, 72);
        assertEquals(expected, SLLInsertionSort.insertionSort(input));
    }

    @Test
    public void testEmpty() {
        IntSLList input = new IntSLList();
        IntSLList output = new IntSLList();
        assertEquals(output, SLLInsertionSort.insertionSort(input));
    }

    @Test
    public void testNull() {
        assertNull(SLLInsertionSort.insertionSort(null));
    }

    @Test
    public void testExample() {
        IntSLList input = new IntSLList(3, 1, 2);
        IntSLList output = new IntSLList(1, 2, 3);
        assertEquals(output, SLLInsertionSort.insertionSort(input));
    }

}