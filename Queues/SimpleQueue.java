import java.util.LinkedList;
import java.util.List;

class SimpleQueue<T> {

    private List<T> list;

    public SimpleQueue() {
        list = new LinkedList<>();      // static type List, dynamic type LinkedList
    }


    /**
     * Reverses the queue itself. NB: This method should be recursive.
     */
    public void reverse() {   // keep on dequeing and enqueing so the first becomes last and vice versa.
        if (size() == 0) {
            return;             // it will go back to the previous method call/stack frame
        }
        T element = dequeue();
        reverse();
        enqueue(element);
    }

    public int size() {
        return list.size();
    }

    /**
     * @return true iff the queue contains no elements.
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Adds an element to the back of the queue.
     * @param element
     *   to add.
     */
    public void enqueue(T element) {
        list.add(element);
    }

    /**
     * Removes and returns the element at the front of the queue.
     * @return the element at the front of the dequeue
     * @throws IllegalArgumentException
     *     iff the queue is empty
     */
    public T dequeue() throws IllegalArgumentException {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty!!");
        }
        T result = list.get(0);
        list.remove(0);
        return result;
    }

}
