import java.util.Iterator;
import java.util.Stack;

/** DEPTH FIRST TRAVERSAL: PRE-ORDER
 * LAZY: DIRECT TRAVERSAL! NO RECURSION, USE STACK. (lifo)
 * WITH RECURSION, YOU GO OVER EDGES MULTIPLE TIMES. (it returns to the previous call)
 * Iterates lazily over a binary tree in a depth-first manner. For instance a tree
 * with 8 as it's root and 4 and 10 as it's children should be iterated as: 8 ->
 * 4 -> 10.
 */
class dfsBinaryTreeIterator<V> implements Iterator<V> {

    BTree<V> reference;
    Stack<EntryPosition<V>> stack;           // stack of Positions in the tree


    /**
     * Constructor.
     * Should reset on a new tree.
     * @param tree
     *     takes the tree
     */
    public dfsBinaryTreeIterator(BTree<V> tree) {
        this.reference = tree;          // no deep copy, but reference!
        this.stack = new Stack<>();
        if (tree.getRoot() != null) {
            stack.add(tree.getRoot());  // add the root: first position
        }
    }

    /**
     * @return True if there is a next element in the iterator, else False
     */
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();    // the most recently pushed position will be the next
    }

    /**
     * Get the next element of the iterator and shift
     * iterator by one.
     * @return current element value
     * @post iterator is moved to next element
     */
    @Override
    public V next() {
        EntryPosition<V> result = stack.pop();   // remove next (most recently added)
        try {                                       // you cant throw exceptions in overridden methods!! Try-catch
            if (reference.hasRight(result)) {
                stack.add(reference.getRight(result));  // add children from right to left!! (LIFO)
            }
            if (reference.hasLeft(result)) {
                stack.add(reference.getLeft(result));
            }

        } catch(InvalidPositionException e) {

        }
        return result.getValue();       // the value of the next position
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