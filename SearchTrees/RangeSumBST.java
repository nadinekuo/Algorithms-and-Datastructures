import java.util.Stack;

public class RangeSumBST {

    /** RECURSIVE
     * Range sum - Given the root node of a binary search tree,
     *            return the sum of values of all nodes with a value in the range [low, high].
     * @param root the root
     * @param low  the lower bound of the range
     * @param high the upper bound of the range
     * @return the int
     * TIME: O(n)
     */
    public int rangeSumBST(BSTNode root, int low, int high) {

        return sumHelper(root, low, high, 0);

    }

    public int sumHelper(BSTNode root, int low, int high, int sum) {

        if (root == null) return 0;

        if (root.key > high) {
            sum += rangeSumBST(root.getLeft(), low, high);
        } else if (root.key < low) {
            sum += rangeSumBST(root.getRight(), low, high);
        } else {
            sum += root.key + rangeSumBST(root.getLeft(), low, high) + rangeSumBST(root.getRight(), low, high);
        }

        return sum;
    }


    /** ITERATIVE USING STACK. (DFS)
     * Range sum -
     * @param root the root
     * @param L  the lower bound of the range
     * @param R the upper bound of the range
     * @return the int
     * TIME: O(n)
     */
    public int rangeSumBSTStack(BSTNode root, int L, int R) {
        int ans = 0;
        Stack<BSTNode> stack = new Stack();
        stack.push(root);

        while (!stack.isEmpty()) {
            BSTNode node = stack.pop();

            if (node != null) {
                if (L <= node.key && node.key <= R)
                    ans += node.key;
                if (L < node.key)
                    stack.push(node.getLeft());
                if (node.key < R)
                    stack.push(node.getRight());
            }
        }
        return ans;
    }
}

