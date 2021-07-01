import java.util.ArrayList;
import java.util.List;

class LibraryStringStack {

    List<String> items;

    public LibraryStringStack() {
        items = new ArrayList<>();
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    public void push(String s) {
        this.items.add(s);
    }

    public String pop() {
        return this.items.remove(this.items.size() - 1);
    }

    public String top() {
        return this.items.get(this.items.size() - 1);
    }
}