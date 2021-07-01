import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayHeapTest {

    @Test
    public void isHeapNull() {
        assertFalse(ArrayHeapMax.isHeap(null, 3));
    }

    @Test
    public void isHeapSmall() {
        int[] heap = new int[] {99, 64, 5, 36, 8, 1};
        assertTrue(ArrayHeapMax.isHeap(heap, heap.length));
    }

    @Test
    public void getParentTest() {
        int[] heap = new int[] {99, 64, 5, 36, 8, 1};
        assertEquals(1, ArrayHeapMax.getParent(heap, 3));
    }


}