public class RecursivelyPrintReversedSLL {

    /**
     * Recursively print REVERSED SLL using RECURSION.
     * @param head the head of the SLL
     */
    public static void recursivelyPrintReversedSLL(Node head) {

        // base case
        if (head == null) return;

        recursivelyPrintReversedSLL(head.getNext());
        System.out.println(head.getElement());

    }

}
