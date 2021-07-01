
public class InvertTree {


    /**
     * Invert tree binary tree. ---> Mirror the tree
     * Left becomes right, right becomes left.
     *
     *       4
     *    /   \
     *   2     7         <--- input
     *  / \   / \
     * 1   3 6   9
     *
     *      4
     *    /   \
     *   7     2        <--- output
     *  / \   / \
     * 9   6 3   1
     *
     * @param root the root
     * @return the binary tree
     */
    public BinaryTree invertTree(BinaryTree root) {

        if (root == null) return null;
        if (root.getLeft() == null && root.getRight() == null) return root;

        BinaryTree result = new BinaryTree(root.getKey());
        result.setLeft(invertTree(root.getRight()));          // mirror it
        result.setRight(invertTree(root.getLeft()));
        return result;
    }



    public BinaryTree invertTree2(BinaryTree root) {
        if (root == null) {
            return null;
        }
        BinaryTree right = invertTree(root.getRight());
        BinaryTree left = invertTree(root.getLeft());
        root.setLeft(right);
        root.setRight(left);
        return root;
    }


}
