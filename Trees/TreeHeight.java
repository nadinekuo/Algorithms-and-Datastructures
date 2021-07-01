public class TreeHeight {


    /** Tree height is max node depth.
     * BINARY SEARCH (!) TREE
     * IF IT'S A LEAF, HEIGHT IS 1. (not 0!)
     * IF IT'S A NULL REFERENCE, HEIGHT IS 0. (otherwise the balance factor computation would not be correct..)
     * @param tree - subtree to calculate height of
     * @return
     */
    public static int treeHeight(BinaryTree tree) {

        if (tree == null) return 0;
        if (!tree.hasLeft() && !tree.hasRight()) return 1;

        int max = 1 + Math.max(treeHeight(tree.getLeft()), treeHeight(tree.getRight()));

//        int max = 0;
//        int leftHeight = 1 + treeHeight(tree.getLeft());
//        if (leftHeight > max) {
//            max = leftHeight;
//        }
//        int rightHeight = 1 + treeHeight(tree.getRight());
//        if (rightHeight > max) {
//            max = rightHeight;
//        }

        return max;
    }

    /** Tree height is max node depth.
     * NORMAL BINARY TREE
     * IF IT'S A LEAF, HEIGHT IS 0. (not 1 like with binary search trees!)
     * IF IT'S A NULL REFERENCE, HEIGHT IS 0 TOO.
     * @param tree - subtree to calculate height of
     * @return
     */
    public static int treeHeight2(BinaryTree tree) {

        if (tree == null) return 0;
        if (!tree.hasLeft() && !tree.hasRight()) return 0;

        int max = 1 + Math.max(treeHeight(tree.getLeft()), treeHeight(tree.getRight()));

        return max;
    }

    /** Tree height is max node depth.
     * LINKED TREE (not binary)
     * IF IT'S A LEAF, HEIGHT IS 0. If it's null, height is 0 too.
     * @param t - subtree to calculate height of
     * @return
     */
    private int treeHeight(Tree t) {
        if (t == null || t.getChildren().isEmpty())
            return 0;
        int max = 0;
        for (Tree subtree : t.getChildren()) {
            int cHeight = 1 + treeHeight(subtree);
            if (cHeight > max) {
                max = cHeight;
            }
        }
        return max;
    }


    /**
     * Min depth int.
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     * @param root - Binary Tree
     * @return the min depth - LEAF HEIGHT: 1, NULL REFERENCE HEIGHT: 0
     */
    public int minDepth(BinaryTree root) {
        // empty
        if (root == null) return 0;

        // no child --> leaf
        if (root.getLeft() == null && root.getRight() == null) return 1;

        // one child: we want the other non-null path
        if (root.getLeft() == null) return minDepth(root.getRight()) + 1;
        if (root.getRight() == null) return minDepth(root.getLeft()) + 1;

        // two children
        return Math.min(minDepth(root.getLeft()), minDepth(root.getRight())) + 1;
    }

}
