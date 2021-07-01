public class CheckAVLTree {

    /**
     * Computes whether the BinaryTree is an AVL tree WITHOUT DUPLICATES.
     * Leaves = null references --> height 0
     * LAST LAYER ---> height 1
     * CHECK BOTH SEARCH TREE PROPERTY + HEIGHT BALANCE PROPERTY (see prerequisites)
     * @param tree
     *     the BinaryTree to check.
     * @return true iff the BinaryTree is an AVL tree, else false.
     */
    public static boolean isTreeAVL(BinaryTree tree) {

        // check whether it's a SEARCH TREE: left keys < right keys
        // and contains NO DUPLICATES
        boolean isBinarySearchTree = isTreeBSTHelper(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);

        // check whether it's balanced
        boolean isBalanced = isTreeBalanced(tree);

        return (isBinarySearchTree && isBalanced);
    }

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
     * This method checks whether the given tree has the height-balance property.
     * FOR EVERY INTERNAL NODE n, the heights of the children MAY DIFFER BY AT MOST 1!
     * @param tree
     *     the tree to check.
     * @return true iff the tree has the height-balance property, false otherwise.
     * NULL REFERENCES: h = 0
     * LEAVES: h = 1
     * RECURSIVELY CHECK LEFT AND RIGHT SUBTREE
     */
    public static boolean isTreeBalanced(BinaryTree tree) {
        // base case
        if (tree == null) return true;
        // false if height differs by 2
        if (Math.abs(treeHeight(tree.getLeft()) - treeHeight(tree.getRight())) > 1) return false;
        boolean leftvalid = isTreeBalanced(tree.getLeft());                // check left subtree
        boolean rightvalid = isTreeBalanced(tree.getRight());              // check right subtree
        return (leftvalid && rightvalid);
    }


    /** Tree height is max node depth.
     * IF IT'S A LEAF, HEIGHT IS 1. (not 0!)
     * IF IT'S A NULL REFERENCE, HEIGHT IS 0. (otherwise the balance factor computation would not be correct..)
     * @param tree - subtree to calculate height of
     * @return
     */
    public static int treeHeight(BinaryTree tree) {
        // base cases
        if (tree == null) return 0;                             // null references: h = 0
        if (!tree.hasLeft() && !tree.hasRight()) return 1;      // leaves (last layer): h = 1

        int max = 0;
        int leftHeight = 1 + treeHeight(tree.getLeft());
        if (leftHeight > max) {
            max = leftHeight;
        }
        int rightHeight = 1 + treeHeight(tree.getRight());
        if (rightHeight > max) {
            max = rightHeight;
        }
        return max;
    }

}
