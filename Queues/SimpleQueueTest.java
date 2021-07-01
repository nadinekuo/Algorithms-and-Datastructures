import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class SimpleQueueTest {

    @Test
    void testListToArray() {
        List<String> test = new ArrayList<>(Arrays.asList("Hello", "my", "name", "is"));
        System.out.println(test);   // [Hello, my, name, is]
        System.out.println(test.toArray()[0]);  // Hello
    }

    @Test
    void reverseTest() {
        SimpleQueue<Integer> test = new SimpleQueue<>();
        test.enqueue(1);
        test.enqueue(2);
        test.enqueue(3);
        System.out.println(test.dequeue());
        test.reverse();
        System.out.println(test.dequeue());
    }

    @Test
    public void example() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        assertTrue(queue.isEmpty());
        queue.enqueue(42);
        assertFalse(queue.isEmpty());
    }

}