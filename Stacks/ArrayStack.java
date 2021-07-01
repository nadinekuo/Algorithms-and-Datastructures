import java.util.EmptyStackException;

class ArrayStack {

        private Object[] elements;
        private int size;
        private int capacity;

        /**
         * Creates an empty ArrayStack with capacity 1.
         */
        public ArrayStack() {
            this.size = 0;
            this.capacity = 1;
            elements = new Object[capacity];
        }

        /**
         * @return The size of this ArrayStack.
         */
        public int size() {
            return this.size;
        }

        /**
         * @return `true` iff this ArrayStack is empty, `false` otherwise.
         */
        public boolean isEmpty() {
            return this.size == 0;
        }

        /**
         * @return `true` iff the size is equal to the capacity, `false` otherwise.
         */
        public boolean isFull() {
            return this.size == this.capacity;
        }

        /**
         * @return the top element of the stack without removing it
         */
        public Object peek() throws EmptyStackException {
            if (isEmpty()){
                throw new EmptyStackException();
            }
            return elements[size-1];
        }

        /**
         * Adds `o` to the stack.
         * If capacity of stack was too small, capacity is doubled and `o` is added.
         * @param o
         *     the element to add to the stack.
         */
        public void push(Object o) {
            if (isFull()) {
                this.capacity *= 2;
                Object[] temp = new Object[capacity];
                for (int i = 0; i < elements.length; i++) {
                    temp[i] = elements[i];
                }
                elements = temp;
            }
            elements[size] = o;
            size++;
        }

        /**
         * Removes the top element from the stack.
         * If removing top would make the stack use less than 25% of its capacity,
         * then the capacity is halved.
         * MINIMUM CAPACITY IS 1.
         * @return the element which was at the top of the stack.
         * @throws EmptyStackException
         *     iff the stack is empty
         */
        public Object pop() throws EmptyStackException {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            Object result = elements[size-1];
            elements[size-1] = null;
            size--;
            if (size < 0.25*capacity) {     // if you would do (capacity/4), it would round 0.5 to 0
                this.capacity = capacity/2;
                if (capacity == 0) {        // size can't be < 0, so this line would not be necessary
                    capacity = 1;
                }
                Object[] temp = new Object[capacity];
                for (int i = 0; i < size; i++) {
                    temp[i] = elements[i];
                }
                elements = temp;
            }
            return result;
        }

        /**
         * @return a String representation of the ArrayStack
         * Example output for ArrayStack with 2 elements and capacity 5:
         * <ArrayStack[1,2]>(Size=2, Cap=5)
         */
        public String toString() {
            String res = "<ArrayStack[";
            for (int i = 0; i < size; i++) {
                if (i+1 == size) {
                    res += elements[i];
                } else {
                    res += elements[i] + ",";
                }
            }
            res += "]>(Size=" + size + ", Cap=" + capacity + ")";
            return res;
        }

        // For testing, do not remove or change.
        public Object[] getElements() {
            return elements;
        }


}

