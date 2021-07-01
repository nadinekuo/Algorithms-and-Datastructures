class Node {

    // Each node object has these two fields
    private Object element;
    private Node next;

    /**
     * Constructor
     * @param e - the element (value) stored in this node
     * @param next - the node that is next (i.e. our node refers to the next node)
     */
    public Node(Object e, Node next) {
        this.element = e;
        this.next = next;
    }

    /**
     * Sets the element of this node with a new value
     * @param e - new value for this node
     */
    public void setElement(Object e) {
        this.element = e;
    }

    /**
     * @return the element stored in this node
     */
    public Object getElement() {
        return this.element;
    }

    /**
     * Sets the next node
     * @param next - the new node that our node refers to
     */
    public void setNext (Node next) {
        this.next = next;
    }

    /**
     * @return the next node
     */
    public Node getNext() {
        return this.next;
    }
}

