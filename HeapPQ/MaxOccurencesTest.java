import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxOccurencesTest {

    @Test
    public void sixOccurrences() {
        int[] a = {2, 4, 3, 4, 2, 2, 2, 2, 2};
        assertTrue(MaxOccurences.upperCount(a, 6));
        assertFalse(MaxOccurences.upperCount(a, 5));
    }

    @Test
    public void testNull() {
        int[] a = null;
        assertTrue(MaxOccurences.upperCount(a, 1), "Null array should return true with number 1");
        assertTrue(MaxOccurences.upperCount(a, 2), "Null array should return true with number 2");
    }

    @Test
    public void testExample() {
        int[] a = { 2, 3, 1, 4, 5, 1, 7, 0 };
        assertTrue(MaxOccurences.upperCount(a, 2), "Method should return true with count at most 2");
        assertFalse(MaxOccurences.upperCount(a, 1), "Method should return false with count at most 1");
    }

}