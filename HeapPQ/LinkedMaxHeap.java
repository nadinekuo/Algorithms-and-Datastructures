class LinkedMaxHeap {

    // linked (tree-based) MAX heap, so use bitmask to access last node!
    // with array heaps, you could get index n-1

    TreeNode root;

    int size;

    public LinkedMaxHeap(int key) {
        root = new TreeNode(key);
        size = 1;
    }

    /**
     * Returns the last node in this heap when performing a breadth-first traversal
     * LINKED TREE MAX HEAP, SO WE CAN'T ACCESS LAST NODE BY index size-1.
     */
    public TreeNode getLastNode() {
        int height = (int) Math.ceil(Math.log(size + 1) / Math.log(2)) - 1;
        int completeSize = (int) Math.pow(2, height) - 1;       //nodes in levels 0 - (h-1)
        int lastIndex = (size - completeSize - 1);
        TreeNode node = this.root;
        for (int mask = 1 << (height - 1); mask > 0; mask >>= 1) {
            int bit = lastIndex & mask;
            if (bit == 0) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        return node;
    }

    /**
     * Removes the last node in the heap
     * Needed for removeMax, after swapping with the last node
     */
    public void removeLastNode() {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            root = null;
            size--;
            return;
        }
        TreeNode parent = getLastNode().getParent();
        if (parent.hasRight()) {           // if it has right, that must be the last node.
            parent.removeRight();
        } else {
            parent.removeLeft();            // else, left is last node
        }
        size--;
    }

    /**
     * Swaps the keys of two nodes i and j without affecting their pointers i.e. left, right, and parent
     */
    public void swap(TreeNode i, TreeNode j) {
        int temp = i.getKey();
        i.setKey(j.getKey());
        j.setKey(temp);
    }


    /**
     * Performs the downheap operation starting from the specified node
     * @param node the node where the downheap starts
     *             RECURSIVE (book: while-loop)
     *    First, node itself is set to largest.
     *    If left or right is larger, than that node becomes largest.  --> swap
     */
    public void downHeap(TreeNode node) {
        TreeNode largestNode = node;
        if (node.hasLeft() && (node.getLeft().getKey() > node.getKey())) {
            largestNode = node.getLeft();
        }
        if (node.hasRight() && (node.getRight().getKey() > largestNode.getKey())) {
            largestNode = node.getRight(); }

        if (largestNode.getKey() != node.getKey()) {            // if root node already largest, don't swap
            swap(node, largestNode);
            downHeap(largestNode);                       // RECURSIVELY continue at child
        }
    }


    /**
     * Removes the maximum element in this max heap
     * @return the maximum element in the heap (key)
     * 1. Swap with last node
     * 2. Remove last node
     * 3. Call downHeap()
     * 4. Return element
     */
    public int removeMax() {
        int element = root.getKey();
        swap(root, getLastNode());          // swap with last node
        removeLastNode();                   // essentially, root is removed.
        if (root != null) {                 // If tree only contains root (thus root = lastNode), then NOTHING IS LEFT!
            downHeap(root);                     // downheap bubbling from the root
        }
        return element;
    }
}
