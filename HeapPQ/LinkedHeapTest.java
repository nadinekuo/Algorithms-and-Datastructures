import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedHeapTest {



    @Test
    public void testSingleRoot() {
        LinkedMaxHeap heap = new LinkedMaxHeap(5);
        System.out.println(heap.getLastNode());
        heap.swap(heap.root, heap.getLastNode());       // it swaps with itself!
        System.out.println(heap.root);
        System.out.println(heap.removeMax());
    }

    @Test
    public void testExampleRemove() {
        LinkedMaxHeap heap = new LinkedMaxHeap(2);
        heap.root.setLeft(new TreeNode(1));
        heap.size++;
        heap.root.setRight(new TreeNode(0));
        heap.size++;
        assertEquals(2, heap.removeMax());
        assertEquals(1, heap.removeMax());
    }

    @Test
    public void testExampleDownHeap() {
        LinkedMaxHeap heap = new LinkedMaxHeap(101);
        heap.root.setLeft(new TreeNode(42));
        heap.size++;
        heap.root.setRight((new TreeNode(24)));
        heap.size++;
        heap.root.setKey(7);
        assertEquals(7, heap.root.getKey());
        heap.downHeap(heap.root);
        assertEquals(42, heap.root.getKey());
    }

    @Test
    public void testFullLayer() {
        LinkedHeap2 heap = new LinkedHeap2(4);
        heap.setLeft(heap.getRoot(), 5);
        heap.setRight(heap.getRoot(), 6);

        heap.setLeft(heap.getLeft(heap.getRoot()), 15);
        heap.setRight(heap.getLeft(heap.getRoot()), 9);
        heap.setLeft(heap.getRight(heap.getRoot()), 7);
        heap.setRight(heap.getRight(heap.getRoot()), 20);

        assertEquals(9, LinkedHeap2.findMiddleInLastLayer(heap).getKey());
    }

    @Test
    public void testExample() {

        LinkedHeap2 heap = new LinkedHeap2(4);
        heap.setLeft(heap.getRoot(), 5);
        heap.setRight(heap.getRoot(), 6);

        heap.setLeft(heap.getLeft(heap.getRoot()), 15);
        heap.setRight(heap.getLeft(heap.getRoot()), 9);
        heap.setLeft(heap.getRight(heap.getRoot()), 7);
        heap.setRight(heap.getRight(heap.getRoot()), 20);

        heap.setLeft(heap.getLeft(heap.getLeft(heap.getRoot())), 16);
        heap.setRight(heap.getLeft(heap.getLeft(heap.getRoot())), 25);
        heap.setLeft(heap.getRight(heap.getLeft(heap.getRoot())), 14);
        heap.setRight(heap.getRight(heap.getLeft(heap.getRoot())), 12);
        heap.setLeft(heap.getLeft(heap.getRight(heap.getRoot())), 11);
        heap.setRight(heap.getLeft(heap.getRight(heap.getRoot())), 13);

        assertEquals(14, LinkedHeap2.findMiddleInLastLayer(heap).getKey());
    }

        @Test
        public void testNode() {
            LinkedHeap2 test = new LinkedHeap2(5);
            test.setLeft(test.getRoot(), 10);
            test.setRight(test.getRoot(), 15);
            System.out.println(test.getRoot());
        }

        @Test
        public void testNull() {
            assertNull(LinkedHeap2.findMiddleInLastLayer(null));
        }

        @Test
        public void testTwoPositions() {
            LinkedHeap2 heap = new LinkedHeap2(42);
            heap.setLeft(heap.getRoot(), 84);
            assertEquals(84, heap.findMiddleInLastLayer(heap).getKey());
        }

        @Test
        public void testThreePositions() {
            LinkedHeap2 heap = new LinkedHeap2(42);
            heap.setLeft(heap.getRoot(), 84);
            heap.setRight(heap.getRoot(), 99);
            assertEquals(84, heap.findMiddleInLastLayer(heap).getKey());

    }


}