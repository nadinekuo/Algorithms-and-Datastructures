import java.util.*;

public class DFSTreeIterator<E> implements Iterator<E> {

    // iterator iterates over Positions in the BTree

    private Iterator<EntryPosition<E>> iterator;
    private PosBinaryTree<E> reference;

    /**
     * Constructor.
     * Iterator iterates over List which contains all Positions in DFS order.
     * See helper-method for DFS PRE-ORDER below.
     * The list is REVERSED, so it becomes POST-ORDER (but from right to left)
     */
    public DFSTreeIterator(PosBinaryTree<E> tree) {
        this.reference = tree;
        List<EntryPosition<E>> list = depthFirstSearch(tree.getRoot());
        Collections.reverse(list);
        iterator = list.iterator();
    }

    /**
     * Helper method: depth-first search.
     * Adds all visited POSITIONS (BTNodes) to List
     * Pre-order
     * RECURSIVE
     * This method is not efficient: Positions are processed more than 1x... (AddAll)
     */
    public List<EntryPosition<E>> depthFirstSearch(EntryPosition<E> node) {

        List<EntryPosition<E>> list = new ArrayList<>();
        list.add(node);      // starts with root (See constructor)
        try {
            if (reference.hasLeft(node)) {
                list.addAll(depthFirstSearch(reference.getLeft(node)));
            }
            if (reference.hasRight(node)) {
                list.addAll(depthFirstSearch(reference.getRight(node)));
            }
        } catch (InvalidPositionException e) {

        }
        return list;
    }


    /**
     * @return True if there is a next element in the iterator, else False
     */
    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }


    /**
     * Get the next element of the iterator and shift
     * iterator by one.
     * @return current element value
     * @post iterator is moved to next element
     */
    @Override
    public E next() {
        return iterator.next().getValue();
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
