import java.util.*;

public class CLList<T> implements PositionList<T> {


    //TO BE IMPLEMENTED!
    // THIS IS A DOUBLY CLL!!!! (PositionLists allow insertions/removals at arbitrary positions)
    // used for class DoubleEndedQueue (under Queues)

    private DLLNode tail;
    private DLLNode head;       // implicit head
    private int size;

    /**
     * Constructor: initialises the head and tail fields as null
     */
    public CLList () {
        tail = null;
        head = null;
    }

    /**
     * @return the number of nodes/elements in the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @return true iff the list is empty.
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * @return the first node in the list or null if no such node exists.
     */
    @Override
    public Position<T> getFirst() {
        return null;
    }

    /**
     * @return the last node in the list or null if no such node exists.
     */
    @Override
    public Position<T> getLast() {
        return null;
    }

    /**
     * Finds the next element in the list given a position.
     *
     * @param p position to find the next element of.
     * @return the next element of p.
     * @throws InvalidPositionException iff p is invalid.
     */
    @Override
    public Position<T> getNext(Position<T> p) throws InvalidPositionException {
        return null;
    }

    /**
     * Finds the previous element in the list given a position.
     *
     * @param p position to find the previous element of.
     * @return the previous element of p.
     * @throws InvalidPositionException iff p is invalid.
     */
    @Override
    public Position<T> getPrev(Position<T> p) throws InvalidPositionException {
        return null;
    }

    /**
     * Adds an element to the front of the list.
     *
     * @param o element to add.
     */
    @Override
    public void addFirst(T o) {

    }

    /**
     * Adds an element to th end of the list.
     *
     * @param o element to add.
     */
    @Override
    public void addLast(T o) {

    }

    /**
     * Adds an element after a specified position.
     *
     * @param p position to place element after.
     * @param o element to insert.
     * @throws InvalidPositionException iff p is invalid.
     */
    @Override
    public void addAfter(Position<T> p, T o) throws InvalidPositionException {

    }

    /**
     * Adds an element before a specified position.
     *
     * @param p position that the element should be placed in front of.
     * @param o element to insert.
     * @throws InvalidPositionException iff p is invalid.
     */
    @Override
    public void addBefore(Position<T> p, T o) throws InvalidPositionException {

    }

    /**
     * Removes a position from the list.
     *
     * @param p position to remove.
     * @return the element of p.
     * @throws InvalidPositionException if p is invalid
     */
    @Override
    public T remove(Position<T> p) throws InvalidPositionException {
        return null;
    }

    /**
     * Changes the value of the given position to the given element.
     *
     * @param p position to change the value of.
     * @param o the new element for p.
     * @return the old element of p.
     * @throws InvalidPositionException iff p is invalid.
     */
    @Override
    public T set(Position<T> p, T o) throws InvalidPositionException {
        return null;
    }
}
