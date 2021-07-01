class DLList {

    // Each object in DLList has one field head, which points to the starting Node of DLList.
    private DLLNode head;
    // Each object in DLList has one field tail, which points to the final Node of DLList.
    private DLLNode tail;

    // NO HEADER AND TRAILER
    // NO SIZE FIELD

    /**
     * Constructor: initialises the head and tail fields as null
     */
    public DLList() {
        head = null;
        tail = null;
    }

    /**
     * @return The element in the head Node of the DLL
     */
    public Object getHead() {
        return head.getElement();
    }

    /**
     * @return The element in the tail Node of the DLL
     */
    public Object getTail() {
        return tail.getElement();
    }

    /**
     * Adds element e in a new Node to the head of the list.
     * @param e
     *     The element to add.
     */
    public void addFirst(Object e) {
        if (size() == 0) {
            head = new DLLNode(e, null, null);
            tail = head;
        } else {
            DLLNode newest = new DLLNode(e, null, head);
            head.setPrevious(newest);
        }
    }

    /**
     * Remove the first Node in the list and return its element.
     * @return The element of the head Node. If the list is empty, this method returns null.
     */
    public Object removeFirst() {
        if (size() == 0) {
            return null;
        }
        Object element = head.getElement();
        head = head.getNext();      // will become null if the DLL only contained 1 node
        if (head != null) {
            head.setPrevious(null);
        }
        if (size() == 0) {          // if the DLL is empty after removing
            tail = null;
        }
        return element;
    }

    /**
     * Adds element e in a new Node to the tail of the list.
     * @param e
     *     The element to add.
     */
    public void addLast(Object e) {
        DLLNode newest = new DLLNode(e, tail, null);  // will become new tail
        if (size() == 0) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
    }

    /**
     * Remove the last Node in the list and return its element.
     *
     * @return The element of the tail Node. If the list is empty, this method returns null.
     */
    public Object removeLast() {
        if (size() == 0) {
            return null;
        }
        Object element = tail.getElement();
        tail = tail.getPrevious();          // will become null if there was only 1 Node
        if (tail != null) {
            tail.setNext(null);
        }
        if (size() == 0) {                  // if the DLL is now empty
            head = null;
        }
        return element;
    }

    /**
     * @return the number of Nodes in the list
     */
    public int size() {
        if (head == null || tail == null) {
            return 0;
        }
        // if (head == tail) {
        //     return 1;
        // }
        DLLNode walk = head;
        int count = 1;
        while (walk.getNext() != null) {
            walk = walk.getNext();
            count++;
        }
        return count;
    }

    /**
     * Adds element e in a new Node which is inserted at position pos.
     * The list is zero indexed, so the first element in the list corresponds to position 0.
     * This also means that `addAtPosition(0, e)` has the same effect as `addFirst(e)`.
     * If there is no Node in position pos, this method adds it to the last position.
     *
     * @param pos
     *     The position to insert the element at.
     * @param e
     *     The element to add.
     */
    public void addAtPosition(int pos, Object e) {
        if (pos > size()-1 || pos < 0) {
            addLast(e);
            return;                              // stops method execution (alternative to else-statement)
        }
         if (pos == 0) {
             addFirst(e);
             return;
         }
         DLLNode walk = head;
        DLLNode newest = new DLLNode(e, null, null);
        for (int i = 0; i < pos; i++) {
            walk = walk.getNext();          // walk is now at the position where you wanna insert
        }
        DLLNode pred = walk.getPrevious();
        DLLNode succ = walk;                   // walk is the successor of the new Node
        newest.setPrevious(pred);
        newest.setNext(succ);
        pred.setNext(newest);
        succ.setPrevious(newest);
    }

    /**
     * Remove Node at position pos and return its element.
     * The list is zero indexed, so the first element in the list corresponds to position 0.
     * This also means that `removeFromPosition(0)` has the same effect as `removeFirst()`.
     *
     * @param pos
     *     The position to remove the Node from.
     * @return The element of the Node in position pos. If there is no Node in position pos, this method returns null.
     */
    public Object removeFromPosition(int pos) {
        if (size() == 0 || pos > size()-1) {
            return null;
        }

         if (pos == 0) {
             return removeFirst();
         }

         if (pos == size()-1) {
             return removeLast();
         }

        DLLNode temp = head;
        for (int i = 0; i < pos; i++) {
            temp = temp.getNext();
        }
        DLLNode pred = temp.getPrevious();
        DLLNode succ = temp.getNext();
        pred.setNext(succ);             // outlinking the Node to be removed (garbage collection)
        succ.setPrevious(pred);
        return temp.getElement();
    }

    /**
     * @return A new DLL that contains the elements of the current one in reversed order.
     * DON'T MUTATE THE ORIGINAL LIST! Return a NEW LIST.
     */
    public DLList reverse() {
        if (size() == 0) {
            return new DLList();
        }
        DLLNode temp = head;
        DLList result = new DLList();
        while (temp != null) {
            result.addFirst(temp.getElement());
            temp = temp.getNext();
        }
        return result;
    }

}

