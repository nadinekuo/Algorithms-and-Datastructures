import java.util.ArrayList;

public class SLLInsertionSort {

    /**
     * Constructor 2: initialises SLL with int elements
     * EXAMPLE:   SLList2 input = new SLList2(3, 1, 2);  <--- gives new SLL with elements in this order
     * OR:
     *         int[] sorted = {1, 2, 3};
     *         SLList2 test = new SLList2(sorted);
     * Queue: 3 - 1 - 2  <-- removeLast
     * addFirst in SLL: 3 - 1 - 2
     */

    /**
     * @param list
     *     The singly linked list to sort.
     * @return A NEW singly linked list that contains the elements as the input list
     * sorted in non-decreasing (INCREASING) order of NODE ELEMENTS (int)
     */
    static IntSLList insertionSort(IntSLList list) {

        if (list == null) return null;
        if (list.getFirst() == null) return new IntSLList();   // empty list (no head)

        ArrayList<Integer> elements = new ArrayList<>();
        IntSLList.Node walk = list.getFirst();        // start at head
        elements.add(walk.getElement());
        while (walk.getNext() != null) {
            walk = walk.getNext();
            elements.add(walk.getElement());
        }
        System.out.println("Size of SLL: " + elements.size());

        // convert Arraylist to array
        int[] elementsarr = new int[elements.size()];
        for(int i = 0;  i < elements.size(); i++) {
            elementsarr[i] = elements.get(i);
        }
        insertionSortHelper(elementsarr);           // insertion sort on array holding all SLL elements

        // create new SLL using int[] elements
        IntSLList result = new IntSLList(elementsarr);     // SEE SLL CONSTRUCTOR 2
        return result;

    }

    /**
     * @param elements
     *     - array of integers to be sorted.
     * in-place INSERTION SORT: increasing order
     */
    public static void insertionSortHelper(int[] elements) {
        // start at index 1
        for (int i = 1; i < elements.length; i++) {
            int current = elements[i];
            // iterate backwards
            int j = i;
            while (j > 0 && elements[j - 1] > current) { // if any of previous elements larger, shift to right
                elements[j] = elements[j - 1]; // shift to right to make space for current (copy! Not swap)
                j--;
            }
            elements[j] = current;              // insert at right index
        }
    }



}
