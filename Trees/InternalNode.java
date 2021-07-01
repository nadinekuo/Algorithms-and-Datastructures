
/**
 * Internal AbstractNode that stores an operator represented as a string
 *  * USED IN ARITHMETIC TREE.
 */
@SuppressWarnings("rawtypes")
class InternalNode extends AbstractNode<String> {
    public AbstractNode left;
    public AbstractNode right;

    public InternalNode(String operator, AbstractNode left, AbstractNode right) {
        this.val = operator;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return false;
    }

    public AbstractNode getLeft() {
        return left;
    }

    public AbstractNode getRight() {
        return right;
    }
}