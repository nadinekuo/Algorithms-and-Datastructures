import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlattenBinarySearchTree {

    /**
     * Return all elements in the given BST in DESCENDING order. --> traverse right to left in-order!
     * @param tree The BST to traverse.
     * @return A LIST of all elements in REVERSE order.
     * O(n) time, n = amount of nodes --> worst case: 2 rec calls with h-1, so 2^h = 2^logn = n
     * O(h) space, besides the list.
     */
    public static List<Integer> descendingOrder(BinaryTree tree) {

        // Normal in-order traversal (L --> R)
        List<Integer> result = inOrder(tree);

        // reverse the list (R --> L)
        Collections.reverse(result);
        System.out.println("Reversed: " + result);
        return result;
    }

    /**
     * In order DFS: left, parent, right
     * HERE WE CREATE A NEW ARRAYLIST, which is modified by the helper.
     * @param tree the tree
     * @return the list which is processed by the helper
     */
    public static List<Integer> inOrder(BinaryTree tree) {
        List<Integer> list = new ArrayList<>();
        inOrderHelper(tree, list);
        System.out.println("DFS In order traversal: " + list);
        return list;
    }

    private static void inOrderHelper (BinaryTree tree, List<Integer> list) {
        if (tree == null) return;

        if (tree.hasLeft()) {
            inOrderHelper(tree.getLeft(), list);
        }

        list.add(tree.getKey());
        System.out.println("New node added to list: " + tree.getKey());

        if (tree.hasRight()) {
            inOrderHelper(tree.getRight(), list);
        }

    }

}
