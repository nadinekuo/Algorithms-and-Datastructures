import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticCoatisTest {

    @Test
    void invalidExpression() {
        String expression = "1 + 2";
        ArithmeticCoatis.compute(expression);
    }

    @Test
    public void testExample() {
        String input = "1 2 3 * +";
        int expected = 7;
        assertEquals(expected, ArithmeticCoatis.compute(input));
    }

    @Test
    public void testExample2() {
        String input = "1 2 + 3 *";
        int expected = 9;
        assertEquals(expected, ArithmeticCoatis.compute(input));
    }

    @Test
    public void testLargerExample() {
        String input = "10 2 8 * + 3 -";
        int expected = 23;
        assertEquals(expected, ArithmeticCoatis.compute(input));
    }

}