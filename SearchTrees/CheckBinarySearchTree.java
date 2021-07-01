import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CheckBinarySearchTree {


    /**
     * Computes whether the BinaryTree is a binary search tree.
     * @param tree
     *     the BinaryTree to check.
     * @return true iff the BinaryTree is a binary search tree, else false.
     * RECURSIVELY CHECK ALL SUBTREES
     * ALL KEYS IN LEFT SUBTREE MUST BE SMALLER
     * ALL KEYS IN RIGHT SUBTREE MUST BE BIGGER
     * NO DUPLICATES
     */
    public static boolean isTreeBST(BinaryTree tree) {
        return isTreeBSTHelper(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isTreeBSTHelper(BinaryTree tree, int lowerbound, int upperbound) {
        // base case
        if (tree == null) {
            return true;                // leaves are always true, but layers above should also be true!
        }
        // no duplicates: so =
        // duplicates must be next to each other, else the search tree property wouldn't hold anyways
        if (tree.getKey() <= lowerbound || tree.getKey() >= upperbound) return false;     // check root

        boolean leftvalid = isTreeBSTHelper(tree.getLeft(), lowerbound, tree.getKey());   // check left subtree

        boolean rightvalid = isTreeBSTHelper(tree.getRight(), tree.getKey(), upperbound);   // check right subtree

        return (leftvalid && rightvalid);                   // if both left and right fulfill, return true, else false
    }

    /**
     * THIS VERSION GIVES TIMEOUT ERROR IN SPEC TESTS, BC YOU FIRST CREATE A LIST (instead of checking tree directly)
     * Computes whether the BinaryTree is a binary search tree WITHOUT DUPLICATE VALUES. (keys)
     * A binary search tree cannot have duplicate keys, because put() always replaces existing keys!
     * @param tree
     *     the BinaryTree to check.
     * @return true iff the BinaryTree is a binary search tree, else false.
     * O(n) time! n = amount of nodes
     */
    public static boolean isTreeBST2(BinaryTree tree) {    // O(n) + O(n) = O(n)

        // in-order DFS traversal should give keys in order!  ---->  O(2^h) = O(2^logn) = O(n)
        List<Integer> inorderDFS = inOrder(tree);

        // Iteratively check list returned by in-order DFS     ---> O(n)
        // List has to be in ascending order + CANT contain duplicates
        // (actually, you don't even need hashset, since it will be false anyways if duplicates are not after each other!)
        HashSet<Integer> checklist = new HashSet<>();

        for (int i = 0; i < inorderDFS.size()-1; i++) {
            int current = inorderDFS.get(i);
            checklist.add(current);
            int next = inorderDFS.get(i+1);
            if (next <= current || checklist.contains(next)) {      // Hashset: O(1)
                return false;
            }
        }
        return true;
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
        return list;
    }

    private static void inOrderHelper (BinaryTree tree, List<Integer> list) {
        if (tree == null) return;

        if (tree.hasLeft()) {
            inOrderHelper(tree.getLeft(), list);
        }

        list.add(tree.getKey());

        if (tree.hasRight()) {
            inOrderHelper(tree.getRight(), list);
        }

    }
}
