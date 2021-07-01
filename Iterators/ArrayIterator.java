import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<E> implements Iterator<E> {

    private E[] reference;
    private int index;


    /**
     * Constructor.
     * Should reset on a new array.
     * @param array
     *     takes the array
     */
    public ArrayIterator(E[] array) {
        this.reference = array;
        this.index = 0;
    }


    /**
     * @return True if there is a next element in the iterator, else False
     */
    @Override
    public boolean hasNext() {
        return index < this.reference.length;
    }


    /**
     * Get the next element of the iterator and shift
     * iterator by one.
     * @return current element value
     * @post iterator is moved to next element
     */
    @Override
    public E next() {
        if (!hasNext()) throw new NoSuchElementException();
        E item = reference[index];
        index++;
        return item;
    }

    /**
     * Skip a single element of the iterator.
     * @post iterator is moved to next element.
     */
    @Override
    public void remove() {
        next();
    }

//    public Iterator<E> iterator() {
//        return new ArrayIterator<E>();
//    }
}
