import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuickSelectInPlaceTest {

    @Test
    public void testExample() {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 3, 52, 42, 6, 123, 2, 1, 4, 44, 64));
        Integer[] numbers = {2, 3};
        List<Integer> test = Arrays.asList(numbers);
        System.out.println(QuickSelectInPlace.quickSelectInPlace(test, 6));
        assertEquals((Integer) 4, QuickSelectInPlace.quickSelectInPlace(list, 4));
        assertEquals((Integer) 42, QuickSelectInPlace.quickSelectInPlace(list, 7));
    }

    @Test
    public void testQuickSelect() {
        Integer[] numbers = {2, 1};
        List<Integer> test = Arrays.asList(numbers);
        System.out.println(QuickSelect.quickSelect(test, 6));
    }

}