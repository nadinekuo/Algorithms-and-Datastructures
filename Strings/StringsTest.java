import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringsTest {

    @Test
    public void testSubstring() {
        String test = "Nadine";
        System.out.println(test.substring(0, 0));
    }


    @Test
    void testPermutations() {
        String test1 = "Hello";
        String test2 = "Helo";
        assertFalse(CheckPermutations.permutation(test1, test2));
        assertFalse(CheckPermutations.permutation(test1, test2));
    }

    @Test
    void testStarRecursion() {
        String test = "Hello little";
        System.out.println(InsertStarRecursively.insertPairStar(test));
    }
    @Test
    void replaceSpace() {
        String test = "This is a test.";
        assertEquals("ThisABCisABCaABCtest.", ReplaceSpaces.replace(test, "ABC"));
        String test2 = "Space ";
        assertEquals("SpaceABC", ReplaceSpaces.replace(test2, "ABC"));
    }

    @Test
    void firstUniqueChar() {
        String test = "hohohokhohoho";
        String test2 = "hehehe";
        assertEquals('k', UniqueChars.firstNonRepeatedCharacter(test));
        assertEquals(null, UniqueChars.firstNonRepeatedCharacter(test2));
    }


}