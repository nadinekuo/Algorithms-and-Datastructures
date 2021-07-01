import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LibraryStack<T> implements Stack<T> {

    private List<T> stack;

    public LibraryStack() {
        stack = new ArrayList<>();
    }

    /**
     * @return true iff it contains no elements.
     */
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * @return the number of elements in the stack.
     */
    @Override
    public int size() {
        return stack.size();
    }

    /**
     * Add an element to the top of the stack
     *
     * @param e element to push.
     */
    @Override
    public void push(T e) {
        stack.add(e);
    }

    /**
     * Removes the top element from the stack.
     * @return the first element. THUS THE LAST IN THE ARRAYLIST.
     * @throws NoSuchElementException iff the stack is empty
     */
    @Override
    public T pop() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException();
        return stack.remove(size()-1);
    }

    /**
     * @return the top element (does not pop it).
     * @throws NoSuchElementException iff the stack is empty
     */
    @Override
    public T peek() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException();
        return stack.get(size() - 1);
    }
}
