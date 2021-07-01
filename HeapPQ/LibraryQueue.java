import java.util.*;

class LibraryPQ<T> {
    private PriorityQueue<T> ll;

    public LibraryPQ() {
        ll = new PriorityQueue<>();
    }

    /**
     * @return true iff the priority queue is empty, else false
     */
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    /**
     * @return amount of elements in the priority queue
     */
    public int size() {
        return ll.size();
    }

    /**
     * Adds an Entry to the priority queue sorted on the key in a decreasing order.
     *
     * @param e
     *     Entry to be added.
     */
    public void enqueue(T e) {
        ll.offer(e);
    }

    /**
     * Removes the Entry with the maximum key from the priority queue.
     *
     * @return Entry with max key in pq
     * @throws NoSuchElementException
     *     iff this queue is empty
     */
    public T dequeue() throws NoSuchElementException {
        return ll.remove();
    }

    /**
     * Returns the Entry with the maximum key from the priority queue,
     * without removing it.
     *
     * @return Entry with max key in pq
     * @throws NoSuchElementException
     *     iff this queue is empty
     */
    public T front() throws NoSuchElementException {
        if (ll.peek() == null) {
            throw new NoSuchElementException();
        }
        return ll.peek();
    }
}