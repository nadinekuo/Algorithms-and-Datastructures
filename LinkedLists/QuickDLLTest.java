import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickDLLTest {

    @Test
    void testInsertStrings() {
        QuickDLL list = new QuickDLL();
        list.insert(0, "Hello");
        list.insert(1, "Buy");
        list.insert(2, "Katy");
        list.insert(3, "Perry's");
        list.insert(4, "New");
        list.insert(5, "Album.");
        assertEquals(6, list.getSize());
        assertEquals("Buy", list.getHead().getNext(0).getElement());
        assertEquals("Perry's", list.getHead().getNext(1).getElement());
        list.insert(3, "Elizabeth");
        assertEquals("Elizabeth", list.getHead().getNext(1).getElement());
    }

    @Test
    public void testOneElementInsert() {
        QuickDLL list = new QuickDLL();
        list.insert(0, 42);
        assertEquals(42, list.getHead().getElement());
        assertEquals(42, list.getTail().getElement());
        assertEquals(1, list.getSize());
    }

    @Test
    public void testOneElementAddFirst() {
        QuickDLL list = new QuickDLL();
        list.addFirst(42);
        assertEquals(42, list.getHead().getElement());
        assertEquals(42, list.getTail().getElement());
        assertEquals(1, list.getSize());
    }

    @Test
    public void testOneElementAddLast() {
        QuickDLL list = new QuickDLL();
        list.addLast(42);
        assertEquals(42, list.getHead().getElement());
        assertEquals(42, list.getTail().getElement());
        assertEquals(1, list.getSize());
    }

    @Test
    public void testOneNodePointers() {
        QuickDLL list = new QuickDLL();
        for (int i = 0; i < 50; i++) {
            list.addLast(i);
        }
        assertEquals(1, list.getHead().getNext(0).getElement());
        assertEquals(3, list.getHead().getNext(1).getElement());

        assertEquals(9, list.getHead().getNext(2).getElement());

        assertEquals(14, list.getHead().getNext(3).getElement());

    }

    @Test
    public void testOneNodePointersLaterInList() {
        QuickDLL list = new QuickDLL();
        for (int i = 0; i < 50; i++) {
            if (i == 20) {
                continue;
            }
            list.addLast(i);
        }
        list.insert(20, 20);
        assertEquals(19, list.atPosition(18).getNext(0).getElement());
        assertEquals(21, list.atPosition(18).getNext(1).getElement());
        assertEquals(27, list.atPosition(18).getNext(2).getElement());
        assertEquals(32, list.atPosition(18).getNext(3).getElement());
    }

}