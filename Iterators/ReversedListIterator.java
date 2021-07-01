import java.util.*;

    /**
    * Iterates lazily over lists in reversed order. For instance, the list
    * [1,2,3,4] should be iterated as follows: 4 -> 3 -> 2 -> 1.
     * ITERATES LIST DIRECTLY. DON'T CREATE LIST COPY, but you can create a reference.
    */
    class ReversedListIterator<V> implements Iterator<V> {

        private int index;                      // index of the next element to report
        private List<V> reference;

        /**
         * Constructor.
         * Should reset on a new List.
         * @param list
         *     takes the list
         */
        public ReversedListIterator(List<V> list) {
            this.reference = list;
            this.index = list.size()-1;     // reversed order!!
        }

        /**
         * @return True if there is a next element in the iterator, else False
         */
        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        /**
         * Get the next element of the iterator and shift
         * iterator by one.
         * @return current element value
         * @post iterator is moved to next element
         * @throws NoSuchElementException
         *      iff there is no next element
         */
        @Override
        public V next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                return reference.get(index--);          // post-increment
            }
        }

        /**
         * Skip a single element of the iterator. CALL NEXT()
         *
         * @post iterator is moved to next element
         * @throws NoSuchElementException
         *      iff there is no elemented to be removed
         */
        @Override
        public void remove() throws NoSuchElementException {
            next();
        }
    }


