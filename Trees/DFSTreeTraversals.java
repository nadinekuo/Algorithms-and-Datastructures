import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class DFSTreeTraversals {



    /** NON-RECURSIVE DFS PRE-ORDER
     * Using Stack.
     * First push right child, then left!
     */
    public ArrayList<Integer> preorderItr(BinaryTree root) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<BinaryTree> stack = new Stack<BinaryTree>();

        if (root == null) return result;

        stack.add(root);
        while (!stack.isEmpty()) {
            BinaryTree current = stack.pop();
            result.add(current.getKey());

            if (current.hasRight()) {
                stack.add(current.getRight());
            }
            if (current.hasLeft()) {
                stack.add(current.getLeft());
            }

        }
        return result;

    }

    /**
     * RECURSIVE
     * More efficient method using a helper. O(n)!!!
     * Previous version: addAll() is O(k) to add all k keys of Subtrees of left
     * Here: only 1 insertion into the list at each node!!!
     * You create a new List here and pass it to postHelper, which processes it.
     * You DON'T wanna create a new list every recursive call!!!
     *
     * @param tree the tree
     * @return list
     */
    public static List<Integer> postOrder2(BinaryTree tree) {
        List<Integer> result = new ArrayList<>();
        postHelper(tree, result);
        return result;
    }


    // helper method processes the given list; no return value!
    private static void postHelper(BinaryTree tree, List<Integer> list) {
        if (tree == null) {         // if no child, getLeft() and getRight() return null
            return;
        }

        if (tree.hasLeft()) {
            postHelper(tree.getLeft(), list);
        }
        if (tree.hasRight()) {
            postHelper(tree.getRight(), list);
        }
        list.add(tree.getKey());                    // add leaf key to list first (no more children)
    }

    /**
     * RECURSIVE
     * addAll takes O(n) time: per node O(n)
     * WHOLE METHOD EXECUTION: O(n^2) in worst-case!!!! But can be bounded to O(n log n)
     * Each method call, you create a NEW LIST! (so no duplicates added, but elements are processed more than 1x!)
     * @param tree The input BinaryTree.
     * @return A LIST OF ALL KEYS in the tree, in POST-ORDER. --> left, right, parent The key is the integer element
     */
    public static List<Integer> postOrder1(BinaryTree tree) {
        List<Integer> result = new ArrayList<>();

        if (tree == null) { // base case
            return result;
        }
        if (tree.hasLeft()) {
            result.addAll(postOrder1(tree.getLeft()));
        }
        if (tree.hasRight()) {
            result.addAll(postOrder1(tree.getRight()));
        }

        result.add(tree.getKey());                 // key of leaf added first (has no more right/left)
        return result;

    }

    public static void postOrderGeneralTrees(Tree tree, List<Integer> list) {

        if (tree == null) return;

        for (Tree t : tree.getChildren()) {
            postOrderGeneralTrees(t, list);
        }
        list.add(tree.getValue());
    }



    /**
     * Pre order DFS: parent, left, right
     * @param tree
     * @return the list which is processed by the helper
     */
    public static List<Integer> preOrder(BinaryTree tree) {
        List<Integer> list = new ArrayList<>();
        preOrderHelper(tree, list);         // processes the new list
        return list;
    }

    private static void preOrderHelper(BinaryTree tree, List<Integer> list) {
        if (tree == null) {
            return;
        }
        list.add(tree.getKey());
        if (tree.hasLeft()) {
            preOrderHelper(tree.getLeft(), list); // you don't ADD to the list, but process it.
        }
        if (tree.hasRight()) {
            preOrderHelper(tree.getRight(), list);
        }
    }

    public static void preOrderGeneralTrees(Tree tree, List<Integer> list) {

        if (tree == null) return;
        list.add(tree.getValue());

        for (Tree t : tree.getChildren()) {
            preOrderGeneralTrees(t, list);
        }

    }


    /**
     * In order DFS: left, parent, right
     *
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
