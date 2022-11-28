import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FibonacciTest {



    @Test
    public void testTimeFibonacci() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 41, 42, 43, 44));
        for (int n : numbers) {
            runFibWithTime(n);
        }
    }


    public void runFibWithTime(int n) {
        long start = System.currentTimeMillis();
//        long[] res = FibonacciHW1.fibonacciArray(n);
        int res = Fibonacci.fibonacciExponential(n);
        long end = System.currentTimeMillis();
        System.out.println(String.format("Elapsed time for %d: %d ms", n, end - start));
        System.out.println(res);
//        System.out.println(Arrays.toString(res));
    }


    @Test
    public void example() {
        Assertions.assertEquals(8, Fibonacci.fibonacciDynamicIterative(6));
    }

    @Test
    public void test05() {
        Assertions.assertEquals(5, Fibonacci.fibonacciDynamicIterative(5));
    }

}