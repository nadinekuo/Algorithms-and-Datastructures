class BTNode<V> implements EntryPosition {

    private int key;
    private V value;
    private EntryPosition parent, left, right;

    /**
     * Simple constructor.
     * @param key
     *     to set as key.
     * @param value
     *     to set as value.
     */
    public BTNode(int key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    /**
     * @param value
     *     to set.
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * @return the parent.
     */
    public EntryPosition<V> getParent() {
        return parent;
    }

    /**
     * @return the left child.
     */
    public EntryPosition<V> getLeft() {
        return left;
    }

    /**
     * @return the right child.
     */
    public EntryPosition<V> getRight() {
        return right;
    }

    /**
     * @param parent
     *     to set
     */
    public void setParent(EntryPosition<V> parent) {
        this.parent = parent;
    }

    /**
     * @param left
     *     to set
     */
    public void setLeft(EntryPosition<V> left) {
        this.left = left;
    }

    /**
     * @param right
     *     to set
     */
    public void setRight(EntryPosition<V> right) {
        this.right = right;
    }


}
