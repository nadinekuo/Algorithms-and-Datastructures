public class ArithmeticTree {


    /**
     * Evaluates the arithmetic expression stored in this binary tree.
     * (IN-ORDER TRAVERSAL gives this order too)
     * @param node
     * @return
     * @throws IllegalArgumentException
     */
    @SuppressWarnings("rawtypes")
    public static int eval(AbstractNode node) throws IllegalArgumentException {
        if (node.isLeaf()) {
            return (int)node.getVal();
        }
        InternalNode n  = (InternalNode)node;
        String operator = n.getVal();
        switch(operator) {
            case("+"):
                return eval(n.getLeft()) + eval(n.getRight());
            case("-"):
                return eval(n.getLeft()) - eval(n.getRight());
            case("*"):
                return eval(n.getLeft()) * eval(n.getRight());
            default:
                throw new IllegalArgumentException();
        }
    }

}
