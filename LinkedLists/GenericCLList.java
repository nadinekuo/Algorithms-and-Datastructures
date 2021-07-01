public class GenericCLList<T> {


    // ----------- NESTED NODE CLASS --------------------------------//

    class Node {
        // Each Node object has these two fields
        private T element;
        private Node next;

        // Constructor: Creates a Node object with element = e and next = n
        Node(T e, Node n) {
            element = e;
            next = n;
        }

        // This function gets T e as input and sets e as the element of the Node
        public void setElement(T e) {
            element = e;
        }

        // This function returns the element variable of the Node
        public T getElement() {
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

    // ----------- NESTED NODE CLASS --------------------------------//



    // Each object in CSLList has one field tail, which points to the tail Node of CSLList.
    private Node tail;              // tail.next is implicit head!

    /**
     * Constructor: initialises the tail field as null
     */
    public GenericCLList() {
        tail = null;
    }

    /**
     * @return The element in the first Node of this CSLL. If the list is empty, this method returns null.
     * RETURN IMPLICIT HEAD'S ELEMENT.
     */
    public T getFirst() {
        if (tail == null)
            return null;
        return tail.getNext().getElement();
    }

    /**
     * @return The element in the last Node of this CSLL. If the list is empty, this method returns null.
     * RETURN TAIL'S ELEMENT.
     */
    public T getLast() {
        if (tail == null)
            return null;
        return tail.getElement();
    }

    /**
     * Adds element e in a new Node to the head of the list.
     * @param e
     *     The element to add.
     *     NEW IMPLICIT HEAD: set tail.next to new node.
     */
    public void addFirst(T e) {
        if (e == null) return;
        if (tail == null) {              // if empty
            Node newHead = new Node(e, null);
            tail = newHead;
            tail.setNext(tail);         // LINK TO ITSELF CIRCULARLY (only node in list)
            System.out.println("New implicit head: " + newHead.getElement());
        } else {
            Node newHead = new Node(e, tail.next);      // points to old implicit head
            tail.setNext(newHead);
            System.out.println("New implicit head: " + newHead.getElement());
        }
    }

    /**
     * Adds element e in a new Node to the tail of the list.
     *
     * @param e
     *     The element to add.
     */
    public void addLast(T e) {
        addFirst(e);
        rotate();
        System.out.println("New tail (after rotation): " + e);
    }

    /**
     * Remove the first Node in the list and return its element. (IMPLICIT HEAD)
     * @return The element of the first Node. If the list is empty, this method returns null.
     * IF ONLY 1 NODE, TAIL GETS REMOVED. (which points to itself)
     */
    public T removeFirst() {
        if (tail == null) return null;
        Node head = tail.getNext();
        if (head == tail) {
            tail = null;              // IF ONLY 1 NODE, TAIL GETS REMOVED. (which points to itself)
            System.out.println("Head (=tail) removed: " + head.getElement());
        } else {
            tail.setNext(head.getNext());   // (If 2 nodes only, tail will point to itself now)
            System.out.println("Head removed: " + head.getElement());
        }
        return head.getElement();
    }

    /**
     * Rotates the list such that the second element in the list will become the first element in the list.
     * Example: rotating the list [1, 2, 3] will become [2, 3, 1].
     * DON'T ROTATE IF CLL IS EMPTY!
     */
    public void rotate() {
        if (tail != null) {
            tail = tail.getNext();
        }
    }

    /**
     * Merges this list and the other list by alternating elements from the two lists.
     * If one of the lists is LONGER THAN THE OTHER, the REMAINING ELEMENTS ARE ADDED to the end of the resulting list.
     * @param other
     *     The other list to alternate elements with. Is treated as an empty list if it is null.
     * @return A new list with alternated elements of this list and the other list.
     * START WITH THIS LIST (this head is new head), THEN ADD head of other list AS 2ND NODE.
     * If you call addLast(), THE ORDER WILL REMAIN UNCHANGED! (not reversed, like with addFirst)
     */
    public GenericCLList<T> alternate(GenericCLList<T> other) {

        GenericCLList<T> result = new GenericCLList<>();

                                                         // THIS can't be null! Otherwise you wouldn't be able to call this method.
        if (other == null || other.tail == null) {
            if (tail == null) return result;                 // OTHER list null/empty, this empty.
            else {                                           // OTHER list null/empty, this not --> add all of this list to NEW RESULT LIST
                Node walk = tail;
                do {
                    walk = walk.getNext();
                    result.addLast(walk.getElement());
                } while (walk != tail);
                return result;
            }
        } else if (tail == null) {                          // THIS list empty, other not. --> add all of other to result
            Node walk = other.tail;
            do {
                walk = walk.getNext();
                result.addLast(walk.getElement());
            } while (walk != other.tail);
            return result;
        }
                                        // now we know both lists have at least 1 element
        Node walk1 = tail;
        Node walk2 = other.tail;
                                    // all nodes of SHORTEST list added:
        do {
            walk1 = walk1.getNext();
            walk2 = walk2.getNext();
            result.addLast(walk1.getElement());
            result.addLast(walk2.getElement());
        } while (walk1 != tail && walk2 != other.tail);

                                // ALL remaining nodes of LONGEST list still to be added...
        if (walk1 != tail) {
            Node remainder = walk1;
            do {
                remainder = remainder.getNext();
                result.addLast(remainder.getElement());
            } while (remainder != tail);
        }

        if (walk2 != other.tail) {
            Node remainder = walk2;
            do {
                remainder = remainder.getNext();
                result.addLast(remainder.getElement());
            } while (remainder != other.tail);
        }
        return result;
    }

    /**
     * Removes all elements at the odd positions in this list.
     * Note that the head of the list is element number 0, which is an even position.
     * WE WANNA KEEP 0 (head), 2, 4, 6, ....
     */
    public void dropOdd() {

        if (tail == null || tail.getNext() == tail) return;     // 1 element remains (0 = even)

        GenericCLList<T> temp = new GenericCLList<>();

        // Now we know there are at least 2 elements
        // REMOVE ALL NODES (until empty) AND ADD to temp
        while (tail != null) {
            temp.addLast(this.removeFirst());        // addLast, so temp is not reversed!!
        }
        // Only add even counts to this CLL again
        int count = 0;
        Node walk = temp.tail;
        do {
            walk = walk.getNext();
            if (count % 2 == 0) {
                this.addLast(walk.getElement());
            }
            count++;
        } while (walk != temp.tail);
    }



    /**
     * LOOP UNTIL NEXT NODE == TAIL.
     */
//    public String toString() {
//        if (tail == null) return "CSLList<>";
//        StringBuilder sb = new StringBuilder();
//        Node head = tail.getNext();
//        sb.append("Implicit head: " + head.getElement() + " --> ");
//        Node walk = head;
//        while (walk != tail) {        // STOP IF TAIL REACHED AGAIN! Else, infinite loop!
//            sb.append(walk.getNext().getElement() + " --> ");
//            walk = walk.getNext();
//        }
//        return sb.toString();
//    }

    public String toString() {
        if (tail == null) return "CSLList<>";
        String res = "CSLList<";
        Node current = tail;
        do {
            current = current.getNext();
            res += ((current == tail) ? "!" : "") + current.getElement() + ((current == tail) ? "!" : "") + ", ";
        } while (current != tail);
        return res + ">";
    }

}
