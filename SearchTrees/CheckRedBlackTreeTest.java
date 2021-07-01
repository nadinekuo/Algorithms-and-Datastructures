import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckRedBlackTreeTest {


    @Test
    public void testEqualDepthProperty() {
        RedBlackBinaryTree tree = new RedBlackBinaryTree(42, false);
        RedBlackBinaryTree subtree1 = new RedBlackBinaryTree(27, false);
        RedBlackBinaryTree subtree2 = new RedBlackBinaryTree(53, false);
        subtree1.setLeft(new RedBlackBinaryTree(23, true));
        subtree1.setRight(new RedBlackBinaryTree(36, true));
        subtree2.setLeft(new RedBlackBinaryTree(48, true));
        subtree2.setRight(new RedBlackBinaryTree(57, true));
        tree.setLeft(subtree1);
        tree.setRight(subtree2);
        assertTrue(CheckRedBlackTree.checkDepthProperty(tree));
//        assertTrue(CheckRedBlackTree.isRedBlackTree(tree));
//        subtree1.setRed(true);
//        assertFalse(CheckRedBlackTree.checkDepthProperty(tree));
    }


    @Test
    public void testUnequalDepthProperty() {
        RedBlackBinaryTree tree = new RedBlackBinaryTree(42, false);
        RedBlackBinaryTree subtree1 = new RedBlackBinaryTree(27, false);
        RedBlackBinaryTree subtree2 = new RedBlackBinaryTree(53, false);
        subtree1.setLeft(new RedBlackBinaryTree(23, true));
        subtree1.setRight(new RedBlackBinaryTree(36, true));
        subtree2.setLeft(new RedBlackBinaryTree(48, true));
        subtree2.setRight(new RedBlackBinaryTree(57, false));
        tree.setLeft(subtree1);
        tree.setRight(subtree2);
        assertFalse(CheckRedBlackTree.checkDepthProperty(tree));
    }



    @Test
    public void testExample() {
        RedBlackBinaryTree tree = new RedBlackBinaryTree(4, false);
        assertTrue(CheckRedBlackTree.isRedBlackTree(tree));
        tree.setLeft(new RedBlackBinaryTree(2, false));
        tree.setRight(new RedBlackBinaryTree(6, false));
        assertTrue(CheckRedBlackTree.isRedBlackTree(tree));
        tree.getLeft().setLeft(new RedBlackBinaryTree(1, false));
        tree.setRight(null);
        assertFalse(CheckRedBlackTree.isRedBlackTree(tree));           // left has black depth 3, right 1.
    }



}