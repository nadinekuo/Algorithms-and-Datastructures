import java.util.*;

public class IntSLList {

    class Node {
        // Each Node object has these two fields
        private int element;
        private Node next;

        // Constructor: Creates a Node object with element = e and next = n
        Node(int e, Node n) {
            element = e;
            next = n;
        }

        // This function gets int e as input and sets e as the element of the Node
        public void setElement(int e) {
            element = e;
        }

        // This function returns the element variable of the Node
        public int getElement() {
            return element;
        }

        // This function gets Node n as input and sets the next variable of the current Node object as n.
        public void setNext(Node n) {
            next = n;
        }

        // This function returns the next Node
        public Node getNext() {
            return next;
        }
    }

    // Each object in SLList has one field head, which points to the starting Node of SLList.
    private Node head;

    /**
     * Constructor: initialises the head field as null
     */
    public IntSLList() {
        head = null;
    }

    /**
     * Constructor 2: initialises SLL with int elements
     * EXAMPLE:   SLList2 input = new SLList2(3, 1, 2);  <--- gives new SLL with elements in this order
     * OR:
     *         int[] sorted = {1, 2, 3};
     *         SLList2 test = new SLList2(sorted);
     * Queue: 3 - 1 - 2  <-- removeLast
     * addFirst in SLL: 3 - 1 - 2
     */
    public IntSLList(int... elements) {
        LinkedList<Integer> reversed = new LinkedList<>();
        for (int element : elements) {
            reversed.add(element);
        }
        while (!reversed.isEmpty()) {
            this.addFirst(reversed.removeLast());
        }
    }

    /**
     * Recursively print REVERSED SLL using RECURSION.
     * @param head the head of the SLL
     */
    public static void recursivelyPrintReversedSLL(IntSLList.Node head) {

        // base case
        if (head == null) return;

        recursivelyPrintReversedSLL(head.next);
        System.out.println(head.element);

    }

    /**
     * @return The element in the first Node of this SLL. If the list is empty, this method returns null.
     */
    public Node getFirst() {
        if (head == null)
            return null;
        return head;
    }

    /**
     * Adds element e in a new Node to the head of the list.
     *
     * @param e
     *     The element to add.
     */
    public void addFirst(int e) {
        head = new Node(e, head);
    }

    /**
     * Remove the first Node in the list and return its element.
     *
     * @return The element of the first Node.
     * @throws NullPointerException
     *     If the list is empty.
     */
    public int removeFirst() {
        Node result = head;
        head = head.getNext();
        return result.getElement();
    }

    /**
     * Adds an element after an already existing node.
     *
     * @param node
     *     The node to add a new element after.
     * @param e
     *     The new element to add.
     */
    public void addAfter(Node node, int e) {
        Node newNode = new Node(e, node.getNext());
        node.setNext(newNode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        IntSLList slList = (IntSLList) o;
        Node a = this.head;
        Node b = slList.head;
        while (a != null && b != null) {
            if (!Objects.equals(a.getElement(), b.getElement())) {
                return false;
            }
            a = a.next;
            b = b.next;
        }
        return Objects.equals(a, b);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SLList[");
        Node current = this.head;
        while (current != null) {
            sb.append(current.getElement());
            sb.append(",");
            current = current.next;
        }
        sb.replace(sb.length() - 1, sb.length(), "]");
        return sb.toString();
    }

}
