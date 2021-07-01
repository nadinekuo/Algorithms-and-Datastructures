import java.util.LinkedList;
import java.util.*;
import java.util.Queue;

public class CousinUncleMWST {



    /**
     * return NEAREST LEFT COUSIN (child of nearest left uncle/parent's sibling) OF MWSTNode node in this tree.
     * FIND COUSIN VIA UNCLE! (parent's siblings)
     * Return null if no such node can be found.
     *    * VISIT ONLY THE MINIMUM NO. OF NODES NECESSARY.
     *
     */
    public static MWSTNode getCousin(MultiWaySearchTree tree, MWSTNode node) {
        if(tree == null || node == null) {
            return null;
        }

        MWSTNode parent = node.getParent();

        List<MWSTNode> uncles = getSiblings(tree, parent);
        if(uncles == null) {
            return null;        //  parent is null (this is root) OR has no siblings (parent is root)
        }

        // START AT NEAREST LEFT UNCLE: loop to left until uncle with non-null child found --> cousin
        for(int i = uncles.indexOf(parent) - 1; i >= 0; i--) {
            MWSTNode uncle = uncles.get(i);
            if(uncle != null) {
                List<MWSTNode> cousins = uncle.getChildren(); // if no children, the LinkedList is: [null, null, null...]
                // Start at most right cousin! (nearest)
                for (int j = cousins.size()-1; j >= 0; j--) {
                    MWSTNode cousin = cousins.get(j);
                    if(cousin != null) {
                        System.out.println("Nearest left cousin of " + node + " found: " + cousin);
                        return cousin;
                    }
                }
                // THIS WOULD RETURN THE FARTHEST LEFT COUSIN:
//                for(MWSTNode cousin : cousins) {
//                    if(cousin != null) {
//                        System.out.println("Nearest left cousin of " + node + " found: " + cousin);
//                        return cousin;
//                    }
//                }
            }
        }
        // NEAREST RIGHT COUSIN: for(int i = uncles.indexOf(parent) + 1; i < uncles.size(); i++) {
        return null;
    }

    // HELPER: RETURNS ALL SIBLINGS OF THIS NODE, including this node. (ALL CHILDREN OF COMMON PARENT)
    private static List<MWSTNode> getSiblings(MultiWaySearchTree tree, MWSTNode node) {
        if(tree == null || node == null) {
            return null;
        }
        MWSTNode parent = node.getParent();
        if(parent == null) {                // root has no siblings
            return null;
        }
        System.out.println("All siblings of " + node.getKeys() + ": " + parent.getChildren().toString());
        return parent.getChildren();
    }

    /**
     * Return FARTHEST RIGHT UNCLE of MWSTNode node.
     * Return null if no such node can be found.
     *    * VISIT ONLY THE MINIMUM NO. OF NODES NECESSARY.
     */
    public static MWSTNode getUncle(MultiWaySearchTree tree, MWSTNode node) {
        if(tree == null || node == null) {
            return null;
        }

        MWSTNode parent = node.getParent();

        List<MWSTNode> uncles = getSiblings(tree, parent);
        if(uncles == null) {        // parent has no siblings --> root
            return null;
        }
// START AT FARTHEST RIGHT UNCLE: loop left until non-null uncle found
        for(int i = uncles.size()-1; i > uncles.indexOf(parent); i--) {
            MWSTNode uncle = uncles.get(i);
            if(uncle != null) {
                System.out.println("Farthest right non-null uncle of " + node.getKeys() + " found: " + uncle.getKeys());
                return uncle;
            }
        }
        // NEAREST LEFT UNCLE:  for(int i = uncles.indexOf(parent) - 1; i >= 0; i--) {
        return null;
    }

    /**
     * Return TRUE iff the key can be found within the first 3 layers of the tree
     * VISIT ONLY THE MINIMUM NO. OF NODES NECESSARY.
     */
    public static boolean restrictedSearch(MultiWaySearchTree tree, int key) {
        if(tree == null) {
            return false;
        }
        return restrictedSearchHelper(tree.getRoot(), key, 0);
    }


    // RECURSIVE HELPER METHOD: looks for key in 3 layers only (levels 0, 1, 2).
    private static boolean restrictedSearchHelper(MWSTNode node, int key, int level) {
        if(node == null || level == 3) {    // level == 3 is the 4th layer! So key not found.
            return false;
        }

        if(node.getKeys().contains(key)) {
            System.out.println("Key " + key + " found in " + node +  ", level: " + level);
            return true;
        }

        for(MWSTNode child : node.getChildren()) {
            if(restrictedSearchHelper(child, key, level+1)) {       // if 1 child (in next layer) contains key, it's  true
                return true;
            }
        }

        return false;
    }


}
