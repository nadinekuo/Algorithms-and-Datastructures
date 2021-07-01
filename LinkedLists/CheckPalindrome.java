import java.util.*;
import java.util.Stack;

public class CheckPalindrome {

    /**
     * Checks for a String represented as a SLList whether this String is a palindrome.
     * This is done by using a stack.
     *
     * An empty String or null should return true.
     *
     * @param list
     *     SLList used to represent a String
     * @return true if the String represented as a SLList is a palindrome, otherwise false
     */
    public static boolean checkPalindrome(CharacterLinkedList list) {

        if (list == null || list.size() == 0) return true;

        LibraryStack<Character> stack = new LibraryStack<>();

        int middle = list.size()/2;

        for (int i = 0; i < middle; i++) {       // push the first half
            stack.push(list.removeFirst());
        }

        if (stack.size() != list.size()) list.removeFirst(); // if odd no, middle letter doesnt matter

        for (int i = 0; i < middle; i++) {
            if (stack.pop() != list.removeFirst()) return false;
        }

        return true;

    }

    /**
     * Checks for a String represented as a SLList whether this String is a palindrome.
     * This is done by using a PQ queue.
     * An empty String or null should return true.
     *
     * @param list
     *     SLList used to represent a String
     * @return true if the String represented as a SLList is a palindrome, otherwise false
     */
    public static boolean checkPalindromePQ(CharacterLinkedList list) {

        if (list == null || list.size() < 2) return true;

        LibraryPQ<EntryLetter> queue = new LibraryPQ<>();
        // insert 1st half into PQ, create Entries with increasing key (counter)
        int middle = list.size()/2;
        for (int i = 0; i < middle; i++) {
            EntryLetter letter = new EntryLetter(i, list.removeFirst());    // removeMax will give the most recent added Entry (LIFO) (see compare method in Entry)
            queue.enqueue(letter);
                System.out.println(i + ": Enqueued: " + letter.getElement());
                System.out.println("Next in list: " + list.getFirst());
        }

        if (list.size() != queue.size()) { // ignore middle, if list had odd amount
            list.removeFirst();
        }

        // removeMax, compare to 2nd half in list
        while (!queue.isEmpty()) {
            char current = queue.dequeue().getElement();
                System.out.println("Removed: " + current);
            if (current != list.removeFirst()) {
                return false;
            }
        }
        return true;
    }

}
