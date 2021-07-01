class LinkedHeap2 {

    private int size = 0;
    private LinkedHeap2.Node root;


    /**
     * @param heap
     * COMPLETE LINKED TREE
     * O(h) --> O(log n)!!!
     * Total: n nodes (heap size)
     *
     *     the Heap to check, can be null. If not null, this heap will always contain at least one Node.
     * @return the Node corresponding to the middle element in the last layer of the Heap, or null if the Heap is null.
     * In case the last layer contains an EVEN number of elements, returns the element just LEFT of the middle (see test).
     */
    public static LinkedHeap2.Node findMiddleInLastLayer(LinkedHeap2 heap) {
        if (heap == null) {
            return null;
        }
        if (!heap.hasLeft(heap.getRoot()) && !heap.hasRight(heap.getRoot())) {  // if no children
            return heap.getRoot();
        }

        int n = heap.size();                                    // total amount of nodes
        // casting to int rounds down (floor)
        int height = (int) (Math.log(n)/Math.log(2));           // tree height (log2(n))
        int maxIndex = (n-((int) Math.pow(2, height)));         // last node index: n - 2 ^ height
        int midIndex = maxIndex/2;                              // rounds down
        int comp = 1 << (height-1);                             // bitmask for bit 1 (to be updated)

        LinkedHeap2.Node result = heap.getRoot();
        for (int i = 1; i <= height; i++) {                     // height = bitstring length
            if ((midIndex & comp) == 0) {                       // bitwise comparison (AND)
                result = heap.getLeft(result);                   // left path
            } else {
                result = heap.getRight(result);                   // right path
            }
            comp = comp >> 1;                                     // update bit mask for next comparison
        }
        return result;
    }


    /**
     * @param heap
     *     the Heap to check, can be null. If not null, this heap will always contain at least one Node.
     * @return the Node corresponding to the last position in the Heap, or null if the Heap is null.
     */
    public static LinkedHeap2.Node findLastPosition(LinkedHeap2 heap) {
        if (heap == null) return null;
        if (!heap.hasLeft(heap.getRoot()) && !heap.hasRight(heap.getRoot())) {
            return heap.getRoot();
        }

        int n = heap.size();
        int height = (int) (Math.log(n)/Math.log(2));
        int lastIndex = n - (int) Math.pow(2, height);
        int comp = 1 << (height-1);

        LinkedHeap2.Node result = heap.getRoot();
        for (int i = 1; i <= height; i++) {
            if ((lastIndex & comp) == 0) {
                result = heap.getLeft(result);
            } else {
                result = heap.getRight(result);
            }
            comp = comp >> 1;
        }
        return result;
    }

    /**
     * Initializes a Heap with one Node.
     * @param rootKey
     *     the key given to the root Node of the Heap.
     */
    public LinkedHeap2(int rootKey) {
        root = new LinkedHeap2.Node(rootKey);
        size++;
    }

    /**
     * @return the root Node of this Heap.
     */
    public LinkedHeap2.Node getRoot() {
        return root;
    }

    /**
     * @param n
     *     The Node to get the left child from.
     * @return the left child of n.
     */
    public LinkedHeap2.Node getLeft(LinkedHeap2.Node n) {
        return n.left;
    }

    /**
     * @param n
     *     The Node to get the right child from.
     * @return the right child of n.
     */
    public LinkedHeap2.Node getRight(LinkedHeap2.Node n) {
        return n.right;
    }

    /**
     * @param n
     *     The Node to check the left child from.
     * @return true iff Node n has a left child, false otherwise.
     */
    public boolean hasLeft(LinkedHeap2.Node n) {
        return n.left != null;
    }

    /**
     * @param n
     *     The Node to check the right child from.
     * @return true iff Node n has a right child, false otherwise.
     */
    public boolean hasRight(LinkedHeap2.Node n) {
        return n.right != null;
    }

    /**
     * This method creates a new left child of n if it does not yet have a left child.
     *
     * @param n
     *     The Node to set the left child from.
     * @param leftKey
     *     The key to set in the left child of Node n.
     */
    public void setLeft(LinkedHeap2.Node n, int leftKey) {
        if (n.left == null) {
            n.left = new LinkedHeap2.Node(leftKey);
            size++;
        } else {
            n.left.key = leftKey;       // if not null, just change key
        }
    }

    /**
     * This method creates a new right child of n if it does not yet have a right child.
     *
     * @param n
     *     The Node to set the right child from.
     * @param rightKey
     *     The key to set in the right child of Node n.
     */
    public void setRight(LinkedHeap2.Node n, int rightKey) {
        if (n.right == null) {
            n.right = new LinkedHeap2.Node(rightKey);
            size++;
        } else {
            n.right.key = rightKey;
        }
    }

    /**
     * @return The size of this Heap, i.e. the amount of Nodes.
     */
    public int size() {
        return size;
    }

    // ********************************** NESTED NODE CLASS ************************************************//

    class Node {
        private int key;
        private LinkedHeap2.Node left, right;

        /**
         * Simple constructor.
         * @param key
         *     to set as key.
         */
        public Node(int key) {
            this.key = key;
        }

        /**
         * @return The integer key of this Node.
         */
        public int getKey() {
            return key;
        }

        @Override
        public String toString() {
            return key + "(" + (left == null ? " " : left) + ',' + (right == null ? " " : right) + ')';
        }
    }
}
