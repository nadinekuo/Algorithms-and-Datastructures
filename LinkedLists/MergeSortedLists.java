import java.sql.PreparedStatement;
import java.util.List;

public class MergeSortedLists {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);  // 5 - 6 - null
        l1.next = new ListNode(6);
        ListNode l2 = new ListNode(42);  // 42 - 43 - null
        l2.next = new ListNode(43);
        ListNode result = mergeTwoLists(l1, l2); // 5 - 6 - 42 - 43 - null
        ListNode walk = result;

        System.out.println(walk.val);
        if (walk.next == null) {
            System.out.println("next is null");
        }

        while (walk.next != null) {
            System.out.println(walk.next.val);
            walk = walk.next;
        }
    }


    public static class ListNode {

        private int val;
        private ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

//        int getVal() {
//            return this.val;
//        }
//
//        ListNode getNext() {
//            return this.next;
//        }
    }



        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode result = new ListNode(0); // dummy header

        // loop over all nodes starting from the head
        // append smallest to result list
        ListNode walk = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                walk.next = l1;
                l1 = l1.next;
            } else {
                walk.next = l2;
                l2 = l2.next;
            }
            walk = walk.next;
        }

        // append remaining
        while (l1 != null) {
            walk.next = l1;
            l1 = l1.next;
            walk = walk.next;
        }

        while (l2 != null) {
            walk.next = l2;
            l2 = l2.next;
            walk = walk.next;
        }

        // shallow copy (pointer to memory location), so changes will be reflected in result
        return result.next; // skip first dummy header
    }

}
