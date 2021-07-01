import java.util.*;
import java.util.Stack;

public class LinkedListStack<T> {

    private LinkedList<T> ll;

    public LinkedListStack() {
        ll = new LinkedList<>();
    }

    /**
     * @return true iff the stack is empty, else false
     */
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    /**
     * @return amount of elements in stack
     */
    public int size() {
        return ll.size();
    }

    /**
     * Pushes a new element to the stack.
     *
     * @param e
     *     element to be added to the stack
     */
    public void push(T e) {
        ll.offer(e);                //addLast
    }

    /**
     * Removes top element from the stack and returns it.
     *
     * @return top element of the stack
     * @throws NoSuchElementException
     *     iff the stack is empty
     */
    public T pop() throws NoSuchElementException {
        return ll.removeLast();
    }

    /**
     * Returns the top element of the stack, without removing it.
     *
     * @return top element of the stack
     * @throws NoSuchElementException
     *     iff the stack is empty
     */
    public T peek() throws NoSuchElementException {
        if (ll.peekLast() == null) {
            throw new NoSuchElementException();
        }
        return ll.peekLast();
    }

}
