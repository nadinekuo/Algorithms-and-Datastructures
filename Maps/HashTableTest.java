import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    public void testExample() {
        HashTableLinearProbing tab = new HashTableLinearProbing(1);
        assertTrue(tab.put("apple", "juice"));
        assertEquals("juice", tab.get("apple"));
        assertEquals(true, tab.remove("apple"));
        assertEquals(null, tab.table[0].getKey());
        assertEquals(null, tab.table[0].getValue());
        assertEquals(null, tab.get("apple"));
    }

    @Test
    public void testIllegalArgument2() {
        try {
            new HashTableLinearProbing(0);
        } catch (IllegalArgumentException e1) {
            try {
                new HashTableLinearProbing(-42);
            } catch (IllegalArgumentException e2) {
                return;
            }
        }
        fail();
    }

    @Test
    void testCollision() {
        HashTableSepChain2 test = new HashTableSepChain2(10);
        assertTrue(test.put("banana", "yellow"));
        assertTrue(test.put("banana", "green"));
        assertEquals("green", test.get("banana"));
        assertFalse(test.remove("watermelon"));
        assertTrue(test.remove("banana"));
        assertEquals(null, test.get("banana"));
        assertFalse(test.remove("banana"));
        assertTrue(test.put("lime", "purple"));
        assertTrue(test.put("lime", "blue"));
    }

    @Test
    public void testOneElement() {
        HashTableSepChain2 tab = new HashTableSepChain2(5);
        assertTrue(tab.put("apple", "juice"));
//        assertTrue(tab.put("apple", "pie"));
        assertEquals("juice", tab.get("apple"));
        assertEquals(true, tab.remove("apple"));
        assertEquals(null, tab.get("apple"));
    }

    @Test
    public void testIllegalArgument() {
        try {
            new HashTableSepChain2(0);
        } catch (IllegalArgumentException e1) {
            try {
                new HashTableSepChain2(-42);
            } catch (IllegalArgumentException e2) {
                return;
            }
        }
        fail();
    }
}
