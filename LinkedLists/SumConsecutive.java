import java.util.*;

public class SumConsecutive {


    /**
     * Sum consecutive ints in SLL in O(n)
     * removeFirst into temp SLL (reversed!!), then put back in original SLL again.
     */
    public static void sumConsecutiveInts() {

        // create example list
        LinkedList<Integer> list = new LinkedList<Integer>();

        for (int i = 1; i < 6; i++) {
            list.addLast(i);
        }

        LinkedList<Integer> temp = new LinkedList<Integer>();
        // sum and print
        for (int i = list.size(); i > 1; i--) {
            int first = list.removeFirst();
            System.out.print(first + list.getFirst());      // getFirst is the consecutive int
            temp.addFirst(first);
        }
        temp.addFirst(list.removeFirst());                  // last one, which doesn't have a consecutive

        // reverse temp back to original list.
        for (int i = list.size(); i > 0; i--) {
            list.addFirst(temp.removeFirst());
        }
    }


    /**
     * Sum consecutive ints in SLL in O(n^2)
     * RemoveFirst, then addLast in same original SLL.
     * we call addLast n times, which is O(n) without tail reference!!!
     */
    public static void sumConsecutiveInts2() {

        // create example list
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 1; i < 6; i++) {
            list.addLast(i);
        }

        // sum and print
        for (int i = list.size(); i > 1; i--) {
            int first = list.removeFirst();
            System.out.print(first + list.getFirst());
            list.addLast(first);
        }
        list.addLast(list.removeFirst());                   // last one, which doesn't have a consecutive
    }
}
