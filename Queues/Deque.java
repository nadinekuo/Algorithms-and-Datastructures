
/**
 * DO NOT MODIFY
 * Interface for the double ended queue.
 */
interface Deque<T> {
    /**
     * @return the number of elements in the deque.
     */
    public int size();

    /**
     * @return true iff the deque contains no elements.
     */
    public boolean isEmpty();

    /**
     * @return the element at the front of the dequeue
     * @throws InvalidPositionException
     *     iff the queue is empty
     */
    public T getFirst() throws InvalidPositionException;

    /**
     * @return the element at the end of the dequeue
     * @throws InvalidPositionException
     *     iff the queue is empty
     */
    public T getLast() throws InvalidPositionException;

    /**
     * Adds an element to the front of the deque.
     *
     * @param element
     *     to add.
     */
    public void addFirst(T element);

    /**
     * Adds an element to the back of the deque.
     *
     * @param element
     *     to add.
     */
    public void addLast(T element);

    /**
     * Removes and return the element at the front of the dequeue.
     *
     * @return the element at the front of the dequeue
     * @throws InvalidPositionException
     *     iff the queue is empty
     */
    public T removeFirst() throws InvalidPositionException;

    /**
     * Removes and return the element at the end of the dequeue.
     *
     * @return the element at the end of the dequeue
     * @throws InvalidPositionException
     *     iff the queue is empty
     */
    public T removeLast() throws InvalidPositionException;
}