import java.util.LinkedList;
import java.util.List;

public class CopyTree {

    /**
     * Creates a HARD COPY of the n-ary tree.
     * @param t - the tree to create a copy of
     * @return a NEW TREE in which every node contains the values of the nodes at the corresponding positions in t
     * NEW COPY OF ALL CHILDREN (SUBTREES)
     * RECURSION
     */
    public static Tree copy(Tree t) {
        if (t == null) {
            return null;
        }

        if (t.getChildren() == null || t.getChildren().isEmpty()) {    // base case: leaf
            return new Tree(t.getValue());
        }

        List<Tree> childcopies = new LinkedList<>();
        for (Tree subtree : t.getChildren()) {
            childcopies.add(copy(subtree));
        }
        Tree result = new Tree(t.getValue(), childcopies);
        return result;
    }

}
