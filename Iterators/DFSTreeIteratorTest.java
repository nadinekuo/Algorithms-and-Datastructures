import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class DFSTreeIteratorTest {

    @Test
    public void DFSTest() {
        PosBinaryTree<Integer> testtree = new PosBinaryTree<>();
        testtree.add(1, 2);
        testtree.add(2, 9);
        testtree.add(3, 5);
        testtree.add(4, 7);
        testtree.add(5, 8);
        DFSTreeIterator<Integer> iterator = new DFSTreeIterator<>(testtree);
        System.out.println(iterator.depthFirstSearch(testtree.getRoot()));
    }

    @Test
    public void addAllTest() {
        Tree tree2 = new Tree(9);
        Tree tree3 = new Tree(5);
        Tree tree4 = new Tree(7);
        Tree tree5 = new Tree(8);
        List<Tree> children = new ArrayList<>();
        children.add(tree2);
        children.add(tree3);
        Tree tree = new Tree(2, children);
        System.out.println(tree);
    }

}
