public class countNodesAtLevel {

    /**
     * Counts the number of NON-NULL nodes in the tree at a CERTAIN LEVEL
     * @param tree
     *     The BINARY TREE to count nodes in. (NOT COMPLETE!)
     * @param level
     *     The specified level to count nodes in.
     * @return the number of nodes at that level, or 0 if tree is null.
     */
    public static int countNodesAtLevel(BinaryTree tree, int level) {
        return levelCountHelper(tree, 0, level);
    }

    public static int levelCountHelper(BinaryTree tree, int currentLevel, int desiredLevel) {

        // base cases
        if (tree == null) return 0;
        if (currentLevel == desiredLevel) return 1;

        if (tree.hasLeft() && tree.hasRight()) {
                        System.out.println("Tree " + tree.getKey() + " has left child: " + tree.getLeft().getKey() + " and right child: " + tree.getRight().getKey());
            int sum = levelCountHelper(tree.getLeft(), currentLevel+1, desiredLevel)
                            + levelCountHelper(tree.getRight(), currentLevel+1, desiredLevel);
                        System.out.println("Sum returned at recursion level " + currentLevel + ": " + sum);
            return sum;
        }
        else if (tree.hasLeft()) {
                    System.out.println("Tree" + tree.getKey() + " only has left child: " + tree.getLeft().getKey());
            return levelCountHelper(tree.getLeft(), currentLevel+1, desiredLevel);
        } else if(tree.hasRight()) {
                    System.out.println("Tree" + tree.getKey() + " only has right child: " + tree.getRight().getKey());
            return levelCountHelper(tree.getRight(), currentLevel+1, desiredLevel);
        } else {
            return 0;       // no nodes in desired level
        }
    }

}
