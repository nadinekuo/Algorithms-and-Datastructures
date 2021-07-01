interface BTree<V> {

    /**
     * @return the root of the tree
     */
    public EntryPosition<V> getRoot();

    /**
     * Get the left child of a position.
     *
     * @param v
     *     the position to get the child of.
     * @return the child of the position iff hasLeft(v) is true.
     * @throws InvalidPositionException
     *     else
     */
    public EntryPosition<V> getLeft(EntryPosition<V> v) throws InvalidPositionException;

    /**
     * Get the right child of a position.
     *
     * @param v
     *     the position to get the child of.
     * @return the child of the position iff hasRight(v) is true.
     * @throws InvalidPositionException
     *     else
     */
    public EntryPosition<V> getRight(EntryPosition<V> v) throws InvalidPositionException;

    /**
     * Check if a position has a left child.
     *
     * @param v
     *     position to check.
     * @return true iff v has a left child.
     * @throws InvalidPositionException
     *     if v is not valid (e.g. null)
     */
    public boolean hasLeft(EntryPosition<V> v) throws InvalidPositionException;

    /**
     * Check if a position has a right child.
     *
     * @param v
     *     position to check.
     * @return true iff v has a right child.
     * @throws InvalidPositionException
     *     if v is not valid (e.g. null)
     */
    public boolean hasRight(EntryPosition<V> v) throws InvalidPositionException;

    /**
     * Adds a new entry to the tree.
     *
     * @param key
     *     to use.
     * @param value
     *     to add.
     */
    public void add(int key, V value);
}
