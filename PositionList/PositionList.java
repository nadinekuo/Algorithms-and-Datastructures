
/**
 * DO NOT MODIFY
 * Interface for a node based list.
 *
 * @param <T>
 *     Type of elements the list can hold
 */
interface PositionList<T> {
    /**
     * @return the number of nodes/elements in the list.
     */
    public int size();

    /**
     * @return true iff the list is empty.
     */
    public boolean isEmpty();

    /**
     * @return the first node in the list or null if no such node exists.
     */
    public Position<T> getFirst();

    /**
     * @return the last node in the list or null if no such node exists.
     */
    public Position<T> getLast();

    /**
     * Finds the next element in the list given a position.
     *
     * @param p
     *     position to find the next element of.
     * @return the next element of p.
     * @throws InvalidPositionException
     *     iff p is invalid.
     */
    public Position<T> getNext(Position<T> p) throws InvalidPositionException;

    /**
     * Finds the previous element in the list given a position.
     *
     * @param p
     *     position to find the previous element of.
     * @return the previous element of p.
     * @throws InvalidPositionException
     *     iff p is invalid.
     */
    public Position<T> getPrev(Position<T> p) throws InvalidPositionException;

    /**
     * Adds an element to the front of the list.
     *
     * @param o
     *     element to add.
     */
    public void addFirst(T o);

    /**
     * Adds an element to th end of the list.
     *
     * @param o
     *     element to add.
     */
    public void addLast(T o);

    /**
     * Adds an element after a specified position.
     *
     * @param p
     *     position to place element after.
     * @param o
     *     element to insert.
     * @throws InvalidPositionException
     *     iff p is invalid.
     */
    public void addAfter(Position<T> p, T o) throws InvalidPositionException;

    /**
     * Adds an element before a specified position.
     *
     * @param p
     *     position that the element should be placed in front of.
     * @param o
     *     element to insert.
     * @throws InvalidPositionException
     *     iff p is invalid.
     */
    public void addBefore(Position<T> p, T o) throws InvalidPositionException;

    /**
     * Removes a position from the list.
     *
     * @param p
     *     position to remove.
     * @return the element of p.
     * @throws InvalidPositionException
     *     if p is invalid
     */
    public T remove(Position<T> p) throws InvalidPositionException;

    /**
     * Changes the value of the given position to the given element.
     *
     * @param p
     *     position to change the value of.
     * @param o
     *     the new element for p.
     * @return the old element of p.
     * @throws InvalidPositionException
     *     iff p is invalid.
     */
    public T set(Position<T> p, T o) throws InvalidPositionException;
}