public class SpecialFourSevenTree {

    // Special Multiway Search Tree --> (4-7)-tree
    // Normal MST properties:
    //          1. EACH INTERNAL NODE HAS >= 2 CHILDREN
    //          2. A d-NODE HAS d CHILDREN AND d-1 KEYS.
    //          3. SEARCH TREE PROPERTY: k_i-1 < keys of ith child < k_i
    // (doesn't have to be balanced, only (2,4)-trees)

    // Each node is an array of int keys (int[] keys)
    // Each MWST has an array of child subtrees (MultiwaySearchTree[] children)

    /**
     * Checks whether the given MultiwaySearchTree satisfies all to condition
     * Our reference solution does not change this function in any way.
     * NO DUPLICATE KEYS
     * @param tree
     *     MultiwaySearchTree to check.
     * @return True iff the given tree satisfies all conditions. --> each internal node: 3-6 keys
     * 1. EVERY NODE HAS AT MOST 7 CHILDREN. (6 keys)
     * 2. EVERY NON-LEAF NODE (except root) HAS AT LEAST 4 CHILDREN. (3 keys)
     * 3. THE ROOT HAS AT LEAST 2 CHILDREN if it's not a leaf node.         --> root >= 1 key
     * 4. MULTIWAY SEARCH TREE WITH DISTINCT KEYS.
     *          - d-NODE WITH D CHILDREN MUST HAVE d-1 KEYS!
     *          - SEARCH TREE PROPERTY: k_i-1 < keys of ith child < k_i
     */
    public static boolean isSpecialTree(MultiwaySearchTree1 tree) {
        if (tree == null) return true;
        return satisfiesCondition1(tree) && satisfiesCondition2(tree) && satisfiesCondition3(tree) && satisfiesCondition4(tree);
    }

    /**
     * ----------- Helper -----------------
     * ALL child nodes in the children array need to be null to make it a leaf node
     * If 1 is NOT NULL, it's not a leaf.
     * (it could be that only some child subtrees are null)
     */
    public static boolean isLeafNode(MultiwaySearchTree1 tree) {
        boolean isLeaf = true;
        for (MultiwaySearchTree1 t : tree.getChildren()) {
            if (t != null) isLeaf = false;
        }
        return isLeaf;
    }

    /**
     * EVERY NODE HAS AT MOST 7 CHILDREN. (7-node, so 6 keys max (but keys are checked in condition 4))
     * Note that you should not change the method signature (name/parameters/return type).
     * If length > 7, it occupied more spaces than allowed. So sufficient to check array length.
     */
    public static boolean satisfiesCondition1(MultiwaySearchTree1 tree) {
    // base case: leaves
        if (tree == null) return true;
        if (isLeafNode(tree)) return true;      // for leaves, amount of children doesn't  matter (null)

        if (tree.getChildren().length > 7) return false;            // no non-null checks needed??3 (it could have length 9 but only 3 children)

        boolean childrenValid = true;
        // check children array size for each node recursively: if 1 child doesn't fulfill, it's false.
        for (MultiwaySearchTree1 t : tree.getChildren()) {
            if (!satisfiesCondition1(t)){
                childrenValid = false;
                System.out.println("Subtree " + t + " has more than 7 children!");
            }
        }
        return childrenValid;
    }

    /**
     * EVERY NON-LEAF NODE (except root) HAS AT LEAST 4 CHILDREN. (4-node, so 3 keys min.)
     * Note that you should not change the method signature (name/parameters/return type).
     * See RECURSIVE helper below.
     *      * YOU CAN ASSUME ALL SLOTS in children array are filled. (except for condition 2 & 3?)
     *      If you have < 4 children (non-nulls), false.
     *      If you have > 4 children but 3 keys and childrenarray.length = 7, this method returns true, but condition 4 gives false! (you must have d(keys) +1 children)
     * CALLS METHOD BELOW ON CHILDREN, SO IGNORES ROOT.
     */
    public static boolean satisfiesCondition2(MultiwaySearchTree1 tree) {

        if (tree == null) return true;
        if (isLeafNode(tree)) return true;       // if node is leaf, doesn't matter (its children are null)

        // check each child subtree (ignores root!): if 1 doesn't fulfill, it's false.
        boolean childValid = true;
        for (MultiwaySearchTree1 t : tree.getChildren()) {
            if(!checkAtLeastFourChildren(t)) childValid = false;
        }
        return childValid;

    }

    // All child subtrees (not root!) of the original tree are passed to this method.
    public static boolean checkAtLeastFourChildren(MultiwaySearchTree1 tree) {

        // base cases
        if (tree == null) return true;
        if (isLeafNode(tree)) return true;       // if node is leaf, doesn't matter (its children are null)

        boolean childValid = true;
        // the children array has fixed size, so loop to CHECK FOR NULLS! It could have length 5 but only 1 key!
        int childcount = 0;
        for (MultiwaySearchTree1 t : tree.getChildren()) {
            if (t != null) childcount++;
        }
        if (childcount < 4) childValid = false;

        // recursively check each child: if 1 doesn't fulfill, it's false.
        for (MultiwaySearchTree1 t : tree.getChildren()) {
            if (!checkAtLeastFourChildren(t)) childValid = false;
            System.out.println("Internal subtree " + t + " has less than 4 children!");
        }
        return childValid;
    }

