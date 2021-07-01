import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class BFSPathBetween {

    /**
     * PATH FINDING USING BFS. --> queue
     * GRAPH IS NOT CONNECTED or ACYCLIC necessarily: in 0--1--2, there is a path between 0 and 2!
     * In a CONNECTED subgraph, 2 vertices are always reachable.
     * Checks if vertex b is reachable from vertex a.
     * @param a Vertex to start from.
     * @param b Vertex to reach.
     * @return true if vertex b is reachable.
     */
    public static boolean solve(Vertex a, Vertex b) {

        Set<Vertex> known = new HashSet<>();
        LinkedList<Vertex> queue = new LinkedList<>();
        queue.add(a);
        known.add(a);                              // holds path of visited vertices

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();      // dequeue first, current is constantly updated
                        System.out.println("Dequeued vertex: " + current);
            if (current == b) return true;            // path found
            for (Vertex v : current.getNeighbours()) {
                if (!known.contains(v)) {
                    queue.add(v);
                    known.add(v);
                }
            }
        }
        return false;
    }





}
