class TreeNode {

    private int key;

    private TreeNode left, right;

    private TreeNode parent;

    /**
     * Simple constructor.
     *
     * @param key
     *     to set as key.
     */
    public TreeNode(int key) {
        this.key = key;
    }

    /**
     * Extended constructor.
     *
     * @param key
     *     to set as key.
     * @param left
     *     to set as left child.
     * @param right
     *     to set as right child.
     */
    public TreeNode(int key, TreeNode left, TreeNode right) {
        this.key = key;
        setLeft(left);
        setRight(right);
    }

    /**
     * @return the key
     */
    public int getKey() {
        return key;
    }

    /**
     * @param key to set
     */
    public void setKey(int key) {
        this.key = key;
    }

    /**
     * @return the left child.
     */
    public TreeNode getLeft() {
        return left;
    }

    /**
     * @return the right child.
     */
    public TreeNode getRight() {
        return right;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    /**
     * @param left
     *     to set
     */
    public void setLeft(TreeNode left) {
        this.left = left;
        left.setParent(this);
    }

    /**
     * @param right
     *     to set
     */
    public void setRight(TreeNode right) {
        this.right = right;
        right.setParent(this);
    }

    /**
     * @return the parent
     */
    public TreeNode getParent() {
        return this.parent;
    }

    /**
     * @param parent
     *     to set
     */
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public boolean hasParent() {
        return this.parent != null;
    }

    /**
     * Removes the reference to the left child
     */
    public void removeLeft() {
        this.left = null;
    }

    /**
     * Removes the reference to the right child
     */
    public void removeRight() {
        this.right = null;
    }

    @Override
    public String toString() {
        return "TreeNode{" + "key = " + key + ", left = " + (hasLeft() ? getLeft().key : null) + ", right = " + (hasRight() ? getRight().key : null) + '}';
    }
}
