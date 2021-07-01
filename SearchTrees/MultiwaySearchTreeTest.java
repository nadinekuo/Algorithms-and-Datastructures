import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

class MultiwaySearchTreeTest {


    @Test
    public void nadineNullTest() {
//        MultiwaySearchTree1[] nulltrees = new MultiwaySearchTree1[4];
//        System.out.println(nulltrees[0]);

        LinkedList<MWSTNode> test = new LinkedList<>(Collections.nCopies(2, null));
        System.out.println(test);
    }

    /*
     *        root: [24 42 80]
     *             /   |      \
     *            /    |       \
     *           /     |        \
     *          /      |         \
     *      [5 8 10]  [31 37]      [100]
     *        |  |       |  \
     *        |  |       |   \
     *        |  |       |    \
     *       [6] [9]    [33 36] [39]
     */
    @Test
    public void testMoreLeftCousins() {
        MWSTNode root = new MWSTNode(Arrays.asList(24, 42, 84), null, null);

//        System.out.println(root.getChildren());

        MWSTNode firstChild = new MWSTNode(Arrays.asList(5, 8, 10), root, null);
        MWSTNode secondChild = new MWSTNode(Arrays.asList(31, 37), root, null);
        MWSTNode fourthChild = new MWSTNode(Arrays.asList(100), root, null);

        MWSTNode firstGrandChild = new MWSTNode(Arrays.asList(6), firstChild, null);
        MWSTNode secondGrandChild = new MWSTNode(Arrays.asList(9), firstChild, null);
        firstChild.setChildren(new LinkedList<>(Arrays.asList(null, firstGrandChild, secondGrandChild, null)));
        MWSTNode thirdGrandChild = new MWSTNode(Arrays.asList(33, 36), secondChild, null);
        MWSTNode fourthGrandChild = new MWSTNode(Arrays.asList(39), secondChild, null);
        secondChild.setChildren(new LinkedList<>(Arrays.asList(null, thirdGrandChild, fourthGrandChild)));
        root.setChildren(new LinkedList<>(Arrays.asList(firstChild, secondChild, null, fourthChild)));

        MultiWaySearchTree tree = new MultiWaySearchTree(root);

        assertEquals(secondGrandChild, CousinUncleMWST.getCousin(tree, thirdGrandChild));   // [9] is nearest left cousin of [33, 36]
        assertEquals(secondGrandChild, CousinUncleMWST.getCousin(tree, fourthGrandChild)); // [9] is also nearest left cousin of [39]
    }



    /*
     *        root: [24 42 80]
     *             /   |      \
     *            /    |       \
     *           /     |        \
     *          /      |         \
     *      [5 8 10]  [31 37]      [100]
     *        |          |  \
     *        |          |   \
     *        |          |    \
     *       [6]      [33 36] [39]
     */
    @Test
    public void testExampleCousin() {
        MWSTNode root = new MWSTNode(Arrays.asList(24, 42, 84), null, null);

//        System.out.println(root.getChildren());

        MWSTNode firstChild = new MWSTNode(Arrays.asList(5, 8, 10), root, null);
        MWSTNode secondChild = new MWSTNode(Arrays.asList(31, 37), root, null);
        MWSTNode fourthChild = new MWSTNode(Arrays.asList(100), root, null);
        MWSTNode firstGrandChild = new MWSTNode(Arrays.asList(6), firstChild, null);
        firstChild.setChildren(new LinkedList<>(Arrays.asList(null, firstGrandChild, null, null)));
        MWSTNode secondGrandChild = new MWSTNode(Arrays.asList(33, 36), secondChild, null);
        MWSTNode thirdGrandChild = new MWSTNode(Arrays.asList(39), secondChild, null);
        secondChild.setChildren(new LinkedList<>(Arrays.asList(null, secondGrandChild, thirdGrandChild)));
        root.setChildren(new LinkedList<>(Arrays.asList(firstChild, secondChild, null, fourthChild)));

        MultiWaySearchTree tree = new MultiWaySearchTree(root);

        assertEquals(firstGrandChild, CousinUncleMWST.getCousin(tree, thirdGrandChild));   // [6] is nearest left cousin of [39]
        assertEquals(firstGrandChild, CousinUncleMWST.getCousin(tree, secondGrandChild)); // [6] is also nearest left cousin of [33, 36]
    }

