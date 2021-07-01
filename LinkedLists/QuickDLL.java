class QuickDLL {

    // in addition to the usual references to the immediate neighbours,
    // the implementation of all methods in the QuickDLL class should make sure that
    // each node also maintains references to the nodes that are 3, 9, and 14 positions further in the list.

    // Each QuickDLL has one field head, which points to the starting Node of QuickDLL.
    private Node head;

    // Each QuickDLL has one field tail, which points to the last Node of QuickDLL.
    private Node tail;

    // Each QuickDLL has one size field, which represents the number of elements in the QuickDLL.
    // Make sure to also update the size of the list!
    private int size;

    /**
     * Constructor: initialises the head and tail fields as null
     */
    public QuickDLL() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * @return The head Node of the DLL
     */
    public Node getHead() {
        return head;
    }

    /**
     * @return The tail Node of the DLL
     */
    public Node getTail() {
        return tail;
    }

    /**
     * @return the number of elements in the WeirdDLL.
     */
    public int getSize() {
        return size;
    }

    /**
     * @param index of the node to get
     * @return O(n) operation to get the node at position index.
     */
    public Node atPosition(int index) {
        if (index < 0)
            return null;
        Node finger = head;
        while (index > 0 && finger != null) {
            finger = finger.getNext(0);
            index -= 1;
        }
        return finger;
    }

    public void addFirst(Object value) {
        Node newHead = new Node(value);
        if (size == 0) {
            head = newHead;       // pointers are null
            tail = newHead;
        } else {                 // we use 2, 8, 13 instead of 3, 9, 14, because it's not part of the list yet!
            newHead.setNext(0, head);
            newHead.setNext(1, atPosition(2)); // will be null if no node here
            newHead.setNext(2, atPosition(8));
            newHead.setNext(3, atPosition(13));
            head.setPrevious(newHead);
            head = newHead;
        }
        size++;
    }

    public void addLast(Object value) {
        Node newTail = new Node(value);

        if (size == 0) {
            head = newTail;         // pointers are null
            tail = newTail;
        } else {
            newTail.setPrevious(tail);
            tail.setNext(0, newTail);
            Node toUpdate1 = atPosition(size-3);      // update all pointers which are now not null anymore
            if (toUpdate1 != null) {
                toUpdate1.setNext(1, newTail);
            }
            Node toUpdate2 = atPosition(size-9);
            if (toUpdate2 != null) {
                toUpdate2.setNext(2, newTail);
            }
            Node toUpdate3 = atPosition(size-14);
            if (toUpdate3 != null) {
                toUpdate3.setNext(3, newTail);
            }
            tail = newTail;
        }
        size++;
    }

    /**
     * Adds a new element at a given position or index in the list
     * When the given index is larger than the size of the list, you should consider this as a call to addLast instead.
     * You may assume that the given index is always ≥ 0.
     */
    public void insert(int index, Object value) {
        if (index >= size) {
            addLast(value);
            return;
        } else if (index == 0) {
            addFirst(value);
            return;
        } else {
            Node newNode = new Node(value);
            Node newNext = atPosition(index);
            Node newPrev = newNext.getPrevious();

            newPrev.setNext(0, newNode);   // new links
            newNode.setPrevious(newPrev);
            newNode.setNext(0, newNext);
            newNext.setPrevious(newNode);

            // update pointers 1, 2, 3 of new node (may be null)
            newNode.setNext(1, atPosition(index+3));
            newNode.setNext(2, atPosition(index+9));
            newNode.setNext(3, atPosition(index+14));

            // update pointers of 14 nodes that came before newly inserted node...ugh
            for (int i = -14; i < 0; i++) {
                Node toUpdate = atPosition(index + i);
                if (toUpdate == null) continue;
                toUpdate.setNext(0, atPosition(index + i + 1));
                toUpdate.setNext(1, atPosition(index + i + 3));
                toUpdate.setNext(2, atPosition(index + i + 9));
                toUpdate.setNext(3, atPosition(index + i + 14));
            }
        }
        size++;
    }



    // ------------------------- NESTED NODE CLASS ----------------------------------------------------------------//




    class Node {


        private Object element;

        // A Node object maintains an array of references to the next nodes
        // Pointers are null when they point to a node that does not exist.
        //  you should ensure that the array pointers contains the correct references in the correct order: from closest to farthest node in the list.
        private Node[] pointers;

        private Node previous;

        // Constructor: Creates a Node object with element = e and no pointers set.
        Node(Object e) {
            element = e;
            pointers = new Node[4];
            previous = null;
        }

        // This function gets Object e as input and sets e as the element of the Node
        public void setElement(Object e) {
            element = e;
        }

        // This function returns the element variable of the Node
        public Object getElement() {
            return element;
        }

        /**
         * @param pointer_index the pointer index to update.
         * @param n             the node to set in the pointer table
         */
        public void setNext(int pointer_index, Node n) {
            pointers[pointer_index] = n;
        }

        /**
         * @param pointer_index Number between 0 and 3 to indicate which pointer is required
         * @return the correct next_node based on the pointer_index
         */
        public Node getNext(int pointer_index) {
            return pointers[pointer_index];
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        @Override
        public String toString() {
            return "Node{" + "element=" + element + '}';
        }
    }
}