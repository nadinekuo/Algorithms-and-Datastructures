import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CentreIterator<E> implements Iterator<E> {

    // visits middle index first
    // then goes 1 left (-1) of the middle, then 1 right (+1) of the middle
    // then 2 left of the middle, then 2 right of the middle...

    private List<E> reference;
    private int index = 0;
    private boolean negative;

    public CentreIterator(List<E> collection) {
        this.reference = collection;
        this.negative = false;
    }

    /**
     * Returns true if the iteration has more elements.
     */
    @Override
    public boolean hasNext() {
        return index >= reference.size() || index < 0;
    }

    /**
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public E next() {
        if (!hasNext()) throw new NoSuchElementException();
        int offset = index;
        if (negative) {
            offset = -offset;         // go to the left side
            index++;                   // only increment after both sides visited

        }
        negative = !negative;   // next iteration will visit other side again
        return reference.get(reference.size()/2 + offset);   // center + offset, either pos or neg
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

