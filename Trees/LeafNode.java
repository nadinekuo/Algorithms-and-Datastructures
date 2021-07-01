

/**
 * Leaf Node that stores an operand represented as an integer
 * USED IN ARITHMETIC TREE.
 */

class LeafNode extends AbstractNode<Integer> {
    public LeafNode(int constant) {
        this.val = constant;
    }

    public boolean isLeaf() {
        return true;
    }
}