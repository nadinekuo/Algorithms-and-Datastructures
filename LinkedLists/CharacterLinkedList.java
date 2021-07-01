import java.util.*;

public class CharacterLinkedList {

        private LinkedList<Character> ll;

        /**
         * Creates a new SLList with a String, each character will be a node.
         * The first character in the String will be the head.
         *
         * @param s
         *     String that this SLList represents.
         */
        public CharacterLinkedList(String s) {
            ll = new LinkedList<>();
            for (int i = s.length() - 1; i >= 0; i--) {
                ll.addFirst(s.charAt(i));
            }
        }

        /**
         * Removes the first element in the list and returns it.
         *
         * @return first element in the list
         */
        public Character removeFirst() {
            return ll.poll();
        }

        /**
         * Returns the first element in the first and returns it, without removing it.
         *
         * @return first element in the list
         */
        public Character getFirst() {
            return ll.peek();
        }

        /**
         * Returns the size of the list.
         *
         * @return the size of the list
         */
        public int size() {
            return ll.size();
        }

}
