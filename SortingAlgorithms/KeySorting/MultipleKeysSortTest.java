import org.junit.jupiter.api.Test;
import org.junit.*;

import java.util.ArrayList;
import java.util.*;

import static java.util.Arrays.*;
import static org.junit.Assert.*;


    class MultipleKeysSortTest {

        @Test
        public void testEmpty2() {
            String test = "0644444444";
            int ascii = test.charAt(9);
                System.out.println(ascii);      // 52
            char character = test.charAt(9);
                System.out.println(character);  // 4
            int digit = Integer.parseInt(String.valueOf(character));
                System.out.println(digit);      // 4
            assertEquals(new ArrayList<>(), LSDRadixSort.radixSortLSD(new ArrayList<>()));
        }

        @Test
        public void testReversed() {
            List<String> data = asList("0644444444", "0633333333", "0622222222", "0611111111");
            List<String> data2 = asList("0611111111", "0622222222", "0633333333", "0644444444");
            assertEquals(data2, LSDRadixSort.radixSortLSD(data));
        }

        @Test
        public void testEmpty() {
            String[][] data = {};
            String[][] data2 = {};
            MultipleKeysSort.stableSort(data, 0);
            assertArrayEquals(data2, data);
        }

        @Test
        public void testOneColumn() {
            String[][] data = {{"d"}, {"a"}, {"e"}, {"b"}, {"g"}, {"c"}, {"f"}};
            String[][] data2 = {{"a"}, {"b"}, {"c"}, {"d"}, {"e"}, {"f"}, {"g"}};
            MultipleKeysSort.stableSort(data, 0);
            assertArrayEquals(data2, data);
        }

        @Test
        public void testMixed() {
            String[][] data = {{"aaa", "ddd"}, {"ccc", "bbb"}};
            String[][] data2 = {{"aaa", "ddd"}, {"ccc", "bbb"}};
            String[][] data3 = {{"ccc", "bbb"}, {"aaa", "ddd"}};
            MultipleKeysSort.stableSort(data, 0);
            assertArrayEquals(data2, data);
            MultipleKeysSort.stableSort(data, 1);
            assertArrayEquals(data3, data);
        }

        @Test
        public void myTest() {
            String[][] test = { {"hello", "world"}, {"this", "is", "cool"}, {"there", "are", "three", "rows"}};
            System.out.println(Arrays.deepToString(test));
            System.out.println(test.length);
            System.out.println(test[0].length);
            System.out.println(test[1].length);
            System.out.println(test[2].length);
            MultipleKeysSort.stableSort(test, 1);
            System.out.println(Arrays.deepToString(test));
        }

    }