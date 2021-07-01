class StudentList {

    private Student head;
    private Student tail;

    public Student getHead() {
        return head;
    }

    public Student getTail() {
        return tail;
    }

    /**
     * Adds a student with the given ID to the head of the list.
     * @param id ID of student to add.
     *           SKIP BACK AND SKIP AHEAD!!
     */
    public void addFirst(int id) {
        if (head == null) {             // empty list (or: size = 0)
            Student newNode = new Student(id, null, null);
            head = newNode;
            tail = head;
            head.setSkipAhead(null);
            head.setSkipBack(null);
        } else {
            Student newNode = new Student(id, null, head);
            head.setPrevious(newNode);
            head = newNode;
            if (size() > 4) {
                Student fourSkips = head.getNext().getNext().getNext().getNext();
                head.setSkipAhead(fourSkips);
                head.getSkipAhead().setSkipBack(head);          // both directions!
//                head.setSkipBack(null);
            } else {                            // this can be left out, as it would be null anyways
                head.setSkipAhead(null);
                head.setSkipBack(null);
            }
        }
        System.out.println("New head: " + head.getId());
    }

    /**
     * Remove the first student in the list and return their ID.
     * @return The ID of the first student.
     * @throws EmptyListException If the list is empty.
     *     *           SKIP BACK AND SKIP AHEAD!!
     */
    public int removeFirst() {
        if (size() == 0) {
            throw new EmptyListException();
        } else {
            int id = head.getId();
            System.out.println("To remove: " + id);
            if (size() > 4) {
                head.getSkipAhead().setSkipBack(null);      // head was the "skip back" of this node
            }
            head = head.getNext();      // head collected by garbage collection
            if (head != null) {
                head.setPrevious(null);
            }
            if (size() == 0) {          // if the DLL is empty after removing
                tail = null;
            }
            return id;
        }
    }

    /**
     * Returns the ID of the student at the given seat.
     * @param seatNumber Seat to find student of.
     * @return The ID of the student at the given seat.
     * @throws IllegalSeatNumberException If there is no seat with this number.
     *         // Traverse back to front or front to back
     *         // Use skipAhead/skipBack!!!
     *         you can only execute a call to next or previous three times)!
     */
    public int getStudentAtSeat(int seatNumber) {

        if (size() == 0) throw new IllegalSeatNumberException();
        if (seatNumber < 0 || seatNumber > size()-1) throw new IllegalSeatNumberException();

        if (seatNumber == 0) return head.getId();
        if (seatNumber == size()-1) return tail.getId();

        Student walk = head;
        // loop until skip ahead not possible anymore
        int fullskips = seatNumber/4;
        int remainder = seatNumber % 4;     // can be max 3
        for (int i = 0; i < fullskips; i++) {
            walk = walk.getSkipAhead();
        }
        if (remainder == 0) return walk.getId();   // student at seatNumber
        else {     // search remainder part
            for (int i = 0; i < remainder; i++) {
                walk = walk.getNext();
            }
            return walk.getId();
        }
    }

    /** HELPER METHOD.
     * @return the number of Nodes in the list
     */
    public int size() {
        if (head == null || tail == null) {
            return 0;
        }
         if (head == tail) {
             return 1;
         }
        Student walk = head;
        int count = 1;
        while (walk.getNext() != null) {
            walk = walk.getNext();
            count++;
        }
        return count;
    }

//    Koen ---> DLL (missed the case where the index is negative, but I think everything else works):
//            package weblab;
//
//    class CoatiList {
//
//        private CoatiNode head;
//
//        private CoatiNode tail;
//
//        public CoatiNode getHead() {
//            return head;
//        }
//
//        public CoatiNode getTail() {
//            return tail;
//        }
//
//        /**
//         * Adds value v in a new node to the tail of the list.
//         *
//         * @param v Value to add.
//         */
//        public void addLast(int v) {
//            CoatiNode newNode = new CoatiNode(v);
//
//            if(head == null) {
//                head = newNode;
//            }
//
//            if(tail != null) {
//                tail.setNext(newNode);
//                newNode.setPrevious(tail);
//            }
//
//            CoatiNode skip = tail;
//            for(int i = 0; i < 3; i++) {
//                if(skip == null) {
//                    break;
//                }
//                skip = skip.getPrevious();
//            }
//            if(skip != null) {
//                skip.setSkipAhead(newNode);
//                newNode.setSkipBack(skip);
//            }
//
//            tail = newNode;
//        }
//
//        /**
//         * Remove the first node in the list and return its value.
//         *
//         * @return The value of the head node.
//         * @throws EmptyListException If the list is empty.
//         */
//        public int removeFirst() {
//            if(head == null) {
//                throw new EmptyListException();
//            }
//
//            int v = head.getValue();
//
//            if(head == tail) {
//                head = null;
//                tail = null;
//                return v;
//            }
//
//            CoatiNode next = head.getNext();
//            if(next != null) {
//                next.setPrevious(null);
//                head.setNext(null);
//            }
//
//            CoatiNode skip = head.getSkipAhead();
//            if(skip != null) {
//                skip.setSkipBack(null);
//                head.setSkipAhead(null);
//            }
//
//            head = next;
//
//            return v;
//        }
//
//        /**
//         * Returns the value of node at the given position.
//         * @param pos Position to look for.
//         * @return The value of the node at the given position.
//         * @throws IllegalIndexException If there is no node at this index.
//         */
//        public int getValueAtPosition(int pos) {
//            CoatiNode node = head;
//            while(node != null && pos > 0) {
//                if(pos > 3) {
//                    node = node.getSkipAhead();
//                    pos -= 4;
//                } else {
//                    node = node.getNext();
//                    pos--;
//                }
//            }
//
//            if(node == null) {
//                throw new IllegalIndexException();
//            }
//
//            return node.getValue();
//        }
//    }
}
