import java.util.*;
import java.util.Stack;

public class TopologicalSort {

    /**
     * Topological sort using STACK. (LIFO)
     * @param nodes the nodes
     * @return the list
     */
    public static List<GraphNode> topologicalSort(List<GraphNode> nodes) {

        List<GraphNode> topo = new ArrayList<>();
        Stack<GraphNode> ready = new Stack<>();
        Map<GraphNode, Integer> inCount = new TreeMap<>();

        for (GraphNode n : nodes) {
//            inCount.put(n.id, n.inDegree);
            if (inCount.get(n) == 0) {       // we start with vertices that have inCount == 0
                ready.push(n);
            }
        }
        while (!ready.isEmpty()) {
            GraphNode v = ready.pop();
            topo.add(v);
            for (GraphNode neigh : v.getOutgoingEdges()) {
                inCount.put(neigh, inCount.get(neigh.id)-1);    // decrease inCount by 1, for all adjacent vertices
                if (inCount.get(neigh) == 0) {                  // if neighbour is now ready, push to visit next.
                    ready.push(neigh);
                }
            }
        }

        return topo;
    }

    /**
     * Topological sort using DFS, with STARTING VERTEX given (simplified).
     * @param nodes the nodes
     * @return the list
     * There can be multiple paths to the same vertex! So keep track of known set.
     * DFS: so we FIRST visit the DEEPEST vertices --> so call ADDFIRST (head) on result Linked List.
     */
    public static List<GraphNode> topologicalSortDFS(List<GraphNode> nodes, GraphNode start) {

        Set<GraphNode> known = new HashSet<>();
        LinkedList<GraphNode> topo = new LinkedList<>();

        known.add(start);
        for (GraphNode vertex : start.getOutgoingEdges()) {
            if (!known.contains(vertex)) {
                topologicalSortDFS(nodes, vertex);
            }
        }
        topo.addFirst(start);           // add CURRENT vertex; deepest node, which is visited first.
        return topo;
    }





}
