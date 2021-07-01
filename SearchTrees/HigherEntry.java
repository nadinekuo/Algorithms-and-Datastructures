import java.util.*;
import java.util.Queue;

public class HigherEntry {

    /**
     * Given a Binary Search Tree and an Integer, returns the Entry in this tree
     * with the smallest key that is STRICTLY larger than int k.
     * @param tree
     *     Binary search tree to search in. NOT BALANCED! So O(h)! (If balanced, O(log n))
     * @param k
     *     The key of the resulting entry should be strictly larger than this k, IF ANY, ELSE NULL.
     * @return The entry with smallest key, strictly larger than k.
     * PERFORM BFS!
     * PUT ALL ENTRIES WITH KEY > K in a list --> return MINIMUM of that list.
     */
    static Entry higherEntry(BinarySearchTree tree, int k) {

        if (tree == null) return null;
        List<Entry> bfs = bfs(tree);

        // put all ENTRIES higher than k in a list
        List<Entry> higherEntries = new ArrayList<>();
        for (Entry e : bfs) {
            if (e.key > k) {
                higherEntries.add(e);
            }
        }
        if (higherEntries.isEmpty()) return null;     // NO ENTRY HIGHER THAN int k

        // Find minimum in higherEntries list
        Entry currentMin = higherEntries.get(0);
        for (int i = 1; i < higherEntries.size(); i++) {
            if (higherEntries.get(i).key < currentMin.key) {
                currentMin = higherEntries.get(i);
            }
        }
        return currentMin;
    }

    /**
     * BINARY TREE
     * BFS: layer 1, layer 2, ...
     * Traverses the tree in a breadth first search order. The result will be a list containing the key of each node in the correct order.
     * @param tree - the tree that will be traversed
     * @return list containing the keys of each node in the correct order
     */
    public static List<Entry> bfs(BinarySearchTree tree) {  // a Tree here is just the "current Node", storing 1 key

        Queue<BinarySearchTree> queue = new LinkedList<>();
        List<Entry> res = new ArrayList<>();

        if (tree == null) {
            return res;
        }

        queue.add(tree);    // LinkedList doesnt have enqueue() (addLast)
        while (!queue.isEmpty()) {
            BinarySearchTree t = queue.poll();  // dequeue front of queue (removeFirst)
            res.add(t.getEntry());

            if (t.hasLeft()) {
                queue.add(t.getLeft());
            }
            if (t.hasRight()) {
                queue.add(t.getRight());
            }
        }
        return res;
    }

}
