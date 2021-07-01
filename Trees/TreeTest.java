import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {


    @Test
    public void testSmall() {
        BinaryTree tree = new BinaryTree(0, new BinaryTree(1, new BinaryTree(3), new BinaryTree(4)), new BinaryTree(2, new BinaryTree(5), new BinaryTree(6)));
//        assertEquals(1, countNodesAtLevel.countNodesAtLevel(tree, 0));
//        assertEquals(2, countNodesAtLevel.countNodesAtLevel(tree, 1));
        assertEquals(4, countNodesAtLevel.countNodesAtLevel(tree, 2));
    }

    @Test
    public void testNull() {
        BinaryTree tree = null;
        assertEquals(0, countNodesAtLevel.countNodesAtLevel(tree, 0));
    }

    @Test
    public void testEmptyTree() {
        BinaryTree one = new BinaryTree(1);
        BinaryTree two = new BinaryTree(2);
        BinaryTree three = new BinaryTree(3);
        BinaryTree four = new BinaryTree(4, one, two);
        BinaryTree five = new BinaryTree(5, three, four);
        BinaryTree six = new BinaryTree(6);
        BinaryTree seven = new BinaryTree(7, five, six);
        System.out.println(IsBSTBalanced.treeHeight(seven));
        assertEquals(3, IsBSTBalanced.treeHeight(seven));
        assertTrue(IsBSTBalanced.isTreeBalanced(null));
    }

    @Test
    public void testOneLevel1() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(84), new BinaryTree(21));
        System.out.println(IsBSTBalanced.treeHeight(tree));
        assertTrue(IsBSTBalanced.isTreeBalanced(tree));
    }

    @Test
    public void testLinearTree() {
        assertFalse(IsBSTBalanced.isTreeBalanced(new BinaryTree(1, new BinaryTree(2, new BinaryTree(3), null), null)));
    }

    @Test
    public void testOneLevel() {
        BinaryTree empty = new BinaryTree(5);
        System.out.println(empty.getLeft());

        BinaryTree tree = new BinaryTree(42, new BinaryTree(21), new BinaryTree(84));
        assertEquals(Arrays.asList(84, 42, 21), FlattenBinarySearchTree.descendingOrder(tree));
    }

    @Test
    public void testOneLeftChild() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(21), null);
        assertEquals(Arrays.asList(42, 21), FlattenBinarySearchTree.descendingOrder(tree));
    }

    @Test
    public void testTree() {
        Tree one = new Tree(1);
        Tree two = new Tree(2);
        Tree three = new Tree(3);
        List<Tree> children = new ArrayList<>();
        children.add(one);
        children.add(two);
        children.add(three);
        Tree test = new Tree(5, children);
        System.out.println(test);
        System.out.println(CopyTree.copy(test));
    }

    @Test
    public void testExample1() {
        Tree t = new Tree(1, Arrays.asList(new Tree(2), new Tree(3), new Tree(4)));
        assertEquals(t, CopyTree.copy(t));  // Equals method is overridden
    }

    @Test
    public void testExample2() {
        Tree t1 = new Tree(1, Arrays.asList(new Tree(2), new Tree(3), new Tree(4)));
        Tree t2 = CopyTree.copy(t1);
        t1.getChildren().get(0).setValue(42);
        assertNotEquals(t1, t2);
    }

}