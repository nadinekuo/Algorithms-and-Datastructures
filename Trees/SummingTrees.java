import java.util.ArrayList;
import java.util.List;

public class SummingTrees {


    /**
     * Sums the values of the nodes of two n-ary trees. SAME SHAPE.
     * @param t1 - first tree to sum values for
     * @param t2 - second tree to sum values for
     * @return A NEW TREE in which every node contains the sum of the values of the nodes at the corresponding positions in t1 and t2
     */
    public static Tree sum(Tree t1, Tree t2) {

        if (t1 == null || t2 == null) {
            return null;
        }

        int added = t1.getValue() + t2.getValue();  // sum of all values (recursive call)

        if (t1.getChildren() == null) {
            return new Tree(added);             // base case: leaves, no children
        }

        List<Tree> childrensum = new ArrayList<>();   // Use arrayList, so you can access by index!
        for (int subtree = 0; subtree < t1.getChildren().size(); subtree++) {
            childrensum.add(sum(t1.getChildren().get(subtree), t2.getChildren().get(subtree))); // recursive call
        }
        return new Tree(added, childrensum);
    }

}
