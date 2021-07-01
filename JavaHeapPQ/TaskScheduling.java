import java.util.PriorityQueue;

public class TaskScheduling {

    /**
     * Computes how fast the given tasks can be finished by the given amount of TAs.
     * @param durations Array containing the duration for each tasks.
     * @param n Amount of TAs to complete the tasks.
     * @return The shortest time in which all tasks can be completed.
     * JAVA default: MIN-HEAP (enqueue = add, dequeue = poll)
     * THE PQ STORES FOR EACH TA, AFTER HOW MUCH TIME ITS DONE, SO IS AVAILABLE AGAIN.
     * The MINIMUM will be polled, so that's when the next TA is available, who will get the next task in the array.
     */
    public static int completeTasks(int[] durations, int n) {

        // assign each task to available TA
        // use PQ to keep track when next is ready
        PriorityQueue<Integer> nextAvailableTime = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            nextAvailableTime.add(0);       // for all TAs, add starting value 0. (all available at time 0)
        }

        int shortestTime = 0;

        for (int i = 0; i < durations.length; i++) {        // for all tasks in array
            int ready = nextAvailableTime.poll();           // get the time when next TA is available
            int timeNextTask = ready + durations[i];        // add duration of current task to time already passed
            shortestTime = Math.max(shortestTime, timeNextTask);  // constantly update as more time passes (you don't wanna ADD all times PER TA!)
            nextAvailableTime.add(timeNextTask);            // add the time when next TA is done to PQ again
        }
        return shortestTime;
    }


}
