import java.util.NoSuchElementException;

/**
 * Interface for a Queue.
 * <p>
 * DO NOT MODIFY
 *
 * @param <T>
 *     Type of elements the queue can hold
 */
interface Queue<T> {
    /**
     * @return true iff it contains no elements.
     */
    public boolean isEmpty();

    /**
     * @return the number of elements in the queue.
     */
    public int size();

    /**
     * Add an element to the end of the queue
     *
     * @param e
     *     element to add.
     */
    public void enqueue(T e);

    /**
     * Removes the first element from the queue.
     *
     * @return the first element.
     * @throws NoSuchElementException
     *     iff the queue is empty
     */
    public T dequeue() throws NoSuchElementException;

    /**
     * @return the first element (does not remove it).
     * @throws NoSuchElementException
     *     iff the queue is empty
     */
    public T front() throws NoSuchElementException;

    void add(T v);
}

