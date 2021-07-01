import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    @Test
    public void testConstructor() {
        ArrayStack tmp = new ArrayStack();
        System.out.println(Arrays.toString(tmp.getElements()));
        assertArrayEquals(tmp.getElements(), new Object[1]);        // empty ArrayStack with capacity 1 and size 0
    }

    @Test
    public void testToStringTwo() {
        ArrayStack s = new ArrayStack();
        s.push(1);
        s.push(2);
        System.out.println(s.toString());
        assertEquals("<ArrayStack[1,2]>(Size=2, Cap=2)", s.toString());
    }

    @Test
    public void testGrowShrink() {
        ArrayStack s = new ArrayStack();
        s.push(1);
        s.push(2);
        assertEquals("<ArrayStack[1,2]>(Size=2, Cap=2)", s.toString());
        s.push(3);
        System.out.println(Arrays.toString(s.getElements()));
        assertEquals(4, s.getElements().length);
        s.pop();
        s.pop();
        s.pop();
        System.out.println(Arrays.toString(s.getElements()));
        assertEquals(2, s.getElements().length);
    }


}