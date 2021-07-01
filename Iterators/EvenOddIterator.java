import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class EvenOddIterator<T> implements Iterator<T> {

    // iterates over a list starting with all even indices (0, 2, 4..) , then the odd indices (1, 3, 5...)
    // LAZY (not SNAPSHOT)

    private List<T> reference;
    private int index = 0;

    public EvenOddIterator(List<T> collection) {
        this.reference = collection;
    }

    /**
     * Returns true if the iteration has more elements.
     */
    @Override
    public boolean hasNext() {
        return index % 2 == 0 || index < reference.size();  // it starts with evens
    }

    /**
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        if (index >= reference.size()) {    // all evens visited
            index = 1;
        }
        T element = reference.get(index);
        index += 2;
        return element;
    }

    /**
     * Removes from the underlying collection the last element returned
     * by this iterator (optional operation).
     */
    @Override
    public void remove() {
        next();
    }






}
