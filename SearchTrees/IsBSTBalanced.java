public class IsBSTBalanced {

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
        if (!tree.hasLeft() && !tree.hasRight()) return 1;      // leaves: h = 1

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
