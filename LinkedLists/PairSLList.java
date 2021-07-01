
public class PairSLList <T> {


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



    // Each object in SLList has one field head, which points to the starting Node of SLList.
    private Node head;

    /**
     * Constructor: initialises the head field as null
     */
    public PairSLList() {
        head = null;
    }

    /**
     * @return The element in the first Node of this SLL. If the list is empty, this method returns null.
     */
    public T getFirst() {
        if (head == null)
            return null;
        return head.getElement();
    }

    /**
     * Adds element e in a new Node to the head of the list.
     *
     * @param e
     *     The element to add.
     */
    public void addFirst(T e) {
        if (head == null) {
            Node newhead = new Node(e, null);   // empty SLL
            head = newhead;
        } else {
            Node newhead = new Node(e, head); // new head's next is old head
            System.out.println("New head: " + newhead.getElement());
            head = newhead;
        }
    }

    /**
     * Remove the first Node in the list and return its elements
     * @return The element of the first Node. If the list is empty, this method returns null.
     */
    public T removeFirst() {
        if (head == null) {                 // empty list
            return null;
        }
        T element = head.getElement();
        if (head.getNext() == null) {           // if only 1 element
            head = null;
            System.out.println("Removed node has element: " + element);
            return element;
        } else {
            head = head.getNext();                  // old head will be cleaned up by garbage collection
            System.out.println("Removed node has element: " + element);
            return element;
        }
    }

    /**
     * Combine this list with the other list.
     * Each element of the resulting list is a Pair object holding one element of this list
     * and the corresponding element at the same position of the other list.
     * If one list is LONGER than the other, any extra elements should be DROPPED
     * Example: Zipping [1, 2] with [5, 6, 7] results in [(1, 5), (2, 6)], where (x, y) denotes a Pair object.
     * TAKE SMALLEST SLL, SO IF OTHER IS EMPTY/NULL, RETURN EMPTY NEW SLL!
     * @param other
     *     The other list to combine elements with. Is treated as an empty list if it is null.
     * @return A new list with alternated elements of this list and the other list.
     */
    public PairSLList<Pair<T, T>> zip(PairSLList<T> other) {

        if (other == null) {
            return new PairSLList<Pair<T, T>>();            // if null, treat as empty SLL (take smallest)
        }

        PairSLList<Pair<T, T>> reversed = new PairSLList<>();
        PairSLList<Pair<T, T>> newList = new PairSLList<>();
        Node walk1 = this.head;
        Node walk2 = other.head;

        // stop when EITHER 1 of the lists has been fully traversed.
        while (walk1 != null && walk2 != null) {
            Pair<T, T> newPair = new Pair<>(walk1.getElement(), walk2.getElement());
            reversed.addFirst(newPair);
            walk1 = walk1.getNext();
            walk2 = walk2.getNext();
        }

        // Add everything from the temporary REVERSED SLL to result SLL.
        PairSLList<Pair<T, T>>.Node walk = reversed.head;                   // add class in front (bc it has a diff generic type)
        while (walk != null) {
            newList.addFirst(walk.getElement());
            walk = walk.getNext();
        }
        return newList;
    }

    /**
     * Appends another SLL to this SLL.
     * @param other
     *     The list to append to this list. Is treated as an empty list if it is null. --> keep this list, do nothing.
     *     If THIS list is empty, THIS list BECOMES other list!
     *     Else, find LAST NODE (O(n)) and set next to other head.
     */
    public void append(PairSLList<T> other) {
        if (other == null || other.head == null) return;

        if (head ==  null) {            // this list is empty, so becomes other list!
            this.head = other.head;
        } else {
            // Find last node, set next to head of other.
            Node walk = this.head;
            while (walk.getNext() != null) {     // If you'd do "while (walk != null)", it will be null the last iteration!!!
                walk = walk.getNext();
            }
            walk.setNext(other.head);           // YOU ARE CALLING A METHOD ON Walk, SO CAN'T BE NULL. (don't do "while walk != null")
        }
    }

    /**
     * Removes all elements at the even positions in this list.
     * Note that the head of the list is element number 0, which is an even position.
     * which nodes you wanna add to original list depends on SIZE; whether its ODD/EVEN!!
     * If size is ODD: all evens stay evens!
     * If size is EVEN: all evens become odds!
     */
    public void dropEven() {
        Node copy = head;           // index 0
        PairSLList<T> reversed = new PairSLList<>();

        int size = 0;                               // get size of SLL
        while (copy != null) {
            reversed.addFirst(this.removeFirst());  // REMOVE AND ADD all nodes to reversed
            copy = copy.getNext();
            size++;
        }
        // add EVEN/ODD nodes from REVERSED to original list again, bc indices have changed!!! (depends on whether size is odd/even)
        // Thus essentially you removed the EVENS from the original.
        Node walk2 = reversed.head;
        int count = size;
        while (walk2 != null) {
            if (count % 2 == 0) {            // only add to original list when count (depends on size!) is even!
                this.addFirst(walk2.getElement());
            }
            walk2 = walk2.getNext();
            count--;
        }
    }

}
