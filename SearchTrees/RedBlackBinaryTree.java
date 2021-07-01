public class RedBlackBinaryTree {

    private int value;

    private RedBlackBinaryTree left, right;

    private boolean isRed;              // can be set to black (recoloring)

    /**
     * Simple constructor.
     *
     * @param value Value for this tree set as value.
     * @param isRed True if this node is red, false otherwise.
     */
    public RedBlackBinaryTree(int value, boolean isRed) {
        this.value = value;
        this.isRed = isRed;
    }

    /**
     * Extended constructor.
     *
     * @param value to set as value.
     * @param left to set as left child.
     * @param right to set as right child.
     */
    public RedBlackBinaryTree(int value, boolean isRed, RedBlackBinaryTree left, RedBlackBinaryTree right) {
        this(value, isRed);
        setLeft(left);
        setRight(right);
    }

    /**
     * @return the value of this tree.
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the new value of this tree.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * @return the left child.
     */
    public RedBlackBinaryTree getLeft() {
        return left;
    }

    /**
     * @return the right child.
     */
    public RedBlackBinaryTree getRight() {
        return right;
    }

    /**
     * @return true if this node is red, false otherwise.
     */
    public boolean isRed() {
        return isRed;
    }

    /**
     * @return true if this node is black, false otherwise.
     */
    public boolean isBlack() {
        return !isRed;
    }

    /**
     * @return True if the tree has a left child, false otherwise.
     */
    public boolean hasLeft() {
        return left != null;
    }

    /**
     * @return True if the tree has a right child, false otherwise.
     */
    public boolean hasRight() {
        return right != null;
    }

    /**
     * @param left Left subtree to set.
     */
    public void setLeft(RedBlackBinaryTree left) {
        this.left = left;
    }

    /**
     * @param right Right subtree to set.
     */
    public void setRight(RedBlackBinaryTree right) {
        this.right = right;
    }

    /**
     * @param red True if the new color is red, false otherwise.
     */
    public void setRed(boolean red) {
        isRed = red;                    // depends on boolean value
    }


}
