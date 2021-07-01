import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTreeTraversal {

    /**
     * NON-BINARY TREE VERSION
     * BFS: layer 1, layer 2, ...
     * Traverses the tree in a breadth first search order. The result will be a list containing the key of each node in the correct order.
     * @param tree - the tree that will be traversed
     * @return list containing the keys of each node in the correct order
     */
    public static List<Integer> bfs(Tree tree) {  // a Tree here is just the "current Node", storing 1 key
        Queue<Tree> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        if (tree == null) {
            return res;
        }

        queue.add(tree);    // LinkedList doesnt have enqueue() (addLast)
        while (!queue.isEmpty()) {
            Tree t = queue.poll();  // dequeue front of queue (removeFirst)
            res.add(t.getValue());
            if (t.getChildren() != null) {
                queue.addAll(t.getChildren());  // enqueue all, which will be visited afterwards
            }
        }

        return res;
    }

    /**
     * BINARY TREE VERSION
     * BFS: layer 1, layer 2, ...
     * Traverses the tree in a breadth first search order. The result will be a list containing the key of each node in the correct order.
     * @param tree - the tree that will be traversed
     * @return list containing the keys of each node in the correct order
     */
    public static List<Entry> bfs(BinarySearchTree tree) {  // a Tree here is just the "current Node", storing 1 key

        Queue<BinarySearchTree> queue = new LinkedList<>();
        List<Entry> res = new ArrayList<>();

        if (tree == null) {
            return res;
        }

        queue.add(tree);    // LinkedList doesnt have enqueue() (addLast)
        while (!queue.isEmpty()) {
            BinarySearchTree t = queue.poll();  // dequeue front of queue (removeFirst)
            res.add(t.getEntry());

            if (t.hasLeft()) {
                queue.add(t.getLeft());
            }
            if (t.hasRight()) {
                queue.add(t.getRight());
            }
        }
        return res;
    }


    /** BFS
     * Given a binary tree, write a method to find and return the node with data = the input data.
     * Do not use recursion.
     *
     * @param root the root
     * @param val  the val
     * @return the binary tree
     */
    public BinaryTree findNode(BinaryTree root, int val) {

        if (root == null) return null;

        // BFS traversal
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTree current = queue.poll();
            if (current.getKey() == val) {
                return current;
            }
            if (current.getLeft() != null) queue.add(current.getLeft());
            if (current.getRight() != null) queue.add(current.getRight());
        }
        return null;


    }

}
