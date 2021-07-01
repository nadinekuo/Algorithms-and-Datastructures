import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DLListTest {

    @Test
    public void testDLListConstructor() {
        DLList list = new DLList();
        assertEquals(0, list.size());
    }

    @Test
    public void testOneElement() {
        DLList list = new DLList();
//        list.addFirst(42);
        list.addLast(42);
        assertEquals(42, list.getHead());
        assertEquals(42, list.getTail());
//        list.removeLast();
        list.removeFirst();
        assertEquals(0, list.size());
    }


    @Test
    public void testAddAtPosition() {
        DLList list = new DLList();
        list.addFirst(3);
        System.out.println(list.size());
        list.addLast(2);
        System.out.println(list.size());
        list.addAtPosition(1, 5);
        System.out.println(list.size());
        assertEquals(3, list.size());
        assertNull(list.removeFromPosition(10));
        assertEquals(3, list.size());
        assertEquals(3, list.removeFirst());
        assertEquals(5, list.removeFirst());
        assertEquals(2, list.removeFirst());
    }

    @Test
    void reverseTest() {
        DLList test = new DLList();
        test.addFirst("Hi");
        test.addFirst("my");
        test.addFirst("name");
        test.addFirst("is");
        test.addFirst("Nadine");        // this is the head
        DLList reversed = test.reverse();
        System.out.println(reversed.getHead());
        System.out.println(reversed.getTail());
    }


    @Test
    public void addAtPositionTest() {
        DLList test = new DLList();
        test.addAtPosition(-3, "Test");
        assertEquals("Test", test.removeLast());
    }

}