    /**
     * THE ROOT HAS AT LEAST 2 CHILDREN if it's not a leaf node.
     * Note that you should not change the method signature (name/parameters/return type).
     * Not recursive. (only root checked)
     *      * YOU CAN ASSUME ALL SLOTS in children array are filled. (except for condition 2 & 3?)
     *         If root has < 2 children (non-nulls), false.
     *      *      If root has > 2 children but 3 keys and childrenarray.length = 7, this method returns true, but condition 4 gives false! (you must have keys+1 children)
     *
     */
    public static boolean satisfiesCondition3(MultiwaySearchTree1 tree) {

        if (tree == null) return true;
        if (isLeafNode(tree)) return true;            // if root is leaf, doesn't matter (it's children are null)

        // the array has fixed size, so loop to CHECK FOR NULLS! It could have length 5 but only 1 key!
        int childcount = 0;
        for (MultiwaySearchTree1 t : tree.getChildren()) {
            if (t != null) childcount++;
        }
        if (childcount < 2) return false;
        return true;
    }

    /**
     * MULTIWAY SEARCH TREE WITH DISTINCT KEYS.
     *              - d-NODE WITH D CHILDREN MUST HAVE d-1 KEYS!
     *               - SEARCH TREE PROPERTY: k_i-1 < keys of ith child < k_i
     * IF you have 3 keys, the children array must have length 3+1 =4 !!
     * Note that you should not change the method signature (name/parameters/return type).
     * Not recursive --> calls helper method below
     *      * YOU CAN ASSUME ALL SLOTS in children array are filled now. If not all filled, it's false (condition 2, 3)
     *      Internal nodes must have at least 4 keys now ---> this method checks if children array length = d+1. (line 176)
     */
    public static boolean satisfiesCondition4(MultiwaySearchTree1 tree) {
        // base case
        if (tree == null) return true;

        int amountkeys = tree.getKeys().length;         // assuming the keys array doesn't contain nulls (int)
        if (amountkeys == 0) return false;              // only 1 child (IF MST property of d+1 children holds! Else, false anyways)

        if(!isArraySorted(tree.getKeys())) return false;        // keys must be sorted!
        if(!isSearchTreeHelper(tree, Integer.MIN_VALUE, Integer.MAX_VALUE)) return false;
        return true;
    }

    /**
     * RECURSIVELY checks whether search tree property holds.
     * For each child subtree, you can just check the first and last key (sorted) If unsorted, it would ret false anyways!
     * IF you have 3 keys, the children array must have length 4!!
     * ONLY FOR FIRST AND LAST CHILD, you use Integer.MIN/MAX
     *      * YOU CAN ASSUME ALL SLOTS in children array are filled now. If not all filled, it's false by condition 2, 3
     * @param tree
     * @return
     */
    public static boolean isSearchTreeHelper(MultiwaySearchTree1 tree, int lowerbound, int upperbound) {

        // base cases
        if (tree == null) return true;
        if (!isArraySorted(tree.getKeys())) return false;            // keys must be sorted

        int amountkeys = tree.getKeys().length;
        if (tree.getChildren().length != amountkeys + 1) return false;          // amount of children must be keys + 1!

        boolean childValid = true;
        // you can just check the first and last key (sorted) If unsorted, it would ret false anyways!
        if (tree.getKeys()[0] <= lowerbound || tree.getKeys()[amountkeys-1] >= upperbound) return false;        // no duplicates between levels!

        // loop through every child subtree i, check boundaries (k_i-1 - k_i)
        for (int i = 0; i < tree.getChildren().length; i++) {

            MultiwaySearchTree1 currentChild = tree.getChildren()[i];

            int lower;
            if (i == 0) {           // FIRST CHILD
                lower = Integer.MIN_VALUE;
                System.out.println("First child of " + tree + " : " + currentChild);
            } else {
                lower = tree.getKeys()[i-1];            // k_i-1
            }
             int upper;
            if (i == tree.getChildren().length-1) {     // LAST CHILD
                upper = Integer.MAX_VALUE;
                System.out.println("Last child of " + tree + " : " + currentChild);
            } else {
                upper = tree.getKeys()[i];      // k_i
            }

            // recursively check ALL subtrees of ALL children (this method checks THEIR CHILDREN)
            if (!isSearchTreeHelper(currentChild, lower, upper)) childValid = false;
        }
        return childValid;
    }

    /** Helper: checks whether array (keys) is SORTED and contains NO DUPLICATES
     * It's  either unsorted, or sorted, but then duplicates would be next to each other!!
     * @param array - to check
     * @return - true/false
     */
    public static boolean isArraySorted(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            int current = array[i];
            int next = array[i+1];
            if (next <= current) {
                return false;
            }
        }
        return true;
    }

}
