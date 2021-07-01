import java.util.ArrayList;
import java.util.List;

class LibraryQueue {

    List<String> items;

    public LibraryQueue() {
        items = new ArrayList<>();
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    public void enqueueFront(String s) {        // DEQUE!
        this.items.add(0, s);
    }

    public void enqueueBack(String s) {
        this.items.add(s);
    }

    public String dequeue() {
        return this.items.remove(0);
    }

    public String first() {
        return this.items.get(0);
    }
}