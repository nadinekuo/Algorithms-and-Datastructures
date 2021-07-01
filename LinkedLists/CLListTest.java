import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CLListTest {

    @Test
    public void testAddFirstOneElement() {
        GenericCLList<String> list = new GenericCLList<>();
        list.addFirst("Hello World");
        assertEquals("Hello World", list.getFirst());
        assertEquals("Hello World", list.getLast());
    }

    @Test
    public void testAddNull() {
        GenericCLList<Object> list = new GenericCLList<>();
        list.addFirst(null);
        list.addLast(null);
        assertNull(list.getFirst());
        assertNull(list.getLast());
    }

    @Test
    public void testRotateTwoElements() {
        GenericCLList<String> list = new GenericCLList<>();
        list.addFirst("Goose");
        list.addLast("Duck");
        list.rotate();
        assertEquals("Duck", list.getFirst());
        assertEquals("Goose", list.getLast());
        System.out.println(list);
    }

    @Test
    public void testAlternateNull() {
        GenericCLList<Integer> list = new GenericCLList<>();
        list.addFirst(42);
        list.addLast(1337);
        GenericCLList<Integer> alternated = list.alternate(null);
        assertEquals(42, (int) alternated.getFirst());
        assertEquals(1337, (int) alternated.getLast());
    }

    @Test
    public void testAlternateTwoElements() {
        GenericCLList<Integer> list1 = new GenericCLList<>();
        GenericCLList<Integer> list2 = new GenericCLList<>();
        list1.addFirst(42);
        list2.addFirst(1337);
        GenericCLList<Integer> alternated = list1.alternate(list2);
        assertEquals(42, (int) alternated.removeFirst());
        assertEquals(1337, (int) alternated.getFirst());
    }

    @Test
    void alternateNullOrEmpty() {
        GenericCLList<String> list1 = new GenericCLList<>();
        GenericCLList<String> list2 = new GenericCLList<>();
        GenericCLList<String> list3 = new GenericCLList<>();
        list3.addLast("Nienke");
        list3.addLast("Martens");
        GenericCLList<String> alternated = list1.alternate(null);
        GenericCLList<String> alternated2 = list1.alternate(list2);
        GenericCLList<String> alternated3 = list1.alternate(list3);
        System.out.println(alternated3);
        assertEquals(null, alternated.getFirst());
        assertEquals(null, alternated.getLast());
        assertEquals(null, alternated2.getFirst());
        assertEquals(null, alternated2.getLast());
        assertEquals("Nienke", alternated3.removeFirst());
        assertEquals("Martens", alternated3.removeFirst());
        assertEquals(null, alternated3.removeFirst());
    }

    @Test
    void alternateSingleElement() {
        GenericCLList<String> list1 = new GenericCLList<>();
        GenericCLList<String> list2 = new GenericCLList<>();
        list1.addFirst("Katy");
        list2.addFirst("Perry");
        GenericCLList<String> alternated = list1.alternate(list2);
        System.out.println(alternated);
        assertEquals("Katy", alternated.getFirst());
        GenericCLList<String> alternated2 = list2.alternate(list1);
        System.out.println(alternated2);
        assertEquals("Perry", alternated2.getFirst());
    }

    @Test
    void alternateOneSingleElement() {
        GenericCLList<String> list1 = new GenericCLList<>();
        GenericCLList<String> list2 = new GenericCLList<>();
        list1.addFirst("Katy");
        list1.addFirst("Feather");
        list2.addFirst("Perry");
        GenericCLList<String> alternated = list1.alternate(list2);
                System.out.println(alternated);
        assertEquals("Feather", alternated.getFirst());
        assertEquals("Katy", alternated.getLast());
        GenericCLList<String> alternated2 = list2.alternate(list1);
                    System.out.println(alternated2);
        assertEquals("Perry", alternated2.getFirst());
        assertEquals("Katy", alternated2.getLast());

        GenericCLList<String> alternated3 = list1.alternate(null);
        GenericCLList<String> alternated4 = list2.alternate(null);
        assertEquals("Feather", alternated3.getFirst());
        assertEquals("Perry", alternated4.getFirst());
        assertEquals("Perry", alternated4.getLast());
    }

    @Test
    public void testAlternateStrings() {
        GenericCLList<String> list1 = new GenericCLList<>();
        GenericCLList<String> list2 = new GenericCLList<>();
        list1.addFirst("Nadine");
        list1.addFirst("name");
        list1.addFirst("Hello");
        list2.addFirst("Perry");
        list2.addFirst("or");
        list2.addFirst("Kuo");
        list2.addFirst("is");
        list2.addFirst("my");
        GenericCLList<String> alternated = list1.alternate(list2);
        System.out.println(alternated);
        assertEquals("Hello", alternated.getFirst());
        assertEquals("Perry", alternated.getLast());

        alternated.dropOdd();
        System.out.println(alternated);
        assertEquals("Hello", alternated.getFirst());
        alternated.rotate();
        System.out.println(alternated);
        assertEquals("Hello", alternated.getLast());
    }

    @Test
    public void testAlternate3() {
        GenericCLList < Integer > list1 = new GenericCLList < > ();
        GenericCLList < Integer > list2 = new GenericCLList < > ();
        list1.addLast(0);
        list1.addLast(1);
        list1.addLast(2);
        GenericCLList < Integer > alternated = list1.alternate(list2);
        System.out.println(alternated);
        assertEquals(0, (int) alternated.removeFirst());
        assertEquals(1, (int) alternated.removeFirst());
        assertEquals(2, (int) alternated.removeFirst());
        assertEquals(null, alternated.removeFirst());
    }
    @Test
    public void testAlternate4() {
        GenericCLList < Integer > list1 = new GenericCLList < > ();
        GenericCLList < Integer > list2 = new GenericCLList < > ();
        list1.addLast(0);
        list1.addLast(1);
        list1.addLast(2);
        System.out.println(list1);
        GenericCLList < Integer > alternated = list2.alternate(list1);
        System.out.println(alternated);
        assertEquals(0, (int) alternated.removeFirst());
        assertEquals(1, (int) alternated.removeFirst());
        assertEquals(2, (int) alternated.removeFirst());
        assertEquals(null, alternated.removeFirst());
    }

    @Test
    public void testAlternate5() {
        GenericCLList < Integer > list1 = new GenericCLList < > ();
        // GenericCLList<Integer> list2 = new GenericCLList<>();
        list1.addLast(0);
        list1.addLast(1);
        list1.addLast(2);
        GenericCLList < Integer > alternated = list1.alternate(null);
        assertEquals(0, (int) alternated.removeFirst());
        assertEquals(1, (int) alternated.removeFirst());
        assertEquals(2, (int) alternated.removeFirst());
        assertEquals(null, alternated.removeFirst());
    }

    @Test
    public void testAlternate6() {
        GenericCLList < Integer > list1 = new GenericCLList < > ();
        GenericCLList < Integer > list2 = new GenericCLList < > ();
         list1.addLast(0);
         list1.addLast(1);
         list1.addLast(2);
        GenericCLList < Integer > alternated = list1.alternate(list2);
         assertEquals(0, (int) alternated.removeFirst());
         assertEquals(1, (int) alternated.removeFirst());
         assertEquals(2, (int) alternated.removeFirst());
        assertEquals(null, alternated.removeFirst());
    }

    @Test
    public void testAlternate7() {
        GenericCLList < Integer > list1 = new GenericCLList <> ();
         GenericCLList<Integer> list2 = new GenericCLList<>();
         list1.addLast(0);
         list1.addLast(1);
         list1.addLast(2);
        GenericCLList < Integer > alternated = list1.alternate(null);
         assertEquals(0, (int) alternated.removeFirst());
         assertEquals(1, (int) alternated.removeFirst());
         assertEquals(2, (int) alternated.removeFirst());
        assertEquals(null, alternated.removeFirst());
    }

    @Test
    public void testAlternate8() {
        GenericCLList < Integer > list1 = new GenericCLList < > ();
        GenericCLList < Integer > list2 = new GenericCLList < > ();
        list1.addLast(0);
        list1.addLast(1);
        list1.addLast(2);
        list2.addLast(0);
        list2.addLast(1);
        list2.addLast(2);
        System.out.println(list1);
        System.out.println(list2);
        GenericCLList < Integer > alternated = list1.alternate(list2);
        System.out.println(alternated);
        assertEquals(0, (int) alternated.removeFirst());
        assertEquals(0, (int) alternated.removeFirst());
        assertEquals(1, (int) alternated.removeFirst());
        assertEquals(1, (int) alternated.removeFirst());
        assertEquals(2, (int) alternated.removeFirst());
        assertEquals(2, (int) alternated.removeFirst());
        assertEquals(null, alternated.removeFirst());
    }

    @Test
    public void testDropOddOneElement() {
        GenericCLList<String> list = new GenericCLList<>();
        list.addFirst("42");
        list.dropOdd();
        assertEquals("42", list.getFirst());
    }


    @Test
    public void testDrop0() {
        GenericCLList < String > list = new GenericCLList < > ();
        list.dropOdd();
        assertEquals(null, list.getFirst());
    }


    @Test
    public void testDrop2() {
        GenericCLList < String > list = new GenericCLList < > ();
        list.addLast("0");
        list.addLast("1");
        list.dropOdd();
        assertEquals("0", list.getFirst());
        list.rotate();
        assertEquals("0", list.getFirst());
    }

    @Test
    public void testDrop3() {
        GenericCLList < String > list = new GenericCLList < > ();
        list.addLast("0");
        list.addLast("1");
        list.addLast("2");
        list.dropOdd();
        assertEquals("0", list.getFirst());
        list.rotate();
        assertEquals("2", list.getFirst());
        list.rotate();
        assertEquals("0", list.getFirst());
    }

    @Test
    public void testDrop4() {
        GenericCLList < String > list = new GenericCLList < > ();
        list.addLast("0");
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.dropOdd();
        for (int i = 0; i < 2 * 2; i++) {
            System.out.print(list.getFirst() + " ");
            list.rotate();
        }
        assertEquals("0", list.getFirst());
        list.rotate();
        assertEquals("2", list.getFirst());
        list.rotate();
        assertEquals("0", list.getFirst());
    }

    @Test
    public void testDrop5() {
        GenericCLList < String > list = new GenericCLList < > ();
        list.addLast("0");
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        list.dropOdd();
        for (int i = 0; i < 2 * 3; i++) {
            System.out.print(list.getFirst() + " ");
            list.rotate();
        }
        assertEquals("0", list.getFirst());
        list.rotate();
        assertEquals("2", list.getFirst());
        list.rotate();
        assertEquals("4", list.getFirst());
        list.rotate();
        assertEquals("0", list.getFirst());
    }

    @Test
    public void testDrop6() {
        GenericCLList < String > list = new GenericCLList < > ();
        list.addLast("0");
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        list.addLast("5");
        list.dropOdd();
        assertEquals("0", list.getFirst());
        list.rotate();
        assertEquals("2", list.getFirst());
        list.rotate();
        assertEquals("4", list.getFirst());
        list.rotate();
        assertEquals("0", list.getFirst());
    }

    @Test
    public void testDrop7() {
        GenericCLList < String > list = new GenericCLList < > ();
        list.addLast("0");
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        list.addLast("5");
        list.addLast("6");
        list.dropOdd();
        assertEquals("0", list.getFirst());
        list.rotate();
        assertEquals("2", list.getFirst());
        list.rotate();
        assertEquals("4", list.getFirst());
        list.rotate();
        assertEquals("6", list.getFirst());
        list.rotate();
        assertEquals("0", list.getFirst());
    }



    @Test
    public void testDropOddThreeElements() {
        GenericCLList<Integer> list = new GenericCLList<>();
        list.addFirst(44);
        list.addFirst(43);
        list.addFirst(42);
        System.out.println(list);
        list.dropOdd();
        System.out.println(list);
        assertEquals(42, list.getFirst());
    }

    @Test
    public void testDropOddFiveElements() {
        GenericCLList<Integer> list = new GenericCLList<>();
        list.addFirst(46);
        list.addFirst(45);
        list.addFirst(44);
        list.addFirst(43);
        list.addFirst(42);
        System.out.println(list);
        list.dropOdd();
        System.out.println(list);
        assertEquals(42, list.getFirst());
    }



}