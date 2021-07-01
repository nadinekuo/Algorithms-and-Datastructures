public class ObjectSLList {


    // Each object in SLList has one field head, which points to the starting Node of SLList.
    private Node head;

    // NO REFERENCE TO TAIL! So O(n) to remove last.

    /**
     * Constructor: initialises the head field as null
     */
    public ObjectSLList() {
        head = null;
    }

    /**
     * @return The element in the head Node of the SLL
     */
    public Object getHead() {
        return head.getElement();
    }


    /**
     * Find middle node in the list!!
     * @param head
     * @return the middle node
     * SLOW: makes 1 skip
     * FAST: makes 2 skips; if fast reaches end, slow is at middle node!
     */
    public Node findMiddleNode(Node head) {
        if(head == null) return null;
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.getNext() != null && fast.getNext().getNext() != null  ) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    /**
     * Adds element e in a new Node to the head of the list.
     * Create new node
     * Update head
     * @param e The element to add.
     */
    public void addFirst(Object e) {
        if (head == null) {
            Node newhead = new Node(e, null);   // empty SLL
            head = newhead;
        } else {
            Node newhead = new Node(e, head); // new head's next is old head
            head = newhead;
        }
    }

    /**
     * Remove the first Node in the list and return its element.
     * @return The element of the head Node. If the list is empty, this method returns null.
     */
    /**
     * Remove the first Node in the list and return its element.
     * @return The element of the head Node. If the list is empty, this method returns null.
     */
    public Object removeFirst() {
        if (head == null) {
            return null;
        }
        Object element = head.getElement();
        if (head.getNext() == null) {           // if only 1 element
            head = null;
            return element;
        } else {
            head = head.getNext();                  // old head will be cleaned up by garbage collection
            return element;
        }
    }

    /**
     * Adds element e in a new Node to the tail of the list.
     * Find tail --> O(n) traversal
     * @param e
     *     The element to add.
     */
    public void addLast(Object e) {
        if (head == null) {
            addFirst(e);            // if empty SLL, it's the same as addFirst
        } else {
            Node newtail = new Node(e, null);
            Node walk = head;
            while (walk.getNext() != null) {      // loop until tail
                walk = walk.getNext();
            }
            walk.setNext(newtail);
        }
    }

    /**
     * Remove the last Node in the list and return its element.
     * Find Node BEFORE tail --> O(n) traversal
     * @return The element of the tail Node. If the list is empty, this method returns null.
     */
    public Object removeLast() {
        if (head == null) {
            return null;
        }
        Node walk = head;
        if (walk.getNext() == null) {   // if only a head
            return removeFirst();
        }
        // or you use 2 pointers: curr and prev
        while (walk.getNext().getNext() != null) {    // loop until Node BEFORE tail
            walk = walk.getNext();
        }
        Object element = walk.getNext().getElement();   // element of tail
        walk.setNext(null);                             // detach old tail
        return element;
    }

    /**
     * Remove Node at position pos and return its element.
     * The list is zero indexed, so the first element in the list corresponds to position 0.
     * This also means that `removeFromPosition(0)` has the same effect as `removeFirst()`.
     *
     * @param pos The position to remove the Node from.
     * @return The element of the Node in position pos. If there is no Node in position pos, this method returns null.
     */
    public Object removeFromPosition(int pos) {
        if (head == null || head.getNext() == null && pos > 0) return null;
        if (pos == 0) {
            return removeFirst();
        }

        // find size of SLL
        int count = 1;
        Node walk = head;
        while (walk != null) {
            walk = walk.getNext();
            count++;
        }
        if (pos == count-1) removeLast();     // remove last pos, thus tail
        if (pos > count-1) return null;

        // find the Node BEFORE the pos
        Node current = head;
        for (int i = 0; i < pos-1; i++) {
            current = current.getNext();
        }
        // now current is Node BEFORE pos
        Object element = current.getNext().getElement();
        current.setNext(current.getNext().getNext());   // Node in pos will be detached
        return element;
    }


}
