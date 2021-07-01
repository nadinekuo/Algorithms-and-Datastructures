abstract class BSTNode {

    protected int key;
    protected String value;
    protected int height;

    private BSTNode left, right;

    /**
     * Simple constructor.
     * @param key
     *     to set as key.
     * @param value
     *     to set as value.
     *     NULL REFERENCES (external "leaves") HAVE HEIGHT 0, LAST LAYER NODES HAVE 1.
     */
    public BSTNode(int key, String value) {
        this.key = key;
        this.value = value;
        height = 1;
    }

    public abstract void recalculateHeight();
    public abstract void rotateLeft();
    public abstract void rotateRight();

    /**
     * @return The key of this BinaryTree node.
     */
    public int getKey() {
        return key;
    }

    /**
     * @return The key of this BinaryTree node.
     */
    public String getValue() {
        return value;
    }

    /**
     * @param key
     *     to set as key.
     */
    public void setKey(int key) {
        this.key = key;
    }

    /**
     * @param value
     *     to set as value.
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the left child.
     */
    public BSTNode getLeft() {
        return left;
    }

    /**
     * @return the right child.
     */
    public BSTNode getRight() {
        return right;
    }

    /**
     * @param left
     *     The BinaryTree node to set as left child.
     */
    public void setLeft(BSTNode left) {
        this.left = left;
    }

    /**
     * @param right
     *     The BinaryTree node to set as right child.
     */
    public void setRight(BSTNode right) {
        this.right = right;
    }

    /**
     * @return the height of this node (for example, 1 if both childs are leaves (null)).
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return the height of the left child (for example, 0 if left child is a leaf (null)).
     */
    public int leftChildHeight() {
        if(getLeft() == null) {
            return 0;
        } else {
            return getLeft().getHeight();
        }
    }

    /**
     * @return the height of the right child (for example, 0 if left child is a leaf (null)).
     */
    public int rightChildHeight() {
        if(getRight() == null) {
            return 0;
        } else {
            return getRight().getHeight();
        }
    }

    /**
     * @param key
     *     The key we need to find in the tree.
     * @return the value that key maps to (null if it didn't exist).
     */
    public String get(int key) {
        if(this.key == key) {
            return getValue();
        } else if(key < this.key) {
            return getLeft().get(key);          // call THIS method upon left child
        } else {
            return getRight().get(key);
        }
    }

    /**
     * @param key
     *     The key we need to put or replace in the tree.
     * @param value
     *     The value that key needs to be mapped to.
     * @return the old value that key mapped to (null if it didn't exist).
     */
    public String put(int key, String value) {
        String ret;

        // If we found the key or arrive at a leaf, do the put operation, otherwise proceed downwards
        if(this.key == key) {
            ret = getValue();
            setValue(value);
        } else if(key < this.key) {
            if(getLeft() == null) {                 // becomes new left child
                setLeft(new AVLNode(key,value));
                ret = null;
            } else {
                ret = getLeft().put(key,value);
            }
        } else {  // key > this.key
            if(getRight() == null) {
                setRight(new AVLNode(key,value));   // becomes new right child
                ret = null;
            } else {
                ret = getRight().put(key,value);
            }
        }
        return ret;
    }

    /**
     * @param key
     *     The key we need to remove from the tree.
     * @return the value that key mapped to (null if it didn't exist).
     */
    public String remove(int key) {
        if(this.key == key) {           // THIS Node has to be removed
            String ret = getValue();

            // find replacement: MAX IN LEFT SUBTREE
            BSTNode toRemove = treeMax(this.getLeft());
//            BSTNode toRemove = this;
//            while(toRemove.getRight() != null) {
//                toRemove = toRemove.getRight();     // <-- WRONG: Replacement should be max in left subtree, not in right.. (see treeMax method below!)
//            }
            setKey(toRemove.getKey());                // replace THIS node by replacement (max in left child)
            setValue(toRemove.getValue());
            toRemove = null;                        // remove replacement (duplicate now)
            return ret;
        } else if(key < this.key) {
            return getLeft().remove(key);   // call remove() on left child
        } else {
            return getRight().remove(key);      // call remove() on right child
        }
    }


    /**
     * Tree max entry --> last entry with MAXIMUM/HIGHEST key
     * @param node - Binary Search Tree subtree
     *             O(n log n) if balanced, else O(h).
     * @return the RIGHTMOST Entry with max. key.
     */
    public static BSTNode treeMax(BSTNode node) {
        BSTNode currentMax = node;
        while (currentMax.getRight() != null) {
            currentMax = node.getRight();
        }
        return currentMax;
    }




}