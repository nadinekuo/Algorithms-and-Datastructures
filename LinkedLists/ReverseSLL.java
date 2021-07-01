
public class ReverseSLL {

    // ------------------------- NESTED NODE CLASS -----------------------------------------//

    private static class Node {

        int value;
        Node next;


        public Node(int val, Node n) {
            value = val;
            next = n;
        }
    }

    // ------------------------- NESTED NODE CLASS -----------------------------------------//



    public static void main(String[] args) {
        Node tail1 = new Node(5, null);
        Node tail2 = new Node(5, null);
        Node head1 = new Node(1, new Node(2, new Node(3, new Node(4, tail1))));
        Node head2 = new Node(1, new Node(2, new Node(3, new Node(4, tail2))));
        Node[] revFwd = reverseForward(head1, tail1);
        Node[] revBwd = reverseBackward(head2, tail2);
        System.out.println("Fwd head " + revFwd[0].value + ", tail " + revFwd[1].value);
        System.out.println("Bwd head " + revBwd[0].value + ", tail " + revBwd[1].value);
        Node node1 = revFwd[0];
        Node node2 = revBwd[0];
        while (node1 != null && node2 != null) {
            System.out.println("fwd " + node1.value + ", bwd " + node2.value);
            node1 = node1.next;
            node2 = node2.next;
        }
        System.out.println("\nFound null\nFwd: " + (node1 == null) + ", Bwd: " + (node2 == null));
    }



    /**
     * 2 references --> O(n)
     *  If we are given direct access to nodes, we can traverse the list directly using the nodes'
     * references and "flip"
     * the references between each pair of consecutive nodes one by one.
     * O(1) time per node (pair), so O(n) time for all nodes in the list.
     */
    private static Node[] reverseForward(Node head, Node tail) {
        if (head == null || head.next == null)
            return new Node[] { head, head };
        Node nextHead = head.next;              // REFERENCE 1
        head.next = null;                       // head becomes tail, so set next to null
        Node nextNextHead = nextHead.next;      // REFERENCE 2
        tail = head;                            // tail becomes new head

        while (nextNextHead != null) {  // will become null in the end, but doesn't matter as long as we don't call a method on it after the loop.
            nextHead.next = head;
            head = nextHead;
            nextHead = nextNextHead;            // SHIFT BOTH REFERENCES
            nextNextHead = nextNextHead.next;   // 1 spot to right
        }
        // nextHead is now at the original LAST node, nextNextHead is null.
        // head is 1 BEFORE LAST
        // head - nextHead - nextNextHead (null)
        nextHead.next = head;                   // NEW HEAD points to the original 1 BEFORE LAST
        head = nextHead;                        // new head is original LAST node
        return new Node[] { head, tail };
    }



    /**
     * 1 reference --> O(n^2)!
     * 2 while-loops:
     * Loop 1:
     * Loop 2:
     */
    private static Node[] reverseBackward(Node head, Node tail) {
        if (head == null || head.next == null)
            return new Node[] { head, head };

        Node node = null;                   // REFERENCE 1
        while (node != head) {          // condition is checked again after 1 loop! (so doesn't break here)
            node = head;
            while (node.next.next != null) {
                node = node.next;               // you reach the node before tail
            }
            node.next.next = node;
            node.next = null;
        }
        node.next = null;               // node is now head, which will become tail, so next is null
        head = tail;
        tail = node;                    // new tail is old head
        return new Node[] { head, tail };
    }


    /**
     * Recursively print REVERSED SLL using RECURSION.
     * @param head the head of the SLL
     */
    public static void recursivelyPrintReversedSLL(Node head) {

        // base case
        if (head == null) return;

        recursivelyPrintReversedSLL(head.next);
        System.out.println(head.value);

    }


}
