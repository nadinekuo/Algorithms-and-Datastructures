import java.util.NoSuchElementException;

/**
 * DO NOT MODIFY
 * Interface for a Stack.
 *
 * @param <T>
 *     Type of elements the Stack can hold
 */
interface Stack<T> {
    /**
     * @return true iff it contains no elements.
     */
    public boolean isEmpty();

    /**
     * @return the number of elements in the stack.
     */
    public int size();

    /**
     * Add an element to the top of the stack
     *
     * @param e
     *     element to push.
     */
    public void push(T e);

    /**
     * Removes the top element from the stack.
     *
     * @return the first element.
     * @throws NoSuchElementException
     *     iff the stack is empty
     */
    public T pop() throws NoSuchElementException;

    /**
     * @return the top element (does not pop it).
     * @throws NoSuchElementException
     *     iff the stack is empty
     */
    public T peek() throws NoSuchElementException;
}