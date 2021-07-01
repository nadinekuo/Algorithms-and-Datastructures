import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckPalindromeTest {

    @Test
    public void testEmpty() {
        CharacterLinkedList list = new CharacterLinkedList("");
        assertTrue(CheckPalindrome.checkPalindromePQ(list));
    }

    @Test
    public void testNull() {
        CharacterLinkedList list = null;
        assertTrue(CheckPalindrome.checkPalindromePQ(list));
    }

    @Test
    public void testExampleTrue() {
        CharacterLinkedList list = new CharacterLinkedList("abba");
        System.out.println("List size: " + list.size());
        assertTrue(CheckPalindrome.checkPalindromePQ(list));
    }

    @Test
    public void testExampleOdd() {
        CharacterLinkedList list = new CharacterLinkedList("abbcbba");
        System.out.println("List size: " + list.size());
        assertTrue(CheckPalindrome.checkPalindromePQ(list));
    }

    @Test
    public void testExampleFalse() {
        CharacterLinkedList list = new CharacterLinkedList("abc");
        assertFalse(CheckPalindrome.checkPalindromePQ(list));
    }

}