    /*
     *        root: [24 42 80]
     *             /   |      \
     *            /    |       \
     *           /     |        \
     *          /      |         \
     *       [5 8 10] [31]      [100]
     *         |
     *         |
     *         |
     *        [6]
     */
    @Test
    public void testExampleUncle() {

        MWSTNode root = new MWSTNode(Arrays.asList(24, 42, 84), null, null);

        MWSTNode firstChild = new MWSTNode(Arrays.asList(5, 8, 10), root, null);
        MWSTNode secondChild = new MWSTNode(Arrays.asList(31), root, null);
        MWSTNode fourthChild = new MWSTNode(Arrays.asList(100), root, null);
        MWSTNode grandChild = new MWSTNode(Arrays.asList(6), firstChild, null);
        firstChild.setChildren(new LinkedList<>(Arrays.asList(null, grandChild, null, null)));
        root.setChildren(new LinkedList<>(Arrays.asList(firstChild, secondChild, null, fourthChild)));

        MultiWaySearchTree tree = new MultiWaySearchTree(root);

        assertEquals(fourthChild, CousinUncleMWST.getUncle(tree, grandChild));      // [100] is farthest right uncle of [6]
        assertEquals(null, CousinUncleMWST.getUncle(tree, firstChild));
    }

    /*
     *        root: [24 42 80]
     *             /   |      \
     *            /    |       \
     *           /     |        \
     *          /      |         \
     *       [5 8 10] [31]      [100]
     *                   \
     *                    \
     *                     \
     *                    [33 35]
     *                       |
     *                       |
     *                       |
     *                      [34]
     */
    @Test
    public void testExampleSearch() {
        MWSTNode root = new MWSTNode(Arrays.asList(24, 42, 84), null, null);

        MWSTNode firstChild = new MWSTNode(Arrays.asList(5, 8, 10), root, null);
        MWSTNode secondChild = new MWSTNode(Arrays.asList(31), root, null);
        MWSTNode fourthChild = new MWSTNode(Arrays.asList(100), root, null);
        MWSTNode grandChild = new MWSTNode(Arrays.asList(33, 35), secondChild, null);
        secondChild.setChildren(new LinkedList<>(Arrays.asList(null, grandChild)));
        MWSTNode grandGrandChild = new MWSTNode(Arrays.asList(34), grandChild, null);
        grandChild.setChildren(new LinkedList<>(Arrays.asList(null, grandGrandChild, null)));
        root.setChildren(new LinkedList<>(Arrays.asList(firstChild, secondChild, null, fourthChild)));

        MultiWaySearchTree tree = new MultiWaySearchTree(root);

        assertTrue(CousinUncleMWST.restrictedSearch(tree, 8));
        assertTrue(CousinUncleMWST.restrictedSearch(tree, 24));
        assertFalse(CousinUncleMWST.restrictedSearch(tree, 44));
        assertFalse(CousinUncleMWST.restrictedSearch(tree, 34));
    }

    /*
     *        root: [24 42 80]
     *             /   |      \
     *            /    |       \
     *           /     |        \
     *          /      |         \
     *      [5 8 10]  [31 37]      [100]
     *        |          |  \
     *        |          |   \
     *        |          |    \
     *       [6]      [33 36] [39]
     */
    @Test
    public void testCousinNull() {
        MWSTNode root = new MWSTNode(Arrays.asList(24, 42, 84), null, null);

        MWSTNode firstChild = new MWSTNode(Arrays.asList(5, 8, 10), root, null);
        MWSTNode secondChild = new MWSTNode(Arrays.asList(31, 37), root, null);
        MWSTNode fourthChild = new MWSTNode(Arrays.asList(100), root, null);
        MWSTNode firstGrandChild = new MWSTNode(Arrays.asList(6), firstChild, null);
        firstChild.setChildren(new LinkedList<>(Arrays.asList(null, firstGrandChild, null, null)));
        MWSTNode secondGrandChild = new MWSTNode(Arrays.asList(33, 36), secondChild, null);
        MWSTNode thirdGrandChild = new MWSTNode(Arrays.asList(39), secondChild, null);
        secondChild.setChildren(new LinkedList<>(Arrays.asList(null, secondGrandChild, thirdGrandChild)));
        root.setChildren(new LinkedList<>(Arrays.asList(firstChild, secondChild, null, fourthChild)));

        MultiWaySearchTree tree = new MultiWaySearchTree(root);

        assertNull(CousinUncleMWST.getCousin(null, null));
        assertNull(CousinUncleMWST.getCousin(null, fourthChild));
        assertNull(CousinUncleMWST.getCousin(tree, null));
        assertEquals(firstGrandChild, CousinUncleMWST.getCousin(tree, secondGrandChild));   // 2 siblings have the same left cousin
        assertEquals(firstGrandChild, CousinUncleMWST.getCousin(tree, thirdGrandChild));
    }

