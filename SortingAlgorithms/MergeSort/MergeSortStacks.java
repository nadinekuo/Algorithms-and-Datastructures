import java.util.Arrays;
import java.util.Stack;

public class MergeSortStacks {

    public static int[] mergeSort(int[] elements) {

        // push all elements onto stack
        Stack<Integer> elements2 = new Stack<>();
        for (int i = 0; i < elements.length; i++) {
            elements2.push(elements[i]);
        }

        // pop all elements from result stack to result array: if stack is in increasing order from top to bottom,
        // our array is in increasing order too.
        Stack<Integer> resultstack = mergeSortStack(elements2);
        int[] result = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            result[i] = resultstack.pop();
        }
        return result;
    }


    // stack is merged in DECREASING order from top to bottom, but we reverse it to INCREASING order.
    public static Stack<Integer> mergeSortStack(Stack<Integer> elements) {

        // base case
        if (elements.size() < 2) return elements;

        // divide into 2 sub-stacks
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int size = elements.size();
        for (int i = 0; i < size/2; i++) {
            s1.push(elements.pop());
        }
        while (!elements.isEmpty()) {
            s2.push(elements.pop());        // remaining part
        }
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);

        // sort the 2 sub-stacks recursively
        s1 = mergeSortStack(s1);
        s2 = mergeSortStack(s2);
        return mergeStackHelper(s1, s2);

    }


    // stack is merged in DECREASING order from top to bottom, but we reverse it to INCREASING order.
    public static Stack<Integer> mergeStackHelper(Stack<Integer> s1, Stack<Integer> s2) {

        Stack<Integer> result = new Stack<>();

        while(!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.peek() < s2.peek()) {            // push largest elements first
                result.push(s1.pop());
            } else {
                result.push(s2.pop());
            }
        }
        // push remaining elements
        while (!s1.isEmpty()) {
            result.push(s1.pop());
        }
        while (!s2.isEmpty()) {
            result.push(s2.pop());
        }
        // reverse stack by using helper stack!!!!!!! Else, the established order will be lost each merge. (LIFO)
        Stack<Integer> temp = new Stack<>();
        while (!result.isEmpty()) {
            temp.push(result.pop());
        }
        System.out.println("Stack after merging:" + temp);
        return temp;

    }



}
