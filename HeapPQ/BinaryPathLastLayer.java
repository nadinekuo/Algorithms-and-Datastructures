public class BinaryPathLastLayer {

    /**
     * Returns the last node in this heap when performing a breadth-first traversal
     * LINKED TREE MAX HEAP, SO WE CAN'T ACCESS LAST NODE BY index size-1.
     *  00000000000000000000000000000001   << (3-1)=2  gives: 00000000000000000000000000000100
     *  00000000000000000000000000000100   >> 1 gives
     *  00000000000000000000000000000010   >> 1 gives
     *  00000000000000000000000000000001
     *  after another >>1, it will not be > 0 anymore, so loop stops.
     */
    public TreeNode getLastNode(LinkedMaxHeap heap) {
        int n = heap.size;
        int height = (int) Math.ceil(Math.log(n + 1) / Math.log(2)) - 1;
        int completeSize = (int) Math.pow(2, height) - 1;       //nodes in levels 0 - (h-1)
        int lastIndex = (n - completeSize - 1);
        TreeNode node = heap.root;
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
     * @param heap
     * COMPLETE LINKED TREE
     * O(h) --> O(log n)!!!
     * Total: n nodes (heap size)
     *     *  00000000000000000000000000000001   << (3-1)=2  gives: 00000000000000000000000000000100
     *      *  00000000000000000000000000000100   >> 1 gives
     *      *  00000000000000000000000000000010   >> 1 gives
     *      *  00000000000000000000000000000001
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




}
