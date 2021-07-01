class AVLNode extends BSTNode {


    // ALL nodes are linked to form an AVL Tree!

    public AVLNode(int key, String value) {
        super(key,value);
    }

    // these 3 methods are used in get() and put()

    // height of THIS AVL node: max of left/right child + 1
    // we update the field (O(1)! It would be O(n) to calculate it each time we need height)
    public void recalculateHeight() {

//        height = Math.max(leftChildHeight() + 1, rightChildHeight() + 1);

        if (leftChildHeight() > rightChildHeight()) {
            height = leftChildHeight() + 1;
        } else {
            height = rightChildHeight() + 1;
        }
    }


    public boolean isBalanced(AVLNode node) {
        return Math.abs(node.getLeft().getHeight() - node.getRight().getHeight()) <= 1;
    }


    /** TRI-NODE RESTRUCTURE
     * Called from THIS AVLNode (top of the 3 in the imbalanced structure) --> Operates on 3 nodes
     * Check AVL balance condition (restructure if needed)
     * if the left child’s left is taller --> single rotate
     * if left child’s right is taller (zigzag) --> double rotate
     * This method calls rotateLeft() and rotateRight().
     */
    public void restructure() {
        // left and right height may differ AT MOST by 1
        if (leftChildHeight() > rightChildHeight()+1) {     // we know left is not null (height => 2)!
            if (getLeft().leftChildHeight() > getLeft().rightChildHeight()) {   // single rotation
                rotateRight();
            } else {                                                           // double rotation (zigzag)
                getLeft().rotateLeft();
                rotateRight();
            }
        } else if(rightChildHeight() > leftChildHeight()+1) {
            if (getRight().rightChildHeight() > getRight().leftChildHeight()) {   // single rotation
                rotateLeft();
            } else {                                                                // double rotation
                getRight().rotateRight();
                rotateLeft();
            }
        }
    }

    /** Rotates 2 nodes to left
     *  Called from the top node of the 2 (root of this subtree)
     * Make right child new root
     */
    public void rotateLeft() {

        AVLNode rightChild = (AVLNode)getRight();
        swapKeyValue(this, rightChild);         // THIS node now has key/value of former rightChild

        // relinking
        setRight(rightChild.getRight());           // T3 is new right child
        rightChild.setRight(rightChild.getLeft());  // T2 is new right child of rightChild
        rightChild.setLeft(getLeft());              // T1 is new left child of rightChild
        setLeft(rightChild);

        // recalculate height
        rightChild.recalculateHeight();
        recalculateHeight();

    }

    /** Rotates 2 nodes to right
     *  Called from the top node of the 2 (root of this subtree)
     * Make left child new root
     */
    public void rotateRight() {
        //we swap key and value of this node and left child node! (no ref to parent)
        AVLNode leftChild = (AVLNode)getLeft();
        swapKeyValue(this, leftChild);

        // relinking
        setLeft(leftChild.getLeft());
        leftChild.setLeft(leftChild.getRight());
        leftChild.setRight(getRight());
        setRight(leftChild);

        leftChild.recalculateHeight();
        recalculateHeight();
    }

    public static void swapKeyValue(AVLNode node1, AVLNode node2) {
        int tempKey = node1.getKey();
        String tempValue = node1.getValue();

        node1.setKey(node2.getKey());
        node1.setValue(node2.getValue());
        node2.setKey(tempKey);
        node2.setValue(tempValue);
    }



    @Override
    public String get(int key) {
        return super.get(key);     // extends BSTNode!
    }


    /** THIS METHOD IS CALLED RECURSIVELY BY the put() method in AVLTree class
     * Add extra steps to put() in BSTNode: balance condition!
     */
    @Override
    public String put(int key, String value) {
        String ret;
        if (key == this.key) {    // given key equal to key of THIS AVL node
            String oldvalue = this.value;
            this.value = value;       // value of THIS NODE gets replaced
            return oldvalue;
        }

        else if (key < this.key) {
            if (getLeft() == null) {
                setLeft(new AVLNode(key, value)); // new node Entry (key did not exist)
                ret = null;
            } else {
                ret = getLeft().put(key, value);  // call this SAME METHOD on left child
            }
        }
        // same for right subtree
        else {
            if (getRight() == null) {
                setRight(new AVLNode(key, value)); // new node Entry (key did not exist)
                ret = null;
            } else {
                ret = getRight().put(key, value);  // call this SAME METHOD on left child
            }
        }

        recalculateHeight();              // recursion: called on THIS node and CHILD!
        restructure();                      // tri-node restructuring will only take place if needed.

        return ret;
    }



}