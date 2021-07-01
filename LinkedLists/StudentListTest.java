import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {


    /**
     * See Stydent equals() method: id, next, prev, skip back, skip ahead are compared.
     */
    @Test
    void testAddStudentObjects() {
        StudentList list = new StudentList();
        Student nadine = new Student(5);
//        nadine.setPrevious(null);
//        nadine.setNext(null);
//        nadine.setSkipBack(null);
//        nadine.setSkipAhead(null);
        list.addFirst(5);
        assertEquals(nadine, list.getHead());
//        Student jadine = new Student(29);     // THIS DOES NOT WORK, BECAUSE THE EQUALS METHOD USES: Object.equals(next)...
//        nadine.setPrevious(jadine);
//        jadine.setNext(nadine);
//        list.addFirst(29);
//        assertEquals(jadine, list.getHead());
        assertEquals(nadine, list.getTail());
        assertEquals(null, list.getHead().getNext());
    }

    @Test
    void testSkipAhead() {
        StudentList list = new StudentList();
        list.addFirst(8);
        list.addFirst(7);
        list.addFirst(6);
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        assertEquals(8, list.getStudentAtSeat(7));
        assertEquals(5, list.getHead().getSkipAhead().getId());
        assertEquals(6, list.getHead().getNext().getSkipAhead().getId());
        assertEquals(null, list.getTail().getSkipAhead());
    }

    @Test
    void testSkipBack() {
        StudentList list = new StudentList();
        list.addFirst(8);
        list.addFirst(7);
        list.addFirst(6);
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        assertEquals(4, list.getTail().getSkipBack().getId());
        assertEquals(3, list.getTail().getPrevious().getSkipBack().getId());
        assertEquals(1, list.removeFirst());
        assertEquals(6, list.getHead().getSkipAhead().getId());
        assertEquals(2, list.removeFirst());
        assertEquals(3, list.removeFirst());
        assertEquals(4, list.removeFirst());
        assertEquals(null, list.getTail().getSkipBack());
    }

    @Test
    public void getPositionHigh() {
        StudentList list = new StudentList();
        list.addFirst(6);
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        System.out.println(list.size());
        System.out.println(list.getHead().getSkipAhead().getId());
        assertEquals(1, list.getStudentAtSeat(0));
        assertEquals(6, list.getStudentAtSeat(5));
        assertEquals(1, list.removeFirst());
        assertEquals(2, list.getStudentAtSeat(0));
        assertEquals(2, list.removeFirst());
        assertEquals(6, list.getStudentAtSeat(3));
    }

    @Test
    public void oneElement() {
        StudentList list = new StudentList();
        list.addFirst(42);
        assertEquals(42, list.getHead().getId());
        assertEquals(42, list.getTail().getId());
    }

    @Test
    public void twoElements() {
        StudentList list = new StudentList();
        list.addFirst(4);
        list.addFirst(3);
        assertEquals(3, list.removeFirst());
        assertEquals(4, list.removeFirst());
    }

    @Test
    public void getPosition() {
        StudentList list = new StudentList();
        list.addFirst(2);
        list.addFirst(1);
        assertEquals(1, list.getStudentAtSeat(0));
        assertEquals(2, list.getStudentAtSeat(1));
    }

}