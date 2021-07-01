import java.util.LinkedList;
import java.util.Queue;

public class TreeCompleteness {

    /** FOR ALL LEVELS EXCEPT THE LAST ONE: check whether node has left AND right child.
     * LAST LEVEL REACHED? check whether other nodes DONT have children.
     * Computes whether the BinaryTree is complete. AT MOST 2 CHILDREN, OR NULL if no children.
     * @param tree
     *     the BinaryTree to check.
     * @return true iff the BinaryTree is complete, else false.
     * BREADTH-FIRST: QUEUE
     */
    public static boolean isTreeComplete(BinaryTree tree) {

        if ((tree == null) || (!tree.hasLeft() && !tree.hasRight())) {
            return true;
        }

        Queue<BinaryTree> breadthfirst = new LinkedList<>();
        breadthfirst.add(tree);     // enqueue root
        boolean lastlevel = false;

        while (!breadthfirst.isEmpty()) {

            BinaryTree current = breadthfirst.poll();

            if (!current.hasLeft() && current.hasRight()) {
                return false;
            }

            if (current.hasLeft()) {
                breadthfirst.add(current.getLeft());        // enqueue left child
            }
            if (current.hasRight()) {
                breadthfirst.add(current.getRight());   // enqueue right child
            }

            if (lastlevel) {
                if (current.hasLeft() || current.hasRight()) {
                    return false;
                }
            }
            if (!current.hasRight()) {              // SET THIS TO TRUE AT THE END, cause in the SAME loop the current is still allowed to have children on the left!
                lastlevel = true;                   // child is null, so ur about to reach last level
            }
        }
        return true;

    }
}