    /*
     *        root: [24 42 80]
     *             /   |      \
     *            /    |       \
     *           /     |        \
     *          /      |         \
     *       [5 8 10] [31]      [100]
     *         |
     *         |
     *         |
     *        [6]
     */
    @Test
    public void testUncleNull() {
        MWSTNode root = new MWSTNode(Arrays.asList(24, 42, 84), null, null);

        MWSTNode firstChild = new MWSTNode(Arrays.asList(5, 8, 10), root, null);        // parent pointer: root
        MWSTNode secondChild = new MWSTNode(Arrays.asList(31), root, null);
        MWSTNode fourthChild = new MWSTNode(Arrays.asList(100), root, null);
        MWSTNode grandChild = new MWSTNode(Arrays.asList(6), firstChild, null);
        firstChild.setChildren(new LinkedList<>(Arrays.asList(null, grandChild, null, null)));      // children pointer
        root.setChildren(new LinkedList<>(Arrays.asList(firstChild, secondChild, null, fourthChild)));

        MultiWaySearchTree tree = new MultiWaySearchTree(root);

        assertNull(CousinUncleMWST.getUncle(null, null));
        assertNull(CousinUncleMWST.getUncle(null, grandChild));
        assertNull(CousinUncleMWST.getUncle(tree, null));
        assertNull(CousinUncleMWST.getUncle(tree, firstChild));
        assertEquals(fourthChild, CousinUncleMWST.getUncle(tree, grandChild));
        assertEquals(null, CousinUncleMWST.getCousin(tree, grandChild));    // no (nearest) left cousin
        assertEquals(null, CousinUncleMWST.getUncle(tree, firstChild));     // parent root has no siblings
    }

    @Test
    public void testSearchNull() {
        assertFalse(CousinUncleMWST.restrictedSearch(null, 8));
        assertFalse(CousinUncleMWST.restrictedSearch(null, 34));
    }

// -------------------------------------------------------------------------------------------

    // makes node with key = "value" and 2 null children
    private MultiwaySearchTree1 makeLeafNode(int value) {
        int[] child2Value = new int[1];
        child2Value[0] = value;
        MultiwaySearchTree1[] child2Children = new MultiwaySearchTree1[2];
        return new MultiwaySearchTree1(child2Value, child2Children);
    }




    @Test
    public void testExample2() {
        int[] rootValue = new int[1];           // keys
        rootValue[0] = 4;
        MultiwaySearchTree1[] rootChildren = new MultiwaySearchTree1[2];      // children array
        MultiwaySearchTree1 tree = new MultiwaySearchTree1(rootValue, rootChildren);
//        assertTrue(SpecialFourSevenTree.satisfiesCondition1(tree));
//        Assert.assertTrue(SpecialFourSevenTree.isSpecialTree(tree));
        rootChildren[0] = makeLeafNode(2);
        rootChildren[1] = makeLeafNode(6);
//                assertTrue(SpecialFourSevenTree.satisfiesCondition4(tree));
        Assert.assertTrue(SpecialFourSevenTree.isSpecialTree(tree));
    }

    @Test
    public void testExample3() {
        int[] rootValue = new int[1];
        rootValue[0] = 4;
        MultiwaySearchTree1[] rootChildren = new MultiwaySearchTree1[2];
        rootChildren[0] = makeLeafNode(2);
        rootChildren[1] = makeLeafNode(3);
        MultiwaySearchTree1 tree = new MultiwaySearchTree1(rootValue, rootChildren);
        Assert.assertFalse(SpecialFourSevenTree.isSpecialTree(tree));
        Assert.assertTrue(SpecialFourSevenTree.satisfiesCondition1(tree));
        Assert.assertTrue(SpecialFourSevenTree.satisfiesCondition2(tree));
        Assert.assertTrue(SpecialFourSevenTree.satisfiesCondition3(tree));
        Assert.assertFalse(SpecialFourSevenTree.satisfiesCondition4(tree));
    }

}