import java.util.*;
import java.util.Queue;

public class CountEvenChildren {


    /**
     * Counts the number of nodes with an EVEN number of children. 0, 2, 4, 6...
     * @param tree - NON-BINARY tree
     *     The tree to count nodes with an even number of children in.
     * @return the number of nodes with an even number of children, or 0 if tree is null.
     * PERFORM BFS --> GO OVER THE LIST.
     * if no children (leaf)          --> count++
     * if no. of children % 2 == 0       --> count++
     */
    public static int countNodesEvenChildren(Tree tree) {
        if (tree == null) return 0;

        List<Tree> bfs = bfs(tree);     // ALL (sub)trees in the tree

        int count = 0;
        for (Tree t : bfs) {
            if (t.getChildren().size() % 2 == 0) {      // 0, 2, 4, 6, 8... children
                count++;
            }
        }
        return count;
    }


    /**
     * NON-BINARY TREE VERSION
     * BFS: layer 1, layer 2, ...
     * Traverses the tree in a breadth first search order. The result will be a list containing the key of each node in the correct order.
     * @param tree - the tree that will be traversed
     * @return list containing the keys of each node in the correct order
     */
    public static List<Tree> bfs(Tree tree) {  // a Tree here is just the "current Node", storing 1 key
        Queue<Tree> queue = new LinkedList<>();
        List<Tree> res = new ArrayList<>();

        if (tree == null) {
            return res;
        }

        queue.add(tree);    // LinkedList doesnt have enqueue() (addLast)
        while (!queue.isEmpty()) {
            Tree t = queue.poll();  // dequeue front of queue (removeFirst)
            res.add(t);
            if (t.getChildren() != null) {
                queue.addAll(t.getChildren());  // enqueue all, which will be visited afterwards
            }
        }
        return res;
    }

}
