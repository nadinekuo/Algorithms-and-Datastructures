import java.util.Objects;

class MergeLawyer {

    private int badgeNumber;

    private int numberOfTrials;

    private double hourlyWage;

    private double totalIncome;

    private int numberOfObjections;

    /** Queue of Lawyers
     * Returns a NEW QUEUE of the given queue, sorted by hourlyWage (DESCENDING)
     * If equal wage, then compare by totalIncome...(DESCENDING)
     * ORDER IN INPUT QUEUE SHOULD NOT CHANGE
     */
    public static ReverseQueue<MergeLawyer> sortingSomeLawyer(ReverseQueue<MergeLawyer> queue) {

        if (queue == null) {
            return null;
        }
        // Base case (trivially sorted)
        if (queue.size() < 2) {
            return queue;
        }
        // Split into 2 halves
        ReverseQueue<MergeLawyer> left = new ReverseQueue<>();
        ReverseQueue<MergeLawyer> right = new ReverseQueue<>();
        int count1 = 0;
        while (count1 < queue.size()/2) {        // fill left sub-queue with n/2 elements
            MergeLawyer element = queue.dequeue();
            left.enqueue(element);
            queue.enqueue(element);     // preserve elements in original queue
            count1++;
        }
        int count2 = 0;
        while (count2 < (queue.size()-left.size())) {      // put all elements that are NOT in left sub-queue, in right sub-queue
            MergeLawyer element = queue.dequeue();
            right.enqueue(element);
            queue.enqueue(element);
            count2++;
        }
        // 2 recursive calls, 1 for each half
        left = sortingSomeLawyer(left);
        right = sortingSomeLawyer(right);
        // Merge into larger sorted Queue
        return merge(left, right);
    }


    // helper merge method
    // all sub-queues passed must have at least 2 elements (checked by method above)
    // DESCENDING hourlyWage (or totalIncome)
    public static ReverseQueue<MergeLawyer> merge(ReverseQueue<MergeLawyer> q1, ReverseQueue<MergeLawyer> q2) {

        ReverseQueue<MergeLawyer> result = new ReverseQueue<>();   // create larger result queue

        // here the elements of the 2 queues passed don't have to be preserved
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.front().getHourlyWage() > q2.front().getHourlyWage()) {  // if hourlyWage of q1.front is higher, add first
                result.enqueue(q1.dequeue());
            } else {    // else, sort by totalIncome
                if (q1.front().getHourlyWage() == q2.front().getHourlyWage() && q1.front().getTotalIncome() > q2.front().getTotalIncome()) {
                    result.enqueue(q1.dequeue());
                } else {
                    result.enqueue(q2.dequeue());
                }
            }
        }
        while (!q1.isEmpty()) {                // enqueue remaining elements in result queue
            result.enqueue(q1.dequeue());
        }
        while (!q2.isEmpty()) {
            result.enqueue(q2.dequeue());
        }
        return result;
    }



    public MergeLawyer(int badgeNumber, int numberOfTrials, double hourlyWage, double totalIncome, int numberOfObjections) {
        this.badgeNumber = badgeNumber;
        this.numberOfTrials = numberOfTrials;
        this.hourlyWage = hourlyWage;
        this.totalIncome = totalIncome;
        this.numberOfObjections = numberOfObjections;
    }

    public int getBadgeNumber() {
        return badgeNumber;
    }

    public int getNumberOfTrials() {
        return numberOfTrials;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public int getNumberOfObjections() {
        return numberOfObjections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof MergeLawyer))
            return false;
        MergeLawyer className = (MergeLawyer) o;
        return badgeNumber == className.badgeNumber && numberOfTrials == className.numberOfTrials && Double.compare(className.hourlyWage, hourlyWage) == 0 && Double.compare(className.totalIncome, totalIncome) == 0 && numberOfObjections == className.numberOfObjections;
    }

    @Override
    public int hashCode() {
        return Objects.hash(badgeNumber, numberOfTrials, hourlyWage, totalIncome, numberOfObjections);
    }

    @Override
    public String toString() {
        return "Lawyer{" + "badgeNumber=" + badgeNumber + ", numberOfTrials=" + numberOfTrials + ", hourlyWage=" + hourlyWage + ", totalIncome=" + totalIncome + ", numberOfObjections=" + numberOfObjections + '}';
    }
}