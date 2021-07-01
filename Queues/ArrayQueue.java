import java.util.NoSuchElementException;

class ArrayQueue {

    private int[] arr;     // array storing ints
    private int f = 0;    // index of front element
    private int sz = 0;   // current no. of elements stored

    /**
     * Creates a new ArrayQueue with the given capacity.
     * @param capacity the capacity for this queue
     */
    public ArrayQueue(int capacity) {
        arr = new int[capacity];
    }

    public boolean isEmpty() {
        return sz == 0;
    }

    /**
     * Adds the given element to the queue.
     * @param e the element to add to the queue
     * @throws NoSuchElementException if the queue is full
     */
    public void enqueue(int e) throws NoSuchElementException {
        if (sz == arr.length) {             // capacity reached
            throw new NoSuchElementException();
        }
        int available = (f + sz) % arr.length;
        arr[available] = e;
        sz++;                 // increment size
    }

    /**
     * Removes an element from the queue and returns it.
     * @return the first element in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public int dequeue() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int result = arr[f];
        // arr[f] = null;       // ints can't be null, but this will eventually be overriden
        f = (f+1) % arr.length; // increment f
        sz--;
        return result;
    }
}

