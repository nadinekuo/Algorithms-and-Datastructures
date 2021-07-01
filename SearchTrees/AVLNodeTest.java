import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AVLNodeTest {


    @Test
    void nullTest() {
        BinarySearchTree test = new BinarySearchTree(1, 25);
        System.out.println(test.getLeft());
        AVLTree tree1 = new AVLTree();
        tree1.put(1, "Node1");
        tree1.put(2, "Node2");
        System.out.println(tree1);
    }

    @Test
    public void testBase() {
        BinarySearchTree tree = new BinarySearchTree(1, 42);
        assertEquals(1, HigherEntry.higherEntry(tree, 0).key);
        assertNull(HigherEntry.higherEntry(tree, 1));
        assertNull(HigherEntry.higherEntry(tree, 2));
        assertNull(HigherEntry.higherEntry(null, 42));
    }

    @Test
    public void testSmall() {
        BinarySearchTree tree = new BinarySearchTree(42, 42,
                new BinarySearchTree(21, 21, new BinarySearchTree(10, 10), new BinarySearchTree(30, 30)),
                new BinarySearchTree(84, 84, new BinarySearchTree(60, 60), new BinarySearchTree(100, 100)));
         assertEquals(10, HigherEntry.higherEntry(tree, 2).key);
        assertEquals(60, HigherEntry.higherEntry(tree, 42).key);
         assertEquals(100, HigherEntry.higherEntry(tree, 88).key);
        assertEquals(30, HigherEntry.higherEntry(tree, 21).key);
    }

    // toString method performs BFS!
    @Test
    void AVLTreeThreeLevels() {
        AVLTree test = new AVLTree();
        test.put(12, "Hello");
        test.put(4, "my");
        test.put(14, "name");
        test.put(0, "is");
        test.put(6, "Nadine");
        System.out.println(test);
        assertEquals("Hello", test.get(12));
    }

    @Test
    public void testGet() {
        AVLTree bst = new AVLTree();
        bst.put(5,"5");
        bst.put(3,"3");
        bst.put(7,"7");
        assertEquals("3",bst.get(3));
        assertEquals("7",bst.get(7));
    }

    @Test
    public void testTwoLevels() {
        AVLTree bst = new AVLTree();
        bst.put(5,"5");
        bst.put(7,"7");
        bst.put(3,"3");
        assertEquals("3",bst.getRoot().getLeft().getValue());
        assertEquals("7",bst.getRoot().getRight().getValue());
    }

}