import java.util.PriorityQueue;

public class ExamMostPoints {

    private PriorityQueue<ExamQuestion> pq;

    /**
     * Constructor
     * MAX ORIENTED; highest no. of points first priority
     * YOU CANNOT ASSIGN A PQ TO AN ARRAY (questions, same name)
     * @param questions - the questions that are part of this exam
     * compareTo() method in library does natural ordering
     * You could also use the constructor in PQ class to define own comparator
     */
    public ExamMostPoints(ExamQuestion[] questions) {
        this.pq = new PriorityQueue<>(); // Java's PQ implemented using heap
        for (ExamQuestion question : questions) {
            pq.add(question);   // the compare method gives the order we want (see Library)
        }
    }

    /**
     * Returns the next question that should be answered on this exam,
     * the values of the returned exam questions should in descending order (i.e. questions with high value should be returned first)
     * @return
     */
    public ExamQuestion getNext() {
        return pq.poll();   // the largest priority; most points
    }

    // Java does down-heap bubbling but those methods are private

}
