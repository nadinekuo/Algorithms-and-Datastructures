import java.util.NoSuchElementException;

public class QueueFrom2Stacks<T> {

    private Stack<T> s1 = new LibraryStack<>();       // actual queue
    private Stack<T> s2 = new LibraryStack<>();       // stores elements from s1 to retrieve the bottom element when dequeing (FIFO)

    /**
     * @return true iff there are no elements left.
     */
    public boolean isEmpty() {
        return s1.isEmpty();
    }

    /**
     * @return the number of elements in the queue.
     */
    public int size() {
        return s1.size();
    }

    /**
     * Adds an element to the queue.
     * @param i
     *     element to enqueue.
     */
    public void enqueue(T i) {
        s1.push(i);
    }

    /**
     * Removes the first element from the queue.
     * @return the first element from the queue.
     * @throws NoSuchElementException
     *     iff the queue is empty.
     */
//   public T dequeue() throws NoSuchElementException {
//     if (s1.isEmpty()) {
//         throw new NoSuchElementException();
//     }
//     for (int i = 1; i < s1.size(); i++) {
//         s2.push(s1.pop());                      // use s2 to store other elements
//     }
//     T result = s1.pop();                        // store bottom element
//     for (int i = 0; i < s2.size(); i++) {
//         s1.push(s2.pop());
//     }
//     return result;
//   }

    public T dequeue() throws NoSuchElementException {
        if (s1.isEmpty()) {
            throw new NoSuchElementException();
        }
        while (s1.size() != 1) {
            s2.push(s1.pop());
            // T element = s1.pop();
            // s2.push(element);
        }
        T result = s1.pop();
        while (s2.size() != 0) {
            s1.push(s2.pop());
            // T element = s2.pop();
            // s1.push(element);
        }
        return result;
    }

    /**
     * Only returns (i.e. does not remove) the first element from the queue.
     * @return the first element from the queue.
     * @throws NoSuchElementException
     *     iff the queue is empty.
     */
//   public T first() throws NoSuchElementException {
//     if (s1.isEmpty()) {
//         throw new NoSuchElementException();
//     }
//     for (int i = 1; i < s1.size(); i++) {
//         s2.push(s1.pop());
//     }
//     T result = s1.peek();
//     for (int i = 0; i < s2.size(); i++) {
//         s1.push(s2.pop());
//     }
//     return result;
//   }

    public T first() throws NoSuchElementException {
        if (s1.isEmpty()) {
            throw new NoSuchElementException();
        }
        while (s1.size() != 1) {
            s2.push(s1.pop());
            // T element = s1.pop();
            // s2.push(element);
        }
        T result = s1.peek();
        while (s2.size() != 0) {
            s1.push(s2.pop());
            // T element = s2.pop();
            // s1.push(element);
        }
        return result;
    }


}
