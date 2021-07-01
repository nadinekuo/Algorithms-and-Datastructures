public class CheckRedBlackTree {


    /**
     * Checks whether the given BinaryTree is a Red Black Tree.
     * @param tree BinaryTree to check.
     * @return True if the given tree is a Red Black Tree, false otherwise.
     * 1. BINARY SEARCH TREE -----> NO DUPLICATES
     * 2. Root property: root is black
     * 3. Red property: The children of a red node are black. --> RED NODE MUST HAVE BLACK PARENT (NO DOUBLE REDS)
     * 4. Depth property: All leaves have the same black depth. --> NO "BLACK DEFICITS/DOUBLE BLACKS"
     *      * ( ----- 5. External property: Every leaf is black. (null-references) ------)
     */
    public static boolean isRedBlackTree(RedBlackBinaryTree tree) {

        if (tree == null) return false;
        // check root property: root CAN'T be red.
        if (tree.isRed()) return false;

        // check if it's a Binary Search Tree (left keys < right keys) WITHOUT DUPLICATES
        boolean isBinarySearchTree = isTreeBSTHelper(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (!isBinarySearchTree) return false;
        if (!checkRedProperty(tree)) return false;          // check red property
        if (!checkDepthProperty(tree)) return false;          // check depth property

        // ASSUME EXTERNAL PROPERTY ALWAYS HOLDS (you can't access null...)
        return true;
    }



    /**
     * Checks whether the given BinaryTree has the Red Property
     * @param tree BinaryTree to check.
     * @return boolean
     * 4. Red property: The children of a red node are black. --> RED NODE MUST HAVE BLACK PARENT (no double reds)
     * RECURSIVELY CHECK IF ALL RED NODES HAVE BLACK CHILDREN
     * Root must be black (checked earlier)
     * Can I assume the nulls are black?
     */
    public static boolean checkRedProperty(RedBlackBinaryTree tree) {
        if (tree == null) return true;
        if (!tree.hasLeft() && !tree.hasRight()) return true;       // if last layer node, it can be black/red

        // now we know it either has left or right (or both)
        if (tree.isRed() && tree.hasLeft()) {                       // if node is red, check left and right
            if (tree.getLeft().isRed()) return false;               // (if node is black, doesn't matter FOR THIS LAYER)
        }
        if (tree.isRed() && tree.hasRight()) {
            if (tree.getRight().isRed()) return false;
        }

        // recursively check left and right subtrees
        boolean leftvalid = checkRedProperty(tree.getLeft());
        boolean rightvalid = checkRedProperty(tree.getRight());
        return (leftvalid && rightvalid);
    }


    /**
     * Checks whether the given BinaryTree has the Red Property
     * @param tree BinaryTree to check.
     * @return boolean
     * 5. Depth property: All leaves have the same black depth. --> NO BLACK DEFICITS/DOUBLE BLACKS
     *  ALL SUBTREES MUST HAVE SAME BLACK DEPTH!
     */
    public static boolean checkDepthProperty(RedBlackBinaryTree tree) {

        if (tree == null) return true;
        if (!tree.hasLeft() && !tree.hasRight()) return true;       // can be any color if last layer

        // check if all nulls/leaves have the same black depth: ALL PATHS to null should have the same no. of blacks

        int blackDepth = calculateBlackDepth(tree, 0);  // start with black depth = 0
        if (blackDepth == -1) return false;
        return true;
    }

    /** CALCULATES BLACK DEPTH OF SUBTREE FROM TOP TO BOTTOM (or -1 if property doesn't hold)
     * (or recursively, from bottom to top: each time we encounter a black node, we do +1)
     * @param tree - subtree
     * @param currentBlacks - black depth from the subtree root
     * @return black depth or -1 if doesn't hold!
     *      *  ALL SUBTREES MUST HAVE SAME BLACK DEPTH!
     *      (you can leave out the parameter currentBlacks...)
     */
    public static int calculateBlackDepth(RedBlackBinaryTree tree, int currentBlacks) {

        if (tree == null) return currentBlacks;         // leaves have black depth 0

        int leftBlackDepth = calculateBlackDepth(tree.getLeft(), currentBlacks);
        int rightBlackDepth = calculateBlackDepth(tree.getRight(), currentBlacks);

        // EITHER: BOTH SUBTREES RETURN -1 (depth property doesn't hold for both trees)
        if (leftBlackDepth == -1) return -1;        // rightBlackDepth must be -1 too. (line 95)
//        if (rightBlackDepth == -1) return -1;

        // OR: 1 OF THE 2 SUBTREES RETURN -1 (thus black depth must be unequal, since one is -1)
        if (leftBlackDepth != rightBlackDepth) {
            System.out.println("Left and right of node " + tree.getValue() + " have unequal black depths! \nLeft: " + leftBlackDepth + "\nRight: " + rightBlackDepth);
            return -1;
        }
        // add 1 to black depth (recursively) if root itself is black
        if (tree.isBlack()) {
            System.out.println("Black node count+1: " + tree.getValue());
            return leftBlackDepth + 1;          // now we know leftBlackDepth and rightBlackDepth must be equal
        } else {
            System.out.println("Red node: " + tree.getValue());
            return leftBlackDepth;
        }
    }


    /**
     * Computes whether the BinaryTree is a binary search tree.
     * @param tree
     *     the BinaryTree to check.
     * @return true iff the BinaryTree is a binary search tree, else false.
     * RECURSIVELY CHECK ALL SUBTREES
     * ALL KEYS IN LEFT SUBTREE MUST BE < SMALLER (this method checks VALUES)
     * ALL KEYS IN RIGHT SUBTREE MUST BE > BIGGER
     * NO DUPLICATES: not >= or <=, so check using =
     */
    public static boolean isTreeBSTHelper(RedBlackBinaryTree tree, int lowerbound, int upperbound) {
        // base case
        if (tree == null) {
            return true;                // leaves are always true, but layers above should also be true!
        }
        // no duplicates: so check using =
        // duplicates must be next to each other, or else the search tree property wouldn't hold anyways
        if (tree.getValue() <= lowerbound || tree.getValue() >= upperbound) return false;     // check root

        boolean leftvalid = isTreeBSTHelper(tree.getLeft(), lowerbound, tree.getValue());   // check left subtree

        boolean rightvalid = isTreeBSTHelper(tree.getRight(), tree.getValue(), upperbound);   // check right subtree

        return (leftvalid && rightvalid);                   // if both left and right fulfill, return true, else false
    }

}
