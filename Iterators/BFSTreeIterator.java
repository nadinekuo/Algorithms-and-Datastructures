import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

// Breadth first: QUEUE
// queue of Binary Tree Positions (see interfaces under Homework3)

public class BFSTreeIterator<E> implements Iterator<E> {

    private Queue<EntryPosition<E>> queue;
    private BTree<E> reference;

    /**
     * Constructor.
     * Should reset on a new Tree.
     */
    public BFSTreeIterator(BTree<E> tree) {
        this.reference = tree;
        this.queue = new LinkedList<>();
        queue.add(tree.getRoot());              // start at root
    }


    /**
     * @return True if there is a next element in the iterator, else False
     */
    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
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
        EntryPosition<E> current = queue.remove();
        try {
            if (reference.hasLeft(current)) {
                queue.add(reference.getLeft(current));
            } if (reference.hasRight(current)) {
                queue.add(reference.getRight(current));
            }
        } catch (InvalidPositionException e) {

        }
        return current.getValue();
    }

    /**
     * Skip a single element of the iterator.
     * @post iterator is moved to next element.
     */
    @Override
    public void remove() {
        next();
    }

}
