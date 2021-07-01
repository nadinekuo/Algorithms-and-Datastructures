import java.util.LinkedList;

class ReverseQueue<T> {

    private LinkedList<T> q;

    public ReverseQueue() {
        this.q = new LinkedList<>();
    }

    /**
     * Reverses the queue itself. NB: This method should be recursive.
     */
    public void reverse() {   // keep on dequeing and enqueing so the first becomes last and vice versa.
        if (size() == 0) {
            return;             // it will go back to the previous method call/stack frame (line 13)
        }
        T element = dequeue();
        reverse();
        enqueue(element);
    }

    public void enqueue(T e) {
        q.add(e);
    }

    public T dequeue() {
        return q.poll();
    }

    public int size() {
        return q.size();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public T front() {
        return q.peek();
    }

}