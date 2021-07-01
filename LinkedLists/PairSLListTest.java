import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairSLListTest {

    @Test
    void testReversedSLL() {
        IntSLList list = new IntSLList(1, 2, 3, 4, 5);
        IntSLList.recursivelyPrintReversedSLL(list.getFirst());
    }

    public static <T> void assertEmpty(PairSLList<T> list) {
        assertNull(list.getFirst());
        assertNull(list.removeFirst());
    }

    @Test
    public void specTest1() {
        PairSLList<String> list1 = new PairSLList<>();
        PairSLList<String> list2 = new PairSLList<>();
        list2.addFirst("World");
        list1.append(list2);
        assertEquals("World", list1.removeFirst());
        assertEmpty(list1);
    }


    @Test
    public void testDropEvenTwoElements() {
        PairSLList<Integer> list = new PairSLList<>();
        list.addFirst(42);
        list.addFirst(43);
        list.dropEven();
        assertEquals(42, (int) list.removeFirst());
        assertEmpty(list);
    }


    @Test
    public void testAddOneElement() {
        PairSLList<String> list = new PairSLList<>();
        list.addFirst("Hello World");
        assertEquals("Hello World", list.getFirst());
    }

    @Test
    public void testAddRemoveNull() {
        PairSLList<Object> list = new PairSLList<>();
        list.addFirst(null);
        assertNull(list.removeFirst());
    }

    @Test
    public void testZipNull() {
        PairSLList<Integer> list1 = new PairSLList<>();
        list1.addFirst(42);
        list1.addFirst(43);
        list1.addFirst(44);
        PairSLList<Pair<Integer, Integer>> zipped = list1.zip(null);
        assertNull(zipped.getFirst());
    }

    @Test
    public void testZipOnePair() {
        PairSLList<Integer> list1 = new PairSLList<>();
        PairSLList<Integer> list2 = new PairSLList<>();
        list1.addFirst(42);
        list2.addFirst(1337);
        PairSLList<Pair<Integer, Integer>> zipped = list1.zip(list2);
        assertEquals(new Pair<>(42, 1337), zipped.getFirst());
    }

    @Test
    public void testAppendNull() {
        PairSLList<String> list1 = new PairSLList<>();
        list1.addFirst("Hello");
        list1.append(null);
        assertEquals("Hello", list1.removeFirst());
        assertNull(list1.getFirst());
    }

    @Test
    public void testAppendOneElement() {
        PairSLList<String> list1 = new PairSLList<>();
        PairSLList<String> list2 = new PairSLList<>();
        list1.addFirst("Hello");
        list2.addFirst("World");
        list1.append(list2);
        assertEquals("Hello", list1.removeFirst());
        assertEquals("World", list1.removeFirst());
        assertNull(list1.getFirst());
    }

    @Test
    public void testDropEvenOneElement() {
        PairSLList<Integer> list = new PairSLList<>();
        list.addFirst(42);
        list.dropEven();
        assertNull(list.getFirst());
    }

}