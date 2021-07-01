public class DLLNode {

    // NESTED NODE CLASS -------------------------------------------------
        // Each node object has these three fields
        private Object element;
        private DLLNode previous;
        private DLLNode next;

        // Constructor: Creates a Node object with element = e, previous = p and next = n
        DLLNode(Object e, DLLNode p, DLLNode n) {
            element = e;
            previous = p;
            next = n;
        }

        // This function gets Object e as input and sets e as the element of the Node
        public void setElement(Object e) {
            element = e;
        }

        // This function returns the element variable of the Node
        public Object getElement() {
            return element;
        }

        // This function gets Node n as input and sets the next variable of the current Node object as n.
        public void setNext(DLLNode n) {
            next = n;
        }

        // This function returns the next Node
        public DLLNode getNext() {
            return next;
        }

        // This function gets Node p as input and sets the previous variable of the current Node object as p.
        public void setPrevious(DLLNode p) {
            previous = p;
        }

        // This function returns the previous Node
        public DLLNode getPrevious() {
            return previous;
        }
// END OF NESTED NODE CLASS -------------------------------------------------

}
