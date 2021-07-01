/**
 * Implementation of a double ended queue.
 * @param <T>
 *     Type of elements the queue can hold
 */
class DoubleEndedQueue<T> implements Deque<T> {
    /**
     * Position-based list to keep the elements of the queue
     */
    private final PositionList<T> list;

    /**
     * Constructs a new queue.
     * Chooses a circular linked list as an implementation of a position-based list.
     * CLL implements PositionList<T>
     */
    public DoubleEndedQueue() {
        this.list = new CLList<>();
    }       // CLList class defined under LinkedLists

    /**
     * @return the number of elements in the queue.
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * @return true iff the queue contains no elements.
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * @return the element at the front of the queue
     * @throws InvalidPositionException
     *     iff the queue is empty
     */
    @Override
    public T getFirst() throws InvalidPositionException {
        if (isEmpty()) {
            throw new InvalidPositionException("empty deque!");
        }
        return list.getFirst().getElement();
    }

    /**
     * @return the element at the end of the queue
     * @throws InvalidPositionException
     *     iff the queue is empty
     */
    @Override
    public T getLast() throws InvalidPositionException {
        if (isEmpty()) {
            throw new InvalidPositionException("empty deque!");
        }
        return list.getLast().getElement();
    }

    /**
     * Adds an element to the front of the queue.
     *
     * @param element
     *     to add.
     */
    @Override
    public void addFirst(T element) {
        list.addFirst(element);
    }

    /**
     * Adds an element to the back of the queue.
     *
     * @param element
     *     to add.
     */
    @Override
    public void addLast(T element) {
        list.addLast(element);
    }

    /**
     * Removes and return the element at the front of the queue.
     *
     * @return the element at the front of the queue
     * @throws InvalidPositionException
     *     iff the queue is empty
     */
    @Override
    public T removeFirst() throws InvalidPositionException {
        if (isEmpty()) {
            throw new InvalidPositionException("empty deque!");
        }
        Position<T> first = list.getFirst();
        list.remove(first);
        return first.getElement();
    }

    /**
     * Removes and return the element at the end of the queue.
     *
     * @return the element at the end of the queue
     * @throws InvalidPositionException
     *     iff the queue is empty
     */
    @Override
    public T removeLast() throws InvalidPositionException {
        if (isEmpty()) {
            throw new InvalidPositionException("empty deque!");
        }
        Position<T> last = list.getLast();
        list.remove(last);
        return last.getElement();
    }
}