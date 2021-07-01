import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MSDRadixSortTest {

    @Test
    public void testExample() {
        String test = "BC4D2A";
        int bucketidx;
        for (int i = 0; i < test.length(); i++) {
            char symbol = test.charAt(i);
            System.out.println("current char " + symbol);
            if (Character.isDigit(test.charAt(i))) {
                bucketidx = 26 + Integer.parseInt(String.valueOf(symbol));
            } else {
                int offset = symbol - 'A';
                System.out.println(offset);
                bucketidx = 25-offset;          // reversed!!
            }
            System.out.println(bucketidx);
        }
    }

    @Test
    void testRandomList() {
        assertEquals(Arrays.asList("BC4D2A", "AC1D4B", "AC1B3B", "AB1B3B", "AB2A4B", "AB2A4A", "AA1B3B"),
                DoctorMSDRadix.sortDoctorIds(Arrays.asList("AA1B3B", "AB2A4B", "BC4D2A", "AB1B3B", "AB2A4A", "AC1B3B", "AC1D4B")));
    }

    @Test
    void sameStrings() {
        assertEquals(Arrays.asList("A1B2C3", "A1B2C3", "A1B2C3"),
                DoctorMSDRadix.sortDoctorIds(Arrays.asList("A1B2C3", "A1B2C3", "A1B2C3")));
    }

    @Test
    public void testNull() {
        assertNull(DoctorMSDRadix.sortDoctorIds(null));
    }

    @Test
    public void testEmpty1() {
        assertEquals(Collections.emptyList(), DoctorMSDRadix.sortDoctorIds(Collections.emptyList()));
    }

    @Test
    public void testEmpty() {
        assertEquals(new ArrayList<>(), MSDRadixSort.radixSortMSD(new ArrayList<>()));
    }

    @Test
    public void testReversed() {
        List<String> data = Arrays.asList("donut", "cherry", "banana", "apple");
        List<String> data2 = Arrays.asList("apple", "banana", "cherry", "donut");
        assertEquals(data2, MSDRadixSort.radixSortMSD(data));
    }

    @Test
    public void testStable() {
        List<String> data = Arrays.asList("donut", "donuts", "donutss", "donutsss");
        assertEquals(data, MSDRadixSort.radixSortMSD(data));
    }

}