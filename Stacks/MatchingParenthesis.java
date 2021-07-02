import java.util.Stack;
import java.util.*;

public class MatchingParenthesis {

    /**
     * Returns true iff the delimiters in given expression are properly matched
     * True: () {([])}
     * False: ){[]}
     * @param expression the expression
     * @return true/false
     * IF WE REACH THE END OF THE EXPRESSION AND STACK IS EMPTY, then the expression was properly matched.
     * We only allow fixed symbols: (, {, [
     */
    public static boolean isMatched(String expression) {

        final String opening = "({[";       // left parenthesis
        final String closing = ")}]";       // right parenthesis
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            System.out.println("Current char: " + c);
            if (opening.indexOf(c) != -1) {         // c must be one of the 3 in "({["  (if not, indexOf returns -1)
                stack.push(c);
                System.out.println("New symbol pushed: " + stack.peek());
//                System.out.println("Stack: " + stack.toString());
            } else if (closing.indexOf(c) != -1) {
                if (stack.isEmpty()) return false;  // right parenthesis has nothing to match with!
                if (closing.indexOf(c) != opening.indexOf(stack.pop())) return false;   // mismatch
            }
        }
        return (stack.isEmpty());       // MUST BE EMPTY NOW.

    }







}
