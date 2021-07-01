public class BinTreeSearch {

    /**
     * Get method for Binary Search Tree: O(h)
     * O(log n) if balanced! (Thus AVL tree)
     * @param tree - the root node (Position/Entry) of the subtree in which we search for the given key.
     * @param key - the key given
     * @return the v - value of Entry (element at key)
     * IF UNSUCCESSFUL SEARCH, NULL RETURNED.
     */
    public static Entry binaryTreeSearch(BinarySearchTree tree, int key) {
        if (tree == null) return null;              // not found, we reached a null child ("leaf")

        if (key == tree.getKey()) {
            return tree.getEntry();
        }
        else if (key < tree.getKey()) {
            return binaryTreeSearch(tree.getLeft(), key);        // recursively search in left subtree
        }
        else return binaryTreeSearch(tree.getRight(), key);      // recursively search in right subtree
    }

//    /**
//     * Get method for Binary Search Tree: O(h)
//     * O(log n) if balanced! (Thus AVL tree)
//     * @param tree - the root node (Position/Entry) of the subtree in which we search for the given key.
//     * @param key - the key given
//     * @return the v - value of Entry (element at key)
//     * IF UNSUCCESSFUL SEARCH, FINAL NON-NULL Node Entry RETURNED --> IN THE BOOK THEY HAVE EXPLICIT "EMPTY NODES" WHICH ARE NULL REFERENCES.
//     * Only works for proper/full trees!! --> have 0 or 2 children. So if no left, then no right either! Must be leaf.
//     */
//    public static Entry binaryTreeSearch2(BinarySearchTree tree, int key) {
//
//        if (isExternal(tree)) return tree.getEntry();       // LAST "null" node where search stopped returned!
//
//        if (key == tree.getKey()) {
//            return tree.getEntry();
//        }
//        else if (key < tree.getKey()) {
//            return binaryTreeSearch(tree.getLeft(), key);        // recursively search in left subtree
//        }
//        else {
//            return binaryTreeSearch(tree.getRight(), key);      // recursively search in right subtree
//        }
//    }


    /** IN THE BOOK THEY HAVE EXPLICIT "EMPTY NODES" WHICH ARE NULL REFERENCES.
     * Is external? (Non-null leaf)
     * @param tree
     * @return boolean - true if it's a node in last layer (last non-null node)
     * EITHER
     */
    public static boolean isExternal(BinarySearchTree tree) {
        return (!tree.hasLeft() && !tree.hasRight());
    }

    /**
     * Is internal? (Non-null leaf)
     * @param tree
     * @return boolean - true if it's not a leaf (not in last layer)
     * EITHER
     */
    public static boolean isInternal(BinarySearchTree tree) {
        return (tree.hasLeft() || tree.hasRight());
    }


    /**
     * Tree max entry --> last entry with MAXIMUM/HIGHEST key
     * @param tree - Binary Search Tree
     *             O(n log n) if balanced, else O(h).
     * @return the RIGHTMOST Entry with max. key.
     */
    public static Entry treeMax(BinarySearchTree tree) {
        BinarySearchTree currentMax = tree;
        while (currentMax.getRight() != null) {
            currentMax = tree.getRight();
        }
        return currentMax.getEntry();
    }





}
