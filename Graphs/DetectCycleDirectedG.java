import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DetectCycleDirectedG {

    /** DIRECTED GRAPH!
     * A GRAPH HAS A CYCLE IFF IT HAS A BACK EDGE ---> DFS!
     * Detects cycles in a connected component.
     * @param s starting node in our connected component.
     * @param nodes the nodes that belong to our graph.
     * @return true iff there is a cycle in the connected component the source belongs to.
     * TRUE IFF  --> s can reach the cycle, but not nec. part of it!
     */
    public static boolean detectCycle(GraphNode s, List<GraphNode> nodes) {

        Set<GraphNode> known = new HashSet<>();
        known.add(s);                               // add starting vertex

        // for all adjacent vertices of s, check if they have a cycle!
        for (GraphNode neighbour : s.getOutgoingEdges()) {
            if (hasCycle(nodes, s, neighbour,  known)) return true;        // pass node s as prev, neighbour as vertex
                     System.out.println("Neighbour " + neighbour + " does not have a cycle.");
            known.remove(neighbour);                                    // remove vertex again for next search!
        }
        return false;
    }

    /**
     *
     * @param graph
     * @param prev - parent vertex (first one is node s (else null))
     * @param vertex - current vertex
     * @param known - visited vertices (NODE S IS ALREADY ADDED)
     * @return true iff graph has cycle, else false.
     */
    public static boolean hasCycle(List<GraphNode> graph, GraphNode prev, GraphNode vertex, Set<GraphNode> known) {

        if (graph == null || graph.isEmpty() || !graph.contains(vertex)) return false;
        // now we know list contains node s

        known.add(vertex);
        for (GraphNode next : vertex.getOutgoingEdges()) {
            if (!known.contains(next)) {
                if (hasCycle(graph, vertex, next, known)) return true;
            }
            else if (next != prev) return true;              // if already visited it should not be the parent (not back edge!)
        }
        return false;
    }

}
